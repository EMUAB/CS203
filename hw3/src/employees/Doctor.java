package employees;

public class Doctor extends Employee{
    private String specialty;
    public Doctor(String name, int blazerID, String specialty) {
        super(name, blazerID);
        this.specialty = specialty;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}
