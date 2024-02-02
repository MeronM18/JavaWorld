package BubbleSort; //Meron Matti

import java.io.*;
import java.util.*;

public class BubbleSort {
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

    public static void bubbleSort(int[] array) { //method that takes an array of integers and sorts it using the bubble sort algorithm
        int n = array.length; //gets the length of the array
        for (int i = 0; i < n - 1; i++) { //for loop to iterate through the array
            for (int j = 0; j < n - i - 1; j++) { //nested for loop to iterate through the array
                if (array[j] > array[j + 1]) { //if statement to compare the current integer with the next integer
                    int temp = array[j]; //swaps the integers if the current integer is greater than the next integer
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
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
 
                bubbleSort(array); //sorts the array using the bubble sort algorithm

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