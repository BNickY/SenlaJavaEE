public class Philistine extends AUser{
    private String passportId;

    public Philistine(int id, String name, String phoneNumber, String passportId) {
        super(id, name, phoneNumber);
        this.passportId = passportId;
    }

    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }

    @Override
    public String toString() {
        return super.toString() + ", passport id: " + passportId;
    }
}
