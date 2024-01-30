package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        // Create a new file named "test.txt"
        File file = new File("test.txt");

        try {
            if (file.createNewFile()) {
                System.out.println("File created successfully.");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }
    }
}

    /**
     * InnerTest
     */
    class WritetoFile {
     public static void main(String[] args) {
        try {
            FileWriter myWriter = new FileWriter("test.txt");
            myWriter.write("HAAA URFTY JAZZZZ");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
     }   
       
    }
    
    class ReadFIle {
        public static void main(String[] args) {
            try {
              File myObj = new File("test.txt");
              Scanner myReader = new Scanner(myObj);
              while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
              }
              myReader.close();
            } catch (FileNotFoundException e) {
              System.out.println("An error occurred.");
              e.printStackTrace();
            }

            File file = new File("test.txt");
            if (file.exists()) {
                System.out.println("File name: " + file.getName());
                System.out.println("Absolute path: " + file.getAbsolutePath());
                System.out.println("Writeable: " + file.canWrite());
                System.out.println("Readable " + file.canRead());
                System.out.println("File size in bytes " + file.length());
            } else {
                System.out.println("File does not exist");
            }
          }
    }