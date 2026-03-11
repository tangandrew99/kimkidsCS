import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    @Test
    public void testCountAvailable_allAvailable() {
        Library lib = new Library();
        lib.addBook(new Book("The Hobbit", false));
        lib.addBook(new Book("Dune", false));
        assertEquals(2, lib.countAvailable());
    }

    @Test
    public void testCountAvailable_noneAvailable() {
        Library lib = new Library();
        lib.addBook(new Book("1984", true));
        lib.addBook(new Book("Brave New World", true));
        assertEquals(0, lib.countAvailable());
    }

    @Test
    public void testCountAvailable_mixed() {
        Library lib = new Library();
        lib.addBook(new Book("Hamlet", false));
        lib.addBook(new Book("Macbeth", true));
        lib.addBook(new Book("Othello", false));
        assertEquals(2, lib.countAvailable());
    }

    @Test
    public void testCountAvailable_empty() {
        Library lib = new Library();
        assertEquals(0, lib.countAvailable());
    }
}
