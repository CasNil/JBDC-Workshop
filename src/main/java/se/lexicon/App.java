package se.lexicon;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // Test findById()
        /*
        CityDaoJDBC cityDaoJDBC = new CityDaoJDBC();
        int idToTest = 3805;

        City foundCity = cityDaoJDBC.findById(idToTest);

        if (foundCity != null) {
            System.out.println("City found: " + foundCity);
        } else {
            System.out.println("City with Id " + idToTest + " not found.");
        }
        */


        // Test findByCode()
        /*
        CityDaoJDBC cityDaoJDBC = new CityDaoJDBC();
        String codeToTest = "USA";

        List<City> result = cityDaoJDBC.findByCode(codeToTest);

        if (result != null && !result.isEmpty()) {
            for (City city : result) {
                System.out.println(city);
            }
        } else {
            System.out.println("No cities found with code: " + codeToTest);
        }
        */

        // Test findByName()
        /*
        CityDaoJDBC cityDaoJDBC = new CityDaoJDBC();
        String nameToTest = "San Francisco";

        List<City>result = cityDaoJDBC.findByName(nameToTest);
        if (result != null && !result.isEmpty()) {
            for (City city : result) {
                System.out.println(city);
            }
        } else {
            System.out.println("No cities found with name: " + nameToTest);
        }
        */

        // Test findAll()
        /*
        CityDaoJDBC cityDaoJDBC = new CityDaoJDBC();

        List<City> result = cityDaoJDBC.findAll();

        if (result != null && !result.isEmpty()) {
            for (City city : result) {
                System.out.println(city);
            }
        } else {
            System.out.println("No cities found in the database");
        }
        */

        // Test add()
        /*
        CityDaoJDBC cityDaoJDBC = new CityDaoJDBC();

        City city = new City("San Francisco", "USA");

        City addedCity = cityDaoJDBC.add(city);

        if (addedCity.getId() != 0) {
            System.out.println("City was added: " + addedCity);
        } else {
            System.out.println("Failed to add the city.");
        }
        */

        // Test update()
        /*
        CityDaoJDBC cityDaoJDBC = new CityDaoJDBC();

        City cityToUpdate = new City();
        cityToUpdate.setId(3805);
        cityToUpdate.setName("San Miguel");
        cityToUpdate.setCountryCode("USA");

        City updatedCity = cityDaoJDBC.update(cityToUpdate);

        if (updatedCity != null) {
            System.out.println("City updated successfully: " + updatedCity);
        } else {
            System.out.println("Failed to update the city.");
        }
        */

        // Test delete()
        CityDaoJDBC cityDaoJDBC = new CityDaoJDBC();

        City cityToDelete = new City();
        cityToDelete.setId(4000);

        int rowsDeleted = cityDaoJDBC.delete(cityToDelete);

        if (rowsDeleted > 0) {
            System.out.println("City deleted successfully. Rows affected: " + rowsDeleted);
        } else {
            System.out.println("No city found with Id " + cityToDelete.getId() + " or failed to delete.");
        }
    }
}
