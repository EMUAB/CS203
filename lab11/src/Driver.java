public class Driver {
    public static void main(String[] args) {
        Cat cat = new Cat("cat");
        Feline feline = new Feline("fiddli");
        Dog dog = new Dog("dog");

        System.out.println(feline.walk());
        feline.sound();
        feline.sleep();

        System.out.println(dog.walk());
        dog.sound();
        dog.fetch();
        System.out.println(dog.eat());

        System.out.println(cat.walk());
        cat.sound();
        cat.sleep();
        System.out.println(cat.eat());
        cat.annoy();
    }
}
