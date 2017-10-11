public class Patient extends AMan{
    private MedicalCard medicalCard;
    private Station station;

    public Patient(String name, String surname){
        super(name,surname);
        System.out.println("Patient");
    }

    public MedicalCard getMedicalCard() {
        return medicalCard;
    }

    public void setMedicalCard(MedicalCard newMedicalCard) {
        medicalCard = newMedicalCard;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station newStation) {
        station = newStation;
    }
}
