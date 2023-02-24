import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class InExGui extends SimpleGui {
    private JFrame frame;
    private JTextPane pane;
    private String exportString = "";
    private JButton closeButton;
    private Point spawnLoc;
    private boolean isEditable = false;
    private ArrayList<ArrayList<Flashcard>> deck;

    /**
     * Creates a GUI used for exporting a String converted from a deck
     **/
    public InExGui(String exportString, Point spawnLoc) {
        this.exportString = exportString;
        this.spawnLoc = spawnLoc;
        spawnLoc.translate(100, 25);
        this.isEditable = false;
    }

    /**
     * Creates a GUI used for importing a String and converting it into a deck
     **/
    public InExGui(ArrayList<ArrayList<Flashcard>> deckIn, Point spawnLoc) {
        this.spawnLoc = spawnLoc;
        spawnLoc.translate(100, 25);
        this.isEditable = true;
        this.deck = deckIn;
    }

    public void createAndAddComponents() {
        pane = new JTextPane();
        pane.setEditable(isEditable);
        pane.setText(exportString);
        pane.setPreferredSize(new Dimension(300, 300));
        pane.setFont(new Font("Dialog", Font.PLAIN, 15));

        JSplitPane split = new JSplitPane();
        split.setEnabled(false);
        split.setDividerLocation(150);
        split.setDividerSize(10);

        JButton copyButton = new JButton();
        copyButton.setText("Copy");
        copyButton.setToolTipText("Copies the above text to the clipboard");
        copyButton.setActionCommand("copy");
        copyButton.addActionListener(new ButtonListener());

        JButton pasteButton = new JButton();
        pasteButton.setText("Paste");
        pasteButton.setToolTipText("Pastes the current clipboard contents into the pane");
        pasteButton.setActionCommand("paste");
        pasteButton.addActionListener(new ButtonListener());

        closeButton = new JButton();
        closeButton.setText("Close");
        closeButton.setActionCommand("close");
        closeButton.addActionListener(new ButtonListener());

        if (isEditable) {
            split.setLeftComponent(pasteButton);
            closeButton.setText("Confirm");
            closeButton.setActionCommand("confirm");
            frame.setTitle("Import");
        } else {
            split.setLeftComponent(copyButton);
        }
        split.setRightComponent(closeButton);
        frame.add(split, BorderLayout.SOUTH);
        frame.add(pane, BorderLayout.CENTER);
    }

    public void createAndShowGUI() {
        frame = new JFrame();
        frame.setAlwaysOnTop(true);
        frame.setLocation(spawnLoc);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Export");
        createAndAddComponents();

        frame.pack();
        frame.setVisible(true);
    }


    public class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if ("copy".contentEquals(e.getActionCommand())) {
                Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
                StringSelection sel = new StringSelection(exportString);
                c.setContents(sel, sel);

            } else if ("close".contentEquals(e.getActionCommand())) {
                frame.dispose();

            } else if ("paste".contentEquals(e.getActionCommand())) {
                Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
                try {
                    pane.setText((String) c.getData(DataFlavor.stringFlavor));
                } catch (UnsupportedFlavorException | IOException ex) {
                    ex.printStackTrace();
                }

            } else if ("confirm".contentEquals(e.getActionCommand())) {
                deck = Box.importText(deck, pane.getText());
                frame.dispose();
            }
        }
    }
}
