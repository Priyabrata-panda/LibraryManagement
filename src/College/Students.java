package College;

import java.util.Scanner;

public class Students {

    private Student[] theStudents;
    private int count;
    private Scanner input;

    public Students(Scanner input) {
        this.theStudents = new Student[50];
        this.count = 0;
        this.input = new Scanner(System.in);
    }

    public void addStudent(Student s) {
        if (count < 50) {
            for (int i = 0; i < count; i++) {
                if (s.getRegNum().equalsIgnoreCase(theStudents[i].getRegNum())) {
                    System.out.println("Student with Reg Num " + s.getRegNum() + " is Already Registered.");
                    return;
                }
            }
            theStudents[count] = s;
            count++;
        } else {
            System.out.println("Maximum number of students reached.");
        }
    }

    public void showAllStudents() {
        System.out.println("Student Name\t\tReg Number");
        for (int i = 0; i < count; i++) {
            System.out.println(theStudents[i].getStudentName() + "\t\t" + theStudents[i].getRegNum());
        }
    }

    public int isStudent() {
        System.out.println("Enter Reg Number:");
        String regNum = input.nextLine();
        for (int i = 0; i < count; i++) {
            if (theStudents[i].getRegNum().equalsIgnoreCase(regNum)) {
                return i;
            }
        }
        System.out.println("Student is not Registered. Get Registered First.");
        return -1;
    }

    public void checkOutBook(Books bookManager) {
        int studentIndex = this.isStudent();
        if (studentIndex != -1) {
            System.out.println("Checking out...");
            bookManager.showAllBooks();
            Book b = bookManager.checkOutBook();
            if (b != null) {
                if (theStudents[studentIndex].getBooksCount() <= 3) {
                    theStudents[studentIndex].borrowBook(b);
                    System.out.println("Book added to student's borrowed list.");
                } else {
                    System.out.println("Student cannot borrow more than 3 books.");
                }
            } else {
                System.out.println("Book is not Available.");
            }
        }
    }

    public void checkInBook(Books book) {
        int studentIndex = this.isStudent();
        if (studentIndex != -1) {
            Student student = theStudents[studentIndex];
            System.out.println("S.No\t\tBook Name\t\tAuthor Name");
            for (int i = 0; i < student.getBooksCount(); i++) {
                Book borrowedBook = student.getBorrowedBooks()[i];
                System.out.println(borrowedBook.getsNo() + "\t\t" + borrowedBook.getBookName() + "\t\t" + borrowedBook.getAuthorName());
            }
            System.out.println("Enter Serial Number of Book to be Checked In:");
            int sNo = input.nextInt();
            for (int i = 0; i < student.getBooksCount(); i++) {
                if (sNo == student.getBorrowedBooks()[i].getsNo()) {
                    book.checkInBook(student.getBorrowedBooks()[i]);
                    student.returnBook(student.getBorrowedBooks()[i]);
                    System.out.println("Book checked in successfully.");
                    return;
                }
            }
            System.out.println("Book of Serial No " + sNo + " not found.");
        }
    }

    public void closeScanner() {
        input.close();
    }
}
