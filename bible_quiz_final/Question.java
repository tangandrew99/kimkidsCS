/**
 * QUESTION CLASS
 *
 * This is a "blueprint" (class) for a single quiz question.
 * Every Question object will have:
 *   - a question to ask
 *   - 4 possible answers (stored in an ARRAY)
 *   - the index of the correct answer (0, 1, 2, or 3)
 *
 * 🎓 OOP CONCEPT: This is ENCAPSULATION — we keep the data
 *    private and only allow access through methods (getters).
 */
public class Question {

    // --- ATTRIBUTES (what a Question HAS) ---
    // 🎓 These are "private" so only this class can change them directly!
    private String questionText;
    private String[] answers;      // array of 4 answer choices
    private int correctIndex;      // which answer is correct (0, 1, 2, or 3)

    // --- CONSTRUCTOR (how we BUILD a Question) ---
    // 🎓 A constructor runs when we write: new Question(...)
    public Question(String questionText, String[] answers, int correctIndex) {
        this.questionText = questionText;
        this.answers = answers;
        this.correctIndex = correctIndex;
    }


    // =========================================================
    // ✏️  CHALLENGE 1 — isCorrect() method
    // =========================================================
    // This method should CHECK if the player's guess is right.
    // It receives the player's chosen index (0, 1, 2, or 3)
    // and should RETURN true if it matches correctIndex, false if not.
    //
    // 💡 Hint: You can do this in ONE line using ==
    //          The return type is boolean.
    //
    // When you're done it should work like this:
    //   question.isCorrect(2)  →  true  (if correct answer is index 2)
    //   question.isCorrect(0)  →  false (if correct answer is NOT index 0)
    //
    // 🎮 AFTER CHALLENGE 1:
    //    Run the game and answer a question correctly.
    //    The button should turn GREEN and say "✅ Correct! Great job, ..."
    //    Wrong answers should turn RED. (Before this, every answer shows red!)
    // =========================================================
    public boolean isCorrect(int playerGuess) {
        // 👇 YOUR CODE HERE — delete this line and write your solution!
        return false; // placeholder — this will always say "wrong" until you fix it
    }


    // =========================================================
    // ✏️  CHALLENGE 2 — getCorrectAnswer() method
    // =========================================================
    // This method should RETURN the correct answer as a String.
    // (Not the index number — the actual answer text!)
    //
    // 💡 Hint: Use the answers array and correctIndex together.
    //          Remember: arrays use square brackets → answers[someIndex]
    //
    // 🎮 AFTER CHALLENGE 2:
    //    When you answer WRONG, the feedback message will now show
    //    the real answer — e.g. "❌ Not quite! The answer was: Noah"
    //    (Before this, it shows "The answer was: " with nothing after it.)
    // =========================================================
    public String getCorrectAnswer() {
        // 👇 YOUR CODE HERE
        return ""; // placeholder
    }


    // --- These methods are already done — no need to change them! ---

    // Return the question text (the GUI uses this to display the question)
    public String getQuestionText() {
        return questionText;
    }

    // Return one specific answer choice by index (the GUI uses this for buttons)
    public String getAnswer(int index) {
        return answers[index];
    }
}
