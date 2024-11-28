package lab5.tests;


import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import lab5.Book;
import lab5.BorrowingService;
import lab5.Library;
import lab5.Member;
import lab5.PaperBook;
import lab5.Ebook;
import lab5.AudioBook;

class TestBorrowingService {
	private Library library;

	@BeforeEach
	void setUp() throws Exception {
		 this.library = new Library(); // empty library for each test
	}
	BorrowingService service = BorrowingService.getInstance();
	Member member1 = new Member("John", service);
	Member member2 = new Member("Frank", service);
	Book b1 = new Ebook("Dune");
	Book b2 = new Ebook("The Hobbit");
	Book b3 = new AudioBook("Dante's Inferno");
	Book b4 = new PaperBook("1984");
	
	@Test
	void borrowBook() {
		//Member 1 borrows all books
		library.addMember(member1);
		library.addBook(b1);
		library.addBook(b2);
		library.addBook(b3);
		library.addBook(b4);
		member1.borrowBook(b1);
		member1.borrowBook(b2);
		member1.borrowBook(b3);
		assertEquals(member1.borrowedBooksCount() ,3);
	}
	
	@Test
	void borrowOtherMember(){
		//Member 1 borrows all books
		//Member 2 tries to borrow a book
		library.addMember(member1);
		library.addMember(member2);
		library.addBook(b1);
		library.addBook(b2);
		library.addBook(b3);
		member1.borrowBook(b2);
		assertEquals(member2.borrowedBooksCount(), 0);
	}
	
	@Test
	void borrowBorrowed(){
		//Member 1 tries to borrow a book they've already borrowed
		library.addMember(member1);
		library.addBook(b1);
		library.addBook(b2);
		library.addBook(b3);
		//member1.borrowBook(b1);
		member1.borrowBook(b1);
		assertEquals(member1.borrowedBooksCount(), 1);
	}
	
	@Test
	void returnAll(){
		//Member 1 returns all borrowed books
		library.addMember(member1);
		library.addBook(b1);
		library.addBook(b2);
		library.addBook(b3);
		member1.borrowBook(b1);
		member1.borrowBook(b2);
		member1.borrowBook(b3);
		member1.returnBook(b1);
		member1.returnBook(b2);
		member1.returnBook(b3);
		assertEquals(member1.borrowedBooksCount(), 0);
	}
	
	@Test
	void returnOtherMember(){
		//Member 1 tries to return a book that Member 2 has borrowed
		library.addMember(member1);
		library.addBook(b1);
		library.addBook(b2);
		library.addBook(b3);
		member1.borrowBook(b1);
		member1.returnBook(b1);
		member2.borrowBook(b2);
		member2.returnBook(b1);
		assertEquals(member2.borrowedBooksCount(), 1);
	}
	
}
