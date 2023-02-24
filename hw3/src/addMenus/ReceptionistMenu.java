package addMenus;

import java.util.Scanner;

public class ReceptionistMenu extends AdminMenu {
    private String answering;
    public ReceptionistMenu(Scanner in) {
        super(in);
        System.out.print("Answering (y/n): ");
        answering = in.next().toUpperCase();
    }

    public String isAnswering() {
        return answering;
    }
}
