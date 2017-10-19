public class Student extends AUser{
    private String studentCardId;

    public Student(int id, String name, String phoneNumber, String studentCardId) {
        super(id, name, phoneNumber);
        this.studentCardId = studentCardId;
    }

    public String getStudentCardId() {
        return studentCardId;
    }

    public void setStudentCardId(String studentCardId) {
        this.studentCardId = studentCardId;
    }

    @Override
    public String toString() {
        return super.toString() + ", student card id: " + studentCardId;
    }
}
