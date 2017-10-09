public class BodyLineStep implements ILineStep{

    @Override
    public IProductPart buildProductPart() {
        System.out.println("Build Body");
        return new Body();
    }
}
