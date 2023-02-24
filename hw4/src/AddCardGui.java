import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddCardGui extends SimpleGui {
    private JTextField front, back;
    private JFrame frame;
    private Point spawnLoc;
    private ArrayList<ArrayList<Flashcard>> deck;

    public AddCardGui(ArrayList<ArrayList<Flashcard>> deck, Point spawnLoc) {
        this.deck = deck;
        this.spawnLoc = spawnLoc;
        spawnLoc.translate(100, 100);
    }

    public void createAndAddComponents() {
        front = new JTextField();
        front.setBorder(BorderFactory.createTitledBorder("Front"));
        front.setAlignmentX(Component.CENTER_ALIGNMENT);
        front.setPreferredSize(new Dimension(300, 70));

        back = new JTextField();
        back.setBorder(BorderFactory.createTitledBorder("Back"));
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        back.setPreferredSize(new Dimension(300, 70));

        JButton add = new JButton();
        add.setText("Add");
        add.setAlignmentX(Component.CENTER_ALIGNMENT);
        add.addActionListener(new MainListener());

        frame.add(front);
        frame.add(back);
        frame.add(add);
    }

    public void createAndShowGUI() {
        frame = new JFrame();
        frame.setAlwaysOnTop(true);
        frame.setLocation(spawnLoc);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setTitle("Add a card");
        createAndAddComponents();

        frame.pack();
        frame.setVisible(true);
    }

    public class MainListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Box.addNewCard(deck, new Flashcard(front.getText(), back.getText()));
            front.setText("");
            back.setText("");
            frame.setTitle("Added flashcard!");
        }
    }
}
