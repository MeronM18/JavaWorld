import java.util.Scanner;

class Vehicle {
    String car;
    String model;
    int year;
    String color;

    public void carDetails() {
        System.out.println("");
        System.out.println("Car Details!");
        System.out.println("------------");
        System.out.println("Car Brand: " + car);
        System.out.println("Car Model: " + model);
        System.out.println("Car Year: " + year);
        System.out.println("Car Color: " + color);
    }
}

public class App1 {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        Vehicle myCar = new Vehicle();

        System.out.println("Hi, this will gather information about your car!");

        System.out.println("Enter your car brand:");
        String brand = input.nextLine();
        myCar.car = brand;

        System.out.println("Enter model of car:");
        String model = input.nextLine();
        myCar.model = model;

        System.out.println("Enter your car year:");
        int date = input.nextInt();
        myCar.year = date;

        input.nextLine(); // Consume the newline character left by nextInt()

        System.out.println("Enter color of car:");
        String color = input.nextLine();
        myCar.color = color;

        myCar.carDetails();

        input.close();
    }
}
