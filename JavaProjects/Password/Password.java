package Password; //Meron Matti

import java.util.Scanner;

public class Password {
    public static void main(String[] args) {
        final int NUM_LOWER_LETTERS = 1; //defining constants for lowercase, uppercase letters, numbers, and special symbols
        final int NUM_UPPER_LETTERS = 1;
        final int NUM_DIGITS = 1;
        final int NUM_SPECIAL_CHARS = 1;
        int lowerCount = 0; //declaring variables to keep track of the constants 
        int upperCount = 0;
        int digitCount = 0;
        int specialCount = 0;
        Scanner input = new Scanner(System.in); //initialize scanner to receive user input

        System.out.println("Hi, this will check if password entered meets the requirements:"); //front-end program layout and requirements
        System.out.println("(1) password length between 8 - 16");
        System.out.println("(2) lower case letters, i.e, a-z");
        System.out.println("(3) upper case letters, i.e, A-Z");
        System.out.println("(4) numbers, i.e, 0-9");
        System.out.println("(5) special symbols: ~!@#$%^&*()+-");
        System.out.println("\nEnter password: ");
        String password = input.nextLine();
        
        int passLength = password.length(); //get the length of password and store it into int variable

        for (int i = 0; i < passLength; i++) 
        {
            char ch = password.charAt(i); //extracts one character from string at a time
            if (Character.isLowerCase(ch)) {
                lowerCount++; //if statement to check if character is lowercase and increments count by 1
            } else if (Character.isUpperCase(ch)) {
                upperCount++; //if statement to check if character is uppercase and increments count by 1
            } else if (Character.isDigit(ch))  {
                digitCount++; //if statement to check for numbers
            } else if (ch == '~' || ch == '!' || ch == '@' || ch == '#' || ch == '$' || ch == '%' || ch == '^' || ch == '&'
                || ch == '*' || ch == '(' || ch == ')' || ch == '-' || ch == '=' || ch == '+' || ch == '_') {
                specialCount++; //if statement to check for special symbols
            } 

        }

            if (passLength >= 8 && passLength <= 16 && lowerCount >= NUM_LOWER_LETTERS && upperCount >= NUM_UPPER_LETTERS && digitCount >= NUM_DIGITS 
                && specialCount >= NUM_SPECIAL_CHARS) {
                    System.out.println("Password meets the requirements!"); //checks if password meets all the requirements
                } else {
                System.out.println("The password is missing these requirements:"); //if statements when password is short of the requirements
                if (passLength < 8) {
                    System.out.println("password is too short");
                }
                if (passLength > 16) {
                    System.out.println("password is too long");
                }
                if (lowerCount < NUM_LOWER_LETTERS) {
                    System.out.println("lowercase letters");
                }
                if (upperCount < NUM_UPPER_LETTERS) {
                    System.out.println("uppercase letters");
                }
                if (digitCount < NUM_DIGITS) {
                    System.out.println("numbers");
                }
                if (specialCount < NUM_SPECIAL_CHARS) {
                    System.out.println("special symbols");
                }
            }

            input.close(); //close scanner
    }
}
