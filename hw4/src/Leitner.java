import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Leitner {
    public static void main(String[] args) {
        ArrayList<ArrayList<Flashcard>> deck = Box.setupBoxes(new ArrayList<>());
        Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
        Point spawnLoc = new Point((int) ((screenDim.getWidth() / 2) - 200), (int) ((screenDim.getHeight() / 2) - 300));

        //Optional theme change to make it look nice :)
        try {
            UIManager.setLookAndFeel(UIManager.createLookAndFeel("Nimbus"));
            JFrame.setDefaultLookAndFeelDecorated(true);
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        MainGui gui = new MainGui(deck, spawnLoc);
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                gui.createAndShowGUI();
            }
        });


    }
}
