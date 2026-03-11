import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TeamTest {

    @Test
    public void testConstructor_setsName() {
        Team t = new Team("Lakers", "Los Angeles", 17);
        assertEquals("Lakers", t.name);
    }

    @Test
    public void testConstructor_setsCity() {
        Team t = new Team("Lakers", "Los Angeles", 17);
        assertEquals("Los Angeles", t.city);
    }

    @Test
    public void testConstructor_setsChampionships() {
        Team t = new Team("Lakers", "Los Angeles", 17);
        assertEquals(17, t.championships);
    }

    @Test
    public void testRoster_startsEmpty() {
        Team t = new Team("Bulls", "Chicago", 6);
        assertNotNull(t.roster);
        assertEquals(0, t.roster.size());
    }

    @Test
    public void testAddPlayer_addsToRoster() {
        Team t = new Team("Bulls", "Chicago", 6);
        t.addPlayer("Michael Jordan");
        assertEquals(1, t.roster.size());
        assertEquals("Michael Jordan", t.roster.get(0));
    }

    @Test
    public void testAddPlayer_multiplePlayers() {
        Team t = new Team("Bulls", "Chicago", 6);
        t.addPlayer("Michael Jordan");
        t.addPlayer("Scottie Pippen");
        t.addPlayer("Dennis Rodman");
        assertEquals(3, t.roster.size());
    }

    @Test
    public void testTwoTeams_independentRosters() {
        Team t1 = new Team("Lakers", "Los Angeles", 17);
        Team t2 = new Team("Celtics", "Boston", 17);
        t1.addPlayer("LeBron James");
        assertEquals(1, t1.roster.size());
        assertEquals(0, t2.roster.size());
    }
}
