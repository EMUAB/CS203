import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public class MainGui {
    private ArrayList<ArrayList<Flashcard>> deck;
    private Flashcard cCard;
    private JFrame frame;
    private JLabel mainLabel;
    private JButton flipButton, startButton;
    private JSplitPane knowSplitPane;
    private Point spawnLoc;
    private boolean isFlip = false;

    public MainGui(ArrayList<ArrayList<Flashcard>> deck, Point spawnLoc) {
        this.deck = deck;
        this.spawnLoc = spawnLoc;
    }

    public static void createAndAddTopBar(JFrame frame, ActionListener optionsListener, ActionListener editListener) {
        JMenuBar topBar = new JMenuBar();
        topBar.setOpaque(true);
        topBar.setPreferredSize(new Dimension(300, 30));


        JMenu options = createOptionsMenu(optionsListener);
        JMenu edit = createEditMenu(editListener);
        topBar.add(options);
        topBar.add(edit);
        frame.setJMenuBar(topBar);
    }

    public static JMenu createOptionsMenu(ActionListener listener) {
        JMenu options = new JMenu();
        options.setText("Options");

        JMenuItem loadItem = new JMenuItem();
        loadItem.setText("Load");
        loadItem.setActionCommand("load");
        loadItem.addActionListener(listener);

        JMenuItem saveAsItem = new JMenuItem();
        saveAsItem.setText("Save As");
        saveAsItem.setActionCommand("saveAs");
        saveAsItem.addActionListener(listener);

        JMenuItem importFileItem = new JMenuItem();
        importFileItem.setText("Import a File");
        importFileItem.setActionCommand("importFile");
        importFileItem.addActionListener(listener);

        JMenuItem importTextItem = new JMenuItem();
        importTextItem.setText("Import by Text");
        importTextItem.setActionCommand("importText");
        importTextItem.addActionListener(listener);

        JMenu importMenu = new JMenu();
        importMenu.setText("Import");
        importMenu.add(importTextItem);
        importMenu.add(importFileItem);

        JMenuItem exportItem = new JMenuItem();
        exportItem.setText("Export");
        exportItem.setActionCommand("export");
        exportItem.addActionListener(listener);

        JMenuItem helpItem = new JMenuItem();
        helpItem.setText("Help");
        helpItem.setActionCommand("help");
        helpItem.addActionListener(listener);

        JMenuItem quitItem = new JMenuItem();
        quitItem.setText("Quit");
        quitItem.setActionCommand("quit");
        quitItem.addActionListener(listener);

        options.add(loadItem);
        options.add(saveAsItem);
        options.add(importMenu);
        options.add(exportItem);
        options.add(helpItem);
        options.add(quitItem);

        return options;
    }

    public static JMenu createEditMenu(ActionListener listener) {
        JMenu edit = new JMenu();
        edit.setText("Edit");

        JMenuItem addCardItem = new JMenuItem();
        addCardItem.setText("Add a Card");
        addCardItem.setActionCommand("add");
        addCardItem.addActionListener(listener);

        JMenuItem removeCardItem = new JMenuItem();
        removeCardItem.setText("Remove Current Card");
        removeCardItem.setActionCommand("remove");
        removeCardItem.addActionListener(listener);

        JMenuItem modifyCardItem = new JMenuItem();
        modifyCardItem.setText("Modify Current Card");
        modifyCardItem.setActionCommand("modify");
        modifyCardItem.addActionListener(listener);

        JMenuItem inspectDeckItem = new JMenuItem();
        inspectDeckItem.setText("Inspect the Deck");
        inspectDeckItem.setActionCommand("inspect");
        inspectDeckItem.addActionListener(listener);

        edit.add(addCardItem);
        edit.add(removeCardItem);
        edit.add(modifyCardItem);
        edit.add(inspectDeckItem);

        return edit;
    }

    public void createAndAddMainLabel(JFrame frame) {
        mainLabel = new JLabel();
        mainLabel.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        mainLabel.setPreferredSize(new Dimension(500, 300));
        frame.getContentPane().add(mainLabel, BorderLayout.CENTER);
    }

    public void createAndAddStartButton(ActionListener listener) {
        startButton = new JButton();
        startButton.setText("Start Session");
        startButton.setActionCommand("start");
        startButton.addActionListener(listener);
        startButton.setPreferredSize(new Dimension(500, 40));

        frame.add(startButton, BorderLayout.SOUTH);
    }

    public void createAndAddFlipButton(ActionListener listener) {
        flipButton = new JButton();
        flipButton.setText("Flip");
        flipButton.setActionCommand("flip");
        flipButton.addActionListener(listener);
        flipButton.setPreferredSize(new Dimension(500, 40));
        isFlip = true;

        frame.add(flipButton, BorderLayout.SOUTH);
    }

    public void createAndAddKnowButtons(ActionListener listener) {
        knowSplitPane = new JSplitPane();
        knowSplitPane.setPreferredSize(new Dimension(500, 40));
        knowSplitPane.setDividerLocation(250);
        knowSplitPane.setEnabled(false);
        knowSplitPane.setDividerSize(5);

        JButton noAnsButton = new JButton();
        noAnsButton.setText("Don't know answer");
        noAnsButton.setActionCommand("notKnows");
        noAnsButton.addActionListener(listener);
        knowSplitPane.setLeftComponent(noAnsButton);

        JButton isAnsButton = new JButton();
        isAnsButton.setText("Know answer");
        isAnsButton.setActionCommand("knows");
        isAnsButton.addActionListener(listener);
        knowSplitPane.setRightComponent(isAnsButton);

        isFlip = false;

        frame.add(knowSplitPane, BorderLayout.SOUTH);
    }

    public void createAndShowGUI() {
        frame = new JFrame("Leitner");
        frame.setLocation(spawnLoc);
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createAndAddTopBar(frame, new OptionsListener(), new EditListener());
        createAndAddMainLabel(frame);
        setMainLabelText("Add/import cards then press the button below \nto start the study session");
        createAndAddStartButton(new MainListener());
        frame.pack();
        frame.setVisible(true);
    }

    public String getMainLabelText() {
        return mainLabel.getText();
    }

    public void setMainLabelText(String str) {
        mainLabel.setText(str);
    }

    private class MainListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if ("knows".contentEquals(e.getActionCommand())) {
                Box.advanceCard(deck, cCard);
                cCard = Box.chooseCard(deck);
                frame.remove(knowSplitPane);
                createAndAddFlipButton(new MainListener());
                setMainLabelText(cCard.getFront());

            } else if ("notKnows".contentEquals(e.getActionCommand())) {
                Box.resetCard(deck, cCard);
                cCard = Box.chooseCard(deck);
                frame.remove(knowSplitPane);
                createAndAddFlipButton(new MainListener());
                setMainLabelText(cCard.getFront());

            } else if ("flip".contentEquals(e.getActionCommand())) {
                setMainLabelText(cCard.getBack());
                frame.remove(flipButton);
                createAndAddKnowButtons(new MainListener());

            } else if ("start".contentEquals(e.getActionCommand())) {
                if (Box.isEmpty(deck)) {
                    setMainLabelText("Cannot start with an empty deck, please add a card or load a deck");
                } else {
                    frame.remove(startButton);
                    createAndAddFlipButton(new MainListener());
                    cCard = Box.chooseCard(deck);
                    setMainLabelText(cCard.getFront());
                }
            }
        }
    }

    private class OptionsListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if ("quit".contentEquals(e.getActionCommand())) {
                if (JOptionPane.showConfirmDialog(null, "End study session?") == 0) {
                    System.exit(0);
                }

            } else if ("saveAs".contentEquals(e.getActionCommand())) {
                JFileChooser c = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                c.setFileFilter(new FileFilter() {

                    public boolean accept(File f) {
                        if (f.getName().endsWith(".deck") || f.isDirectory()) {
                            return true;
                        }
                        return false;
                    }

                    public String getDescription() {
                        return "Deck File (.deck)";
                    }
                });
                if (c.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    System.out.println(c.getSelectedFile().getPath());
                    FileInteraction.saveToFile(deck, c.getSelectedFile().getPath());
                }

            } else if ("load".contentEquals(e.getActionCommand())) {
                JFileChooser c = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                c.setFileFilter(new FileFilter() {
                    public boolean accept(File f) {
                        if (f.getName().endsWith(".deck") || f.isDirectory()) {
                            return true;
                        }
                        return false;
                    }

                    public String getDescription() {
                        return "Deck File (.deck)";
                    }
                });
                if (c.showOpenDialog(null) == JFileChooser.OPEN_DIALOG) {
                    deck = FileInteraction.parseSave(c.getSelectedFile());
                }

            } else if ("importFile".contentEquals(e.getActionCommand())) {
                JFileChooser c = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                c.setFileFilter(new FileFilter() {
                    public boolean accept(File f) {
                        return f.getName().endsWith(".txt") || f.isDirectory();
                    }

                    public String getDescription() {
                        return "Text File (.txt)";
                    }
                });
                if (c.showOpenDialog(null) == JFileChooser.OPEN_DIALOG) {
                    deck = FileInteraction.importFile(c.getSelectedFile());
                }

            } else if ("importText".contentEquals(e.getActionCommand())) {
                javax.swing.SwingUtilities.invokeLater(() -> {
                    InExGui importGui = new InExGui(deck, frame.getLocation());
                    importGui.createAndShowGUI();
                });

            } else if ("export".contentEquals(e.getActionCommand())) {
                javax.swing.SwingUtilities.invokeLater(() -> {
                    InExGui exportGui = new InExGui(Box.exportAsString(deck), frame.getLocation());
                    exportGui.createAndShowGUI();
                });

            } else if ("help".contentEquals(e.getActionCommand())) {
                JOptionPane.showMessageDialog(null, "If importing a deck from quizlet, on the flashcard set's page choose\nthe three dots,select 'Export', then in the menu under 'Between term and definition',\nchoose the 'Custom' option and change it to the symbol ' | '.\nCopy the text in the box and then put it in a .txt file or paste it into the Import by Text menu.");
            }
        }
    }

    private class EditListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if ("add".contentEquals(e.getActionCommand())) {
                javax.swing.SwingUtilities.invokeLater(() -> {
                    AddCardGui addCard = new AddCardGui(deck, frame.getLocation());
                    addCard.createAndShowGUI();
                });

            } else if ("remove".contentEquals(e.getActionCommand())) {
                if (JOptionPane.showConfirmDialog(null, "Remove current card?") == 0) {
                    if (Objects.equals(getMainLabelText(), "Add/import cards then press the button below \nto start the study session")) {
                        JOptionPane.showMessageDialog(null, "No card to delete");
                    } else {
                        Box.removeCard(deck, cCard);
                        cCard = Box.chooseCard(deck);
                        if (!isFlip) {
                            frame.remove(knowSplitPane);
                            createAndAddFlipButton(new MainListener());
                        }
                        setMainLabelText(cCard.getFront());
                    }
                }

            } else if ("modify".contentEquals(e.getActionCommand())) {
                if (Objects.equals(getMainLabelText(), "Add/import cards then press the button below \nto start the study session")) {
                    JOptionPane.showMessageDialog(null, "No card to modify");
                } else {
                    setMainLabelText("Modifying card...");
                    if (!isFlip) {
                        frame.remove(knowSplitPane);
                        createAndAddFlipButton(new MainListener());
                    }
                    ModifyCardGui modifyCard = new ModifyCardGui(deck, cCard, frame.getLocation(), mainLabel);
                    modifyCard.createAndShowGUI();
                }

            } else if ("inspect".contentEquals(e.getActionCommand())) {
                InspectGui iGui = new InspectGui(deck, frame.getLocation());
                iGui.createAndShowGUI();
            }
        }
    }
}
