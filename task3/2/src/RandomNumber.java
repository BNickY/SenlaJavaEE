import java.util.Random;

public class RandomNumber {

    private int amount;
    private int[] randomNumbers;
    private Random random;

    RandomNumber(int amount) {
        this.amount = amount;
        random = new Random();
        randomNumbers = new int[amount];
        generateNumbers();
    }

    private void generateNumbers(){
        for(int i = 0; i < amount; i++){
            randomNumbers[i] = 100 + random.nextInt(999-100);
        }
    }

    int getFirstDigitsSum(){
        int sum = 0;

        for(int i : randomNumbers){
            sum += i / 100;
        }

        return sum;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int[] getRandomNumbers() {
        return randomNumbers;
    }

    public void setRandomNumbers(int[] randomNumbers) {
        this.randomNumbers = randomNumbers;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

}
