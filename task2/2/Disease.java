public class Disease {
    private String disease;

    public Disease(String disease){
        this.disease = disease;
        System.out.println("Class Disease");
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String newDisease) {
        disease = newDisease;
    }
}
