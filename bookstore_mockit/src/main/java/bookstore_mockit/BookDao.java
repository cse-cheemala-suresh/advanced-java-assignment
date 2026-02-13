package bookstore_mockit;

import java.util.ArrayList;
import java.util.List;

public class BookDao {
	public List<Book> getAllBooks(){
		//Simulate database interaction
		return new ArrayList<Book>();
	}
	public boolean addBook(Book book) {
		//Simulate adding book to the database
		return true;
	}
//	public boolean deleteBookById(int id) {
//		return true;
//	}
}
