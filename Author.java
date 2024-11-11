import java.util.ArrayList;
import java.util.List;

class Author {
    private String name;
    private String dateOfBirth;
    private List<LibraryItem> items;

    public Author(String name, String dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.items = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<LibraryItem> getItems() {
        return items;
    }

    public void addItem(LibraryItem item) {
        items.add(item);
    }
}
