package Workbook_2.NeighorhoodLibrary;

public class Book {
    private final int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;

    public Book(int id, String isbn, String title) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = false;
        this.checkedOutTo = "";
    }

    public int getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public void checkOut(String name) {
        this.checkedOutTo = name;
        this.isCheckedOut = true;
    }

    public void checkIn() {
        this.checkedOutTo = "";
        this.isCheckedOut = false;
    }

    @Override
    public String toString() {
        return String.format(
                "ID: %d | ISBN: %s | Title: %s | Status: %s",
                id,
                isbn,
                title,
                isCheckedOut ? "Checked Out to " + checkedOutTo : "Available"
        );
    }
}
