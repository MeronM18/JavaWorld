package ReverseString;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in); //create a scanner that takes user input
        
        System.out.println("This program will take a string and print it in reverse order!"); //explains what the program does
        System.out.print("Enter a string: ");

        String userInput = scanner.nextLine(); //receives string input from user

        System.out.println("The reversed string is: ");
            for (int i = userInput.length() - 1; i >= 0; i--) { //for loop that sets i equal to the length of string - 1
                System.out.print(userInput.charAt(i)); //i decreases by 1 and prints each character starting from the end of the string
            }        

        scanner.close(); //close scanner
    }
}
