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

        // unknown how many rounds you will have to sort
        // the only way you know you're done is if you do a round without swapping any elements
        boolean foundOutOfOrder = true;
        while (foundOutOfOrder) {
            foundOutOfOrder = false;

            // iterate through array and swap any adjacent out of order elements
            for (int i = 0; i < array.length - 1; ++i) {
                if (array[i] > array[i + 1]) {
                    swapElements(array, i, i + 1);
                    foundOutOfOrder = true; // now we know we have to do at least one more round
                }
            }
        }
    }

    // swaps the location of 2 elements in the array
    public static void swapElements(int[] array, int loc1, int loc2) {
        int temp = array[loc1];
        array[loc1] = array[loc2];
        array[loc2] = temp;
    }

}
