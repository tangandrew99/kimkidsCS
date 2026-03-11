// ============================================================
// PlayerTest.java  —  Tests for Challenges 3, 4, 5 & 6
// ============================================================
// GREEN ✅ = your code works   |   RED ❌ = needs fixing
// ============================================================
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player("Sarah");
    }


    // ----------------------------------------------------------------
    // CHALLENGE 3 — addPoint()
    // ----------------------------------------------------------------

    @Test
    @DisplayName("C3: score starts at 0")
    void addPoint_startsAtZero() {
        assertEquals(0, player.getScore(),
            "A new player should start with score = 0");
    }

    @Test
    @DisplayName("C3: addPoint() increases score by 1")
    void addPoint_incrementsByOne() {
        player.addPoint();
        assertEquals(1, player.getScore(),
            "After one addPoint(), score should be 1");
    }

    @Test
    @DisplayName("C3: addPoint() can be called multiple times")
    void addPoint_multipleTimes() {
        player.addPoint();
        player.addPoint();
        player.addPoint();
        assertEquals(3, player.getScore(),
            "After three addPoint() calls, score should be 3");
    }

    @Test
    @DisplayName("C3: addPoint() does not change questionsAnswered")
    void addPoint_doesNotAffectQuestionsAnswered() {
        player.addPoint();
        assertEquals(0, player.getQuestionsAnswered(),
            "addPoint() should only change score, not questionsAnswered");
    }


    // ----------------------------------------------------------------
    // CHALLENGE 4 — incrementQuestionsAnswered()
    // ----------------------------------------------------------------

    @Test
    @DisplayName("C4: questionsAnswered starts at 0")
    void increment_startsAtZero() {
        assertEquals(0, player.getQuestionsAnswered(),
            "A new player should start with questionsAnswered = 0");
    }

    @Test
    @DisplayName("C4: incrementQuestionsAnswered() increases by 1")
    void increment_incrementsByOne() {
        player.incrementQuestionsAnswered();
        assertEquals(1, player.getQuestionsAnswered(),
            "After one incrementQuestionsAnswered(), questionsAnswered should be 1");
    }

    @Test
    @DisplayName("C4: incrementQuestionsAnswered() can be called multiple times")
    void increment_multipleTimes() {
        player.incrementQuestionsAnswered();
        player.incrementQuestionsAnswered();
        player.incrementQuestionsAnswered();
        assertEquals(3, player.getQuestionsAnswered(),
            "After three calls, questionsAnswered should be 3");
    }

    @Test
    @DisplayName("C4: incrementQuestionsAnswered() does not change score")
    void increment_doesNotAffectScore() {
        player.incrementQuestionsAnswered();
        assertEquals(0, player.getScore(),
            "incrementQuestionsAnswered() should only change questionsAnswered, not score");
    }

    @Test
    @DisplayName("C4: score and questionsAnswered track independently")
    void trackIndependently() {
        player.incrementQuestionsAnswered(); // answer 1 — wrong
        player.incrementQuestionsAnswered(); // answer 2 — wrong
        player.addPoint();                   // answer 2 was actually right
        player.incrementQuestionsAnswered(); // answer 3 — wrong

        assertEquals(3, player.getQuestionsAnswered(), "questionsAnswered should be 3");
        assertEquals(1, player.getScore(),             "score should be 1");
    }


    // ----------------------------------------------------------------
    // CHALLENGE 5 — getScorePercent()
    // ----------------------------------------------------------------

    @Test
    @DisplayName("C5: returns 0 when no questions have been answered yet (no divide-by-zero)")
    void getScorePercent_noQuestions() {
        assertEquals(0, player.getScorePercent(),
            "getScorePercent() should return 0 when questionsAnswered is 0 — " +
            "don't divide by zero!");
    }

    @Test
    @DisplayName("C5: 8 correct out of 8 = 100%")
    void getScorePercent_allCorrect() {
        for (int i = 0; i < 8; i++) {
            player.addPoint();
            player.incrementQuestionsAnswered();
        }
        assertEquals(100, player.getScorePercent(),
            "8/8 correct should be 100%");
    }

    @Test
    @DisplayName("C5: 0 correct out of 8 = 0%")
    void getScorePercent_noneCorrect() {
        for (int i = 0; i < 8; i++) {
            player.incrementQuestionsAnswered();
        }
        assertEquals(0, player.getScorePercent(),
            "0/8 correct should be 0%");
    }

    @Test
    @DisplayName("C5: 6 correct out of 8 = 75%")
    void getScorePercent_sixOutOfEight() {
        for (int i = 0; i < 6; i++) {
            player.addPoint();
            player.incrementQuestionsAnswered();
        }
        for (int i = 0; i < 2; i++) {
            player.incrementQuestionsAnswered();
        }
        assertEquals(75, player.getScorePercent(),
            "6/8 correct should be 75%");
    }

    @Test
    @DisplayName("C5: 1 correct out of 2 = 50%")
    void getScorePercent_half() {
        player.addPoint();
        player.incrementQuestionsAnswered();
        player.incrementQuestionsAnswered();
        assertEquals(50, player.getScorePercent(),
            "1/2 correct should be 50%");
    }

    @Test
    @DisplayName("C5: returns a whole number (integer division is fine)")
    void getScorePercent_wholeNumber() {
        player.addPoint();
        player.incrementQuestionsAnswered();
        player.incrementQuestionsAnswered();
        player.incrementQuestionsAnswered();
        // 1/3 ≈ 33% — we just want an int, not a decimal
        int result = player.getScorePercent();
        assertTrue(result >= 33 && result <= 34,
            "1/3 should be roughly 33%, got: " + result);
    }


    // ----------------------------------------------------------------
    // CHALLENGE 6 — getRank()
    // ----------------------------------------------------------------

    @Test
    @DisplayName("C6: 100% → \"Bible Scholar! 🏆\"")
    void getRank_scholar() {
        for (int i = 0; i < 8; i++) {
            player.addPoint();
            player.incrementQuestionsAnswered();
        }
        assertEquals("Bible Scholar! 🏆", player.getRank(),
            "100% score should give rank \"Bible Scholar! 🏆\"");
    }

    @Test
    @DisplayName("C6: 80% → \"Disciple 📖\"")
    void getRank_disciple() {
        // 8/10 = 80%
        for (int i = 0; i < 8; i++) {
            player.addPoint();
            player.incrementQuestionsAnswered();
        }
        player.incrementQuestionsAnswered();
        player.incrementQuestionsAnswered();
        assertEquals("Disciple 📖", player.getRank(),
            "80% score should give rank \"Disciple 📖\"");
    }

    @Test
    @DisplayName("C6: 60% → \"Seeker 🕊️\"")
    void getRank_seeker() {
        // 6/10 = 60%
        for (int i = 0; i < 6; i++) {
            player.addPoint();
            player.incrementQuestionsAnswered();
        }
        for (int i = 0; i < 4; i++) {
            player.incrementQuestionsAnswered();
        }
        assertEquals("Seeker 🕊️", player.getRank(),
            "60% score should give rank \"Seeker 🕊️\"");
    }

    @Test
    @DisplayName("C6: 40% → \"Wanderer 🌿\"")
    void getRank_wanderer() {
        // 4/10 = 40%
        for (int i = 0; i < 4; i++) {
            player.addPoint();
            player.incrementQuestionsAnswered();
        }
        for (int i = 0; i < 6; i++) {
            player.incrementQuestionsAnswered();
        }
        assertEquals("Wanderer 🌿", player.getRank(),
            "40% score should give rank \"Wanderer 🌿\"");
    }

    @Test
    @DisplayName("C6: below 40% → \"Keep Studying! ✝️\"")
    void getRank_keepStudying() {
        // 2/10 = 20%
        for (int i = 0; i < 2; i++) {
            player.addPoint();
            player.incrementQuestionsAnswered();
        }
        for (int i = 0; i < 8; i++) {
            player.incrementQuestionsAnswered();
        }
        assertEquals("Keep Studying! ✝️", player.getRank(),
            "20% score should give rank \"Keep Studying! ✝️\"");
    }

    @Test
    @DisplayName("C6: getRank() returns a non-empty String")
    void getRank_notEmpty() {
        player.addPoint();
        player.incrementQuestionsAnswered();
        String rank = player.getRank();
        assertNotNull(rank,  "getRank() should not return null");
        assertFalse(rank.isEmpty(), "getRank() should not return an empty string");
    }

    // ----------------------------------------------------------------
    // Already-done methods — quick sanity checks
    // ----------------------------------------------------------------

    @Test
    @DisplayName("getName() returns the name passed to the constructor")
    void getName_works() {
        assertEquals("Sarah", player.getName());
    }
}
