import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * ============================================================
 * 🚫 DON'T WORRY ABOUT THIS FILE!
 * ============================================================
 *
 * TriviaApp is the GUI (Graphical User Interface) — it's what
 * draws the buttons, labels, and screens you see on screen.
 *
 * It uses a library called Swing which is built into Java.
 * You do NOT need to understand how Swing works right now.
 *
 * ✅ WHAT YOU SHOULD NOTICE in this file:
 *    - We CREATE objects from YOUR classes:
 *        player = new Player(name);   ← uses your Player class!
 *        quiz   = new Quiz();         ← uses your Quiz class!
 *    - We CALL methods on those objects:
 *        quiz.hasNextQuestion()       ← your Challenge 7!
 *        quiz.getCurrentQuestion()    ← already done for you
 *        player.addPoint()            ← your Challenge 3!
 *        player.getRank()             ← your Challenge 6!
 *
 * That's OOP in action — this GUI file doesn't know HOW your
 * classes work internally. It just calls the methods and
 * trusts them to do their job. 🎓
 *
 * ============================================================
 * ⬇️  YOU DO NOT NEED TO EDIT ANYTHING BELOW THIS LINE  ⬇️
 * ============================================================
 */
public class TriviaApp {

    // Our OOP objects — created from YOUR classes!
    private Quiz quiz;
    private Player player;

    // Swing GUI pieces (don't worry about these)
    private JFrame frame;
    private JLabel questionLabel;
    private JLabel feedbackLabel;
    private JLabel scoreLabel;
    private JLabel progressLabel;
    private JButton[] answerButtons;

    // Colors (feel free to change these if you want!)
    private static final Color BG_COLOR      = Color.decode("#1a1a2e");
    private static final Color CARD_COLOR    = Color.decode("#16213e");
    private static final Color BUTTON_COLOR  = Color.decode("#0f3460");
    private static final Color CORRECT_COLOR = Color.decode("#27ae60");
    private static final Color WRONG_COLOR   = Color.decode("#c0392b");
    private static final Color GOLD_COLOR    = Color.decode("#f0c040");
    private static final Color GREY_COLOR    = Color.decode("#aaaaaa");

    // ---- Constructor — sets up the main window ----
    public TriviaApp() {
        frame = new JFrame("✝️ Bible Trivia Challenge");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 460);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        showNameScreen();
        frame.setVisible(true);
    }

    // ---- SCREEN 1: Enter your name ----
    private void showNameScreen() {
        JPanel root = new JPanel();
        root.setLayout(new BoxLayout(root, BoxLayout.Y_AXIS));
        root.setBackground(BG_COLOR);
        root.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

        JLabel title    = makeLabel("✝️ Bible Trivia", 36, GOLD_COLOR, true);
        JLabel subtitle = makeLabel("Test your knowledge of Scripture!", 16, GREY_COLOR, false);
        JLabel prompt   = makeLabel("Enter your name to begin:", 14, Color.WHITE, false);

        JTextField nameField = new JTextField();
        nameField.setMaximumSize(new Dimension(250, 36));
        nameField.setPreferredSize(new Dimension(250, 36));
        nameField.setAlignmentX(Component.CENTER_ALIGNMENT);
        nameField.setFont(new Font("Arial", Font.PLAIN, 14));
        nameField.setBackground(Color.decode("#2c2c54"));
        nameField.setForeground(Color.WHITE);
        nameField.setCaretColor(Color.WHITE);
        nameField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.decode("#4444aa"), 1),
            BorderFactory.createEmptyBorder(4, 8, 4, 8)
        ));

        JButton startBtn = makeButton("Start Quiz →", CORRECT_COLOR);

        ActionListener startAction = e -> {
            String name = nameField.getText().trim();
            if (name.isEmpty()) name = "Player";

            // 🎓 HERE is where we use YOUR classes!
            player = new Player(name);   // creates a Player object (your class!)
            quiz   = new Quiz();         // creates a Quiz object   (your class!)
            showQuizScreen();
        };

        startBtn.addActionListener(startAction);
        nameField.addActionListener(startAction);   // pressing Enter also starts

        addCentered(root, title);
        addCentered(root, subtitle);
        root.add(Box.createVerticalStrut(10));
        addCentered(root, prompt);
        root.add(Box.createVerticalStrut(6));
        addCentered(root, nameField);
        root.add(Box.createVerticalStrut(14));
        addCentered(root, startBtn);

        frame.setContentPane(root);
        frame.revalidate();
        frame.repaint();
    }

    // ---- SCREEN 2: The main quiz screen ----
    private void showQuizScreen() {
        JPanel root = new JPanel();
        root.setLayout(new BoxLayout(root, BoxLayout.Y_AXIS));
        root.setBackground(BG_COLOR);
        root.setBorder(BorderFactory.createEmptyBorder(24, 30, 24, 30));

        // Top bar: progress + score
        JPanel topBar = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        topBar.setOpaque(false);
        topBar.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        progressLabel = makeLabel("Question 1 / 8", 13, GREY_COLOR, false);
        scoreLabel    = makeLabel("Score: 0", 13, GOLD_COLOR, true);
        topBar.add(progressLabel);
        topBar.add(scoreLabel);

        // Card panel for the question
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(CARD_COLOR);
        card.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        card.setAlignmentX(Component.CENTER_ALIGNMENT);
        card.setMaximumSize(new Dimension(500, Integer.MAX_VALUE));

        questionLabel = makeLabel("Loading...", 18, Color.WHITE, true);
        questionLabel.setMaximumSize(new Dimension(460, Integer.MAX_VALUE));
        questionLabel.setPreferredSize(new Dimension(460, 60));
        card.add(questionLabel);

        // Answer buttons
        JPanel buttonBox = new JPanel();
        buttonBox.setLayout(new BoxLayout(buttonBox, BoxLayout.Y_AXIS));
        buttonBox.setOpaque(false);
        buttonBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonBox.setMaximumSize(new Dimension(500, Integer.MAX_VALUE));

        answerButtons = new JButton[4];
        for (int i = 0; i < 4; i++) {
            final int index = i;
            answerButtons[i] = makeButton("", BUTTON_COLOR);
            answerButtons[i].setMaximumSize(new Dimension(460, 44));
            answerButtons[i].setPreferredSize(new Dimension(460, 44));
            answerButtons[i].addActionListener(e -> handleAnswer(index));
            buttonBox.add(answerButtons[i]);
            buttonBox.add(Box.createVerticalStrut(8));
        }

        feedbackLabel = makeLabel(" ", 15, Color.WHITE, true);

        root.add(topBar);
        root.add(Box.createVerticalStrut(12));
        addCentered(root, card);
        root.add(Box.createVerticalStrut(12));
        addCentered(root, buttonBox);
        root.add(Box.createVerticalStrut(8));
        addCentered(root, feedbackLabel);

        frame.setContentPane(root);
        frame.revalidate();
        frame.repaint();

        loadCurrentQuestion();
    }

    // ---- Load the current question into the labels/buttons ----
    private void loadCurrentQuestion() {
        // 🎓 Calling YOUR method: quiz.hasNextQuestion()
        if (!quiz.hasNextQuestion()) {
            showResultsScreen();
            return;
        }

        // 🎓 Calling YOUR method: quiz.getCurrentQuestion()
        //    This returns a Question OBJECT — then we call methods on it!
        Question q = quiz.getCurrentQuestion();

        progressLabel.setText("Question " + quiz.getCurrentQuestionNumber()
                              + " / " + quiz.getTotalQuestions());
        scoreLabel.setText("Score: " + player.getScore());
        questionLabel.setText("<html><div style='width:440px'>" + q.getQuestionText() + "</div></html>");
        feedbackLabel.setText(" ");

        // 🎓 A LOOP! We loop through all 4 buttons and set their text.
        for (int i = 0; i < 4; i++) {
            answerButtons[i].setText(q.getAnswer(i));
            answerButtons[i].setEnabled(true);
            answerButtons[i].setBackground(BUTTON_COLOR);
        }
    }

    // ---- Called when the player clicks an answer button ----
    private void handleAnswer(int selectedIndex) {
        Question q = quiz.getCurrentQuestion();

        // Disable all buttons so the player can't click again
        for (JButton btn : answerButtons) btn.setEnabled(false);

        // 🎓 Calling YOUR method: player.incrementQuestionsAnswered()
        player.incrementQuestionsAnswered();

        // 🎓 Calling YOUR method: q.isCorrect(selectedIndex)
        if (q.isCorrect(selectedIndex)) {
            // 🎓 Calling YOUR method: player.addPoint()
            player.addPoint();
            answerButtons[selectedIndex].setBackground(CORRECT_COLOR);
            feedbackLabel.setText("✅ Correct! Great job, " + player.getName() + "!");
            feedbackLabel.setForeground(CORRECT_COLOR);
        } else {
            answerButtons[selectedIndex].setBackground(WRONG_COLOR);
            // 🎓 Calling YOUR method: q.getCorrectAnswer()
            feedbackLabel.setText("❌ Not quite! The answer was: " + q.getCorrectAnswer());
            feedbackLabel.setForeground(WRONG_COLOR);
        }

        // Wait 1.5 seconds, then move to next question (Swing Timer — don't worry about this)
        Timer timer = new Timer(1500, e -> {
            // 🎓 Calling YOUR method: quiz.advance()
            quiz.advance();
            loadCurrentQuestion();
        });
        timer.setRepeats(false);
        timer.start();
    }

    // ---- SCREEN 3: Results screen at the end ----
    private void showResultsScreen() {
        JPanel root = new JPanel();
        root.setLayout(new BoxLayout(root, BoxLayout.Y_AXIS));
        root.setBackground(BG_COLOR);
        root.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

        JLabel title   = makeLabel("Quiz Complete! 🎉", 32, GOLD_COLOR, true);
        JLabel name    = makeLabel(player.getName(), 22, Color.WHITE, true);
        JLabel score   = makeLabel(
            player.getScore() + " / " + player.getQuestionsAnswered() + " correct",
            20, Color.WHITE, false
        );
        // 🎓 Calling YOUR methods: getScorePercent() and getRank()
        JLabel percent = makeLabel(player.getScorePercent() + "%", 48, GOLD_COLOR, true);
        JLabel rank    = makeLabel(player.getRank(), 22, CORRECT_COLOR, true);

        JButton playAgain = makeButton("Play Again", BUTTON_COLOR);
        playAgain.addActionListener(e -> showNameScreen());

        addCentered(root, title);
        root.add(Box.createVerticalStrut(10));
        addCentered(root, name);
        addCentered(root, score);
        root.add(Box.createVerticalStrut(6));
        addCentered(root, percent);
        addCentered(root, rank);
        root.add(Box.createVerticalStrut(16));
        addCentered(root, playAgain);

        frame.setContentPane(root);
        frame.revalidate();
        frame.repaint();
    }

    // ---- Helper: make a styled label ----
    private JLabel makeLabel(String text, int size, Color color, boolean bold) {
        JLabel label = new JLabel(text);
        int style = bold ? Font.BOLD : Font.PLAIN;
        label.setFont(new Font("Arial", style, size));
        label.setForeground(color);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        return label;
    }

    // ---- Helper: make a styled button ----
    private JButton makeButton(String text, Color bgColor) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Arial", Font.PLAIN, 14));
        btn.setBackground(bgColor);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setOpaque(true);
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn.setMinimumSize(new Dimension(200, 40));
        btn.setPreferredSize(new Dimension(200, 40));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return btn;
    }

    // ---- Helper: add a component centered on a BoxLayout panel ----
    private void addCentered(JPanel panel, JComponent comp) {
        comp.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(comp);
    }

    // ---- Main method — Java starts here ----
    public static void main(String[] args) {
        // Run on the Event Dispatch Thread (good Swing practice — don't worry about this)
        SwingUtilities.invokeLater(() -> new TriviaApp());
    }
}
