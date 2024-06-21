package College;

import java.util.Scanner;

public class Books {

    private static final int MAX_BOOKS = 50;
    private Book[] theBooks = new Book[MAX_BOOKS];
    private int count;
    Scanner input;

    public Books(Scanner input) {
        this.input= input;
        this.count = 0;
    }

    public int compareBookObjects(Book b1, Book b2) {
        if (b1.getBookName().equalsIgnoreCase(b2.getBookName())) {
            System.out.println("Book of this Name Already Exists.");
            return 0;
        }
        if (b1.getsNo() == b2.getsNo()) {
            System.out.println("Book of this Serial No Already Exists.");
            return 0;
        }
        return 1;
    }

    public void addBook(Book newBook) {
        for (int i = 0; i < count; i++) {
            if (this.compareBookObjects(newBook, this.theBooks[i]) == 0)
                return;
        }
        if (count < MAX_BOOKS) {
            theBooks[count] = newBook;
            count++;
        } else {
            System.out.println("No Space to Add More Books.");
        }
    }

    public void searchBySno() {
        System.out.println("\t\t\t\tSEARCH BY SERIAL NUMBER\n");
        System.out.println("Enter Serial No of Book:");
        int sNo = input.nextInt();

        System.out.println("S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");

        for (int i = 0; i < count; i++) {
            if (sNo == theBooks[i].getsNo()) {
                System.out.println(
                        theBooks[i].getsNo() + "\t\t"
                                + theBooks[i].getBookName() + "\t\t"
                                + theBooks[i].getAuthorName() + "\t\t"
                                + theBooks[i].getBookQtyCopy() + "\t\t"
                                + theBooks[i].getBookQty());
                return;
            }
        }
        System.out.println("No Book for Serial No " + sNo + " Found.");
    }

    public void searchByAuthorName() {
        System.out.println("\t\t\t\tSEARCH BY AUTHOR'S NAME");
        input.nextLine();
        System.out.println("Enter Author Name:");
        String authorName = input.nextLine();

        System.out.println("S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");

        for (int i = 0; i < count; i++) {
            if (authorName.equalsIgnoreCase(theBooks[i].getAuthorName())) {
                System.out.println(
                        theBooks[i].getsNo() + "\t\t"
                                + theBooks[i].getBookName() + "\t\t"
                                + theBooks[i].getAuthorName() + "\t\t"
                                + theBooks[i].getBookQtyCopy() + "\t\t"
                                + theBooks[i].getBookQty());
            }
        }
    }

    public void showAllBooks() {
        System.out.println("\t\t\t\tSHOWING ALL BOOKS\n");
        System.out.println("S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");

        for (int i = 0; i < count; i++) {
            System.out.println(
                    theBooks[i].getsNo() + "\t\t"
                            + theBooks[i].getBookName() + "\t\t"
                            + theBooks[i].getAuthorName() + "\t\t"
                            + theBooks[i].getBookQtyCopy() + "\t\t"
                            + theBooks[i].getBookQty());
        }
    }

    public void upgradeBookQty(Scanner input) {
        System.out.println("\t\t\t\tUPGRADE QUANTITY OF A BOOK\n");
        System.out.println("Enter Serial No of Book:");
        int sNo = input.nextInt();

        for (int i = 0; i < count; i++) {
            if (sNo == theBooks[i].getsNo()) {
                System.out.println("Enter No of Books to be Added:");
                int addingQty = input.nextInt();
                theBooks[i].setBookQty(theBooks[i].getBookQty() + addingQty);
                theBooks[i].setBookQtyCopy(theBooks[i].getBookQtyCopy() + addingQty);
                return;
            }
        }
    }

    public void dispMenu() {
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println("Press 1 to Add new Book.");
        System.out.println("Press 0 to Exit Application.");
        System.out.println("Press 2 to Upgrade Quantity of a Book.");
        System.out.println("Press 3 to Search a Book.");
        System.out.println("Press 4 to Show All Books.");
        System.out.println("Press 5 to Register Student.");
        System.out.println("Press 6 to Show All Registered Students.");
        System.out.println("Press 7 to Check Out Book.");
        System.out.println("Press 8 to Check In Book");
        System.out.println("-------------------------------------------------------------------------------------------------------");
    }

    public int isAvailable(int sNo) {
        for (int i = 0; i < count; i++) {
            if (sNo == theBooks[i].getsNo()) {
                if (theBooks[i].getBookQtyCopy() > 0) {
                    System.out.println("Book is Available.");
                    return i;
                }
                System.out.println("Book is Unavailable");
                return -1;
            }
        }
        System.out.println("No Book of Serial Number " + sNo + " Available in Library.");
        return -1;
    }

    public Book checkOutBook() {
        System.out.println("Enter Serial No of Book to be Checked Out.");
        int sNo = input.nextInt();

        int bookIndex = isAvailable(sNo);

        if (bookIndex != -1) {
            theBooks[bookIndex].setBookQtyCopy(theBooks[bookIndex].getBookQtyCopy() - 1);
            return theBooks[bookIndex];
        }
        return null;
    }

    public void checkInBook(Book b) {
        for (int i = 0; i < count; i++) {
            if (b.equals(theBooks[i])) {
                theBooks[i].setBookQtyCopy(theBooks[i].getBookQtyCopy() + 1);
                return;
            }
        }
    }
}
