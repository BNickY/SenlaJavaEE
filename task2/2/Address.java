public class Address {
    private String district;
    private String street;

    public Address(String district, String street) {
        System.out.println("Address");
        this.district = district;
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String newDistrict) {
        district = newDistrict;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String newStreet) {
        street = newStreet;
    }
}
