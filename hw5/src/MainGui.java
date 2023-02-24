import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class MainGui {
    private JFrame frame;
    private JLabel topLabel;
    private JSplitPane mainMenuPane1;
    private JPanel bookPanel, customerPanel, rentPanel, rentInnerPanel, checkRentedPanel;
    private JScrollPane checkInnerPane;
    private JTextField textField1, textField2;
    private JList list1, list2;
    private JButton returnButton;
    private JTree tree;
    private int currentMenu = 0;

    public static final int MAIN_MENU = 0;
    public static final int BOOK_MENU = 1;
    public static final int CUSTOMER_MENU = 2;
    public static final int CHECK_RENTED_MENU = 3;
    public static final int RENT_MENU = 4;

    private ArrayList<Book> bookList;
    private ArrayList<Customer> customerList;

    public MainGui(ArrayList<Book> bookList, ArrayList<Customer> customerList) {
        this.bookList = bookList;
        this.customerList = customerList;
        createAndShowMainGUI();
    }

    public void createAndShowMainGUI() {
        frame = new JFrame("Bookstore thing");
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 500));
        frame.pack();
        frame.setVisible(true);

        topLabel = new JLabel();
        topLabel.setText("Bookstore Main Menu");
        frame.add(topLabel, BorderLayout.NORTH);

        returnButton = new JButton();
        returnButton.setText("Return to Main Menu");
        returnButton.setActionCommand("toMain");
        returnButton.addActionListener(new MainListener());

        createAndAddMainMenu();
    }

    public void createAndAddMainMenu() {
        mainMenuPane1 = new JSplitPane();
        mainMenuPane1.setDividerLocation(90);
        mainMenuPane1.setContinuousLayout(false);
        mainMenuPane1.setDividerSize(0);
        mainMenuPane1.setEnabled(false);
        mainMenuPane1.setOrientation(0);

        JSplitPane mainMenuPane2 = new JSplitPane();
        mainMenuPane2.setDividerLocation(90);
        mainMenuPane2.setContinuousLayout(false);
        mainMenuPane2.setDividerSize(0);
        mainMenuPane2.setEnabled(false);
        mainMenuPane2.setOrientation(0);

        JSplitPane mainMenuPane3 = new JSplitPane();
        mainMenuPane3.setDividerLocation(90);
        mainMenuPane3.setContinuousLayout(false);
        mainMenuPane3.setDividerSize(0);
        mainMenuPane3.setEnabled(false);
        mainMenuPane3.setOrientation(0);

        JSplitPane mainMenuPane4 = new JSplitPane();
        mainMenuPane4.setDividerLocation(90);
        mainMenuPane4.setContinuousLayout(false);
        mainMenuPane4.setDividerSize(0);
        mainMenuPane4.setEnabled(false);
        mainMenuPane4.setOrientation(0);

        JButton catButton = new JButton();
        catButton.setText("Open Book Catalogue");
        catButton.setActionCommand("cat");
        catButton.addActionListener(new MainListener());
        catButton.setPreferredSize(new Dimension(500, 30));

        JButton cstmrButton = new JButton();
        cstmrButton.setText("View Customer List");
        cstmrButton.setActionCommand("cstmr");
        cstmrButton.addActionListener(new MainListener());
        cstmrButton.setPreferredSize(new Dimension(500, 30));

        JButton rentedListButton = new JButton();
        rentedListButton.setText("View Rented by Customer");
        rentedListButton.setActionCommand("checkRented");
        rentedListButton.addActionListener(new MainListener());
        rentedListButton.setPreferredSize(new Dimension(500, 30));

        JButton rentButton = new JButton();
        rentButton.setText("Rent a Book");
        rentButton.setActionCommand("rent");
        rentButton.addActionListener(new MainListener());
        rentButton.setPreferredSize(new Dimension(500, 30));

        JButton saveButton = new JButton("Save");
        saveButton.setActionCommand("save");
        saveButton.addActionListener(new MainListener());
        saveButton.setPreferredSize(new Dimension(500, 30));

        mainMenuPane1.setLeftComponent(rentButton);
        mainMenuPane1.setRightComponent(mainMenuPane2);
        mainMenuPane2.setLeftComponent(catButton);
        mainMenuPane2.setRightComponent(mainMenuPane3);
        mainMenuPane3.setLeftComponent(rentedListButton);
        mainMenuPane3.setRightComponent(mainMenuPane4);
        mainMenuPane4.setLeftComponent(cstmrButton);
        mainMenuPane4.setRightComponent(saveButton);

        frame.add(mainMenuPane1, BorderLayout.CENTER);
    }

    public void createAndAddBookMenu() {
        bookPanel = new JPanel();
        bookPanel.setLayout(new BorderLayout(0, 0));

        textField1 = new JTextField();
        textField1.setEditable(true);

        JButton searchButton = new JButton();
        searchButton.setText("Search");
        searchButton.setActionCommand("search");
        searchButton.addActionListener(new MainListener());

        JSplitPane searchSplit = new JSplitPane();
        searchSplit.setDividerLocation(400);
        searchSplit.setContinuousLayout(false);
        searchSplit.setDividerSize(0);
        searchSplit.setEnabled(false);

        searchSplit.setLeftComponent(textField1);
        searchSplit.setRightComponent(searchButton);

        list1 = new JList();
        setList1("");

        JScrollPane list1Pane = new JScrollPane(list1);

        bookPanel.add(list1Pane, BorderLayout.CENTER);
        bookPanel.add(returnButton, BorderLayout.SOUTH);
        bookPanel.add(searchSplit, BorderLayout.NORTH);

        frame.add(bookPanel, BorderLayout.CENTER);
    }

    public void createAndAddCustomerMenu() {
        customerPanel = new JPanel();
        customerPanel.setLayout(new BorderLayout(0, 0));

        list2 = new JList();
        setList2();
        JScrollPane customerScroll = new JScrollPane(list2);

        customerPanel.add(customerScroll, BorderLayout.CENTER);
        customerPanel.add(returnButton, BorderLayout.SOUTH);
        frame.add(customerPanel, BorderLayout.CENTER);
    }

    public void createAndAddRentMenu() {
        rentPanel = new JPanel();
        rentPanel.setLayout(new BorderLayout(0, 0));

        setRentButtons(false);

        rentPanel.add(returnButton, BorderLayout.SOUTH);
        frame.add(rentPanel, BorderLayout.CENTER);
    }

    public void createAndAddCheckRentedMenu() {
        checkRentedPanel = new JPanel();
        checkRentedPanel.setLayout(new BorderLayout(0, 0));

        textField2 = new JTextField();
        textField2.setEditable(true);

        JButton searchButton = new JButton();
        searchButton.setText("Search");
        searchButton.setActionCommand("searchCustomer");
        searchButton.addActionListener(new MainListener());

        JSplitPane checkSplitPane = new JSplitPane();
        checkSplitPane.setDividerLocation(400);
        checkSplitPane.setContinuousLayout(false);
        checkSplitPane.setDividerSize(0);
        checkSplitPane.setEnabled(false);

        checkSplitPane.setLeftComponent(textField2);
        checkSplitPane.setRightComponent(searchButton);

        checkInnerPane = new JScrollPane();
        setupCheckTree("");

        checkRentedPanel.add(checkSplitPane, BorderLayout.NORTH);
        checkRentedPanel.add(returnButton, BorderLayout.SOUTH);
        frame.add(checkRentedPanel, BorderLayout.CENTER);
    }

    public void setupCheckTree(String customerName) {
        ArrayList<Book> booksRented = Book.booksByCustomer(bookList, customerName);
        DefaultMutableTreeNode top = new DefaultMutableTreeNode(customerName);
        DefaultMutableTreeNode book;
        DefaultMutableTreeNode info;

        for (Book b : booksRented) {
            book = new DefaultMutableTreeNode(b.getTitle());
            top.add(book);
            info = new DefaultMutableTreeNode("Author: " + b.getAuthor());
            book.add(info);
            info = new DefaultMutableTreeNode("Publisher: " + b.getPublisher());
            book.add(info);
            info = new DefaultMutableTreeNode("Pages: " + b.getPages());
            book.add(info);
        }
        tree = new JTree(top);
        checkInnerPane.setViewportView(tree);
        checkRentedPanel.add(checkInnerPane, BorderLayout.CENTER);
    }

    public void setRentButtons(boolean refresh) {
        if (refresh) {
            rentInnerPanel.removeAll();
            rentInnerPanel.revalidate();
            rentInnerPanel.repaint();
        }

        rentInnerPanel = new JPanel();
        rentInnerPanel.setLayout(new BoxLayout(rentInnerPanel, BoxLayout.Y_AXIS));

        ArrayList<String> containingArr = new ArrayList<>();
        for (Book b : bookList) {
            if (!b.isRented() && !Book.alreadyCounted(containingArr, b)) {
                JButton tempButton = new JButton(b.getTitle());
                tempButton.addActionListener(new RentListener());
                tempButton.setActionCommand(b.getTitle());
                rentInnerPanel.add(tempButton);
                containingArr.add(b.getTitle());
            }
        }
        rentPanel.add(rentInnerPanel, BorderLayout.CENTER);
    }

    public void setList1(String searchTerm) {
        ArrayList<String> booksString = new ArrayList<>();
        ArrayList<String> containingArr = new ArrayList<>();
        ArrayList<Book> displayList = Book.getSearchedList(bookList, searchTerm);
        for (Book b : displayList) {
            if (!Book.alreadyCounted(containingArr, b)) {
                booksString.add(b.getTitle() + " by " + b.getAuthor() +
                        ", Published by " + b.getPublisher() + "; " +
                        b.getPages() + " pages. " +
                        Book.countCopies(bookList, b) + " in stock.");
                containingArr.add(b.getTitle());
            }
        }
        list1.setListData(booksString.toArray());
    }

    public void setList2() {
        ArrayList<String> customersString = new ArrayList<>();
        for (Customer c : customerList) {
            customersString.add("Name: [" + c.getFirstname() + " " + c.getLastname() +
                    "] Email: [" + c.getEmail() +
                    "] Phone #: [" + c.getPhone() + "]");
        }
        list2.setListData(customersString.toArray());
    }

    public void removeMenu(int menu) {
        switch (menu) {
            case MAIN_MENU -> frame.remove(mainMenuPane1);
            case BOOK_MENU -> frame.remove(bookPanel);
            case CUSTOMER_MENU -> frame.remove(customerPanel);
            case RENT_MENU -> frame.remove(rentPanel);
            case CHECK_RENTED_MENU -> frame.remove(checkRentedPanel);
        }
    }

    public void goToMenu(int desiredMenu) {
        switch (desiredMenu) {
            case MAIN_MENU -> {
                removeMenu(currentMenu);
                createAndAddMainMenu();
                topLabel.setText("Bookstore Main Menu");
                currentMenu = MAIN_MENU;
            }
            case BOOK_MENU -> {
                removeMenu(currentMenu);
                createAndAddBookMenu();
                topLabel.setText("Bookstore Catalogue");
                currentMenu = BOOK_MENU;
            }
            case CUSTOMER_MENU -> {
                removeMenu(currentMenu);
                createAndAddCustomerMenu();
                topLabel.setText("All Customers");
                currentMenu = CUSTOMER_MENU;
            }
            case RENT_MENU -> {
                removeMenu(currentMenu);
                createAndAddRentMenu();
                topLabel.setText("Click a book below to rent");
                currentMenu = RENT_MENU;
            }
            case CHECK_RENTED_MENU -> {
                removeMenu(currentMenu);
                createAndAddCheckRentedMenu();
                topLabel.setText("Type a last name below to check what they have rented");
                currentMenu = CHECK_RENTED_MENU;
            }
        }
    }

    public class MainListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String s = e.getActionCommand();
            switch (s) {
                case "cat" -> goToMenu(BOOK_MENU);
                case "cstmr" -> goToMenu(CUSTOMER_MENU);
                case "checkRented" -> goToMenu(CHECK_RENTED_MENU);
                case "rent" -> goToMenu(RENT_MENU);
                case "toMain" -> goToMenu(MAIN_MENU);
                case "search" -> setList1(textField1.getText());
                case "searchCustomer" -> setupCheckTree(textField2.getText());
                case "save" -> {
                    Book.saveToFile(bookList);
                    Customer.saveToFile(customerList);
                }
            }
        }
    }

    public class RentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String title = e.getActionCommand();
            for (Book b : bookList) {
                if (b.getTitle().equals(title) && !b.isRented()) {
                    String customer = JOptionPane.showInputDialog(frame, "What is the last name of the customer renting the book?", "Rent a Book", JOptionPane.QUESTION_MESSAGE);
                    if (!Objects.equals(customer, "") && !Objects.isNull(customer)) {
                        b.setRented(customer);
                        setRentButtons(true);
                    }
                    break;
                }
            }
        }
    }
}
