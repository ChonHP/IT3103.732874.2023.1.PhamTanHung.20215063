package excercise6;

import java.util.Arrays;
import java.util.Scanner;

public class SortNumericArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for array or use a constant array
        int[] array;
        System.out.print("Do you want to enter your own array? (yes/no): ");
        String choice = scanner.nextLine().toLowerCase();

        if (choice.equals("yes")) {
            array = getUserArrayInput(scanner);
        } else {
            // Use a constant array
            array = new int[]{5, 2, 8, 1, 7};
            System.out.println("Using a constant array: " + Arrays.toString(array));
        }

        // Sort the array
        Arrays.sort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));

        // Calculate and display the sum and average
        int sum = calculateSum(array);
        double average = calculateAverage(array);

        System.out.println("Sum of array elements: " + sum);
        System.out.println("Average of array elements: " + average);

        // Close the scanner
        scanner.close();
    }

    private static int[] getUserArrayInput(Scanner scanner) {
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] array = new int[size];
        System.out.println("Enter array elements:");
        for (int i = 0; i < size; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }

        return array;
    }

    private static int calculateSum(int[] array) {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return sum;
    }

    private static double calculateAverage(int[] array) {
        if (array.length == 0) {
            return 0; // Avoid division by zero
        }
        int sum = calculateSum(array);
        return (double) sum / array.length;
    }
    }


