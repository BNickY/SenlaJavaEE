public abstract class AShell extends AProduct{
    private double caliber;

    public AShell(int id, double price, double weight, double caliber) {
        super(id, price, weight);
        this.caliber = caliber;
    }

    public double getCaliber() {
        return caliber;
    }

    public void setCaliber(double caliber) {
        this.caliber = caliber;
    }

    @Override
    public String toString() {
        return super.toString() + ", caliber: " + caliber;
    }
}