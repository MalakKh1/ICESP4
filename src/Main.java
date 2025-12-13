import util.*;

public class Main {
    public static void main(String[] args) {
        Database.startDatabase();

        TextUI ui = new TextUI();
        ui.run();
    }
}
