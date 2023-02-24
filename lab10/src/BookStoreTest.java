import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookStoreTest {

	private BookStore store;
	private Book b1 = new Book(1, "Harper Lee", "To Kill a Mockingbird");
	private Book b2 = new Book(2, "Aarper Lee", "To Kill a Mockingbird");
	private Book b3 = new Book(3, "Frances Hodgson", "The Secret Garden");
	private Book b4 = new Book(5, "J.K. Rowling",
			"Harry Potter and the Sorcerer's Stone");
	private Book b5 = new Book(4, "Douglas Adams",
			"The Hitchhiker's Guide to the Galaxy");



	/**
	 * set up the store
	 * 
	 */
	@Before
	public void setUpBookStore() {
		store = new BookStore();
		store.addBook(b1);
		store.addBook(b2);
		store.addBook(b3);
		store.addBook(b4);

	}

	/**
	 * tests the addition of book
	 * 
	 */

	@Test
	public void testAddBook() {
		store.addBook(b5);
		assertTrue(store.getBooks().contains(b5));

	}

	/**
	 * tests the deletion of book
	 * 
	 */

	@Test
	public void testDeleteBook() {
		store.deleteBook(b5);
		assertFalse(store.getBooks().contains(b5));
	}

	/**
	 * tests sorting of books by author name
	 * 
	 */

	@Test
	public void testGetBooksSortedByAuthor() {
		assertSame(store.getBooksSortedByAuthor().get(0), b2);
	}

	/**
	 * tests sorting of books by title
	 * 
	 */

	@Test
	public void testGetBooksSortedByTitle() {
		assertSame(store.getBooksSortedByTitle().get(0), b4);
	}

	/**
	 * tests the number of copies of book in store
	 * 
	 */

	@Test
	public void testCountBookWithTitle() {
		assertEquals(2, store.countBookWithTitle("To Kill a Mockingbird"));
	}

}
