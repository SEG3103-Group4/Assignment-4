package mutation;

import java.util.*;

public class LibraryManager {

    private final Map<String, Integer> inventory = new HashMap<>();

    // Add copies of a book to the inventory
    public void addBook(String title, int copies) {
        if (copies <= 0) throw new IllegalArgumentException("Copies must be positive");
        inventory.put(title, inventory.getOrDefault(title, 0) + copies);
    }

    // Borrow a book if available
    public boolean borrowBook(String title) {
        int available = inventory.getOrDefault(title, 0);
        if (available > 0) {
            inventory.put(title, available - 1);
            return true;
        }
        return false;
    }

    // Return a borrowed book
    public void returnBook(String title) {
        inventory.put(title, inventory.getOrDefault(title, 0) + 1);
    }

    // Check number of copies available
    public int getCopies(String title) {
        return inventory.getOrDefault(title, 0);
    }
}
