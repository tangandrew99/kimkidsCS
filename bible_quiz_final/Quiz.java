import java.util.ArrayList;

/**
 * QUIZ CLASS
 *
 * This class manages the whole question bank.
 * It CONTAINS a list of Question objects.
 *
 * 🎓 OOP CONCEPT: COMPOSITION — a Quiz HAS Questions inside it.
 *    One class holding objects of another class is very common in OOP!
 *
 * 🎓 NEW CONCEPT: ArrayList — like a regular array, but it can
 *    grow and shrink. We use it here to store all our questions.
 *    Syntax:  ArrayList<Question> questions = new ArrayList<Question>();
 *             questions.add(someQuestion);   ← add to the end
 *             questions.get(0);              ← get item at index 0
 *             questions.size();              ← how many items
 */
public class Quiz {

    // --- ATTRIBUTES ---
    private ArrayList<Question> questions;   // our list of Question objects
    private int currentIndex;                // which question we're on right now

    // --- CONSTRUCTOR ---
    public Quiz() {
        questions = new ArrayList<Question>();
        currentIndex = 0;
        loadQuestions();   // fill the quiz with questions when created
    }


    // =========================================================
    // ✏️  CHALLENGE 7 — hasNextQuestion() method
    // =========================================================
    // This method should RETURN true if there are still questions
    // left to answer, or false if we've reached the end.
    //
    // 💡 Hint: Compare currentIndex with questions.size()
    //          If currentIndex is LESS THAN questions.size(), there are more.
    //          Return type is boolean.
    //
    // 🎮 AFTER CHALLENGE 7:
    //    THIS IS THE BIG ONE — the game will finally work end to end!
    //    Instead of jumping straight to the results screen, you'll now
    //    see all 8 questions one by one. Answer them all and you'll reach
    //    the results screen properly for the first time!
    //    (Before this, hasNextQuestion() always returns false, so the
    //    game skips directly to results the moment you start.)
    // =========================================================
    public boolean hasNextQuestion() {
        // 👇 YOUR CODE HERE
        return false; // placeholder — this makes the quiz end immediately! Fix it.
    }


    // =========================================================
    // ✏️  CHALLENGE 8 — advance() method
    // =========================================================
    // This method should move to the next question.
    // It's called after the player answers each question.
    //
    // 💡 Hint: Just add 1 to currentIndex. (Same idea as Challenge 3!)
    //
    // 🎮 AFTER CHALLENGE 8:
    //    The quiz now moves forward after every answer — "Question 1 / 8"
    //    becomes "Question 2 / 8" and so on until all 8 are done.
    //    Without this, Challenge 7 would loop on the same question forever!
    // =========================================================
    public void advance() {
        // 👇 YOUR CODE HERE
    }


    // =========================================================
    // ✏️  CHALLENGE 9 — ADD YOUR OWN QUESTIONS!
    // =========================================================
    // Scroll down to loadQuestions() and add at least 5 more
    // Bible trivia questions of your own.
    //
    // 💡 How to add a question:
    //    questions.add(new Question(
    //        "Your question here?",
    //        new String[]{"Option A", "Option B", "Option C", "Option D"},
    //        1    ← the INDEX of the correct answer (0=A, 1=B, 2=C, 3=D)
    //    ));
    //
    // 🎓 Notice we're using:
    //    • new Question(...)        → creating an OBJECT from the Question class
    //    • questions.add(...)       → adding to an ARRAYLIST
    //    • new String[]{...}        → creating an ARRAY inline
    //
    // 🎮 AFTER CHALLENGE 9:
    //    The quiz will now have MORE than 8 questions — the progress bar
    //    will show "Question 1 / 13" (or however many you added).
    //    You've built the whole game! 🎉
    // =========================================================


    // =========================================================
    // ✏️  BONUS CHALLENGE — shuffleQuestions() method
    // =========================================================
    // Want a harder challenge? Make the questions appear in a
    // RANDOM order every time the quiz starts!
    //
    // 💡 Hint: Look up Collections.shuffle() — you'll need to
    //          import java.util.Collections; at the top of the file.
    //          Call it inside the Quiz() constructor after loadQuestions().
    // =========================================================


    // --- These methods are already done — the GUI needs them! ---

    public Question getCurrentQuestion() {
        return questions.get(currentIndex);
    }

    public int getTotalQuestions() {
        return questions.size();
    }

    public int getCurrentQuestionNumber() {
        return currentIndex + 1;   // +1 because we show "Question 1" not "Question 0"
    }


    // -------------------------------------------------------
    // loadQuestions() — the question bank
    // Add your own questions in CHALLENGE 9 below!
    // -------------------------------------------------------
    private void loadQuestions() {

        questions.add(new Question(
            "How many days did God take to create the world?",
            new String[]{"5", "6", "7", "8"},
            1   // "6" is correct (God rested on the 7th)
        ));

        questions.add(new Question(
            "Who built the ark?",
            new String[]{"Moses", "Abraham", "Noah", "David"},
            2   // "Noah" is correct
        ));

        questions.add(new Question(
            "How many disciples did Jesus have?",
            new String[]{"10", "11", "12", "13"},
            2   // "12" is correct
        ));

        questions.add(new Question(
            "What did Jesus turn water into at the wedding at Cana?",
            new String[]{"Juice", "Milk", "Wine", "Honey"},
            2   // "Wine" is correct
        ));

        questions.add(new Question(
            "In what city was Jesus born?",
            new String[]{"Jerusalem", "Nazareth", "Bethlehem", "Jericho"},
            2   // "Bethlehem" is correct
        ));

        questions.add(new Question(
            "Who was swallowed by a big fish?",
            new String[]{"Elijah", "Jonah", "Paul", "Peter"},
            1   // "Jonah" is correct
        ));

        questions.add(new Question(
            "What is the first book of the Bible?",
            new String[]{"Exodus", "Psalms", "Genesis", "Matthew"},
            2   // "Genesis" is correct
        ));

        questions.add(new Question(
            "How many commandments did God give Moses?",
            new String[]{"5", "8", "10", "12"},
            2   // "10" is correct
        ));

        // 🔽 CHALLENGE 9 — ADD YOUR OWN QUESTIONS BELOW THIS LINE! 🔽

    }
}
