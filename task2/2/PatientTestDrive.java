public class PatientTestDrive {
    public static void main(String[] args) {

        AMan patient0 = new Patient("Kol","Kollins");

        Patient patient1 = new Patient("Ivan","Ivanov");

        //1 patient
        Disease[] diseasesOfFirstPatient = new Disease[3];
        diseasesOfFirstPatient[0] = new Disease("flu");
        diseasesOfFirstPatient[1] = new Disease("chickenpox");
        diseasesOfFirstPatient[2] = new Disease("flu");

        MedicalCard patient1MedCard = new MedicalCard(1,diseasesOfFirstPatient);
        patient1.setMedicalCard(patient1MedCard);

        //Station
        Address[] addresses = new Address[3];
        addresses[0] = new Address("13","Sovetskaya st.");
        addresses[1] = new Address("13","Dekabristov st.");
        addresses[2] = new Address("13","Solnechnaya st.");

        Station station = new Station(41,addresses);

        patient1.setStation(station);

        Patient[] patients = new Patient[2];
        patients[0] = patient1;
        patients[1] = (Patient)patient0;

        station.setPatients(patients);
    }
}
