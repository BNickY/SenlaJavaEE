public class Disease {
    private String disease;

    public Disease(String disease){
        System.out.println("Disease");
        this.disease = disease;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String newDisease) {
        disease = newDisease;
    }
}
