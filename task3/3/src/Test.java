public class Test {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse(5,21.2);

        warehouse.addProduct(new ArmorPiercingShell(1,321.2,33,20.2,200));
        warehouse.addProduct(new ArmorPiercingShell(2,321.2,33,20.2,200));
        warehouse.addProduct(new ArmorPiercingShell(3,321.2,33,20.2,200));

        Printer.printWarehouse(warehouse);

        warehouse.addProduct(new FougasseShell(4,521,32,42,12));
        warehouse.addProduct(new ChemicalShell(5,421,521,612,"argon"));

        Printer.printWarehouse(warehouse);

        Printer.printWeight(warehouse.countWeight());
    }
}
