package activities;

import java.util.Arrays;

public class Activity4 {

    static void ascendingSort(int array[]) {

        // Sorting logic
        for (int i = 1; i < array.length; i++) {

            int key = array[i];
            int j = i - 1;

            while (j >= 0 && key < array[j]) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = key;
        }
    }

    public static void main(String args[]) {

        // Unsorted array
        int[] data = {9, 5, 1, 4, 3};

        // Print before sorting
        System.out.println("Before Sorting:");
        System.out.println(Arrays.toString(data));

        // Sort array
        ascendingSort(data);

        // Print after sorting
        System.out.println("After Sorting:");
        System.out.println(Arrays.toString(data));
    }
}