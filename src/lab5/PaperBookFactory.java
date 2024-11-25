package lab5;

public class PaperBookFactory extends BookFactory{
	@Override
	public Book createBook(String name) {
		return new PaperBook(name);
	}
}
