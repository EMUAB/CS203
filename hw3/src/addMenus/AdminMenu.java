package addMenus;

import java.util.Scanner;

public class AdminMenu extends EmployeeMenu {
    private String department;
    public AdminMenu(Scanner in) {
        super(in);
        System.out.print("Department: ");
        department = in.next();
    }

    public String getDepartment() {
        return department;
    }
}
