package employees;

public class Employee {
    private String name;
    private int blazerID;
    public Employee(String name, int blazerID) {
        this.name = name;
        this.blazerID = blazerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlazerID() {
        return blazerID;
    }

    public void setBlazerID(int blazerID) {
        this.blazerID = blazerID;
    }
}
