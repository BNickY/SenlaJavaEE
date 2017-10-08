public class Address {
    private String district;
    private String street;

    public Address(String district, String street) {
        this.district = district;
        this.street = street;
        System.out.println("Class Address");
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
