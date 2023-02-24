package addMenus;

import java.util.Scanner;

public class SurgeonMenu extends DoctorMenu{
    private String operating;
    public SurgeonMenu(Scanner in) {
        super(in);
        System.out.print("Operating (y/n): ");
        operating = in.next().toUpperCase();
    }

    public String isOperating() {
        return operating;
    }
}
