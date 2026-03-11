import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MovieCollectionTest {

    @Test
    public void testMovie_setsTitle() {
        Movie m = new Movie("Inception", 5);
        assertEquals("Inception", m.title);
    }

    @Test
    public void testMovie_setsRating() {
        Movie m = new Movie("Inception", 5);
        assertEquals(5, m.rating);
    }

    @Test
    public void testCollection_startsEmpty() {
        MovieCollection mc = new MovieCollection();
        assertNotNull(mc.movies);
        assertEquals(0, mc.movies.size());
    }

    @Test
    public void testAddMovie_addsToList() {
        MovieCollection mc = new MovieCollection();
        mc.addMovie(new Movie("Dune", 5));
        assertEquals(1, mc.movies.size());
    }

    @Test
    public void testPrintHighRated_onlyShowsQualifying() {
        MovieCollection mc = new MovieCollection();
        mc.addMovie(new Movie("Inception", 5));
        mc.addMovie(new Movie("Meh Film", 2));
        mc.addMovie(new Movie("Dune", 4));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        mc.printHighRated(4);
        System.setOut(System.out);

        String output = out.toString();
        assertTrue(output.contains("Inception"));
        assertTrue(output.contains("Dune"));
        assertFalse(output.contains("Meh Film"));
    }

    @Test
    public void testPrintHighRated_noneQualify() {
        MovieCollection mc = new MovieCollection();
        mc.addMovie(new Movie("Bad Movie", 1));
        mc.addMovie(new Movie("Okay Movie", 2));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        mc.printHighRated(4);
        System.setOut(System.out);

        String output = out.toString().trim();
        assertFalse(output.contains("Bad Movie"));
        assertFalse(output.contains("Okay Movie"));
    }

    @Test
    public void testPrintHighRated_emptyCollection() {
        MovieCollection mc = new MovieCollection();
        // Should not throw an exception
        assertDoesNotThrow(() -> mc.printHighRated(4));
    }

    @Test
    public void testAddMovie_fiveMovies() {
        MovieCollection mc = new MovieCollection();
        mc.addMovie(new Movie("A", 1));
        mc.addMovie(new Movie("B", 2));
        mc.addMovie(new Movie("C", 3));
        mc.addMovie(new Movie("D", 4));
        mc.addMovie(new Movie("E", 5));
        assertEquals(5, mc.movies.size());
    }
}
