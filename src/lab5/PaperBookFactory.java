
public class PaperBookFactory extends BookFactory{
	@Override
	public Book createBook(String name) {
		return new paperBook(name);
	}
}
