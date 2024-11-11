import java.util.Scanner;

public class LibraryDemo {
    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("Library Management System");
            System.out.println("1. Add Author");
            System.out.println("2. Edit Author");
            System.out.println("3. Delete Author");
            System.out.println("4. Add Patron");
            System.out.println("5. Edit Patron");
            System.out.println("6. Delete Patron");
            System.out.println("7. Borrow Item");
            System.out.println("8. Return Item");
            System.out.println("9. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addAuthor();
                case 2 -> editAuthor();
                case 3 -> deleteAuthor();
                case 4 -> addPatron();
                case 5 -> editPatron();
                case 6 -> deletePatron();
                case 7 -> borrowItem();
                case 8 -> returnItem();
                case 9 -> exit = true;
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private static void addAuthor() {
        System.out.print("Enter author name: ");
        String name = scanner.nextLine();
        System.out.print("Enter date of birth: ");
        String dob = scanner.nextLine();
        Author author = new Author(name, dob);
        library.addAuthor(author);
        System.out.println("Author added.");
    }

    private static void editAuthor() {
        System.out.print("Enter author name to edit: ");
        String name = scanner.nextLine();
        System.out.print("Enter new date of birth: ");
        String dob = scanner.nextLine();
        library.editAuthor(name, dob);
    }

    private static void deleteAuthor() {
        System.out.print("Enter author name to delete: ");
        String name = scanner.nextLine();
        library.deleteAuthor(name);
    }

    private static void addPatron() {
        System.out.print("Enter patron name: ");
        String name = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();
        Patron patron = new Student(name, address, phone);  // Assuming Student type here
        library.addPatron(patron);
        System.out.println("Patron added.");
    }

    private static void editPatron() {
        System.out.print("Enter patron name to edit: ");
        String name = scanner.nextLine();
        System.out.print("Enter new address: ");
        String address = scanner.nextLine();
        System.out.print("Enter new phone: ");
        String phone = scanner.nextLine();
        library.editPatron(name, address, phone);
    }

    private static void deletePatron() {
        System.out.print("Enter patron name to delete: ");
        String name = scanner.nextLine();
        library.deletePatron(name);
    }

    private static void borrowItem() {
        System.out.print("Enter patron name: ");
        String patronName = scanner.nextLine();
        Patron patron = library.findPatronByName(patronName);
        if (patron != null) {
            System.out.print("Enter item title to borrow: ");
            String title = scanner.nextLine();
            System.out.print("Enter number of copies to borrow: ");
            int copies = scanner.nextInt();
            library.borrowItem(patron, title, copies);
        }
    }

    private static void returnItem() {
        System.out.print("Enter patron name: ");
        String patronName = scanner.nextLine();
        Patron patron = library.findPatronByName(patronName);
        if (patron != null) {
            System.out.print("Enter item title to return: ");
            String title = scanner.nextLine();
            System.out.print("Enter number of copies to return: ");
            int copies = scanner.nextInt();
            library.returnItem(patron, title, copies);
        }
    }
}
