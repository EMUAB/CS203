import javax.swing.*;

public class CalculatorRun {
    public static void main(String[] args) {
        MainGui gui = new MainGui();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        gui.createAndShowGui();
    }
}
