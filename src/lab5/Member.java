package lab5;

import java.util.*;

public class Member {

    private String name;
    private List<Book> borrowedBooks;
    private BorrowingServiceAPI borrowingService;

    public Member(String name, BorrowingServiceAPI service) {
    	this.borrowingService = service;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void borrowBook(Book book) {
    	BorrowingBookResult b = borrowingService.borrowBook(this, book);
        if(b.getIsSuccess()) {
        	System.out.println(b.getMessage());
        	this.borrowedBooks.add(book);
        if (book == null) {
            System.out.println("Cannot borrow a null book.");
        }
       }
    }

    public void returnBook(Book book) {
        BorrowingBookResult b = borrowingService.returnBook(this, book);
        if(b.getIsSuccess()) {
        	System.out.println(b.getMessage());
        	this.borrowedBooks.remove(book);
        }
    }
    
    public void remove() {
    	List<Book> temp = borrowedBooks;
    	    temp.forEach(book -> {
    	        borrowingService.returnBook(this, book);
    	    });
    	borrowedBooks.clear();
    }
    
    public boolean hasBook(Book b) {
        return this.borrowedBooks.contains(b);
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

	public BorrowingServiceAPI getBorrowingService() {
		return borrowingService;
	}
}