public class PairsSum {

    public static void main(String[] args) {
        int[] example = {1, 2, 3, 4};

        System.out.println(sumOfPairsBruteForce(example));
        System.out.println(sumOfPairsFast(example));
    }

    private static int sumOfPairsBruteForce(int[] numbers) {

        int sum = 0;

        for (int i = 0; i < numbers.length; ++i) {
            for (int k = 0; k < numbers.length; ++k) {
                if (i != k) {
                    sum += (numbers[i] + numbers[k]);
                }
            }
        }

        return sum / 2;
    }

    private static int sumOfPairsFast(int[] numbers) {

        int sum = 0;

        for (int i = 0; i < numbers.length; ++i) {
            sum += (numbers[i] * (numbers.length - 1) * 2);
        }

        return sum / 2;
    }

}


