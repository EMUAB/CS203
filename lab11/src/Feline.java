public class Feline extends Animal {
    private String animalName;

    public Feline(String name) {
        animalName=name;
        System.out.println("Some sort of feline is near...");
    }

    @Override
    public String walk() {
        return "The feline" + super.walk();
    }

    @Override
    public void sound() {
        System.out.println(getAnimalName() + " made a noise");
    }

    public void sleep() {
        System.out.println("zzz");
    }

    public void setAnimalName(String name) {
        animalName=name;
    }

    public String getAnimalName() {
        return animalName;
    }
}
