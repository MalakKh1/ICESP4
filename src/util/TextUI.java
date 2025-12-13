package util;
import domain.*;

import java.util.Scanner;

// Handles all user interaction and console communication
public class TextUI {
    private Scanner scanner;
    private Quiz quiz;

    public TextUI() {
        this.scanner = new Scanner(System.in);
    }

    // Main method to run the quiz application
    public void run() {
        welcomeMsg();

        // Get player name
        String playerName = getPlayerName();
        Player player = new Player(1, 0, playerName);

        // Create quiz and start
        quiz = new Quiz(player);
        playQuiz();

        // Show final results
        displayFinalScore();

        scanner.close();
    }

    private void welcomeMsg() {
        System.out.println("Velkommen til Java Quiz Spillet!   \n");
    }

    private String getPlayerName() {
        System.out.print("Indtast dit navn: ");
        return scanner.nextLine().trim();
    }

    private void playQuiz() {
        System.out.println("\nLad os starte quizzen!");
        System.out.println("───────────────────────────────────────\n");

        // Loop through all questions
        while (!quiz.isQuizComplete()) {
            Question question = quiz.loadNextQuestion();

            if (question == null) {
                System.out.println("Fejl: Kunne ikke indlæse spørgsmål.");
                break;
            }

            // Display question and options
            displayQuestion(question);

            // Get user's answer
            int userAnswer = getUserAnswer();

            // Check if answer is correct
            boolean correct = quiz.checkAnswer(userAnswer, question);

            // Display result
            displayResult(correct, question);

            System.out.println();
        }
    }

    private void displayQuestion(Question question) {
        System.out.println("Kategori: " + question.getCategory());
        System.out.println("Spørgsmål " + question.getId() + ": " + question.getQuestion());
        System.out.println();

        String[] options = question.getOptions();
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        System.out.println();
    }

    private int getUserAnswer() {
        int answer = -1;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Dit svar (1-4): ");

            if (scanner.hasNextInt()) {
                answer = scanner.nextInt();
                scanner.nextLine(); // Clear buffer

                if (answer >= 1 && answer <= 4) {
                    validInput = true;
                } else {
                    System.out.println("Ugyldig input. Vælg et tal mellem 1 og 4.");
                }
            } else {
                System.out.println("Ugyldig input. Indtast et tal.");
                scanner.nextLine(); // Clear invalid input
            }
        }

        return answer;
    }

    private void displayResult(boolean correct, Question question) {
        if (correct) {
            System.out.println("Rigtigt! Godt klaret!");
        } else {
            System.out.println("Forkert!");
            System.out.println("Det rigtige svar var: " + question.getOptions()[question.getCorrectAnswer() - 1]);
        }

        System.out.println("Forklaring: " + question.getExplanation());
    }

    private void displayFinalScore() {
        Player player = quiz.getPlayer();
        int totalQuestions = Database.getTotalQuestions();

        System.out.println("\n═══════════════════════════════════════");
        System.out.println("         QUIZ AFSLUTTET!              ");
        System.out.println("═══════════════════════════════════════");
        System.out.println("Spiller: " + player.getPlayername() + ", scorede: "+ player.getScore() + "/" + totalQuestions + " point i alt!");
        //System.out.println("Score: " + player.getScore() + "/" + totalQuestions);

        /*double percentage = (double) player.getScore() / totalQuestions * 100;
        System.out.printf("Procent: %.1f%%\n", percentage);*/

        int score = player.getScore();
        // Give feedback based on score
        if (score == 10) {
            System.out.println("\nFantastisk! Du er en Java vogter!");
        } else if (score >= 8) {
            System.out.println("\nGodt klaret! Du har styr på det!");
        } else if (score >= 5) {
            System.out.println("\nMid besvarelse! Øv lidt mere!");
        } else {
            System.out.println("\nHvornår var du sidst til undervisningen? Lol");
        }

    }

}