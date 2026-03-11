# ✝️ Bible Trivia Challenge — Student Package

## Your challenges

Complete each challenge in order. After each one, run the tests to check your work,
then launch the game to see what changed!

---

## 🗺️ Roadmap — what unlocks after each challenge

| Challenge | File | Method | What you'll see in the game |
|-----------|------|--------|-----------------------------|
| **1** | `Question.java` | `isCorrect()` | Correct answers turn **green** ✅ |
| **2** | `Question.java` | `getCorrectAnswer()` | Wrong feedback shows the real answer |
| **3** | `Player.java` | `addPoint()` | Score counter goes **up** as you play |
| **4** | `Player.java` | `incrementQuestionsAnswered()` | Sets up the results screen |
| **5** | `Player.java` | `getScorePercent()` | Results screen shows your **real %** |
| **6** | `Player.java` | `getRank()` | Results screen shows your **rank** 🏆 |
| **7** | `Quiz.java` | `hasNextQuestion()` | 🎮 **THE GAME WORKS** — all 8 questions appear! |
| **8** | `Quiz.java` | `advance()` | Quiz moves forward after each answer |
| **9** | `Quiz.java` | `loadQuestions()` | Your own questions appear in the quiz! |

> **⚠️ Right now:** the game opens and jumps straight to results — that's because
> `hasNextQuestion()` always returns `false`. Challenge 7 fixes this!

---

## Running the tests

Open any test file in VS Code and click the **▶️ Run Test** button above a method,
or click **Run All Tests** at the top of the file.

- 🟢 Green = passing
- 🔴 Red = failing — read the message to see what went wrong

### Test files and what they cover

| Test file | Challenges covered | # of tests |
|-----------|--------------------|------------|
| `QuestionTest.java` | 1, 2 | 10 |
| `PlayerTest.java` | 3, 4, 5, 6 | 20 |
| `QuizTest.java` | 7, 8, 9 | 14 |

---

## Running the game

Run `TriviaApp.java` — it has the `main` method.

In VS Code: right-click `TriviaApp.java` → **Run Java**

---

## Files in this project

| File | Touch it? | What it is |
|------|-----------|------------|
| `Question.java` | ✏️ **Yes** | Challenges 1 & 2 |
| `Player.java` | ✏️ **Yes** | Challenges 3–6 |
| `Quiz.java` | ✏️ **Yes** | Challenges 7–9 |
| `TriviaApp.java` | 🚫 No | The GUI — already complete |
| `QuestionTest.java` | 🚫 No | Tests for C1 & C2 |
| `PlayerTest.java` | 🚫 No | Tests for C3–C6 |
| `QuizTest.java` | 🚫 No | Tests for C7–C9 |
