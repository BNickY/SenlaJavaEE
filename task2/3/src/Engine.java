public class Engine implements IProductPart{
    private static final String ENGINE = "Engine";

    Engine(){
        System.out.println(ENGINE + " constructor");
    }

    @Override
    public String toString() {
        return ENGINE;
    }
}
