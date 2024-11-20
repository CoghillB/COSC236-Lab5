package lab5;

public class PaperBook implements Book {
    //implements interface Book
    private String title;
    private boolean isAvailable;

    public PaperBook(String title) {
        this.title = title;
        this.isAvailable = true;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }

    @Override
    public boolean isAvailable() {
        return false;
    }

    @Override
    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public boolean getIsAvailable() {
        return isAvailable;
    }
}