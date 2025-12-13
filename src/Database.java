import java.sql.*;

// Manages all database operations (create, insert, read)
public class Database {
    // Database file location
    private static final String DB_URL = "jdbc:sqlite:java_quiz.db";

    // Initialize database: create table and insert sample questions if needed
    public static void startDatabase() {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {

            // Create questions table if it doesn't exist
            String createTableSQL = """
                CREATE TABLE IF NOT EXISTS questions (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    question TEXT NOT NULL,
                    option1 TEXT NOT NULL,
                    option2 TEXT NOT NULL,
                    option3 TEXT NOT NULL,
                    option4 TEXT NOT NULL,
                    correct_answer INTEGER NOT NULL,
                    category TEXT,
                    explanation TEXT
                )
                """;
            stmt.execute(createTableSQL);

            // Check if table is empty
            String countSQL = "SELECT COUNT(*) FROM questions";
            ResultSet rs = stmt.executeQuery(countSQL);
            if (rs.next() && rs.getInt(1) == 0) {
                // If empty, insert sample questions
                insertSampleQuestions(conn);
            }

        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }

    // Insert 10 sample questions into the database
    private static void insertSampleQuestions(Connection conn) throws SQLException {
        // SQL command with placeholders (?) for values
        String insertSQL = """
            INSERT INTO questions (question, option1, option2, option3, option4, correct_answer, category, explanation)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?)
            """;

        try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            // Question 1: Variables + Datatypes
            pstmt.setString(1, "Hvilken datatype bruges til heltal i Java?");
            pstmt.setString(2, "int");
            pstmt.setString(3, "double");
            pstmt.setString(4, "float");
            pstmt.setString(5, "char");
            pstmt.setInt(6, 1);
            pstmt.setString(7, "Variables + Datatypes");
            pstmt.setString(8, "int gemmer heltal, f.eks. int alder = 25;");
            pstmt.executeUpdate();

            // Question 2: Loops + Conditions
            pstmt.setString(1, "Hvilken loop bruges når man ikke ved hvor mange gange koden skal køre?");
            pstmt.setString(2, "for");
            pstmt.setString(3, "while");
            pstmt.setString(4, "if");
            pstmt.setString(5, "switch");
            pstmt.setInt(6, 2);
            pstmt.setString(7, "Loops + Conditions");
            pstmt.setString(8, "while kører så længe en betingelse er sand, f.eks. while(x < 10)");
            pstmt.executeUpdate();

            // Question 3: Functions + Objects
            pstmt.setString(1, "Hvad kaldes en funktion der tilhører en klasse?");
            pstmt.setString(2, "Variabel");
            pstmt.setString(3, "Metode");
            pstmt.setString(4, "Constructor");
            pstmt.setString(5, "Parameter");
            pstmt.setInt(6, 2);
            pstmt.setString(7, "Functions + Objects");
            pstmt.setString(8, "Funktioner inde i klasser kaldes metoder, f.eks. public void greet() { }");
            pstmt.executeUpdate();

            // Question 4: Arrays
            pstmt.setString(1, "Hvordan opretter man et array med 5 heltal?");
            pstmt.setString(2, "int[] arr = new int[5]");
            pstmt.setString(3, "int arr = 5");
            pstmt.setString(4, "array[5] arr");
            pstmt.setString(5, "int[5] arr");
            pstmt.setInt(6, 1);
            pstmt.setString(7, "Arrays");
            pstmt.setString(8, "int[] arr = new int[5] opretter et array med plads til 5 heltal");
            pstmt.executeUpdate();

            // Question 5: Filer + Composition
            pstmt.setString(1, "Hvordan læser du en fil i Java?");
            pstmt.setString(2, "Med File og Scanner");
            pstmt.setString(3, "Med System.out.println");
            pstmt.setString(4, "Med int og String");
            pstmt.setString(5, "Med if og else");
            pstmt.setInt(6, 1);
            pstmt.setString(7, "Filer + Composition");
            pstmt.setString(8, "File klassen bruges til at pege på filen og Scanner til at læse indholdet");
            pstmt.executeUpdate();

            // Question 6: array[] + ArrayList
            pstmt.setString(1, "Hvad er forskellen på array og ArrayList?");
            pstmt.setString(2, "Ingen forskel");
            pstmt.setString(3, "Array har fast størrelse, ArrayList kan ændres");
            pstmt.setString(4, "ArrayList har fast størrelse, array kan ændres");
            pstmt.setString(5, "Begge er det samme");
            pstmt.setInt(6, 2);
            pstmt.setString(7, "array[] + ArrayList");
            pstmt.setString(8, "Array har fast størrelse (int[] nums = new int[5]), ArrayList kan vokse dynamisk");
            pstmt.executeUpdate();

            // Question 7: CLI, Java klassen, Scanner
            pstmt.setString(1, "Hvad gør Scanner klassen?");
            pstmt.setString(2, "Printer til konsollen");
            pstmt.setString(3, "Læser input fra brugeren");
            pstmt.setString(4, "Gemmer filer");
            pstmt.setString(5, "Laver loops");
            pstmt.setInt(6, 2);
            pstmt.setString(7, "CLI, Java klassen, Scanner");
            pstmt.setString(8, "Scanner læser brugerinput: Scanner scan = new Scanner(System.in);");
            pstmt.executeUpdate();

            // Question 8: Nedarvning + Interfaces
            pstmt.setString(1, "Hvad betyder \"extends\" i Java?");
            pstmt.setString(2, "At nedarve fra en klasse");
            pstmt.setString(3, "At lave en variabel");
            pstmt.setString(4, "At lave et loop");
            pstmt.setString(5, "At printe noget");
            pstmt.setInt(6, 1);
            pstmt.setString(7, "Nedarvning + Interfaces");
            pstmt.setString(8, "extends bruges til nedarvning: class Hund extends Dyr arver fra Dyr-klassen");
            pstmt.executeUpdate();

            // Question 9: Datastrukturer
            pstmt.setString(1, "Hvilken datastruktur bruges til at gemme nøgle-værdi par?");
            pstmt.setString(2, "ArrayList");
            pstmt.setString(3, "Array");
            pstmt.setString(4, "HashMap");
            pstmt.setString(5, "String");
            pstmt.setInt(6, 3);
            pstmt.setString(7, "Datastrukturer");
            pstmt.setString(8, "HashMap gemmer data som nøgle-værdi par: map.put(\"navn\", \"Anna\")");
            pstmt.executeUpdate();

            // Question 10: Databaser
            pstmt.setString(1, "Hvilket SQL-kommando bruges til at hente data fra en database?");
            pstmt.setString(2, "INSERT");
            pstmt.setString(3, "UPDATE");
            pstmt.setString(4, "SELECT");
            pstmt.setString(5, "DELETE");
            pstmt.setInt(6, 3);
            pstmt.setString(7, "Databaser");
            pstmt.setString(8, "SELECT henter data (f.eks. SELECT * FROM students). INSERT tilføjer data");
            pstmt.executeUpdate();

            System.out.println("Questions inserted successfully!");
        }
    }

    // Retrieve ONE question by ID from database
    public static Question getQuestionById(int id) {
        String selectSQL = "SELECT * FROM questions WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            // If question found, create and return Question object
            if (rs.next()) {
                String[] options = {
                        rs.getString("option1"),
                        rs.getString("option2"),
                        rs.getString("option3"),
                        rs.getString("option4")
                };

                return new Question(
                        rs.getInt("id"),
                        rs.getString("question"),
                        options,
                        rs.getInt("correct_answer"),
                        rs.getString("category"),
                        rs.getString("explanation")
                );
            }

        } catch (SQLException e) {
            System.err.println("Error loading question: " + e.getMessage());
        }

        return null; // Return null if question not found
    }

    // Get total number of questions in database
    public static int getTotalQuestions() {
        String countSQL = "SELECT COUNT(*) FROM questions";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(countSQL)) {

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            System.err.println("Error counting questions: " + e.getMessage());
        }

        return 0;
    }
}