import domain.Database;
import util.TextUI;

    public static void main(String[] args) {
        Database.startDatabase();

        TextUI ui = new TextUI();
        ui.run();
    }
