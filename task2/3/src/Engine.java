public class Engine implements IProductPart{
    private static final String ENGINE = "Engine";

    Engine(){
        System.out.println(ENGINE + " has build");
    }

    @Override
    public String toString() {
        return ENGINE;
    }
}
