package se.lexicon;

public class City {
    int id;
    String name;
    String countryCode;

    public City() {
    }

    public City(String name, String countryCode) {
        this.name = name;
        this.countryCode = countryCode;
    }

    public City(int id, String name, String countryCode) {
        this.id = id;
        this.name = name;
        this.countryCode = countryCode;


    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + countryCode + '\'' +
                '}';
    }
}
