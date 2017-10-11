public class Tank implements IProduct {
    private IProductPart body;
    private IProductPart engine;
    private IProductPart tower;

    @Override
    public void installFirstPart(IProductPart firstPart) {
        this.body = firstPart;
        System.out.println("Body has installed");
    }

    @Override
    public void installSecondPart(IProductPart secondPart) {
       this.engine = secondPart;
        System.out.println("Engine has installed");
    }

    @Override
    public void installThirdPart(IProductPart thirdPart) {
       this.tower = thirdPart;
        System.out.println("Tower has installed");
    }
}
