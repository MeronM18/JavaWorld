package JavaProjects.MatrixMultiplication; //Meron Matti

import java.io.*; // Import the File class
import java.util.*; // Import the Arrays class
import java.util.stream.Collectors; // Import the Collectors class

public class Matrix {

    public static void main(String[] args) throws Exception {
        int rows = 3, cols = 2;

        // Matrix 1
        int[][] matrix1 = new int[rows][cols]; // Initialize the matrix
        String filePath1 = "matrix1.txt"; // File path
        initAndWriteMatrix(matrix1, filePath1); // Initialize and write the matrix to a file
        assert matricesEqual(matrix1, readMatrixFromFile(filePath1)); // Check if the matrix is equal to the one read from the file

        // Matrix 2
        int[][] matrix2 = new int[cols][rows]; // Initialize the matrix
        String filePath2 = "matrix2.txt"; // File path
        initAndWriteMatrix(matrix2, filePath2); // Initialize and write the matrix to a file

        // Result Matrix
        int[][] result = multiplyMatrices(matrix1, matrix2);
        String resultFilePath = "result.txt";
        writeMatrixToFile(result, resultFilePath);

        // Print Matrices
        printMatrix(matrix1);
        printMatrix(matrix2);
        printMatrix(result);
    }

    // Function to initialize a matrix with random values and write it to a file
    public static void initAndWriteMatrix(int[][] matrix, String filePath) throws IOException {
        Random random = new Random();

        // Initialize and write the matrix to a file
        for (int[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                row[i] = random.nextInt(5);
            }
        }
        writeMatrixToFile(matrix, filePath);
    }

    // Function to check if two matrices are equal
    public static boolean matricesEqual(int[][] matrix1, int[][] matrix2) {
        return Arrays.deepEquals(matrix1, matrix2);
    }

    // Function to multiply two matrices
    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int cols2 = matrix2[0].length;

        int[][] result = new int[rows1][cols2]; // Initialize the result matrix

        for (int i = 0; i < rows1; i++) { // Iterate through rows of matrix1
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return result;
    }

    // Function to print a matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }

    // Function to read a matrix from a file
    public static int[][] readMatrixFromFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            return reader.lines()
                    .map(line -> Arrays.stream(line.split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray())
                    .toArray(int[][]::new);
        }
    }

    // Function to write a matrix to a file
    public static void writeMatrixToFile(int[][] matrix, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (int[] row : matrix) {
                writer.write(Arrays.stream(row) // Use Arrays.stream() method
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" ")) + "\n"); // Use Collectors.joining() method
            }
        }
    }
}
