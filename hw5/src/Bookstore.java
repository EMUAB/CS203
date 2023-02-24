import javax.swing.*;
import java.util.ArrayList;

public class Bookstore {

    public static void main(String[] args) {
        ArrayList<Book> bookList = Book.readBookList();
        ArrayList<Customer> customerList = Customer.readCustomerList();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
        javax.swing.SwingUtilities.invokeLater(() -> {
            MainGui gui = new MainGui(bookList, customerList);
        });

    }
}
