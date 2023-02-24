import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainGuiTester {
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.createLookAndFeel("Nimbus"));
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        JFrame.setDefaultLookAndFeelDecorated(true);

        MainGui gui = new MainGui(Box.setupBoxes(new ArrayList<ArrayList<Flashcard>>()), new Point(500, 500));
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                gui.createAndShowGUI();
            }
        });
    }

}
