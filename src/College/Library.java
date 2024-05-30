package College;

import java.util.Scanner;

public class Library {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Books ob = new Books(input);

        Students studentManager = new Students(input);

        int choice;
        int searchChoice;

        do {
            System.out.println("\n********************Welcome to the GFG Library!********************");
            System.out.println("Select From The Following Options:");
            System.out.println("1. Add a Book");
            System.out.println("2. Upgrade Book Quantity");
            System.out.println("3. Search Book");
            System.out.println("4. Show All Books");
            System.out.println("5. Add a Student");
            System.out.println("6. Show All Students");
            System.out.println("7. Check Out Book");
            System.out.println("8. Check In Book");
            System.out.println("0. Exit");
            System.out.println("**********************************************************************");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();
            input.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    Book newBook = new Book();
                    ob.addBook(newBook);
                    break;
                case 2:
                    ob.upgradeBookQty(input);
                    break;
                case 3:
                    System.out.println("Press 1 to Search by Book Serial No.");
                    System.out.println("Press 2 to Search by Author Name.");
                    searchChoice = input.nextInt();
                    input.nextLine(); // Consume newline
                    switch (searchChoice) {
                        case 1:
                            ob.searchBySno();
                            break;
                        case 2:
                            ob.searchByAuthorName();
                            break;
                        default:
                            System.out.println("Invalid search choice.");
                    }
                    break;
                case 4:
                    ob.showAllBooks();
                    break;
                case 5:
                    Student newStudent = new Student(input);
                    studentManager.addStudent(newStudent);
                    break;
                case 6:
                    studentManager.showAllStudents();
                    break;
                case 7:
                    studentManager.checkOutBook(ob);
                    break;
                case 8:
                    studentManager.checkInBook(ob);
                    break;
                case 0:
                    System.out.println("Exiting the library. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from the menu.");
            }

        } while (choice != 0);

        input.close(); // Close the Scanner object
    }
}
