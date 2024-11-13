import java.util.ArrayList;
import java.util.HashMap;

public class Library {
    private ArrayList<Book> books;
    private HashMap<String, User> users;

    public Library() {
        this.books = new ArrayList<>();
        this.users = new HashMap<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book);
    }

    public void registerUser(String userName) {
        if (!users.containsKey(userName)) {
            users.put(userName, new User(userName));
            System.out.println("User registered: " + userName);
        } else {
            System.out.println("User already registered.");
        }
    }

    public Book searchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public void displayAvailableBooks() {
        System.out.println("Available Books: ");
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book);
            }
        }
    }

    public void borrowBook(String userName, String title) {
        User user = users.get(userName);
        if (user != null) {
            Book book = searchByTitle(title);
            if (book != null && book.isAvailable()) {
                user.borrowBook(book);
                book.setAvailable(false);  // Mark book as unavailable
                System.out.println(userName + " borrowed " + book);
            } else {
                System.out.println("Book is not available.");
            }
        } else {
            System.out.println("User not registered.");
        }
    }

    public void returnBook(String userName, String title) {
        User user = users.get(userName);
        if (user != null) {
            Book book = searchByTitle(title);
            if (book != null && !book.isAvailable()) {
                user.returnBook(book);
                book.setAvailable(true);  // Mark book as available again
                System.out.println(userName + " returned " + book);
            } else {
                System.out.println("This book was not borrowed or does not exist.");
            }
        } else {
            System.out.println("User not registered.");
        }
    }
}
