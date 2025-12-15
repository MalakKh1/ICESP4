package util;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class HighscoreManager {
    private static final String HIGHSCORE_FILE = "highscores.txt";
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    public static void saveScore(String playerName, int score, int totalQuestions) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(HIGHSCORE_FILE, true))) {
            String timestamp = LocalDateTime.now().format(DATE_FORMAT);
            double percentage = (double) score / totalQuestions * 100;

            writer.write(String.format("%s|%d|%d|%.1f|%s%n",
                    playerName, score, totalQuestions, percentage, timestamp));

            System.out.println("✓ Score gemt i highscores.txt");

        } catch (IOException e) {
            System.err.println("Fejl ved gemning af score: " + e.getMessage());
        }
    }

    public static List<HighscoreEntry> getHighscores() {
        List<HighscoreEntry> highscores = new ArrayList<>();
        File file = new File(HIGHSCORE_FILE);

        if (!file.exists()) {
            return highscores;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(HIGHSCORE_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 5) {
                    highscores.add(new HighscoreEntry(
                            parts[0],
                            Integer.parseInt(parts[1]),
                            Integer.parseInt(parts[2]),
                            Double.parseDouble(parts[3]),
                            parts[4]
                    ));
                }
            }
        } catch (IOException e) {
            System.err.println("Fejl ved læsning af highscores: " + e.getMessage());
        }

        highscores.sort((a, b) -> {
            int scoreCompare = Integer.compare(b.score, a.score);
            if (scoreCompare != 0) return scoreCompare;
            return b.date.compareTo(a.date);
        });

        return highscores;
    }

    public static void displayHighscores() {
        List<HighscoreEntry> highscores = getHighscores();

        if (highscores.isEmpty()) {
            System.out.println("\n Ingen highscores endnu. Du er den første!");
            return;
        }

        System.out.println("\n╔════════════════════ HIGHSCORE ═══════════════════════╗");
        System.out.println("║ Rank │ Navn              │ Score  │ Procent │ Dato     ║");
        System.out.println("╠══════╪═══════════════════╪════════╪═════════╪══════════╣");

        int rank = 1;
        int maxDisplay = Math.min(10, highscores.size());

        for (int i = 0; i < maxDisplay; i++) {
            HighscoreEntry entry = highscores.get(i);
            System.out.printf("║ %-4d / %-17s │ %2d/%-2d procent │ %6.1f%% │ %-8s ║%n",
                    rank++,
                    truncate(entry.playerName, 17),
                    entry.score,
                    entry.totalQuestions,
                    entry.percentage,
                    entry.date.substring(0, 8)
            );
        }

        System.out.println("╚══════════════════════════════════════════════════════╝");
        System.out.println("\n💡 Alle scores er gemt i filen: highscores.txt");
    }

    private static String truncate(String str, int maxLength) {
        if (str.length() <= maxLength) {
            return str;
        }
        return str.substring(0, maxLength - 3) + "...";
    }

    public static class HighscoreEntry {
        public final String playerName;
        public final int score;
        public final int totalQuestions;
        public final double percentage;
        public final String date;

        public HighscoreEntry(String playerName, int score, int totalQuestions,
                              double percentage, String date) {
            this.playerName = playerName;
            this.score = score;
            this.totalQuestions = totalQuestions;
            this.percentage = percentage;
            this.date = date;
        }
    }
}
