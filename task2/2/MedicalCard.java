import java.util.Arrays;

public class MedicalCard {
    private int cardNumber;
    private Disease[] diseasesHistory;

    public MedicalCard(int cardNumber, Disease[] diseasesList){
        System.out.println("MedicalCard");
        this.cardNumber = cardNumber;
        diseasesHistory = diseasesList;
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
       Disease[] newDiseasesHistory = Arrays.copyOf(diseasesHistory,diseasesHistory.length + 1);
       newDiseasesHistory[newDiseasesHistory.length - 1] = newDisease;
       diseasesHistory = Arrays.copyOf(newDiseasesHistory,newDiseasesHistory.length);
    }
}
