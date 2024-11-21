
public class EbookFactory extends BookFactory{
	@Override
	public Book createBook(String name) {
		return new Ebook(name);
	}
}
