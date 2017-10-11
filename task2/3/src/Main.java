public class Main {
    public static void main(String[] args) {
        ILineStep bodyStep = new BodyLineStep();
        ILineStep engineStep = new EngineLineStep();
        ILineStep towerStep = new TowerLineStep();

        AssemblyLine assemblyLine = new AssemblyLine(bodyStep,engineStep,towerStep);
        Tank tank = (Tank) assemblyLine.assembleProduct(new Tank());

        System.out.println("The tank has been built");
    }
}
