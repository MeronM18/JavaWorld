package UML.Animals;

public class Animal {
    String species;
    String diet;

    public Animal(String species, String diet) { //constructor that takes two parameters
        this.species = species; //
        this.diet = diet;
    }

    public void introduce() {
        System.out.println("I am a " + species + ".");
        System.out.println("I am a " + diet + ".");
    }
}
