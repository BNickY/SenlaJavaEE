public class ArmorPiercingShell extends AShell{
    private int armorPenetration;

    public ArmorPiercingShell(int id, double price, double weight, double caliber, int armorPenetration) {
        super(id, price, weight, caliber);
        this.armorPenetration = armorPenetration;
    }

    public int getArmorPenetration() {
        return armorPenetration;
    }

    public void setArmorPenetration(int armorPenetration) {
        this.armorPenetration = armorPenetration;
    }

    @Override
    public String toString() {
        return super.toString() + ", armor penetration: " + armorPenetration;
    }
}
