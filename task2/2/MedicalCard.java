public class MedicalCard {
    private int cardNumber;
    private Disease[] diseasesHistory;

    public MedicalCard(int cardNumber, Disease[] diseasesList){
        this.cardNumber = cardNumber;
        diseasesHistory = diseasesList;
        System.out.println("Class MedicalCard");
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int newCardNumber) {
        cardNumber = newCardNumber;
    }

    public Disease[] getDiseases() {
        return diseasesHistory;
    }

    public void addNewDisease(Disease newDisease){
       //add  new disease
    }
}
