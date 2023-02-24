public class Cat extends Feline implements AnimalStuff{
    public Cat(String name) {
        super(name);
        System.out.println("It is a cat!");
    }

    @Override
    public String walk() {
        return "The cat" + super.walk();
    }

    public void sound() {
        System.out.println("meow");
    }

    @Override
    public void sleep() {
        System.out.println("ZZZ");
    }

    public void annoy() {
        System.out.println("walks in front of you");
    }

    public String eat() {
        return "The cat eats";
    }
}
