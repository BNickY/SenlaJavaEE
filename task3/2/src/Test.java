import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        RandomNumber numbers = new RandomNumber(3);
        System.out.println(Arrays.toString(numbers.getRandomNumbers()));
        System.out.println("First digits sum: " + numbers.getFirstDigitsSum());
    }
}
