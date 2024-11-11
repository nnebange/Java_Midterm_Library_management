import java.util.ArrayList;
import java.util.List;

class Library {
    private List<LibraryItem> items;
    private List<Author> authors;
    private List<Patron> patrons;

    public Library() {
        items = new ArrayList<>();
        authors = new ArrayList<>();
        patrons = new ArrayList<>();
    }

    // Author management methods
    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void editAuthor(String name, String newDob) {
        for (Author author : authors) {
            if (author.getName().equalsIgnoreCase(name)) {
                author.setDateOfBirth(newDob);
                System.out.println("Author updated successfully.");
                return;
            }
        }
        System.out.println("Author not found.");
    }

    public void deleteAuthor(String name) {
        authors.removeIf(author -> author.getName().equalsIgnoreCase(name));
    }

    // Patron management methods
    public void addPatron(Patron patron) {
        patrons.add(patron);
    }

    public void editPatron(String name, String newAddress, String newPhone) {
        for (Patron patron : patrons) {
            if (patron.getName().equalsIgnoreCase(name)) {
                patron.setAddress(newAddress);
                patron.setPhone(newPhone);
                System.out.println("Patron updated successfully.");
                return;
            }
        }
        System.out.println("Patron not found.");
    }

    public void deletePatron(String name) {
        patrons.removeIf(patron -> patron.getName().equalsIgnoreCase(name));
    }

    public Patron findPatronByName(String name) {
        for (Patron patron : patrons) {
            if (patron.getName().equalsIgnoreCase(name)) {
                return patron;
            }
        }
        System.out.println("Patron not found.");
        return null;
    }

    // Borrowing and returning items
    public void borrowItem(Patron patron, String title, int copies) {
        for (LibraryItem item : items) {
            if (item.getTitle().equalsIgnoreCase(title) && item.getAvailableCopies() >= copies) {
                patron.borrowItem(item);
                item.setAvailableCopies(item.getAvailableCopies() - copies);
                System.out.println("Item borrowed successfully.");
                return;
            }
        }
        System.out.println("Item is not available or insufficient copies.");
    }

    public void returnItem(Patron patron, String title, int copies) {
        for (LibraryItem item : items) {
            if (item.getTitle().equalsIgnoreCase(title) && patron.hasBorrowedItem(item)) {
                patron.returnItem(item);
                item.setAvailableCopies(item.getAvailableCopies() + copies);
                System.out.println("Item returned successfully.");
                return;
            }
        }
        System.out.println("Item was not borrowed by this patron.");
    }

    public List<LibraryItem> searchItemsByTitle(String title) {
        List<LibraryItem> results = new ArrayList<>();
        for (LibraryItem item : items) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                results.add(item);
            }
        }
        return results;
    }

    public List<LibraryItem> searchItemsByAuthor(String authorName) {
        List<LibraryItem> results = new ArrayList<>();
        for (LibraryItem item : items) {
            if (item.getAuthor().getName().equalsIgnoreCase(authorName)) {
                results.add(item);
            }
        }
        return results;
    }
}
