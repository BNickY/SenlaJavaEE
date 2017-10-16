public class Test {
    public static void main(String[] args) {
        RandomNumbers numbers = new RandomNumbers(3);
        numbers.showNumbers();

        int sum = numbers.getFirstDigitsSum();
        System.out.println("\n" + "First digits sum: " + sum);
    }
}
