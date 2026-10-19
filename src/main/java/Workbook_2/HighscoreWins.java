package Workbook_2;

import java.util.Scanner;
import java.util.regex.Pattern;

public class HighscoreWins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("What is the score of the game? ");
        System.out.println("Please input using the following format:");
        System.out.print("Home:Visitor|Score:Score (For example Spurs:Knicks|106:107): ");
        String[] parts = scanner.nextLine().split("[|:]");

        String homeTeam = parts[0];
        String visitorTeam = parts[1];
        int homeScore = Integer.parseInt(parts[2]);
        int visitorScore = Integer.parseInt(parts[3]);

        if (homeScore > visitorScore) {
            System.out.printf("Winner: %s", homeTeam);
        } else if (homeScore < visitorScore) {
            System.out.printf("Winner: %s", visitorTeam);
        } else {
            System.out.println("It's a TIE!");

        }
    }
}
