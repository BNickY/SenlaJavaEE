public class AssemblyLine implements IAssemblyLine{

    private ILineStep body;
    private ILineStep engine;
    private ILineStep tower;

    AssemblyLine(ILineStep body, ILineStep engine, ILineStep tower){
        this.body = body;
        this.engine = engine;
        this.tower = tower;
    }

    @Override
    public IProduct assembleProduct(IProduct product) {
        System.out.println("Tank assembling has started");

        product.installFirstPart(body.buildProductPart());
        product.installSecondPart(engine.buildProductPart());
        product.installThirdPart(tower.buildProductPart());

        System.out.println("Tank assembling has finished");

        return product;
    }
}
