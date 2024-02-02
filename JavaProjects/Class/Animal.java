public class Animal {
    public int age;
    public String gender; 

    public void isMammal() {
        System.out.println("This is a method from the Animal class.");
    }

    public void mate() {
        System.out.println("This is a method from the Animal class.");
    }

    public static void main(String[] args) {
        Animal myAnimal = new Animal(); 
        Zebra myZebra = new Zebra();

        myAnimal.isMammal();
        myAnimal.mate();
        myZebra.run();
    }
}

class Fish extends Animal {
    public void canEat() {
        System.out.println("This is a method from the Fish class.");
    }
}

class Zebra extends Animal {
    public boolean is_wild;

    public void run() {
        System.out.println("This is a method from the Zebra class.");
    }
}