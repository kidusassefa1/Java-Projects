package Workbook_4.BigDecimalExercise;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        float f;
        double d;
        BigDecimal b = BigDecimal.ZERO;

        for(f = 0; f <= 1; f += 0.1f) {
            System.out.println(f);
        }
        System.out.println();
        for(d = 0; d <= 1; d += 0.1) {
            System.out.println(d);
        }
        System.out.println();
        for(int i = 0; i <= 10; i++) {
            b= b.add(new BigDecimal(0.1));
            System.out.println(b);
        }

        System.out.println("-----------------------");

        for(f = 0; f <= 1000; f += 19.99f) {
            System.out.println(f);
        }

        System.out.println();
        for(d = 0; d <= 1000; d += 19.99) {
            System.out.println(d);
        }

        System.out.println();
        for(int i = 0; i <= 1000; i++) {
            b= b.add(new BigDecimal(19.99));
            System.out.println(b);
        }
    }
}
