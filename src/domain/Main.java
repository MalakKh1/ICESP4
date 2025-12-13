import domain.Database;
import util.TextUI;

public static void main(String[] args) {
    // Initialize database
    Database.startDatabase();

    // Start the quiz UI
    TextUI ui = new TextUI();
    ui.run();
}