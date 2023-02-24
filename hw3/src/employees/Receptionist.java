package employees;

public class Receptionist extends Admin {
    private String answering;
    public Receptionist(String name, int blazerID, String department, String answering) {
        super(name, blazerID, department);
        this.answering = answering;
    }

    public String isAnswering() {
        return answering;
    }
}
