import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class InspectGui extends SimpleGui {
    private JFrame frame;
    private Point spawnLoc;
    private ArrayList<ArrayList<Flashcard>> deck;

    public InspectGui(ArrayList<ArrayList<Flashcard>> deck, Point spawnLoc) {
        this.spawnLoc = spawnLoc;
        this.spawnLoc.translate(50, 50);
        this.deck = deck;
    }

    public void createAndAddComponents() {
        String[] columnNames = {"Front", "Back"};
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setPreferredSize(new Dimension(400, 250));


        Object[][] b1info = formatCardInfo(deck.get(0));
        JTable b1t = new JTable(b1info, columnNames);

        JScrollPane box1 = new JScrollPane(b1t);
        tabbedPane.addTab("Box 1", box1);

        Object[][] b2info = formatCardInfo(deck.get(1));
        JTable b2t = new JTable(b2info, columnNames);
        JScrollPane box2 = new JScrollPane(b2t);
        tabbedPane.addTab("Box 2", box2);

        Object[][] b3info = formatCardInfo(deck.get(2));
        JTable b3t = new JTable(b3info, columnNames);
        JScrollPane box3 = new JScrollPane(b3t);
        tabbedPane.addTab("Box 3", box3);

        Object[][] b4info = formatCardInfo(deck.get(3));
        JTable b4t = new JTable(b4info, columnNames);
        JScrollPane box4 = new JScrollPane(b4t);
        tabbedPane.addTab("Box 4", box4);

        Object[][] b5info = formatCardInfo(deck.get(4));
        JTable b5t = new JTable(b5info, columnNames);
        JScrollPane box5 = new JScrollPane(b5t);
        tabbedPane.addTab("Box 5", box5);

        frame.add(tabbedPane, BorderLayout.CENTER);
    }

    public void createAndShowGUI() {
        frame = new JFrame();
        frame.setAlwaysOnTop(true);
        frame.setLocation(spawnLoc);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Inspect");
        createAndAddComponents();

        frame.pack();
        frame.setVisible(true);
    }

    public Object[][] formatCardInfo(ArrayList<Flashcard> listIn) {
        Flashcard[] cards = listIn.toArray(new Flashcard[listIn.size()]);
        Object[][] out = new Object[listIn.size()][];
        for (int i = 0; i < listIn.size(); i++) {
            out[i] = cards[i].toArray();
        }
        return out;
    }
}
