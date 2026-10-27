package Workbook_3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BedtimeStories {
    static Scanner scanner = new Scanner(System.in);
    static BufferedReader bufReader;
    public static void main(String[] args) {
        try {
            boolean exit = false;
            do{
                String [] story = displayMenu();
                int lineNumber = 0;
                bufReader = new BufferedReader(new FileReader(story[1]));
                String input;
                System.out.printf("\n%s\n\n", story[0]);
                while((input = bufReader.readLine()) != null) {
                    System.out.println(++lineNumber + ". " + input);
                }
                bufReader.close();

                System.out.print("\nWould you want to read another story (Yes/No)?: ");
                String choice = scanner.nextLine();

                if (choice.equalsIgnoreCase("no")) {
                    exit = true;
                    System.out.println("Exiting ...");
                }
            } while (!exit);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static String[] displayMenu() {
        String[] story = new String[2];

        int choice;
        System.out.println("\nI have the following stories. Which one would you want me to read?");
        while (true) {
            try {
                System.out.print("""
                        
                        1. Mary had a little lamb
                        2. Hansel and Gretel
                        3. Goldilocks
                        Choose 1, 2 or 3 :\s""");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        story[0] = "Mary had a little lamb";
                        story[1] = "mary_had_a_little_lamb.txt";
                        return story;
                    case 2:
                        story[0] = "Hansel and Gretel";
                        story[1] = "hansel_and_gretel.txt";
                        return story;
                    case 3:
                        story[0] = "Goldilocks";
                        story[1] = "goldilocks.txt";
                        return story;
                    default:
                        System.out.println("Please enter numbers only from the list above ... try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid. Enter either 1, 2 or 3 ...");
                scanner.nextLine();
            }
        }
    }
}
