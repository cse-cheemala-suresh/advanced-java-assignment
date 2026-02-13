package bookstore_mockit_test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import bookstore_mockit.Book;
import bookstore_mockit.BookDao;
import bookstore_mockit.BookManager;

public class BookManagerTestWithAnnotations {
	//Mock the BookDao dependency to avoid real database interactions
	@Mock
	private BookDao bookDao;
	
	//Inject the mocked BookDao into BookManager
	@InjectMocks
	private BookManager bookManager;
	
	@BeforeEach
	void setUp() {
		//Initialize Mockito annotations before each test
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void testGetAllBooks() {
		//Arrange: Define mock behavior
		List<Book> mockBooks = Arrays.asList(
				new Book(1, "Effective Java", "Joshua Book", 45.50),
				new Book(2, "Clean Code", "Robert C. Martin", 40.00)
				);
		when(bookDao.getAllBooks()).thenReturn(mockBooks);
		//Act: Call the method to be tested
		List<Book> books = bookManager.getAllBooks();
		//Assert: Verify the results
		assertNotNull(books);
		assertEquals(2, books.size());
		assertEquals("Effective Java", books.get(0).getTitle());
		//Verify that the getAllBooks method was called exactly once
		verify(bookDao, times(1)).getAllBooks();
	}
}
