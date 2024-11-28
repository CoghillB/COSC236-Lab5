package lab5;

public class LibrarianController {
	
	Library library; // Library dependency
	PaperBookFactory PaperBookFactory;
    AudioBookFactory AudioBookFactory;
    EbookFactory EbookFactory;
	BorrowingServiceAPI borrowingService;

	public LibrarianController( ) {
		this.borrowingService = BorrowingService.getInstance();
		this.library = new Library();
		this.PaperBookFactory = new PaperBookFactory();
		this.AudioBookFactory = new AudioBookFactory();
		this.EbookFactory = new EbookFactory();
	}
	public Library getLibrary() {
		return this.library;
	}
	public void showBooks() {
		library.showBooks();
	}
	public void showMembers() {
		library.showMembers();
	}
	public void addPaperBook(String title) {
		library.addBook(PaperBookFactory.createBook(title));  
	}
	public void addEBook(String title) {
		library.addBook(EbookFactory.createBook(title));  
	}
	public void addAudioBook(String title) {
		library.addBook(AudioBookFactory.createBook(title));
	}
	
	public void addBook(BookFactory factory, String title) {  
		library.addBook(factory.createBook(title));
		} 
	
	public void addMember(String name) {
		library.addMember(new Member(name, borrowingService)); // Member class constructor dependency
	}
	public void removeBook(String title) {
		library.removeBook(title); // remove 
	}
	public void removeMember(String name) {
		library.removeMember(name);
	}
	public void showMember(String name) {
		Member member = library.findMemberByName(name);
		if (member != null)
			System.out.println(member);
		else 
			System.out.println("Member " + name + " not found.");
	}
	public void showBook(String title) {
		Book book = library.findBookByTitle(title);
		if (book != null)
			System.out.println(book);
		else 
			System.out.println("Book " + title + " not found.");
	}
	public void showMemberBooks(String name) {
		Member member = library.findMemberByName(name);
		if (member != null)
			member.getBorrowedBooks();
		else 
			System.out.println("Member " + name + " not found.");
	}
	
	public void borrowBookByMember(String title, String name) {
		Member member = library.findMemberByName(name); // use library for search
		Book book = library.findBookByTitle(title);  // use library for search
		if (book != null && member != null)
			member.borrowBook(book); // member borrows a book, not library 
		else 	
			System.out.println("Either book " + title + " or member " + name + " not found.");
	}
	
	public void returnBookByMember(String title, String name) {
		Member member = library.findMemberByName(name); // use library for search
		Book book = library.findBookByTitle(title); // use library for search
		if (book != null && member != null)
			member.returnBook(book); // members returns book. 
		else  	
			System.out.println("Either book " + title + " or member " + name + " not found.");
	}
}
