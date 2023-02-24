import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ModifyCardGui extends SimpleGui {
    private JTextField front, back;
    private JFrame frame;
    private Point spawnLoc;
    private ArrayList<ArrayList<Flashcard>> deck;
    private Flashcard card;
    private JLabel mainlabel;

    public ModifyCardGui(ArrayList<ArrayList<Flashcard>> deck, Flashcard card, Point spawnLoc, JLabel label) {
        this.deck = deck;
        this.spawnLoc = spawnLoc;
        spawnLoc.translate(100, 100);
        this.card = card;
        this.mainlabel = label;
    }

    public void createAndAddComponents() {
        front = new JTextField();
        front.setBorder(BorderFactory.createTitledBorder("Front"));
        front.setAlignmentX(Component.CENTER_ALIGNMENT);
        front.setPreferredSize(new Dimension(300, 70));
        front.setText(card.getFront());

        back = new JTextField();
        back.setBorder(BorderFactory.createTitledBorder("Back"));
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        back.setPreferredSize(new Dimension(300, 70));
        back.setText(card.getBack());

        JButton modify = new JButton();
        modify.setText("Modify");
        modify.setAlignmentX(Component.CENTER_ALIGNMENT);
        modify.addActionListener(new MainListener());

        frame.add(front);
        frame.add(back);
        frame.add(modify);

    }

    public void createAndShowGUI() {
        frame = new JFrame();
        frame.setLocation(spawnLoc);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setTitle("Modify card");
        createAndAddComponents();

        frame.pack();
        frame.setVisible(true);
    }


    public class MainListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            card.setFront(front.getText());
            card.setBack(back.getText());
            JOptionPane.showMessageDialog(null, "Successfully modified card!\nFront: " + front.getText() + "\nBack: " + back.getText());
            mainlabel.setText(front.getText());
            frame.dispose();
        }
    }
}
