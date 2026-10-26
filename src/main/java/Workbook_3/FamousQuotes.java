package Workbook_3;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class FamousQuotes {
    static String[] quotes = new String[10];
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        addQuotes();
        homeScreen();
    }

    public static void homeScreen() {
        int choice = 0;
            System.out.println("\nWelcome to Quotes Glossary!");
            do {
                try {
                    System.out.print("""
                            
                            1. Display Famous Quotes
                            2. Exit
                            Choose 1 or 2:\s""");
                    choice = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice) {
                        case 1 -> displayQuotes();
                        case 2 -> System.out.println("Thank you, good bye!");
                        default -> System.out.println("Invalid choice! Please enter 1-2.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid. Please choose either 1 or 2.");
                    scanner.nextLine();
                }
            } while (choice != 2);
    }

    public static void displayQuotes() {
        int choice;

        try {
                System.out.print("""
                            Choose a quote by selecting an author:
                        
                            1. Franklin D. Roosevelt
                            2. René Descartes
                            3. William Shakespeare
                            4. Lao Tzu
                            5. Francis Bacon
                            6. Albert Einstein
                            7. Friedrich Nietzsche
                            8. Steve Jobs
                            9. Martin Luther King Jr.
                            10. Socrates
                        
                            0. Random Quote
                        
                            Enter your choice:\s""");
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice == 0) {
                    int randomNumber = random.nextInt(10); // Generates 0–9
                    System.out.println(quotes[randomNumber]);
                } else {
                    System.out.println(quotes[choice - 1]);
                }
        } catch (InputMismatchException e) {
            System.out.println("Invalid. Please choose a number and not a string.");
            scanner.nextLine();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid! Pleaes choose a number between 0 to 10.");
        }
    }

    public static void addQuotes() {
        quotes[0] = "The only thing we have to fear is fear itself. - Franklin D. Roosevelt\nMeaning: Fear can hold us back more than the actual problem.";
        quotes[1] = "I think, therefore I am. - René Descartes\nMeaning: Our ability to think proves our existence.";
        quotes[2] = "To be, or not to be, that is the question. - William Shakespeare\nMeaning: Questioning whether life is worth living.";
        quotes[3] = "The journey of a thousand miles begins with a single step. - Lao Tzu\nMeaning: Every big achievement starts with a small action.";
        quotes[4] = "Knowledge is power. - Francis Bacon\nMeaning: Learning gives us the ability to make better decisions.";
        quotes[5] = "In the middle of difficulty lies opportunity. - Albert Einstein\nMeaning: Challenges can lead to growth and new possibilities.";
        quotes[6] = "That which does not kill us makes us stronger. - Friedrich Nietzsche\nMeaning: Overcoming hardships can make us more resilient.";
        quotes[7] = "Stay hungry, stay foolish. - Steve Jobs\nMeaning: Keep learning, stay curious, and take risks.";
        quotes[8] = "I have a dream. - Martin Luther King Jr.\nMeaning: A vision of equality, freedom, and justice for everyone.";
        quotes[9] = "The unexamined life is not worth living. - Socrates\nMeaning: A meaningful life requires self-reflection and questioning.";

    }
}
