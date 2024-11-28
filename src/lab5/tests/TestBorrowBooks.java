package lab5.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab5.AudioBook;
import lab5.Ebook;
import lab5.Member;
import lab5.PaperBook;

class TestBorrowBooks {

	Member member1;
	Member member2;
	
	PaperBook book1 = new PaperBook("Dune");
	Ebook book2 = new Ebook("1984");
	AudioBook book3 = new AudioBook("Moby Dick");
	
	@BeforeEach
	void setUp() throws Exception {
		member1 = new Member("Alice"); // flush borrowedBook array 
		member2 = new Member("Bob");   // flush borrowedBook array 
		book1.setIsAvailable(true);
		book2.setIsAvailable(true);
		book3.setIsAvailable(true);
	}
	@Test
	void borrowBookBook() {
		
		// borrow first book
		assertEquals(member1.borrowedBooksCount(), 0, "Borrowed book should be zero");
		assertTrue(book1.getIsAvailable(), "Book 1 must be available");
		member1.borrowBook(book1);
		assertFalse(book1.getIsAvailable(),"Book 1 must be not available");
		assertEquals(member1.borrowedBooksCount(),1, "Count of borrowed books must be 1");
		
		// borrow second book
		assertTrue(book2.getIsAvailable(),"Book must be available");
		member1.borrowBook(book2);
		assertFalse(book1.getIsAvailable(), "Book should not be available");
		assertEquals(member1.borrowedBooksCount(), 2, "The book coubnt shoud be 2");
		
		//borrow third book
		assertTrue(book3.getIsAvailable(), "Book 3 must be available");
		member1.borrowBook(book3);
		assertFalse(book3.getIsAvailable(), "Book 3 should not be available");
		assertEquals(member1.borrowedBooksCount(), 3, "The book count should be 3");
	}
	
	@Test
	void returnBookBook() {
		
		// borrow two books
		assertTrue(book1.getIsAvailable(), "Book 1 should be available");
		assertTrue(book2.getIsAvailable(), "Book 2 should be available");
		assertEquals(member1.borrowedBooksCount(), 0,"Member1 should not have any books" );
		member1.borrowBook(book1);
		member1.borrowBook(book2);
		assertEquals(member1.borrowedBooksCount(),2, "The count of books must be 2");
		assertFalse(book1.getIsAvailable(), "Book 1 should not be available");
		assertFalse(book2.getIsAvailable(), "Book 2 should not be available");
		
		// return first book
		member1.returnBook(book1);
		assertTrue(book1.getIsAvailable(), "Book should be available after return");
		assertEquals(member1.borrowedBooksCount(), 1, "Count of books must be 1");
		// return second book
		member1.returnBook(book2);
		assertTrue(book2.getIsAvailable(), "Book should be available after return");
		assertEquals(member1.borrowedBooksCount(), 0, "Member 1 should have no books");
		//return third book
		member1.returnBook(book3);
		assertTrue(book3.getIsAvailable(), "Book should be available after return");
		assertEquals(member1.borrowedBooksCount(), 0, "Member 1 should have no books");
		
	}
}
