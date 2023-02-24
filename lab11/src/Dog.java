public class Dog extends Animal implements AnimalStuff {
    private String name;

    public Dog(String name) {
        this.name = name;
        System.out.println("There is a dog!");
    }

    @Override
    public String walk() {
        return "The dog" + super.walk();
    }

    @Override
    public void sound() {
        System.out.println("woof");
    }

    public String fetch() {
        return (getName() + " chases the stick");
    }

    @Override
    public String eat() {
        return "The dog consumes";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
