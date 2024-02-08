package MergeSort; //Meron Matti

import java.io.*;
import java.util.*;

public class MergeSort {
    public static int[] createRandomArray(int arrayLength) { //method that takes an integer parameter and returns an array of random integers
        int[] array = new int[arrayLength];  //creates an array of integers
        Random random = new Random(); //creates a new random object
        for (int i = 0; i < arrayLength; i++) { // for loop to iterate through the array
            array[i] = random.nextInt(101); //assigns a random integer to each index of the array
        }
        return array;
    }

    public static void writeArrayToFile(int[] array, String filename) { //method that takes an array of integers and a string parameter and writes the array to a file
        try (PrintWriter writer = new PrintWriter(filename)) { //try with resources to create a new PrintWriter object
            for (int num : array) { //for each loop to iterate through the array
                writer.println(num); //writes each integer to the file
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int[] readFileToArray(String filename) { //method that takes a string parameter and reads the file to an array of integers
        List<Integer> list = new ArrayList<>(); //creates a new ArrayList of integers
        try (Scanner scanner = new Scanner(new File(filename))) { //try with resources to create a new Scanner object
            while (scanner.hasNextInt()) { //while loop to iterate through the file
                list.add(scanner.nextInt()); //adds each integer to the ArrayList
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int[] array = new int[list.size()]; // creates a new array of integers with the size of the ArrayList
        for (int i = 0; i < list.size(); i++) { //for loop to iterate through the ArrayList
            array[i] = list.get(i); //  assigns each integer to the array
        }
        return array;
    }

    public static void mergeSort(int[] array) { //method that takes an array of integers and sorts it using the merge sort algorithm
        if (array.length <= 1) {
            return;
        }
        
        int mid = array.length / 2;
        int[] leftArray = Arrays.copyOfRange(array, 0, mid);
        int[] rightArray = Arrays.copyOfRange(array, mid, array.length);
        
        mergeSort(leftArray);
        mergeSort(rightArray);
        
        merge(leftArray, rightArray, array);
    }
    
    public static void merge(int[] leftArray, int[] rightArray, int[] result) {
        int leftIndex = 0, rightIndex = 0, resultIndex = 0;
        
        while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
            if (leftArray[leftIndex] < rightArray[rightIndex]) {
                result[resultIndex++] = leftArray[leftIndex++];
            } else {
                result[resultIndex++] = rightArray[rightIndex++];
            }
        }
        
        while (leftIndex < leftArray.length) {
            result[resultIndex++] = leftArray[leftIndex++];
        }
        
        while (rightIndex < rightArray.length) {
            result[resultIndex++] = rightArray[rightIndex++];
        }
    }

    public static void main(String[] arg) { 
        Scanner scanner = new Scanner(System.in);
        int choice;
        try { //try block to handle exceptions
            System.out.println("Enter your choice:");
            System.out.println("1. Generate an array of random integers and store it in a file");
            // Remove the declaration of int choice
            System.out.println("2. Read an existing file containing a list of integers, sort it, and store the sorted array in another file");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            if (choice == 1) { //if statement to check if the user input is 1
                System.out.println("Enter the length of the array:"); 
                int length = scanner.nextInt(); //gets the length of the array
                scanner.nextLine(); // Consume newline character

                int[] array = createRandomArray(length); //creates an array of random integers

                System.out.println("Enter the filename to store the array:");
                String filename = scanner.nextLine();

                writeArrayToFile(array, filename);
            } else if (choice == 2) { //else if statement to check if the user input is 2
                System.out.println("Enter the filename to read the array:");
                String filename = scanner.nextLine();

                int[] array = readFileToArray(filename); //reads the file to an array of integers
 
                mergeSort(array); //sorts the array using the merge sort algorithm

                System.out.println("Enter the filename to store the sorted array:");
                String sortedFilename = scanner.nextLine();

                writeArrayToFile(array, sortedFilename);
            } else {
                System.out.println("Invalid choice");
            }
        } finally {
            scanner.close();
        }

    }
}
