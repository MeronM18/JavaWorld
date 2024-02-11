package UML.Animals;

public class Pet extends Animal {
    String breed;
    String name;

    public Pet(String species, String breed, String name) {
        super(species, "Omnivore");
        this.breed = breed;
        this.name = name;
    }

    public void introduce() {
        super.introduce();
        System.out.println("I am a " + breed + " breed.");
        System.out.println("My name is " + name + ".");
    }

    public void play() {
        System.out.println("I am playing fetch!");
    }
}
