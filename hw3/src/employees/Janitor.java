package employees;

public class Janitor extends Admin {
    private String sweeping;
    public Janitor(String name, int blazerID, String department, String sweeping) {
        super(name, blazerID, department);
        this.sweeping = sweeping;
    }

    public String isSweeping() {
        return sweeping;
    }
}
