public class Address {
    private String street;
    private String city;

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    public String toString() {
        return this.street + ", " + this.city;
    }

    public String getAddress() {
        return this.city + ", " + this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
