package JavaProjects;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in); 
        
        System.out.println("This program will take a string and print it in reverse order!");
        System.out.print("Enter a string: ");

        String userInput = scanner.nextLine();

        System.out.println("The reversed string is: ");
            for (int i = userInput.length() - 1; i >= 0; i--) {
                System.out.print(userInput.charAt(i));
            }

        

        scanner.close();
    }
}
