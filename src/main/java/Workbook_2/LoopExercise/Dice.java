package Workbook_2.LoopExercise;

public class Dice {

    public int roll() {
        int minValue = 1;
        int maxValue = 6;

        return (int)(Math.random() * (maxValue - minValue + 1)) + minValue;
    }
}
