package CountWords;
//Meron Matti
import java.io.*;
import java.util.*;

public class CountWords {

    public static void main(String[] args) {
        // Create a scanner object for user input
        Scanner scanner = new Scanner(System.in);
        String inputFileName = getInputFileName(scanner);
        
        // Read word counts from the input file
        Map<String, Integer> wordCountMap = readWordCountsFromFile(inputFileName);

        String outputFileName = getOutputFileName(scanner);
        
        // Write word counts to the output file
        writeWordCountsToFile(wordCountMap, outputFileName);
        
        // Print a message indicating the word count is completed
        System.out.println("Word count completed. Results written to " + outputFileName);
    }

    // Method to get the input file name from the user
    private static String getInputFileName(Scanner scanner) {
        System.out.print("Enter input file name: ");
        return scanner.nextLine();
    }

    // Method to get the output file name from the user
    private static String getOutputFileName(Scanner scanner) {
        System.out.print("Enter output file name: ");
        return scanner.nextLine();
    }

    // Method to read word counts from the input file
    private static Map<String, Integer> readWordCountsFromFile(String inputFileName) {
        // Create a map to store word counts
        Map<String, Integer> wordCountMap = new HashMap<>();
        try (Scanner fileScanner = new Scanner(new File(inputFileName))) {
            // Read words from the file
            while (fileScanner.hasNext()) {
                String word = fileScanner.next();
                // Update word count in the map
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + inputFileName);
        }
        return wordCountMap;
    }

    // Method to write word counts to the output file
    private static void writeWordCountsToFile(Map<String, Integer> wordCountMap, String outputFileName) {
        try (PrintWriter writer = new PrintWriter(new File(outputFileName))) {
            // Write word counts to the file
            for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
                writer.println(entry.getKey() + " " + entry.getValue());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error writing to file: " + outputFileName);
        }
    }
}
