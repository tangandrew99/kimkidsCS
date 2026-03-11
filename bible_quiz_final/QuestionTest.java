// ============================================================
// QuestionTest.java  —  Tests for Challenges 1 & 2
// ============================================================
// GREEN ✅ = your code works   |   RED ❌ = needs fixing
// ============================================================
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class QuestionTest {

    // A shared question used by most tests:
    // "Who built the ark?" — answers: Moses(0), Abraham(1), Noah(2), David(3)
    // Correct index: 2
    private Question arkQuestion;

    @BeforeEach
    void setUp() {
        arkQuestion = new Question(
            "Who built the ark?",
            new String[]{"Moses", "Abraham", "Noah", "David"},
            2
        );
    }


    // ----------------------------------------------------------------
    // CHALLENGE 1 — isCorrect()
    // ----------------------------------------------------------------

    @Test
    @DisplayName("C1: isCorrect() returns true when the right answer is chosen")
    void isCorrect_rightAnswer() {
        assertTrue(arkQuestion.isCorrect(2),
            "isCorrect(2) should return true — index 2 (\"Noah\") is the correct answer");
    }

    @Test
    @DisplayName("C1: isCorrect() returns false when a wrong answer is chosen")
    void isCorrect_wrongAnswer() {
        assertFalse(arkQuestion.isCorrect(0),
            "isCorrect(0) should return false — index 0 (\"Moses\") is wrong");
    }

    @Test
    @DisplayName("C1: isCorrect() returns false for every other wrong option")
    void isCorrect_allWrongOptions() {
        assertFalse(arkQuestion.isCorrect(1),
            "isCorrect(1) should be false — \"Abraham\" is wrong");
        assertFalse(arkQuestion.isCorrect(3),
            "isCorrect(3) should be false — \"David\" is wrong");
    }

    @Test
    @DisplayName("C1: isCorrect() works when the correct answer is at index 0")
    void isCorrect_correctAtIndexZero() {
        Question q = new Question(
            "How many days did God take to create the world?",
            new String[]{"6", "5", "7", "8"},
            0   // "6" is at index 0 this time
        );
        assertTrue(q.isCorrect(0),
            "isCorrect(0) should return true when the correct answer is at index 0");
        assertFalse(q.isCorrect(1),
            "isCorrect(1) should return false");
    }

    @Test
    @DisplayName("C1: isCorrect() works when the correct answer is at index 3")
    void isCorrect_correctAtIndexThree() {
        Question q = new Question(
            "In what city was Jesus born?",
            new String[]{"Jerusalem", "Nazareth", "Jericho", "Bethlehem"},
            3   // "Bethlehem" is at index 3
        );
        assertTrue(q.isCorrect(3),
            "isCorrect(3) should return true when correct answer is at index 3");
        assertFalse(q.isCorrect(0),
            "isCorrect(0) should return false");
    }


    // ----------------------------------------------------------------
    // CHALLENGE 2 — getCorrectAnswer()
    // ----------------------------------------------------------------

    @Test
    @DisplayName("C2: getCorrectAnswer() returns the correct answer text, not the index")
    void getCorrectAnswer_returnsText() {
        assertEquals("Noah", arkQuestion.getCorrectAnswer(),
            "getCorrectAnswer() should return \"Noah\", not the number 2");
    }

    @Test
    @DisplayName("C2: getCorrectAnswer() returns the right text for a different question")
    void getCorrectAnswer_differentQuestion() {
        Question q = new Question(
            "What is the first book of the Bible?",
            new String[]{"Exodus", "Psalms", "Genesis", "Matthew"},
            2
        );
        assertEquals("Genesis", q.getCorrectAnswer(),
            "getCorrectAnswer() should return \"Genesis\"");
    }

    @Test
    @DisplayName("C2: getCorrectAnswer() is not always index 2 — works for index 1")
    void getCorrectAnswer_atIndexOne() {
        Question q = new Question(
            "Who was swallowed by a big fish?",
            new String[]{"Elijah", "Jonah", "Paul", "Peter"},
            1
        );
        assertEquals("Jonah", q.getCorrectAnswer(),
            "getCorrectAnswer() should return \"Jonah\" (index 1)");
    }

    @Test
    @DisplayName("C2: getCorrectAnswer() returns a non-empty String")
    void getCorrectAnswer_notEmpty() {
        String answer = arkQuestion.getCorrectAnswer();
        assertNotNull(answer,  "getCorrectAnswer() should not return null");
        assertFalse(answer.isEmpty(), "getCorrectAnswer() should not return an empty string");
    }

    // ----------------------------------------------------------------
    // Already-done methods — quick sanity checks
    // ----------------------------------------------------------------

    @Test
    @DisplayName("getQuestionText() returns the question text correctly")
    void getQuestionText_works() {
        assertEquals("Who built the ark?", arkQuestion.getQuestionText());
    }

    @Test
    @DisplayName("getAnswer(i) returns the right option for each index")
    void getAnswer_works() {
        assertEquals("Moses",   arkQuestion.getAnswer(0));
        assertEquals("Abraham", arkQuestion.getAnswer(1));
        assertEquals("Noah",    arkQuestion.getAnswer(2));
        assertEquals("David",   arkQuestion.getAnswer(3));
    }
}
