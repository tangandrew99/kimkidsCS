import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class RosterTest {

    @Test
    public void testMove_setsName() {
        Move m = new Move("Triforce Slash", 37);
        assertEquals("Triforce Slash", m.name);
    }

    @Test
    public void testMove_setsDamage() {
        Move m = new Move("Triforce Slash", 37);
        assertEquals(37, m.damage);
    }

    @Test
    public void testFighter_setsName() {
        Move m = new Move("Triforce Slash", 37);
        Fighter f = new Fighter("Link", "The Legend of Zelda", m);
        assertEquals("Link", f.name);
    }

    @Test
    public void testFighter_setsFranchise() {
        Move m = new Move("Triforce Slash", 37);
        Fighter f = new Fighter("Link", "The Legend of Zelda", m);
        assertEquals("The Legend of Zelda", f.franchise);
    }

    @Test
    public void testFighter_chainedDotNotation_moveName() {
        Move m = new Move("Volt Tackle", 50);
        Fighter f = new Fighter("Pikachu", "Pokemon", m);
        assertEquals("Volt Tackle", f.finalSmash.name);
    }

    @Test
    public void testFighter_chainedDotNotation_damage() {
        Move m = new Move("Critical Hit", 40);
        Fighter f = new Fighter("Marth", "Fire Emblem", m);
        assertEquals(40, f.finalSmash.damage);
    }

    @Test
    public void testRoster_startsEmpty() {
        Roster r = new Roster();
        assertNotNull(r.fighters);
        assertEquals(0, r.fighters.size());
    }

    @Test
    public void testRoster_addFighter() {
        Roster r = new Roster();
        Fighter f = new Fighter("Link", "The Legend of Zelda", new Move("Triforce Slash", 37));
        r.addFighter(f);
        assertEquals(1, r.fighters.size());
    }

    @Test
    public void testPrintRoster_containsAllFighters() {
        Roster r = new Roster();
        r.addFighter(new Fighter("Link", "The Legend of Zelda", new Move("Triforce Slash", 37)));
        r.addFighter(new Fighter("Pikachu", "Pokemon", new Move("Volt Tackle", 50)));
        r.addFighter(new Fighter("Marth", "Fire Emblem", new Move("Critical Hit", 40)));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        r.printRoster();
        System.setOut(System.out);

        String output = out.toString();
        assertTrue(output.contains("Link"));
        assertTrue(output.contains("Pikachu"));
        assertTrue(output.contains("Marth"));
    }

    @Test
    public void testPrintRoster_containsFinalSmashInfo() {
        Roster r = new Roster();
        r.addFighter(new Fighter("Link", "The Legend of Zelda", new Move("Triforce Slash", 37)));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        r.printRoster();
        System.setOut(System.out);

        String output = out.toString();
        assertTrue(output.contains("Triforce Slash"));
        assertTrue(output.contains("37"));
    }
}
