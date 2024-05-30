package College;

import java.util.Scanner;

public class Book {
    private int sNo;
    private String bookName;
    private String authorName;
    private int bookQty;
    private int bookQtyCopy;

    public Book() {
        Scanner input = new Scanner(System.in);
        addBookDetails(input);
        // input.close(); // Uncomment if Scanner is not needed elsewhere
    }

    private void addBookDetails(Scanner input) {
        System.out.println("Enter Serial No of Book:");
        this.sNo = input.nextInt();
        input.nextLine(); // Consume the newline

        System.out.println("Enter Book Name:");
        this.bookName = input.nextLine();

        System.out.println("Enter Author Name:");
        this.authorName = input.nextLine();

        System.out.println("Enter Quantity of Books:");
        this.bookQty = input.nextInt();
        this.bookQtyCopy = this.bookQty;
    }

    // Getters and Setters
    public int getsNo() {
        return sNo;
    }

    public void setsNo(int sNo) {
        this.sNo = sNo;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getBookQty() {
        return bookQty;
    }

    public void setBookQty(int bookQty) {
        this.bookQty = bookQty;
    }

    public int getBookQtyCopy() {
        return bookQtyCopy;
    }

    public void setBookQtyCopy(int bookQtyCopy) {
        this.bookQtyCopy = bookQtyCopy;
    }
}
