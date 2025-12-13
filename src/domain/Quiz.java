package domain;

// Manages quiz logic and question flow
public class Quiz {
    private Player player;
    private int currentQuestionId;
    private int totalQuestions;

    public Quiz(Player player) {
        this.player = player;
        this.currentQuestionId = 1; // Start from question ID 1
        this.totalQuestions = Database.getTotalQuestions();
    }

    // Load the next question from database
    public Question loadNextQuestion() {
        if (currentQuestionId > totalQuestions) {
            return null; // No more questions
        }

        Question question = Database.getQuestionById(currentQuestionId);
        currentQuestionId++; // Move to next question ID
        return question;
    }

    // Check if the user's answer is correct and update score
    public boolean checkAnswer(int userAnswer, Question question) {
        boolean correct = (userAnswer == question.getCorrectAnswer());

        if (correct) {
            player.incrementScore();
        }

        return correct;
    }

    // Check if all questions have been answered
    public boolean isQuizComplete() {
        return currentQuestionId > totalQuestions;
    }

    // Get the player object
    public Player getPlayer() {
        return player;
    }
}