package mutation;

import org.junit.Test;
import static org.junit.Assert.*;

public class LibraryManagerTest {

    @Test
    public void testAddBookAndGetCopies() {
        LibraryManager lib = new LibraryManager();
        lib.addBook("1984", 3);
        lib.addBook("1984", 2);
        assertEquals(5, lib.getCopies("1984"));
    }

    @Test
    public void testBorrowBook() {
        LibraryManager lib = new LibraryManager();
        lib.addBook("Intro to Mutation Testing", 1);

        assertTrue(lib.borrowBook("Intro to Mutation Testing"));
        assertEquals(0, lib.getCopies("Intro to Mutation Testing"));
        assertFalse(lib.borrowBook("Intro to Mutation Testing"));  // no copies left
    }

    @Test
    public void testReturnBook() {
        LibraryManager lib = new LibraryManager();
        lib.addBook("Dune", 1);

        assertTrue(lib.borrowBook("Dune"));
        assertEquals(0, lib.getCopies("Dune"));

        lib.returnBook("Dune");
        assertEquals(1, lib.getCopies("Dune"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddBookWithInvalidCopies() {
        LibraryManager lib = new LibraryManager();
        lib.addBook("Faulty Book", 0);  // Should throw
    }
}
