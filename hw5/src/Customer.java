import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
    private String firstname, lastname, email, phone;
    private ArrayList<Book> booksRented;

    public Customer(String firstname, String lastname, String email, String phone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        booksRented = new ArrayList<>();
    }

    public static Customer searchCustomer(ArrayList<Customer> customerList, String name) {
        for (Customer ct : customerList) {
            String cName = ct.getLastname();
            if (cName.equals(name)) {
                return ct;
            }
        }
        return null;
    }

    public static ArrayList<Customer> readCustomerList() {
        ArrayList<Customer> outList = new ArrayList<>();
        File cList = new File("lists\\customerList.txt");
        try {
            Scanner customerScanner = new Scanner(cList);
            while (customerScanner.hasNextLine()) {
                String[] cLine = customerScanner.nextLine().split("\\|");
                outList.add(new Customer(cLine[0], cLine[1], cLine[2], cLine[3]));
                System.out.println(new Customer(cLine[0], cLine[1], cLine[2], cLine[3]).toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return outList;
    }

    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(firstname).append("|");
        output.append(lastname).append("|");
        output.append(email).append("|");
        output.append(phone);
        return output.toString();
    }

    public void rentBook(Book bookIn) {
        booksRented.add(bookIn);
        bookIn.setRented(getLastname());
    }

    public boolean sameName(Customer customer, String firstname, String lastname) {
        return (customer.getLastname().equals(lastname) && customer.getFirstname().equals(firstname));
    }

    public String getPlainName() {
        return this.firstname + " " + this.lastname;
    }

    public static void saveToFile(ArrayList<Customer> customerListIn) {
        File customerSave = new File("lists\\customerList.txt");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(customerSave));
            for (Customer b : customerListIn) {
                writer.write(b.toString()+"\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFirstname() {
        return this.firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
