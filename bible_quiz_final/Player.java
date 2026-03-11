/**
 * PLAYER CLASS
 *
 * This class represents the person playing the game.
 * Every Player object will have:
 *   - a name
 *   - a score (starts at 0)
 *   - how many questions they've answered
 *
 * 🎓 OOP CONCEPT: This is a CLASS with ATTRIBUTES and METHODS.
 *    The Player "knows things" (attributes) and "can do things" (methods).
 */
public class Player {

    // --- ATTRIBUTES (what a Player HAS) ---
    private String name;
    private int score;
    private int questionsAnswered;

    // --- CONSTRUCTOR ---
    // 🎓 This runs when we write: new Player("Sarah")
    //    It sets up the player at the START of the game.
    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.questionsAnswered = 0;
    }


    // =========================================================
    // ✏️  CHALLENGE 3 — addPoint() method
    // =========================================================
    // This method should add 1 to the player's score.
    // It's called every time the player answers CORRECTLY.
    //
    // 💡 Hint: score++ adds 1 to score. Or you can write score = score + 1;
    //          This method doesn't return anything (void).
    //
    // 🎮 AFTER CHALLENGE 3:
    //    The score counter in the top-right of the quiz screen will now
    //    go UP when you answer correctly — "Score: 0" → "Score: 1" etc.
    //    (Before this, it stays at 0 forever.)
    // =========================================================
    public void addPoint() {
        // 👇 YOUR CODE HERE
    }


    // =========================================================
    // ✏️  CHALLENGE 4 — incrementQuestionsAnswered() method
    // =========================================================
    // This method should add 1 to questionsAnswered.
    // It's called every time the player picks ANY answer (right or wrong).
    //
    // 💡 Hint: Very similar to Challenge 3 above!
    //
    // 🎮 AFTER CHALLENGE 4:
    //    No visible change in the game yet — but the results screen
    //    will now be able to show "X / 8 correct" correctly.
    //    This sets up Challenges 5 and 6!
    // =========================================================
    public void incrementQuestionsAnswered() {
        // 👇 YOUR CODE HERE
    }


    // =========================================================
    // ✏️  CHALLENGE 5 — getScorePercent() method
    // =========================================================
    // This method should calculate and RETURN the player's score
    // as a percentage (a whole number between 0 and 100).
    //
    // 💡 Hint: percentage = (score × 100) ÷ questionsAnswered
    //          But careful! If questionsAnswered is 0, don't divide
    //          (dividing by zero crashes the program). Return 0 in that case.
    //
    // Example: score=7, questionsAnswered=10  →  return 70
    //
    // 🎮 AFTER CHALLENGE 5:
    //    The big percentage number on the results screen will now show
    //    your real score — e.g. "75%" instead of "0%".
    // =========================================================
    public int getScorePercent() {
        // 👇 YOUR CODE HERE — handle the "divide by zero" case first!
        return 0; // placeholder
    }


    // =========================================================
    // ✏️  CHALLENGE 6 — getRank() method
    // =========================================================
    // This method should RETURN a fun rank (as a String) based
    // on how well the player did.
    //
    // Use IF / ELSE IF statements to check getScorePercent():
    //   100%          → "Bible Scholar! 🏆"
    //   80% or above  → "Disciple 📖"
    //   60% or above  → "Seeker 🕊️"
    //   40% or above  → "Wanderer 🌿"
    //   anything else → "Keep Studying! ✝️"
    //
    // 💡 Hint: Call getScorePercent() and save it to a variable first,
    //          then use if / else if / else to check the ranges.
    //
    // 🎮 AFTER CHALLENGE 6:
    //    The rank label on the results screen will now show your rank —
    //    e.g. "Disciple 📖" — instead of being blank.
    //    Challenges 1–6 are all done. The results screen is fully working!
    // =========================================================
    public String getRank() {
        // 👇 YOUR CODE HERE
        return ""; // placeholder
    }


    // --- These are already done — the GUI needs them to work! ---

    public String getName()           { return name; }
    public int getScore()             { return score; }
    public int getQuestionsAnswered() { return questionsAnswered; }
}
