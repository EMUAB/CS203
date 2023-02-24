package employees;

public class Admin extends Employee{
    private String department;
    public Admin(String name, int blazerID, String department) {
        super(name, blazerID);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
