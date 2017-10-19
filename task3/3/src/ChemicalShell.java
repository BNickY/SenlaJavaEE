public class ChemicalShell extends AShell{
    private String gas;

    public ChemicalShell(int id, double price, double weight, double caliber, String gas) {
        super(id, price, weight, caliber);
        this.gas = gas;
    }

    public String getGas() {
        return gas;
    }

    public void setGas(String gas) {
        this.gas = gas;
    }

    @Override
    public String toString() {
        return super.toString() + ", gas: " + gas;
    }
}
