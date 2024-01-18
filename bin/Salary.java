package bin; 

import java.text.DecimalFormat;
import java.util.Scanner;

public class Salary {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Hi, this will calculate your salary!");
        System.out.println("Please enter your hourly wage: ");
        double wage = input.nextDouble();
        System.out.println("Please enter hours worked in a week: ");
        int hours = input.nextInt();
        System.out.println("Enter any cash bonuses: ");
        double bonus = input.nextDouble();

        double salary;

        if (hours > 40) {
            double overtime = hours - 40;
            double overtimePay = overtime * wage * 1.5;
            salary = (wage * 40 + overtimePay) * 52 + bonus;

            // Print detailed compensation breakdown with overtime
            System.out.println("The total compensation:");
            System.out.println("Base Salary: $" + (wage * 40));
            System.out.println("Overtime Hours: " + overtime);
            System.out.println("Overtime Pay: $" + overtimePay);
            System.out.println("Cash Bonuses: $" + bonus);
        } else {
            // Calculate salary without overtime pay
            salary = (wage * hours) * 52 + bonus;

            // Print detailed compensation breakdown without overtime
            System.out.println("The total compensation:");
            System.out.println("Base Salary: $" + (wage * hours));
        }

        // Print the final result
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("Your annual salary is: $" + df.format(salary));

        input.close();
    }
}
