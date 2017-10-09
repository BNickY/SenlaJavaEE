public class TowerLineStep implements ILineStep{

    @Override
    public IProductPart buildProductPart() {
        System.out.println("Build Tower");
        return new Tower();
    }
}
