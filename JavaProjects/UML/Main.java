package UML;

import UML.Animals.Animal;
import UML.Animals.Pet;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal("Tiger", "Carnivore");
        Pet pet = new Pet("Dog", "Labrador", "Buddy");

        animal.introduce();
        pet.introduce();
        pet.play();
    }
}
