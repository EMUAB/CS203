package addMenus;

import java.util.Scanner;

public class EmployeeMenu {
    private int blazerId;
    private String name;
    public EmployeeMenu(Scanner in) {
        System.out.print("Name: ");
        name = in.next();
        System.out.print("BlazerID: ");
        blazerId = in.nextInt();
    }

    public int getBlazerId() {
        return blazerId;
    }

    public String getName() {
        return name;
    }
}
