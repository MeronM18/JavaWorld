package JavaProjects.MetricConverter;

import java.util.Scanner;

//meron matti
/**
 * MetricConverter 
 */
public class MetricConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Metric Converter!"); //prints the directions for the program and this is what user sees
        System.out.println("Please input your query. For example, '1 km to mile'");
        System.out.println("Enter 'exit' or '-1' to quit the program");
    
        while (true) {
            System.out.print("Enter your query: "); //user enters conversions
            String userInput = scanner.nextLine();
    
            if (userInput.equalsIgnoreCase("exit") || userInput.equals("-1")) {
                System.out.println("Exiting the program. Goodbye!"); //this exits the program and ends it
                break;
            }
    
            //convert the input for value, first unit, and final unit
            String[] parts = userInput.split("\\s+"); //splits the user input into an array of strings
            try {
                double value = Double.parseDouble(parts[0]); //this converts the first number to adouble value
                String firstUnit = parts[1]; //extracts the first unit before the 'to' keyword
                String finalUnit = parts[3]; //extracts the final unut after the 'to' keyword
    
                //call the convert method
                double result = convert(value, firstUnit, finalUnit);
    
                //display the result in the format : first value + unit + = + converted unit + final unit
                System.out.println(value + " " + firstUnit + " = " + result + " " + finalUnit);
            } catch (Exception e) {
                System.out.println("Invalid input format. Please enter a valid query."); //if any exception occurs, prints error message
            }
        }
    
        scanner.close(); //closes input scanner
    }

    private static double convert(double value, String firstUnit, String finalUnit) { //method that takes three parameters and performs conversions
         
            switch (firstUnit.toLowerCase()) { //mass conversion 
                case "kg":
                case "kilogram":
                case "kilograms":
                case "kilo":
                case "kgs":
                    switch (finalUnit.toLowerCase()) {
                        case "pounds":
                        case "pound":
                        case "lbs":
                        case "lb":
                            return value * 2.20462;
                        case "grams":
                        case "g":
                        case "gram":
                            return value * 1000;
                        default:
                            break;
                    }
            
                case "lb":
                case "lbs":
                case "pound":
                case "pounds":
                    switch (finalUnit.toLowerCase()) {
                        case "kilo":
                        case "kilograms":
                        case "kilogram":
                        case "kg":
                        case "kgs":
                            return value / 2.2046;
                        case "grams": 
                        case "g":
                        case "gram":
                            return value * 453.59237;
                        default:
                            break;
                    }
                
                case "g":
                case "grams":
                case "gram":
                    switch(finalUnit.toLowerCase()) {
                        case "lbs":
                        case "pounds":
                        case "pound":
                        case "lb":
                            return value / 453.59237;
                        case "kilo":
                        case "kilograms":
                        case "kg":
                        case "kilogram":
                        case "kgs":
                            return value / 1000;
                        case "oz":
                        case "ounces":
                        case "ounce":
                            return value / 28.3495231;
                        default:
                            break;
                    }
                
                case "kilometer": //length converion
                case "kilometers":
                case "km":
                    switch(finalUnit.toLowerCase()) {
                        case "meters":
                        case "meter":
                        case "m":
                            return value * 1000;
                        case "mile":
                        case "miles":
                        case "mi":
                            return value / 1.609344;
                        case "inches":
                        case "inch":
                        case "in":
                            return value * 39370.0787;
                        default:
                            break;
                    }

                case "millimeter":
                case "millimeters": 
                case "mm": 
                    switch(finalUnit.toLowerCase()) {
                        case "inches":
                        case "inch": 
                        case "in": 
                            return value / 25.4;
                        case "centimeters":
                        case "centimeter":
                        case "cm":
                            return value / 10;
                        default:
                            break;
                    }

                case "miles":
                case "mi":
                case "mile":
                    switch(finalUnit.toLowerCase()) {
                        case "km":
                        case "kilometers":
                        case "kilometer":
                            return value * 1.609344;
                        case "feet":
                        case "ft": 
                            return value * 5280;
                        case "meters":
                        case "meter":
                        case "m":
                            return value * 1609.344;
                        default:
                            break;
                    }
          
                case "inches":
                case "inch": 
                case "in": 
                    switch(finalUnit.toLowerCase()) {
                        case "centimeters": 
                        case "cm":
                        case "centimeter": 
                            return value * 2.54;
                        case "feet":
                        case "ft":
                            return value * 12;
                        case "yards": 
                        case "yds":
                        case "yd":
                            return value / 36;
                        default:
                            break;
                    }

                case "cm":
                case "centimeters": 
                case "centimeter":
                    switch(finalUnit.toLowerCase()) {
                        case "inches":
                        case "inch":
                        case "in":
                            return value / 2.54;
                        case "millimeters":
                        case "millimeter":
                        case "mm": 
                            return value * 10;
                        default:
                            break;
                    }

                case "yards":
                case "yard":
                case "yd":
                    switch(finalUnit.toLowerCase()) {
                        case "inches":
                        case "inch":
                        case "in": 
                            return value * 36;
                        case "meters":
                        case "m":
                        case "meter":
                            return value / 1.0936133;
                        case "miles":
                        case "mi":
                        case "mile":
                            return value / 1760;
                        case "kilometers":
                        case "km":
                        case "kilometer":
                            return value / 1093.6133;
                        default:
                            break;
                    }
                
                             break;

                default:
                    System.out.println("Your input is not currently handled by this app, please input another query, for example, 1 kg = lb");
                        return 0.0; //error message if user inputs a conversion that is not handled
            
        }
        
            return value;

    }

    
}