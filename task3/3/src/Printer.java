public class Printer {

    public static void printWarehouse(Warehouse warehouse){
        int tos = warehouse.getTos();
        AProduct[] products = warehouse.getProducts();

        for(int i = 0; i < tos; i++)  System.out.println(products[i]);
    }

    public static void printWeight(double weight){
        System.out.println("Weight: " + weight);
    }

    public static void printMessage(String message){
        System.out.println(message);
    }
}
