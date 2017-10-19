public class Warehouse implements ICountable {

    private int capacity;
    private double area;
    private AProduct[] products;

    private int tos;

    public Warehouse(int capacity, double area) {
        this.capacity = capacity;
        this.area = area;
        tos = 0;
        products = new AProduct[capacity];
    }

    public void addProduct(AProduct product){
        if(tos < products.length){
            products[tos] = product;
            tos++;
        }else
            System.out.println("Warehouse is full!");
    }

    public void removeProduct(int id){
        int count = 0;
        for(int i = 0; i< tos; i++)
        {
            if(products[i].getId() == id)
            {
                for(int j = i; j<(tos -1); j++)
                {
                    products[j] = products[j+1];
                }
                tos--;
                count++;
                break;
            }
        }
        if(count==0)
        {
            System.out.print("Product not found!");
        }
    }

    public void getWarehouseInfo(){
        for(int i = 0; i < tos; i++)
            System.out.println(products[i]);
    }

    @Override
    public double countWeight() {
        double weight = 0;

        for (AProduct product : products) {
            weight += product.getWeight();
        }

        return weight;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public AProduct[] getProducts() {
        return products;
    }

    public void setProducts(AProduct[] products) {
        this.products = products;
    }

}