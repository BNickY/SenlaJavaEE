public class Test {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse(5,21.2);
        AProduct product = new ArmorPiercingShell(1,321.2,33,20.2,200);
        AProduct product1 = new ArmorPiercingShell(2,321.2,33,20.2,200);
        AProduct product2 = new ArmorPiercingShell(3,321.2,33,20.2,200);
        AProduct product3 = new FougasseShell(4,521,32,42,12);
        AProduct product4 = new ChemicalShell(5,421,521,612,"argon");

        warehouse.addProduct(product);
        warehouse.addProduct(product2);
        warehouse.addProduct(product);
        warehouse.addProduct(product1);
        warehouse.addProduct(product3);

        warehouse.getWarehouseInfo();

        System.out.println();
        warehouse.removeProduct(1);


        warehouse.getWarehouseInfo();
    }
}
