package domain;

public class Quiz {
    private Player player;
    private int currentQuestionId;
    private int totalQuestions;

    public Quiz(Player player) {
        this.player = player;
        this.currentQuestionId = 1; // Start fra domain.Question ID 1
        this.totalQuestions = Database.getTotalQuestions();
    }

    // Loader næste spg
    public Question loadNextQuestion() {
        if (currentQuestionId > totalQuestions) {
            return null; // stopper med returner spg
        }

        Question question = Database.getQuestionById(currentQuestionId);
        currentQuestionId++; // Videre til næste spg ID
        return question;
    }

    // Check om bruger svare rigtigt og dernæst opdater score
    public boolean checkAnswer(int userAnswer, Question question) {
        boolean correct = (userAnswer == question.getCorrectAnswer());

        if (correct) {
            player.incrementScore();
        }

        return correct;
    }

    // Checker om alle spg er svaret
    public boolean isQuizComplete() {
        return currentQuestionId > totalQuestions;
    }

    // Get the player object?
    public Player getPlayer() {
        return player;
    }
}