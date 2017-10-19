public class Teacher extends AUser{
    private String resolutionId;

    public Teacher(int id, String name, String phoneNumber, String resolutionId) {
        super(id, name, phoneNumber);
        this.resolutionId = resolutionId;
    }

    public String getResolutionId() {
        return resolutionId;
    }

    public void setResolutionId(String resolutionId) {
        this.resolutionId = resolutionId;
    }

    @Override
    public String toString() {
        return super.toString() + ", resolution id: " + resolutionId;
    }
}
