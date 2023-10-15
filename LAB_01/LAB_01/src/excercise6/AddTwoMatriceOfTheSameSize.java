package excercise6;

import java.util.Scanner;

public class AddTwoMatriceOfTheSameSize {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for matrices or use constant matrices
        int[][] matrix1, matrix2;

        System.out.print("Do you want to enter your own matrices? (yes/no): ");
        String choice = scanner.nextLine().toLowerCase();

        if (choice.equals("yes")) {
            matrix1 = getUserMatrixInput(scanner, "first");
            matrix2 = getUserMatrixInput(scanner, "second");
        } else {
            // Use constant matrices
            matrix1 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
            matrix2 = new int[][]{{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
            System.out.println("Using constant matrices:");
            printMatrix(matrix1, "first");
            printMatrix(matrix2, "second");
        }

        // Add matrices
        int[][] resultMatrix = addMatrices(matrix1, matrix2);

        // Display the result
        System.out.println("Resultant matrix after addition:");
        printMatrix(resultMatrix, "result");

        // Close the scanner
        scanner.close();
    }

    private static int[][] getUserMatrixInput(Scanner scanner, String matrixName) {
        System.out.print("Enter the number of rows for the " + matrixName + " matrix: ");
        int rows = scanner.nextInt();

        System.out.print("Enter the number of columns for the " + matrixName + " matrix: ");
        int cols = scanner.nextInt();

        int[][] matrix = new int[rows][cols];
        System.out.println("Enter elements for the " + matrixName + " matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Element at position (" + (i + 1) + ", " + (j + 1) + "): ");
                matrix[i][j] = scanner.nextInt();
            }
        }

        return matrix;
    }

    private static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] resultMatrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                resultMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return resultMatrix;
    }

    private static void printMatrix(int[][] matrix, String matrixName) {
        System.out.println(matrixName + " matrix:");
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
