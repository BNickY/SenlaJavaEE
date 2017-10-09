public class Station {
    private int stationNumber;
    private Address[] addresses;
    private Patient[] patients;

    public Station(int stationNumber, Address[] addresses) {
        this.stationNumber = stationNumber;
        this.addresses = addresses;
        System.out.println("Class Station");
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

    public void addPatients(Patient[] newPatients){
        //add patients
    }
}
