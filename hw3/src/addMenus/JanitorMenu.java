package addMenus;

import java.util.Scanner;

public class JanitorMenu extends AdminMenu {
    private String sweeping;
    public JanitorMenu(Scanner in) {
        super(in);
        System.out.print("Sweeping (y/n): ");
        sweeping = in.next().toUpperCase();
    }

    public String isSweeping() {
        return sweeping;
    }
}
