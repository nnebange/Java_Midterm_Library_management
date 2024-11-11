import java.util.ArrayList;
import java.util.List;

abstract class LibraryItem {
    private String id;
    private String title;
    private Author author;
    private String isbn;
    private String publisher;
    private int availableCopies;

    public LibraryItem(String id, String title, Author author, String isbn, String publisher, int availableCopies) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publisher = publisher;
        this.availableCopies = availableCopies;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }
}

// Subclass for books
class Book extends LibraryItem {
    public Book(String id, String title, Author author, String isbn, String publisher, int availableCopies) {
        super(id, title, author, isbn, publisher, availableCopies);
    }
}

// Subclass for periodicals
class Periodical extends LibraryItem {
    public Periodical(String id, String title, Author author, String isbn, String publisher, int availableCopies) {
        super(id, title, author, isbn, publisher, availableCopies);
    }
}
