import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {10, 80, 30, 90, 40, 50, 70};

        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void bubbleSort(int[] array) {

        boolean foundOutOfOrder = true;
        while (foundOutOfOrder) {
            foundOutOfOrder = false;

            for (int i = 0; i < array.length - 1; ++i) {
                if (array[i] > array[i + 1]) {
                    swapElements(array, i, i + 1);
                    foundOutOfOrder = true;
                }
            }
        }
    }

    public static void swapElements(int[] array, int loc1, int loc2) {
        int temp = array[loc1];
        array[loc1] = array[loc2];
        array[loc2] = temp;
    }

}
