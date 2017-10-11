import java.util.Arrays;

public class Station {
    private int stationNumber;
    private Address[] addresses;
    private Patient[] patients;

    public Station(int stationNumber, Address[] addresses, Patient[] patients) {
        System.out.println("Station");
        this.stationNumber = stationNumber;
        this.addresses = addresses;
        this.patients = patients;
    }

    public int getStationNumber() {
        return stationNumber;
    }

    public void setStationNumber(int newStationNumber) {
        stationNumber = newStationNumber;
    }

    public Address[] getAddresses() {
        return addresses;
    }

    public void setAddresses(Address[] newAddresses) {
        addresses = newAddresses;
    }

    public Patient[] getPatients() {
        return patients;
    }

    public void setPatients(Patient[] patients) {
        this.patients = patients;
    }

    public void addPatient(Patient patient){
        Patient[] newPatients = Arrays.copyOf(patients,patients.length+1);
        newPatients[newPatients.length-1] = patient;
        patients = Arrays.copyOf(newPatients,newPatients.length);
    }
}
