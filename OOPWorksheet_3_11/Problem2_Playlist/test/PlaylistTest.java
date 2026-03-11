import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PlaylistTest {

    @Test
    public void testConstructor_setsTitle() {
        Playlist p = new Playlist("Chill Vibes");
        assertEquals("Chill Vibes", p.title);
    }

    @Test
    public void testSongs_startsEmpty() {
        Playlist p = new Playlist("Chill Vibes");
        assertNotNull(p.songs);
        assertEquals(0, p.songs.size());
    }

    @Test
    public void testAddSong_addsToList() {
        Playlist p = new Playlist("Chill Vibes");
        p.addSong("Blinding Lights");
        assertEquals(1, p.songs.size());
        assertEquals("Blinding Lights", p.songs.get(0));
    }

    @Test
    public void testAddSong_multipleSongs() {
        Playlist p = new Playlist("Chill Vibes");
        p.addSong("Blinding Lights");
        p.addSong("Levitating");
        p.addSong("Stay");
        assertEquals(3, p.songs.size());
    }

    @Test
    public void testPrintSongs_includesTitleAndSong() {
        Playlist p = new Playlist("Chill Vibes");
        p.addSong("Blinding Lights");

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        p.printSongs();
        System.setOut(System.out);

        String output = out.toString();
        assertTrue(output.contains("Chill Vibes"));
        assertTrue(output.contains("Blinding Lights"));
    }

    @Test
    public void testPrintSongs_allSongsAppear() {
        Playlist p = new Playlist("Workout Mix");
        p.addSong("Eye of the Tiger");
        p.addSong("Lose Yourself");

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        p.printSongs();
        System.setOut(System.out);

        String output = out.toString();
        assertTrue(output.contains("Eye of the Tiger"));
        assertTrue(output.contains("Lose Yourself"));
    }

    @Test
    public void testTwoPlaylists_independent() {
        Playlist p1 = new Playlist("Morning");
        Playlist p2 = new Playlist("Night");
        p1.addSong("Good Morning");
        assertEquals(1, p1.songs.size());
        assertEquals(0, p2.songs.size());
    }
}
