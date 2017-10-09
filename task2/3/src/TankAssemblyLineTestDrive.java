public class TankAssemblyLineTestDrive {
    public static void main(String[] args) {
        ILineStep bodyLS = new BodyLineStep();
        ILineStep engineLS = new EngineLineStep();
        ILineStep towerLS = new TowerLineStep();

        AssemblyLine tankAL = new AssemblyLine(bodyLS,engineLS,towerLS);
        IProduct tank = tankAL.assembleProduct(new Tank());
        
        System.out.println("The tank was assembled");
    }
}
