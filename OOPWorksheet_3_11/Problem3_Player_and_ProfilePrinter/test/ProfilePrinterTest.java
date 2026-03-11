import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ProfilePrinterTest {

    @Test
    public void testPlayer_setsName() {
        Player p = new Player("Alex", 20);
        assertEquals("Alex", p.name);
    }

    @Test
    public void testPlayer_setsAge() {
        Player p = new Player("Alex", 20);
        assertEquals(20, p.age);
    }

    @Test
    public void testPlayer_hobbiesStartEmpty() {
        Player p = new Player("Alex", 20);
        assertNotNull(p.hobbies);
        assertEquals(0, p.hobbies.size());
    }

    @Test
    public void testAddHobby_addsToList() {
        Player p = new Player("Alex", 20);
        p.addHobby("Gaming");
        assertEquals(1, p.hobbies.size());
        assertEquals("Gaming", p.hobbies.get(0));
    }

    @Test
    public void testPrintProfile_containsNameAndAge() {
        Player p = new Player("Alex", 20);
        ProfilePrinter printer = new ProfilePrinter();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        printer.printProfile(p);
        System.setOut(System.out);

        String output = out.toString();
        assertTrue(output.contains("Alex"));
        assertTrue(output.contains("20"));
    }

    @Test
    public void testPrintProfile_containsAllHobbies() {
        Player p = new Player("Sam", 18);
        p.addHobby("Gaming");
        p.addHobby("Reading");
        p.addHobby("Cooking");
        ProfilePrinter printer = new ProfilePrinter();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        printer.printProfile(p);
        System.setOut(System.out);

        String output = out.toString();
        assertTrue(output.contains("Gaming"));
        assertTrue(output.contains("Reading"));
        assertTrue(output.contains("Cooking"));
    }

    @Test
    public void testPrintProfile_emptyHobbies() {
        Player p = new Player("Jordan", 22);
        ProfilePrinter printer = new ProfilePrinter();

        // Should not throw an exception with an empty hobbies list
        assertDoesNotThrow(() -> printer.printProfile(p));
    }

    @Test
    public void testPrintProfile_differentPlayersProduceDifferentOutput() {
        Player p1 = new Player("Alice", 19);
        p1.addHobby("Painting");
        Player p2 = new Player("Bob", 25);
        p2.addHobby("Surfing");
        ProfilePrinter printer = new ProfilePrinter();

        ByteArrayOutputStream out1 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out1));
        printer.printProfile(p1);
        System.setOut(System.out);

        ByteArrayOutputStream out2 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out2));
        printer.printProfile(p2);
        System.setOut(System.out);

        assertNotEquals(out1.toString(), out2.toString());
    }
}
