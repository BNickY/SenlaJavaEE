public class FougasseShell extends AShell{
    private double injuryRadius;

    public FougasseShell(int id, double price, double weight, double caliber, double injuryRadius) {
        super(id, price, weight, caliber);
        this.injuryRadius = injuryRadius;
    }

    public double getInjuryRadius() {
        return injuryRadius;
    }

    public void setInjuryRadius(double injuryRadius) {
        this.injuryRadius = injuryRadius;
    }

    @Override
    public String toString() {
        return super.toString() + ", injury radius: " + injuryRadius;
    }
}
