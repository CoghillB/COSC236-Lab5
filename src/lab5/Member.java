package lab5;

import java.util.*;

public class Member {

    private String name;
    private List<Book> borrowedBooks;

    public Member(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void borrowBook(Book book) {
        if (book != null) {
            this.borrowedBooks.add(book);
            System.out.println("Book " + book.getTitle() + " borrowed by " + this.name);
        } else {
            System.out.println("Cannot borrow a null book.");
        }
    }

    public void returnBook(Book book) {
        if (book != null) {
            this.borrowedBooks.remove(book);
            System.out.println("Book " + book.getTitle() + " returned by " + this.name);
        } else {
            System.out.println("Cannot return a null book.");
        }
    }

    public List<Book> getBorrowedBooks() {
        System.out.println("Books borrowed by " + this.name + ":");
        for (Book book : borrowedBooks) {
            System.out.println(book.getTitle());
        }
        return borrowedBooks;
    }

    @Override
    public String toString() {
        return "Member [name=" + name + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Member))
            return false;
        Member other = (Member) obj;
        return Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public double borrowedBooksCount() {
        return borrowedBooks.size();
    }
}