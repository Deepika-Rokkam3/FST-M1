//In this activity, we are writing a program to check if the sum of all the 10's in the array is exactly 30.
//
//The program returns false if the condition does not satisfy, otherwise returns true.
//
//Instructions:
//
//Add a Class named Activity2.
//In the main() method:
//Initialize an array with 6 number: [10, 77, 10, 54, -11, 10]
//Find the 10's in the array and add them
//Check if value is equal to 30.

package activities;

import java.util.Arrays;

public class Activity2 {

    public static void main(String[] args) {

        int[] numbers = {10, 77, 10, 54, -11, 10};

        // Print array
        System.out.println("Array: " + Arrays.toString(numbers));

        int sum = 0;

        // Find and add all 10's
        for (int num : numbers) {
            if (num == 10) {
                sum = sum + num;
            }
        }

        System.out.println("Sum of 10's = " + sum);

        // Check condition
        System.out.println(sum == 30);
    }
}