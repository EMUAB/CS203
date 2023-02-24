package employees;

public class Surgeon extends Doctor {
    private String operating;
    public Surgeon(String name, int blazerID, String specialty, String operating) {
        super(name, blazerID, specialty);
        this.operating = operating;
    }

    public String isOperating() {
        return operating;
    }
}
