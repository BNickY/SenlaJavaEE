public class Body implements IProductPart{
    private static final String BODY = "Body";
    Body(){
        System.out.println(BODY + " constructor");
    }

    @Override
    public String toString() {
        return BODY;
    }
}
