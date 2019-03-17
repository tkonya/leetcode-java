import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 5, 3, 10, 100, 90, 85};
        int[] numbers2 = Arrays.copyOfRange(numbers, 0, 5);
    }

    public void quickSort(int[] array, int lowIndex, int highIndex) {

        int low = lowIndex;
        int high = highIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = array[lowIndex+(highIndex-lowIndex)/2];
        // Divide into two arrays
        while (low <= high) {

            while (array[low] < pivot) {
                low++;
            }

            while (array[high] > pivot) {
                high--;
            }

            if (low <= high) {
                swapElements(array, low, high);
                //move index to next position on both sides
                low++;
                high--;
            }
        }

        // call quickSort() method on each side recursively
        if (lowIndex < high) {
            quickSort(array, lowIndex, high);
        }

        if (low < highIndex) {
            quickSort(array, low, highIndex);
        }
    }

    public static void swapElements(int[] array, int loc1, int loc2) {
        int temp = array[loc1];
        array[loc1] = array[loc2];
        array[loc2] = temp;
    }

}
