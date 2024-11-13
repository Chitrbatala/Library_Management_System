import java.util.Scanner;

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("Enter command: add, register, borrow, return, search, display, or exit");
            String command = scanner.nextLine();

            if (command.equals("add")) {
                System.out.print("Enter book title: ");
                String title = scanner.nextLine();
                System.out.print("Enter book author: ");
                String author = scanner.nextLine();
                System.out.print("Enter book ISBN: ");
                String isbn = scanner.nextLine();
                Book book = new Book(title, author, isbn);
                library.addBook(book);

            } else if (command.equals("register")) {
                System.out.print("Enter user name: ");
                String userName = scanner.nextLine();
                library.registerUser(userName);

            } else if (command.equals("borrow")) {
                System.out.print("Enter user name: ");
                String userName = scanner.nextLine();
                System.out.print("Enter book title to borrow: ");
                String title = scanner.nextLine();
                library.borrowBook(userName, title);

            } else if (command.equals("return")) {
                System.out.print("Enter user name: ");
                String userName = scanner.nextLine();
                System.out.print("Enter book title to return: ");
                String title = scanner.nextLine();
                library.returnBook(userName, title);

            } else if (command.equals("search")) {
                System.out.print("Enter book title to search: ");
                String title = scanner.nextLine();
                Book book = library.searchByTitle(title);
                if (book != null) {
                    System.out.println("Found book: " + book);
                } else {
                    System.out.println("Book not found.");
                }

            } else if (command.equals("display")) {
                library.displayAvailableBooks();

            } else if (command.equals("exit")) {
                break;

            } else {
                System.out.println("Invalid command. Try again.");
            }
        }
        scanner.close();
    }
}
