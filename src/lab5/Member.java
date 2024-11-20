package lab5;

import java.util.*;

public class Member {
    private String name;
    private List<Book> borrowedBooks = new ArrayList<>();

    public Member(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            book.setIsAvailable(false);
            borrowedBooks.add(book);
        }
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public int borrowedBooksCount() {
        return borrowedBooks.size();
    }
}