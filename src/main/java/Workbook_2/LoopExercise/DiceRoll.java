package Workbook_2.LoopExercise;

public class DiceRoll {
    public static void main(String[] args) {
        Dice dice = new Dice();

        int twoCounter = 0;
        int fourCounter = 0;
        int sixCounter = 0;
        int sevenCounter = 0;

        for (int i = 1; i <= 100; i++) {
            int roll1 = dice.roll();
            int roll2 = dice.roll();

            int sum = roll1 + roll2;

            System.out.printf("Roll %3d:   %d   ----   %d  |  Sum: %d\n", i, roll1, roll2, sum);

            if (sum == 2){
                twoCounter++;
            } else if (sum == 4){
                fourCounter++;
            } else if (sum == 6){
                sixCounter++;
            } else if (sum == 7){
                sevenCounter++;
            }
        }

        System.out.printf("""
                
                Counter for two: %d
                Counter for four: %d
                Counter for six: %d
                Counter for seven: %d
                """, twoCounter, fourCounter, sixCounter, sevenCounter);
    }
}
