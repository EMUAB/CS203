

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookStore {

	private List<Book> books; // store books in a list

	public BookStore() {
		books = new ArrayList<Book>();

	}

	public void addBook(Book b1) {
		books.add(b1);

	}

	public List<Book> getBooksSortedByAuthor() {
		List<Book> temp = new ArrayList<Book>(books);
		Collections.sort(temp, Comparator.comparing(Book::getAuthorName));
		return temp;
	}

	public int countBookWithTitle(String title) {
		int count = 0;
		for (Book book : books) {
			if (book.getTitle() == title) {
				count++;
			}
		}
		return count;
	}

	public void deleteBook(Book b5) {
		books.remove(b5);
	}

	public List<Book> getBooks() {
		return books;
	}

	public List<Book> getBooksSortedByTitle() {
		List<Book> temp = new ArrayList<Book>(books);
		Collections.sort(temp, new Comparator<Book>() {
			public int compare(Book b1, Book b2) {
				return b1.getTitle().compareTo(b2.getTitle());
			}
		});
		return temp;
	}

}
