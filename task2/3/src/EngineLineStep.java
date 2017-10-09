public class EngineLineStep implements ILineStep{

    @Override
    public IProductPart buildProductPart() {
        System.out.println("Build Engine");
        return new Engine();
    }
}
