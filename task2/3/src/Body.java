public class Body implements IProductPart{
    private static final String BODY = "Body";

    Body(){
        System.out.println(BODY + " has build");
    }

    @Override
    public String toString() {
        return BODY;
    }
}
