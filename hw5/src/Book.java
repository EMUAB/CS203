import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class Book {
    private final String title, author, publisher;
    private final int pages;
    private int copies;
    private String rentedBy;

    public Book(String title, String author, String publisher, int pages, String rentedBy) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.pages = pages;
        this.rentedBy = ((rentedBy.equals("null")) ? null : rentedBy);
    }

    public Book(String title, String author, String publisher, int pages) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.pages = pages;
        this.rentedBy = null;
    }

    public static void toFile(ArrayList<Book> bookList, ArrayList<Customer> customerList) {
        File sList = new File("lists\\bookList.txt");
        File cList = new File("lists\\customerList.txt");

        try {
            BufferedWriter sWriter = new BufferedWriter(new FileWriter(sList));
            bookList.forEach((bookIn) -> {
                // writes the store's books to file
                try {
                    sWriter.append(bookIn.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            BufferedWriter cWriter = new BufferedWriter(new FileWriter(cList));
            customerList.forEach((cstmrIn) -> {
                try {
                    cWriter.append(cstmrIn.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Book> readBookList() {
        ArrayList<Book> outList = new ArrayList<>();
        File bList = new File("lists\\bookList.txt");

        try {
            Scanner bScanner = new Scanner(bList);
            while (bScanner.hasNextLine()) {
                String[] cLine = bScanner.nextLine().split("\\|");
                outList.add(new Book(cLine[0], cLine[1], cLine[2], Integer.parseInt(cLine[3]), cLine[4]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return outList;
    }

    public static ArrayList<Book> getSearchedList(ArrayList<Book> bookList, String title) {
        if (title.equals("")) {
            return bookList;
        }
        ArrayList<Book> displayList = new ArrayList<>();
        for (Book cb : bookList) {
            String bookName = cb.getTitle().toLowerCase();
            if (bookName.contains(title.toLowerCase())) {
                displayList.add(cb);
            }
        }
        return displayList;
    }

    public String toString() {
        return title + "|" + author + "|" + publisher + "|" + pages + "|" + ((rentedBy == null) ? "null" : rentedBy);
    }

    public static boolean alreadyCounted(ArrayList<String> containingArr, Book bookIn) {
        String countedTitle = bookIn.getTitle();
        for (String s : containingArr) {
            if (countedTitle.equals(s)) {
                return true;
            }
        }
        return false;
    }

    public static int countCopies(ArrayList<Book> bookList, Book bookIn) {
        int count = 0;
        String desiredTitle = bookIn.getTitle();
        for (Book b : bookList) {
            if (b.getTitle().equals(desiredTitle) && !b.isRented()) {
                count++;
            }
        }
        return count;
    }

    public static ArrayList<Book> booksByCustomer (ArrayList<Book> booksIn, String customer) {
        ArrayList<Book> output = new ArrayList<>();
        for (Book b : booksIn) {
            if (!Objects.isNull(b.getRentedBy()) && b.getRentedBy().equals(customer)) {
                output.add(b);
            }
        }
        return output;
    }

    public static void saveToFile(ArrayList<Book> bookListIn) {
        File bookSave = new File("lists\\bookList.txt");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(bookSave));
            for (Book b : bookListIn) {
                writer.write(b.toString() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isRented() {
        return rentedBy != null;
    }

    public void setRented(String cstmr) {
        this.rentedBy = cstmr;
    }

    public String getRentedBy() {
        return rentedBy;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getPages() {
        return pages;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }
}
