package Workbook_2.NeighorhoodLibrary;

import java.util.Scanner;

public class NeighborhoodLibrary {
    private static final Book[] bookArray = new Book[30];
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {

        initializeArray();

        System.out.println("\n#######################################");
        System.out.println("# Welcome to the Neighborhood Library #");
        System.out.println("#######################################");

        String choice;
        do {
            choice = homeScreen();
            switch (choice) {
                case "1" -> showAvailableBooks();
                case "2" -> showCheckedOutBooks();
                case "3" -> System.out.println("Thank you, good bye!");
                default -> System.out.println("Invalid choice! Please enter 1-3.");
            }
        } while (!choice.equals("3"));
    }

    public static String homeScreen() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("\nWhat do you want to do?\n");
        System.out.print("1 - Show Available Books\n" +
                         "2 - Show Checked Out Books\n" +
                         "3 - Exit\n" +
                         "Enter your command: ");
        return scanner.nextLine();
    }

    public static void showAvailableBooks() throws InterruptedException {
        for (Book book : bookArray) {
            if (!book.isCheckedOut()){
                System.out.println(book);
            }
        }
        String choice;
        Thread.sleep(1000);
        System.out.println("\nWhat do you want to do?\n");
        System.out.print("1 - Check Out A Book?\n" +
                "2 - Return To Home Screen\n" +
                "Enter your command: ");
        choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("1")) {
            bookCheckOut();
        }


    }

    public static void showCheckedOutBooks() throws InterruptedException {
        int borrowedCount = 0;
        for (Book book : bookArray) {
            if (book.isCheckedOut()) {
                System.out.println(book);
                borrowedCount++;
            }
        }

        if (borrowedCount == 0) {
            System.out.println("No Books Have Been Checked Out!");
            return;
        }

        String choice;

        Thread.sleep(1000);
        System.out.println("\nWhat do you want to do?\n");
        System.out.print("1 - Check In A Book?\n" +
                         "2 - Return To Home Screen\n" +
                         "Enter your command: ");
        choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("1")) {
            bookCheckIn();
        }
    }

    public static void bookCheckOut() throws InterruptedException {
        System.out.println("Please Provide the book's ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Book selectedBook = findBookById(id);

        if (selectedBook == null) {
            System.out.println("Book not found, Returning to Home Screen");
        } else if (selectedBook.isCheckedOut()) {
            System.out.println("Sorry, this book is already checked out!");
        } else {
            System.out.println("Book found: " + selectedBook.getTitle());
            System.out.println("Name of Person Checking Out: ");
            String name = scanner.nextLine();
            selectedBook.checkOut(name);
            Thread.sleep(1000);
            System.out.println("Book Checked Out! Returning to Home Screen.");
            Thread.sleep(1000);
        }
    }

    public static void bookCheckIn() throws InterruptedException {
        System.out.println("Please Provide the book's ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Book selectedBook = findBookById(id);

        if (selectedBook != null) {
            System.out.println("Book found: " + selectedBook.getTitle());
            selectedBook.checkIn();
            Thread.sleep(1000);
            System.out.println("Book Checked In! Returning to Home Screen.");
            Thread.sleep(1000);
        } else {
            System.out.println("Book not found, Returning to Home Screen.");
        }
    }

    public static Book findBookById(int id) {
        for (Book book : bookArray) {
            if (book != null && book.getId() == id) {
                return book;
            }
        }
        return null;
    }



    public static void initializeArray() {
        bookArray[0] = new Book(101, "9780547928227", "The Hobbit");
        bookArray[1] = new Book(102, "9780141439518", "Pride and Prejudice");
        bookArray[2] = new Book(103, "9780451524935", "1984");
        bookArray[3] = new Book(104, "9780061120084", "To Kill a Mockingbird");
        bookArray[4] = new Book(105, "9780743273565", "The Great Gatsby");
        bookArray[5] = new Book(106, "9780439708180", "Harry Potter and the Sorcerer's Stone");
        bookArray[6] = new Book(107, "9780316769488", "The Catcher in the Rye");
        bookArray[7] = new Book(108, "9780062315007", "The Alchemist");
        bookArray[8] = new Book(109, "9780140283334", "Lord of the Flies");
        bookArray[9] = new Book(110, "9780553380163", "A Brief History of Time");
        bookArray[10] = new Book(111, "9780060850524", "Brave New World");
        bookArray[11] = new Book(112, "9780141439600", "Jane Eyre");
        bookArray[12] = new Book(113, "9780140449136", "The Odyssey");
        bookArray[13] = new Book(114, "9780141439556", "Wuthering Heights");
        bookArray[14] = new Book(115, "9780142437230", "Don Quixote");
        bookArray[15] = new Book(116, "9780143039433", "The Grapes of Wrath");
        bookArray[16] = new Book(117, "9780060935467", "One Hundred Years of Solitude");
        bookArray[17] = new Book(118, "9780307277671", "The Road");
        bookArray[18] = new Book(119, "9780385490818", "The Handmaid's Tale");
        bookArray[19] = new Book(120, "9780140449266", "The Count of Monte Cristo");
        bookArray[20] = new Book(121, "9780061122415", "The Book Thief");
        bookArray[21] = new Book(122, "9780316015844", "Twilight");
        bookArray[22] = new Book(123, "9780439023481", "The Hunger Games");
        bookArray[23] = new Book(124, "9780307588371", "Gone Girl");
        bookArray[24] = new Book(125, "9780747532699", "Harry Potter and the Philosopher's Stone");
        bookArray[25] = new Book(126, "9780141439471", "Frankenstein");
        bookArray[26] = new Book(127, "9780307474278", "The Da Vinci Code");
        bookArray[27] = new Book(128, "9780062457714", "The Subtle Art of Not Giving a F*ck");
        bookArray[28] = new Book(129, "9780735211292", "Atomic Habits");
        bookArray[29] = new Book(130, "9781501110368", "It Ends with Us");
    }

}
