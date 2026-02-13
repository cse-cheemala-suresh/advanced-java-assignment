package bookstore_mockit;



public class BookManager {
	private BookDao bookDao;
	
	public BookManager(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	
	public java.util.List<Book> getAllBooks(){
		return bookDao.getAllBooks();
	}
	public boolean addBook(Book book) {
		return bookDao.addBook(book);
	}
//	public boolean deleteBook(int id) {
//		return true;
//	}
}
