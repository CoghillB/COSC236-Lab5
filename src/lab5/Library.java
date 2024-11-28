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

    public void showBooks() {
        for (Book book : books.values()) {
            System.out.println(book);
        }
    }

    public int booksCount() {
        return books.size();
    }


    public void addMember(Member member) {
        members.add(member);
    }

    public void removeMember(Member member) {
    	members.remove(member);
    	member.remove();
    }

    public void removeMember(String name) {
        members.removeIf(m -> m.getName().equals(name));
    }

    public Member findMemberByName(String name) {
        return members.stream()
                .filter(member -> member.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public void showMembers() {
        for (Member member : members) {
            System.out.println(member);
        }
    }

    public int membersCount() {
        return members.size();
    }


}