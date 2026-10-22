package Workbook_2.Array_Exercise;

import java.util.Arrays;

public class TestStatistics {
    public static void main(String[] args) {

        // Test Scores (out of 100)
        int[] scores = {77, 91, 89, 81, 91, 85, 61, 97, 87, 93};

        System.out.println("####################################################################################");
        System.out.println("############################### SCHOOL QUARTER REPORT ##############################");
        System.out.println("####################################################################################");

        System.out.print("  ALL TEST SCORES:     ");
        for (int score : scores) {
            System.out.print(score + "    ");
        }

        Arrays.sort(scores);

        int total = 0;
        for (int i : scores) {
            total += i;
        }
        float avg = (float)total / scores.length;

        int highScore = scores[scores.length - 1];
        int lowScore = scores[0];


        System.out.printf("\n  HIGHEST TEST SCORE: %d\n" +
                            "  LOWEST TEST SCORE: %d", highScore, lowScore);
        System.out.printf("\n  AVERAGE TEST SCORE: %.2f", avg);
        System.out.print("\n####################################################################################");
        System.out.print("\n####################################################################################");
    }
}
