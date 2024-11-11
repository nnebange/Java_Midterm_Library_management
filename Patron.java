import java.util.ArrayList;
import java.util.List;

abstract class Patron {
    private String name;
    private String address;
    private String phone;
    protected List<LibraryItem> borrowedItems;

    public Patron(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.borrowedItems = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<LibraryItem> getBorrowedItems() {
        return borrowedItems;
    }

    public void borrowItem(LibraryItem item) {
        borrowedItems.add(item);
    }

    public void returnItem(LibraryItem item) {
        borrowedItems.remove(item);
    }

    public boolean hasBorrowedItem(LibraryItem item) {
        return borrowedItems.contains(item);
    }
}

// Subclasses for different patron types
class Student extends Patron {
    public Student(String name, String address, String phone) {
        super(name, address, phone);
    }
}

class Employee extends Patron {
    public Employee(String name, String address, String phone) {
        super(name, address, phone);
    }
}
