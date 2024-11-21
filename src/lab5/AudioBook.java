package lab5;

import java.util.Objects;

public class AudioBook implements Book {
    private String title;
    private boolean isAvailable;
    private Member rentedBy;

    public AudioBook(String title) {
        this.title = title;
        this.isAvailable = true;
        this.rentedBy = null;
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
        if (this == obj)
            return true;
        if (!(obj instanceof AudioBook))
            return false;
        AudioBook other = (AudioBook) obj;
        return title.equals(other.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    public void rentBook(Member member) {
        if (isAvailable) {
            this.rentedBy = member;
            this.isAvailable = false;
            member.borrowBook(this);
            System.out.println("Book " + title + " rented by " + member.getName());
        } else {
            System.out.println("Book " + title + " is already rented by " + rentedBy.getName());
        }
    }

    public void returnBook(Member member) {
        if (!isAvailable && rentedBy.equals(member)) {
            this.rentedBy = null;
            this.isAvailable = true;
            member.returnBook(this);
            System.out.println("Book " + title + " returned by " + member.getName());
        } else if (isAvailable) {
            System.out.println("Book " + title + " is not currently rented.");
        } else {
            System.out.println("Book " + title + " cannot be returned by " + member.getName() + " because it is rented by " + rentedBy.getName());
        }
    }
}
