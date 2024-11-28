package lab5;

import java.util.Objects;

public class Ebook implements Book {
    // Implements interface Book
    private String title;
    private boolean isAvailable;

    public Ebook(String title) {
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
        return isAvailable;
    }

    @Override
    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public boolean getIsAvailable() {
        return isAvailable;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Ebook)) {
            return false;
        }
        Ebook other = (Ebook) obj;
        return title.equals(other.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
