package lab5;

public class AudioBookFactory extends BookFactory {
	@Override
	public Book createBook(String name) {
		return new AudioBook(name);
	}
}
