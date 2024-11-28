package lab5.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab5.AudioBook;
import lab5.Book;
import lab5.BorrowingService;
import lab5.BorrowingServiceAPI;
import lab5.Ebook;
import lab5.Library;
import lab5.PaperBook;
import lab5.Member;


class TestAddRemoveBooks {

    private Library library;

    @BeforeEach
    void setUp() throws Exception {
        this.library = new Library(); // empty library for each test
    }

    PaperBook paperBook = new PaperBook("Dune");
    Ebook eBook = new Ebook("1984");
    AudioBook audioBook = new AudioBook("Moby Dick");
    BorrowingServiceAPI borrowingService = BorrowingService.getInstance();
    Member member = new Member("Grady Booch", borrowingService);

    @Test
    void AddBooks() {

        assertEquals(library.booksCount(), 0, "Should be no books in library");
        library.addBook(paperBook);
        library.addBook(eBook);
        library.addBook(audioBook);
        assertEquals(library.booksCount(), 3, "There should be 3 books in the library");
    }

    @Test
    void RemoveBooksBook() {

        AddBooks();
        assertEquals(library.booksCount(), 3, "There should be 3 books in the library");
        library.removeBook(eBook);
        library.removeBook(audioBook);
        assertEquals(library.booksCount(), 1, "There should be only one book left in the library");
    }

    @Test
    void RemoveBooksString() {

        AddBooks();
        assertEquals(library.booksCount(), 3, "There should be 3 books in the library");
        library.removeBook("Dune");
        assertEquals(library.booksCount(), 2, "There should be only two book left in the library");
    }

    @Test
    void RemoveBorrowedBook() {

        AddBooks();
        assertEquals(library.booksCount(), 3, "There should be 3 books in the library");

        member.borrowBook(paperBook);
        assertEquals(member.borrowedBooksCount(), 1, "Should be 1 borrowed book");

        library.removeBook(paperBook);
        assertEquals(library.booksCount(), 2, "There should be only two book left in the library");

        assertEquals(member.borrowedBooksCount(), 1, "The book should stay with member"); //
        
        List<Book> borrowedBooks = (List<Book>) member.getBorrowedBooks();
        assertEquals(1, borrowedBooks.size());
        assertEquals(borrowedBooks.get(0), paperBook, "The owned book should be the removed book");
        
    }
}
