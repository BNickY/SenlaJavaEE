public class Test {
    public static void main(String[] args) {
        Patient patient1 = new Patient("Ivan","Ivanov");
        Patient patient2 = new Patient("Petr","Petrov");

        Disease[] diseases = new Disease[2];
        diseases[0] = new Disease("flu");
        diseases[1] = new Disease("headache");

        Disease disease = new Disease("flue");

        MedicalCard mCardPatient1 = new MedicalCard(1,diseases);
        patient1.setMedicalCard(mCardPatient1);

        MedicalCard mCardPatient2 = new MedicalCard(2,diseases);
        patient2.setMedicalCard(mCardPatient2);


        Address[] addresses = new Address[2];
        addresses[0] = new Address("13","Popovicha");
        addresses[1] = new Address("13","Manushko");

        Patient[] patients = new Patient[2];
        patients[0] = patient1;
        patients[0] = patient2;

        Station station = new Station(13,addresses,patients);
    }
}
