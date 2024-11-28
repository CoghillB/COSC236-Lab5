package lab5;

public class BorrowingService implements BorrowingServiceAPI{
	private static BorrowingService instance;
	private int borrowingLimit;
	private BorrowingService() {
	borrowingLimit = 3;
	}
	
	public static BorrowingService getInstance() {
		if(instance == null) {
			instance = new BorrowingService();
		}
		return instance;
	}
	
	@Override
	public BorrowingBookResult borrowBook(Member member, Book book) {
		BorrowingBookResult b = new BorrowingBookResult(true, "Success");
		if(member.hasBook(book)) {
			b.setMessage("Failure to Borrow: Member: " + member.getName() + " has already borrowed " + book.getTitle());
			b.setIsSuccess(false);
			return b;
		}else if(member.borrowedBooksCount() >= borrowingLimit) {
			b.setMessage("Failure to Borrow: Member: " + member.getName() + " has already borrowed the maximum amount");
			b.setIsSuccess(false);
			return b;
		}else if(!book.getIsAvailable()) {
			b.setMessage("Failure to Borrow: Book: " + book.getTitle() + " has already been borrowed");
			b.setIsSuccess(false);
			return b;
		}
		b.setMessage("Success! Member " + member.getName() + " has borrowed " + book.getTitle());
		book.setIsAvailable(false);
		return b;
	}

	@Override
	public BorrowingBookResult returnBook(Member member, Book book) {
		BorrowingBookResult b = new BorrowingBookResult(true, "Success");
		if(!member.hasBook(book)) {
			b.setMessage("Failure to Return: Member " + member.getName() + " does not have " + book.getTitle());
			b.setIsSuccess(false);
			return b;
		}else if(book.getIsAvailable()) {
			b.setMessage("Failure to Return: Book: " + book.getTitle() + " has already been returned");
			b.setIsSuccess(false);
			return b;
		}
		b.setMessage("Success! Member " + member.getName() + " returning " + book.getTitle());
		book.setIsAvailable(true);
		return b;
	}
}
