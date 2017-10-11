public class Tower implements IProductPart{
    private static final String TOWER = "Tower";

    Tower(){
        System.out.println(TOWER + " has build");
    }

    @Override
    public String toString() {
        return TOWER;
    }
}
