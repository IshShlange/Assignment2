package app;

import factory.AudioBookFactory;
import factory.BookFactory;
import factory.LibraryFactory;
import model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryApp {
    private final List<Book> library = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public void run() {
        while (true) {
            printMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> showBooks();
                case "2" -> addBook(new BookFactory());
                case "3" -> addBook(new AudioBookFactory());
                case "0" -> exit();
                default -> System.out.println("Unknown option. Try again.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\n--- Library Menu ---");
        System.out.println("1. Show all books");
        System.out.println("2. Add Book");
        System.out.println("3. Add AudioBook");
        System.out.println("0. Exit");
        System.out.print("Choose: ");
    }

    private void showBooks() {
        if (library.isEmpty()) {
            System.out.println("Library is empty.");
            return;
        }
        library.forEach(System.out::println);
    }

    private void addBook(LibraryFactory factory) {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();

        Book book = factory.createBook(title, author);
        library.add(book);
        System.out.println("Added: " + book);
    }

    private void exit() {
        System.out.println("Goodbye!");
        System.exit(0);
    }
}
