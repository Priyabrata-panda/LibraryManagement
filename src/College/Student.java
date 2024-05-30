package College;

import java.util.Scanner;

public class Student {

    private String studentName;
    private String regNum;
    private Book[] borrowedBooks;
    public int booksCount = 0;

    public Student(Scanner input) {
        this.borrowedBooks = new Book[3];  // Assuming a student can borrow up to 3 books
        this.booksCount = 0;
    }

    public void takeStudentDetails(Scanner input) {
        System.out.println("Enter Student Name:");
        this.studentName = input.nextLine();

        System.out.println("Enter Registration Number:");
        this.regNum = input.nextLine();
    }

    // Getters and Setters
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getRegNum() {
        return regNum;
    }

    public void setRegNum(String regNum) {
        this.regNum = regNum;
    }

    public Book[] getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(Book[] borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public int getBooksCount() {
        return booksCount;
    }

    public void setBooksCount(int booksCount) {
        this.booksCount = booksCount;
    }

    public void borrowBook(Book book) {
        if (booksCount < borrowedBooks.length) {
            borrowedBooks[booksCount] = book;
            booksCount++;
        } else {
            System.out.println("Cannot borrow more than " + borrowedBooks.length + " books.");
        }
    }

    public void returnBook(Book book) {
        for (int i = 0; i < booksCount; i++) {
            if (borrowedBooks[i].equals(book)) {
                borrowedBooks[i] = null;
                booksCount--;
                rearrangeBorrowedBooks();
                return;
            }
        }
        System.out.println("Book not found in borrowed list.");
    }

    private void rearrangeBorrowedBooks() {
        for (int i = 0; i < booksCount; i++) {
            if (borrowedBooks[i] == null) {
                borrowedBooks[i] = borrowedBooks[booksCount];
                borrowedBooks[booksCount] = null;
            }
        }
    }
}
