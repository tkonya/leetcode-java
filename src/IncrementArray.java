import java.util.Arrays;

public class IncrementArray {

    public static void main(String[] args) {
        int[] array = {8, 9, 9, 9};
        System.out.println(Arrays.toString(incrementArray(array)));
    }

    public static int[] incrementArray(int[] array) {

        for (int i = array.length - 1; i >= 0; --i) {
            if (array[i] < 9) {
                array[i] += 1;
                return array;
            } else if (i == 0) {
                array[0] = 0;
                int[] biggerArray = new int[array.length + 1];
                biggerArray[0] = 1;
                System.arraycopy(array, 0, biggerArray, 1, array.length);
                return biggerArray;
            } else {
                array[i] = 0;
            }
        }

        return array;
    }

}
