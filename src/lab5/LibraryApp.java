package lab5;

public class LibraryApp {
	// Create Controller, It will create an empty Library
	private static LibrarianController librarian = new LibrarianController();

	// Some functions for the Assignment
	private static void addMember(String name) {
		try {
			librarian.addMember(name);
		} catch (Exception e) {
			System.out.println("Error adding member: " + name + ". " + e.getMessage());
		}
	}

	private static void addBook(String title) {
		try {
			librarian.addBook(title);
		} catch (Exception e) {
			System.out.println("Error adding book: " + title + ". " + e.getMessage());
		}
	}

	private static void borrowBook(String title, String name) {
		try {
			librarian.borrowBookByMember(title, name);
		} catch (Exception e) {
			System.out.println("Error borrowing book: " + title + " for member: " + name + ". " + e.getMessage());
		}
	}

	private static void returnBook(String title, String name) {
		try {
			librarian.returnBookByMember(title, name);
		} catch (Exception e) {
			System.out.println("Error returning book: " + title + " for member: " + name + ". " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		System.out.println(" *** Library management system demo *** ");

		// Adding one book, see the Sequence diagram in the lab document.
		addBook("Dune");

		// DONE: Create three sequence diagrams for each of these method calls
		addMember("Alice");           // 1. Add a member
		borrowBook("Dune", "Alice");  // 2. Borrow a book
		returnBook("Dune", "Alice");  // 3. Return book

		// Adding some books to the catalog
		System.out.println("\n *** Adding books to the library:");
		addBook("Dune");
		addBook("1984");
		addBook("Moby Dick");

		// Adding members to the library
		System.out.println("\n *** Adding members to the library:");
		addMember("Alice");
		addMember("Bob");

		borrowBook("Dune", "Alice");
		borrowBook("1984", "Alice");
		borrowBook("Moby Dick", "Bob");
		borrowBook("Dune", "Bob"); // will be rejected

		System.out.println("\n *** Books borrowed by Alice:");
		librarian.showMemberBooks("Alice");

		System.out.println("\n *** Books borrowed by Bob:");
		librarian.showMemberBooks("Bob");

		System.out.println("\n *** Book returned by Alice: Dune");
		returnBook("Dune", "Alice");
		borrowBook("Dune", "Bob"); // will be successful
		System.out.println("\n *** Books borrowed by Bob:");
		librarian.showMemberBooks("Bob");
	}
}