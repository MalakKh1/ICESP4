package domain;

// Represents a user of te quiz system
public class Player {

    private int id;// Unique user ID
    private int score;
    private String playername;     // Username

    // Constructor
    public Player(int id, int score, String playername) {
        this.id = id;
        this.score = score;
        this.playername = playername;
    }

    // Getters
    public int getId() {
        return id;
    }
    public int getScore() {
        return score;
    }

    public String getPlayername() {
        return playername;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setScore(int score) {
        this.score = score;
    }
    public void setPlayername(String playername) {
        this.playername= playername;
    }

    // Increment score by 1 (when answer is correct)
    public void incrementScore() {
        this.score++;
    }
}