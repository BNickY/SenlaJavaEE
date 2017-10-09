public class Tank implements IProduct {

    @Override
    public void installFirstPart(IProductPart iProductPart) {
        System.out.println("Install first part of tank:" + iProductPart);
    }

    @Override
    public void installSecondPart(IProductPart iProductPart) {
        System.out.println("Install second part of tank:" + iProductPart);
    }

    @Override
    public void installThirdPart(IProductPart iProductPart) {
        System.out.println("Install third part of tank:" + iProductPart);
    }
}
