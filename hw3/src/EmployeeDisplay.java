import employees.*;
import java.util.ArrayList;

public class EmployeeDisplay {
    EmployeeDisplay() {
    }

    /**Generates a visual representation of the data in the employees ArrayList in String value
     * @param employees
     * @return {@code String}
     */
    public String printList(ArrayList<Employee> employees) {
        String intro = "**********************************\nWelcome to the UAB Employee System\n*********************************\nThe UAB Hospital System has the following employees:\n\n";
        String totalEmp = "Total Number of employees = " + employees.size() + "\n\n";
        ArrayList<String> hospital = new ArrayList<>(), doctor = new ArrayList<>(), surgeon = new ArrayList<>(), nurse = new ArrayList<>(), admin = new ArrayList<>(), receptionist = new ArrayList<>(), janitor = new ArrayList<>();
        for (Employee emp : employees) {
            if (emp instanceof Doctor) {
                if (emp instanceof Surgeon) {
                    surgeon.add("Name: " + emp.getName() + " BlazerId: " + emp.getBlazerID() + " Specialty: " + ((Surgeon) emp).getSpecialty() + " Operating: " + ((Surgeon) emp).isOperating());
                } else {
                    doctor.add("Name: " + emp.getName() + " BlazerId: " + emp.getBlazerID() + " Specialty: " + ((Doctor) emp).getSpecialty());
                }
            } else if (emp instanceof Admin) {
                if (emp instanceof Receptionist) {
                    receptionist.add("Name: " + emp.getName() + " BlazerId: " + emp.getBlazerID() + " Department: " + ((Receptionist) emp).getDepartment() + " Answering: " + ((Receptionist) emp).isAnswering());
                } else if (emp instanceof Janitor) {
                    janitor.add("Name: " + emp.getName() + " BlazerId: " + emp.getBlazerID() + " Department: " + ((Janitor) emp).getDepartment() + " Sweeping: " + ((Janitor) emp).isSweeping());
                } else {
                    admin.add("Name: " + emp.getName() + " BlazerId: " + emp.getBlazerID() + " Department: " + ((Admin) emp).getDepartment());
                }
            } else if (emp instanceof Nurse) {
                nurse.add("Name: " + emp.getName() + " BlazerId: " + emp.getBlazerID() + " Number of patients: " + ((Nurse) emp).getPatients());
            } else {
                hospital.add("Name: " + emp.getName() + " BlazerId: " + emp.getBlazerID());
            }
        }
        String mid = "Hospital Employees: " + hospital.size() + "\n";
        for (String i : hospital) {
            mid += i + "\n";
        }
        mid += "\nDoctors: " + doctor.size() + "\n";
        for (String i : doctor) {
            mid += i + "\n";
        }
        mid += "\nSurgeons: " + surgeon.size() + "\n";
        for (String i : surgeon) {
            mid += i + "\n";
        }
        mid += "\nNurses: " + nurse.size() + "\n";
        for (String i : nurse) {
            mid += i + "\n";
        }
        mid += "\nAdministrators: " + admin.size() + "\n";
        for (String i : admin) {
            mid += i + "\n";
        }
        mid += "\nReceptionist: " + receptionist.size() + "\n";
        for (String i : receptionist) {
            mid += i + "\n";
        }
        mid += "\nJanitors: " + janitor.size() + "\n";
        for (String i : janitor) {
            mid += i + "\n";
        }
        mid += "\n******************************************************************";
        return intro + totalEmp + mid;
    }
}
