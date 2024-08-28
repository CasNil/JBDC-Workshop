package se.lexicon;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDaoJDBC implements CityDao {

    @Override
    public City findById(int id) {
        String sql = "SELECT id, name, countryCode FROM city WHERE id = ?";
        City city = null;

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    city = new City(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return city;
    }

    @Override
    public List<City> findByCode(String code) {
        List<City> cityList = new ArrayList<>();
        String sql = "SELECT id, name, countryCode FROM city WHERE countryCode = ?";

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, code);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                City city = new City(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));

                cityList.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cityList;
    }

    @Override
    public List<City> findByName(String name) {
        List<City> cityList = new ArrayList<>();
        String sql = "SELECT id,name,countryCode FROM city WHERE name = ?";

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                City city = new City(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));

                cityList.add(city);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cityList;
    }

    @Override
    public List<City> findAll() {
        List<City> cityList = new ArrayList<>();
        try {
            Connection connection = MySQLConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from city");

            while (resultSet.next()) {
                int cityId = resultSet.getInt(1);
                String cityName = resultSet.getString(2);
                String countryCode = resultSet.getString(3);

                City city = new City(cityId, cityName, countryCode);
                cityList.add(city);

            }
            cityList.forEach(System.out::println);

        } catch (SQLException e) {
            System.out.println("SQL Exception: ");
            e.printStackTrace();
        }
        return cityList;
    }

    @Override
    public City add(City city) {
        String sql = "INSERT INTO city (name, countryCode) VALUES (?, ?)";

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, city.getName());
            preparedStatement.setString(2, city.getCountryCode());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        city.setId(generatedKeys.getInt(1));
                    }

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return city;
    }

    @Override
    public City update(City city) {
        String sql = "UPDATE city SET name = ?, countryCode = ? WHERE id = ?";

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, city.getName());
            preparedStatement.setString(2, city.getCountryCode());
            preparedStatement.setInt(3, city.getId());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                return city;
            } else {
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public int delete(City city) {
        String sql = "DELETE FROM city WHERE id = ?";
        int rowsAffected = 0;

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, city.getId());

            rowsAffected = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowsAffected;
    }
}
