import java.util.Random;

class RandomNumbers {

    private int amount;
    private int[] randomNumbers;
    private Random random;

    RandomNumbers(int amount) {
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

    void showNumbers(){
        for(int i : randomNumbers) System.out.print(i + " ");
    }

    int getFirstDigitsSum(){
        int sum = 0;

        for(int i : randomNumbers){
            sum += i / 100;
        }

        return sum;
    }
}
