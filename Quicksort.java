import java.util.Random;

public class Quicksort {

    public static void main(String args[]) {
        Random rand = new Random();
        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(100);
        }

        System.out.println("Before:");

        printArray(numbers);

        quicksort(numbers, 0, numbers.length - 1);

        System.out.println("\nAfter:");

        printArray(numbers);

    }

    private static void quicksort(int[] array, int lowIndex, int highIndex) {

        if (lowIndex >= highIndex) { // if lowindex becomes greater or equal to high index, then we have sorted all
                                     // partitions
            return;
        }
        int pivot = array[highIndex];

        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while (leftPointer < rightPointer) { // when we hit pointers we stop
            // left side first
            while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }
            // right side second
            while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }
            swap(array, leftPointer, rightPointer);
        }

        // when pointers are in position to move pivot, high index is our pivot index
        swap(array, leftPointer, highIndex);
        // partitioning finished, time for recursive call to sort partitioned arrays to
        // the left and right of pivot
        quicksort(array, lowIndex, leftPointer - 1); // left side
        quicksort(array, leftPointer + 1, highIndex);// right side
    }

    // swap pointers
    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private static void printArray(int[] numbers) {
        for (int e : numbers) {
            System.out.println(e);
        }
    }
}
