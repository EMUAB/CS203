package addMenus;

import java.util.Scanner;

public class DoctorMenu extends EmployeeMenu {
    private String specialty;

    public DoctorMenu(Scanner in) {
        super(in);
        System.out.print("Specialty: ");
        specialty = in.next();

    }

    public String getSpecialty() {
        return specialty;
    }
}
