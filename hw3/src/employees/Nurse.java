package employees;

public class Nurse extends Employee {
    private int patients;
    public Nurse(String name, int blazerID, int patients) {
        super(name, blazerID);
        this.patients = patients;
    }

    public int getPatients() {
        return patients;
    }

    public void setPatients(int patients) {
        this.patients = patients;
    }
}
