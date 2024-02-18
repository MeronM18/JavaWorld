package Generics; //MERON MATTI

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class MergeSortG<T extends Comparable<T>> { 
    public static <T extends Comparable<T>> T[] createRandomArray(int arrayLength, Class<T> type) { //method to create random array
    T[] array = (T[]) Array.newInstance(type, arrayLength);
    Random random = new Random();
    for (int i = 0; i < arrayLength; i++) {
        array[i] = type.cast(Integer.valueOf(random.nextInt(101))); //random integers from 0 to 100
    }
    return array;
}


    public static <T extends Comparable<T>> void writeArrayToFile(T[] array, String filename) {
        try (PrintWriter writer = new PrintWriter(filename)) { //writes the array to the file
            for (T element : array) { //writes the array to the file
                writer.println(element);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static <T extends Comparable<T>> T[] readFileToArray(String filename, Class<T> type) { //reads the file and converts it to an array
        List<T> list = new ArrayList<>(); //creates a list
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                try {
                    T element = type.cast(Integer.valueOf(line));
                    list.add(element); //adds the elements to the list
                } catch (NumberFormatException e) {
                    // Handle invalid input
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    
        T[] array = (T[]) Array.newInstance(type, list.size()); //converts the list to an array
        return list.toArray(array);
    }
    
 
    public static <T extends Comparable<T>> void mergeSort(T[] array) { //merge sort method
        if (array.length <= 1) {
            return;
        }

        int mid = array.length / 2;
        T[] leftArray = Arrays.copyOfRange(array, 0, mid); //splits the array into two halves
        T[] rightArray = Arrays.copyOfRange(array, mid, array.length);  //splits the array into two halves

        mergeSort(leftArray);
        mergeSort(rightArray);

        merge(leftArray, rightArray, array);
    }

    public static <T extends Comparable<T>> void merge(T[] leftArray, T[] rightArray, T[] result) { //merge method
        int leftIndex = 0, rightIndex = 0, resultIndex = 0;

        while (leftIndex < leftArray.length && rightIndex < rightArray.length) { //merges the two halves
            if (leftArray[leftIndex].compareTo(rightArray[rightIndex]) < 0) {
                result[resultIndex++] = leftArray[leftIndex++];
            } else {
                result[resultIndex++] = rightArray[rightIndex++];
            }
        }

        while (leftIndex < leftArray.length) { //merges the two halves
            result[resultIndex++] = leftArray[leftIndex++];
        }

        while (rightIndex < rightArray.length) {
            result[resultIndex++] = rightArray[rightIndex++];
        }
    }

    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        int choice; //menu driven program
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

                Integer[] array = createRandomArray(length, Integer.class); //creates a random array

                System.out.println("Enter the filename to store the array:");
                String filename = scanner.nextLine();

                writeArrayToFile(array, filename); //writes the array to the file
            } else if (choice == 2) {
                System.out.println("Enter the filename to read the array:");
                String filename = scanner.nextLine();

                Integer[] array = readFileToArray(filename, Integer.class);

                mergeSort(array); //sorts the array

                System.out.println("Enter the filename to store the sorted array:");
                String sortedFilename = scanner.nextLine();

                writeArrayToFile(array, sortedFilename); //writes the sorted array to the file
            } else {
                System.out.println("Invalid choice");
            }
        } finally {
            scanner.close();
        }
    }
}

