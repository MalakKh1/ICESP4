package domain;

// Repræsenter quiz med multiple choice spg
public class Question {
    private int id;
    private String question;
    private String[] options;
    private int correctAnswer;
    private String category;
    private String explanation;

    // Constructor mede ALLE fields
    public Question(int id, String question, String[] options, int correctAnswer, String category, String explanation) {
        this.id = id;
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
        this.category = category;
        this.explanation = explanation;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public String getCategory() {
        return category;
    }

    public String getExplanation() {
        return explanation;
    }

}
