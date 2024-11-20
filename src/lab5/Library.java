package lab5;
import java.util.*;

public class Library {
    private Map<String, Book> books = new HashMap<>();
    private List<Member> members = new ArrayList<>();

    public void addBook(Book book) {
        books.put(book.getTitle(), book);
    }

    public void removeBook(Book book) {
        books.remove(book.getTitle());
    }

    public void removeBook(String title) {
        books.remove(title);
    }

    public Book findBookByTitle(String title) {
        return books.get(title);
    }

    public int booksCount() {
        return books.size();
    }

    // Methods for managing members
    public void addMember(Member member) {
        members.add(member);
    }

    public void removeMember(Member member) {
        members.remove(member);
    }

    public void removeMember(String name) {
        members.removeIf(m -> m.getName().equals(name));
    }

    public Member findMemberByName(String name) {
        for (Member member : members) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    public int membersCount() {
        return members.size();
    }
}