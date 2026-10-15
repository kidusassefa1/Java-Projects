package methodPractice_page118;

public class CompareNumbers {
    public static void main(String[] args) {
        System.out.println(isEven(7));
        System.out.println(isEven(2));
        System.out.println(isEven(99));
        System.out.println(isPositive(-7));
        System.out.println(isPositive(-2));
        System.out.println(isPositive(-2.01));
    }

    static boolean isEven(int number) {
        if (number % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    static boolean isPositive(double number) {
        if (number > 0) {
            return true;
        } else {
            return false;
        }
    }
}
