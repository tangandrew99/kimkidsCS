// ============================================================
// QuizTest.java  —  Tests for Challenges 7, 8 & 9
// ============================================================
// GREEN ✅ = your code works   |   RED ❌ = needs fixing
// ============================================================
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class QuizTest {

    private Quiz quiz;

    @BeforeEach
    void setUp() {
        quiz = new Quiz();
    }


    // ----------------------------------------------------------------
    // CHALLENGE 7 — hasNextQuestion()
    // ----------------------------------------------------------------

    @Test
    @DisplayName("C7: hasNextQuestion() returns true at the very start")
    void hasNextQuestion_trueAtStart() {
        assertTrue(quiz.hasNextQuestion(),
            "hasNextQuestion() should return true when the quiz has just started — " +
            "there are still questions to answer!");
    }

    @Test
    @DisplayName("C7: hasNextQuestion() returns true when there are questions remaining")
    void hasNextQuestion_trueWhileQuestionsRemain() {
        quiz.advance(); // move past question 1
        assertTrue(quiz.hasNextQuestion(),
            "hasNextQuestion() should still return true after advancing once");
    }

    @Test
    @DisplayName("C7: hasNextQuestion() returns false only after ALL questions are done")
    void hasNextQuestion_falseAtEnd() {
        int total = quiz.getTotalQuestions();
        for (int i = 0; i < total; i++) {
            quiz.advance();
        }
        assertFalse(quiz.hasNextQuestion(),
            "hasNextQuestion() should return false once all " + total + " questions have been passed");
    }

    @Test
    @DisplayName("C7: hasNextQuestion() is false only at the end, not one question early")
    void hasNextQuestion_notOneTooEarly() {
        int total = quiz.getTotalQuestions();
        for (int i = 0; i < total - 1; i++) {
            quiz.advance();
        }
        assertTrue(quiz.hasNextQuestion(),
            "hasNextQuestion() should still be true when one question remains — " +
            "don't stop one question too soon!");
    }


    // ----------------------------------------------------------------
    // CHALLENGE 8 — advance()
    // ----------------------------------------------------------------

    @Test
    @DisplayName("C8: advance() moves to the next question (question number goes up)")
    void advance_questionNumberIncreases() {
        assertEquals(1, quiz.getCurrentQuestionNumber(),
            "Quiz should start on question 1");
        quiz.advance();
        assertEquals(2, quiz.getCurrentQuestionNumber(),
            "After advance(), question number should be 2");
    }

    @Test
    @DisplayName("C8: advance() can be called multiple times")
    void advance_multipleTimes() {
        quiz.advance();
        quiz.advance();
        quiz.advance();
        assertEquals(4, quiz.getCurrentQuestionNumber(),
            "After 3 advances, should be on question 4");
    }

    @Test
    @DisplayName("C8: advance() changes the current question (different text)")
    void advance_differentQuestion() {
        String firstQuestion = quiz.getCurrentQuestion().getQuestionText();
        quiz.advance();
        String secondQuestion = quiz.getCurrentQuestion().getQuestionText();
        assertNotEquals(firstQuestion, secondQuestion,
            "After advance(), the current question should be different");
    }

    @Test
    @DisplayName("C8: advance() followed by hasNextQuestion() eventually reaches the end")
    void advance_reachesEnd() {
        int total = quiz.getTotalQuestions();
        for (int i = 0; i < total; i++) {
            assertTrue(quiz.hasNextQuestion(),
                "Should still have questions at step " + i);
            quiz.advance();
        }
        assertFalse(quiz.hasNextQuestion(),
            "Should have no questions left after advancing through all " + total);
    }


    // ----------------------------------------------------------------
    // CHALLENGE 9 — loadQuestions() (adding your own questions)
    // ----------------------------------------------------------------

    @Test
    @DisplayName("C9: quiz has at least the original 8 questions")
    void loadQuestions_hasAtLeastEight() {
        assertTrue(quiz.getTotalQuestions() >= 8,
            "The quiz should have at least 8 questions (the original ones)");
    }

    @Test
    @DisplayName("C9: after adding 5 custom questions, quiz has at least 13 total")
    void loadQuestions_hasAtLeastThirteen() {
        assertTrue(quiz.getTotalQuestions() >= 13,
            "After Challenge 9 you should have added at least 5 questions — " +
            "expected 13 or more total, but found: " + quiz.getTotalQuestions());
    }

    @Test
    @DisplayName("C9: every question has exactly 4 answer options")
    void loadQuestions_allQuestionsHaveFourAnswers() {
        int total = quiz.getTotalQuestions();
        for (int i = 0; i < total; i++) {
            Question q = quiz.getCurrentQuestion();
            for (int j = 0; j < 4; j++) {
                assertNotNull(q.getAnswer(j),
                    "Question " + (i + 1) + " is missing answer at index " + j);
                assertFalse(q.getAnswer(j).isEmpty(),
                    "Question " + (i + 1) + " has an empty answer at index " + j);
            }
            quiz.advance();
        }
    }

    @Test
    @DisplayName("C9: every question has non-empty text")
    void loadQuestions_allQuestionsHaveText() {
        int total = quiz.getTotalQuestions();
        for (int i = 0; i < total; i++) {
            Question q = quiz.getCurrentQuestion();
            assertFalse(q.getQuestionText().isEmpty(),
                "Question " + (i + 1) + " has empty question text");
            quiz.advance();
        }
    }

    // ----------------------------------------------------------------
    // Already-done methods — quick sanity checks
    // ----------------------------------------------------------------

    @Test
    @DisplayName("getCurrentQuestionNumber() starts at 1")
    void getCurrentQuestionNumber_startsAtOne() {
        assertEquals(1, quiz.getCurrentQuestionNumber(),
            "getCurrentQuestionNumber() should return 1 at the start (not 0)");
    }

    @Test
    @DisplayName("getTotalQuestions() returns a positive number")
    void getTotalQuestions_positive() {
        assertTrue(quiz.getTotalQuestions() > 0,
            "getTotalQuestions() should be greater than 0");
    }

    @Test
    @DisplayName("getCurrentQuestion() returns a non-null Question object")
    void getCurrentQuestion_notNull() {
        assertNotNull(quiz.getCurrentQuestion(),
            "getCurrentQuestion() should return a Question object, not null");
    }
}
