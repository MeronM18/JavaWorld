package Generics; //Meron Matti

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class BubbleSortG<T extends Comparable<T>> { //generic class
    public static <T extends Comparable<T>> T[] createRandomArray(int arrayLength, Class<T> type) {
        T[] array = (T[]) Array.newInstance(type, arrayLength);
        Random random = new Random();
        for (int i = 0; i < arrayLength; i++) {
            array[i] = type.cast(random.nextInt(101)); // Cast the integer to T
        }
        return array;
    }
    

    public static <T extends Comparable<T>> void writeArrayToFile(T[] array, String filename) { //writes the array to the file
        try (PrintWriter writer = new PrintWriter(filename)) {
            for (T element : array) {
                writer.println(element); //writes the array to the file
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static <T extends Comparable<T>> T[] readFileToArray(String filename, Class<T> type) { //reads the file and converts it to an array
        List<T> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                try {
                    T element = type.getDeclaredConstructor(String.class).newInstance(scanner.nextLine());
                    list.add(element);
                } catch (Exception e) { // Handle invalid input
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        T[] array = (T[]) Array.newInstance(type, list.size());
        return list.toArray(array);
    }

    public static <T extends Comparable<T>> void bubbleSort(T[] array) { //bubble sort method
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1]; //swaps the elements
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in); //scanner object
        int choice;
        try {
            System.out.println("Enter your choice:");
            System.out.println("1. Generate an array of random integers and store it in a file");
            System.out.println("2. Read an existing file containing a list of integers, sort it, and store the sorted array in another file");
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.println("Enter the length of the array:");
                int length = scanner.nextInt();
                scanner.nextLine();

                Integer[] array = createRandomArray(length, Integer.class); //creates an array of random integers
 
                System.out.println("Enter the filename to store the array:");
                String filename = scanner.nextLine();

                writeArrayToFile(array, filename);
            } else if (choice == 2) {
                System.out.println("Enter the filename to read the array:"); //reads the file
                String filename = scanner.nextLine();

                Integer[] array = readFileToArray(filename, Integer.class); //reads the file and converts it to an array
 
                bubbleSort(array);

                System.out.println("Enter the filename to store the sorted array:"); //writes the sorted array to the file
                String sortedFilename = scanner.nextLine();

                writeArrayToFile(array, sortedFilename);
            } else { //if the user enters an invalid choice
                System.out.println("Invalid choice");
            }
        } finally {
            scanner.close();
        }

    }
}
