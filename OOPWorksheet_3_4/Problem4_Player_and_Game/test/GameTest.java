import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    @Test
    public void testGetWinner_basic() {
        Game game = new Game();
        game.addPlayer(new Player("Alice", 150));
        game.addPlayer(new Player("Bob", 300));
        game.addPlayer(new Player("Carol", 200));
        assertEquals("Bob", game.getWinner());
    }

    @Test
    public void testGetWinner_noPlayers() {
        Game game = new Game();
        assertEquals("No players", game.getWinner());
    }

    @Test
    public void testGetWinner_singlePlayer() {
        Game game = new Game();
        game.addPlayer(new Player("Solo", 42));
        assertEquals("Solo", game.getWinner());
    }

    @Test
    public void testGetWinner_tieGoesToFirst() {
        Game game = new Game();
        game.addPlayer(new Player("First", 100));
        game.addPlayer(new Player("Second", 100));
        assertEquals("First", game.getWinner());
    }
}
