package addMenus;

import java.util.Scanner;

public class NurseMenu extends EmployeeMenu {
    private int patients;
    public NurseMenu(Scanner in) {
        super(in);
        System.out.print("Number of patients: ");
        patients = in.nextInt();
    }

    public int getPatients() {
        return patients;
    }
}
