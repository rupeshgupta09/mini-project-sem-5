import java.util.Scanner;

public class LibraryManagement {

    int BookId, avlBook, TotalBook;
    String BookName = "", BookAuthor = "", BookCategory = "";
    boolean isBookAdded = false;
    Scanner sc = new Scanner(System.in);

    void mainMenu() {
        System.out.println("\n=== Library Management System ===");
        System.out.println("1. Add Book");
        System.out.println("2. View Book");
        System.out.println("3. Search Book");
        System.out.println("4. Issue Book");
        System.out.println("5. Return Book");
        System.out.println("6. Delete Book");
        System.out.println("7. Library Report");
        System.out.println("8. Exit");
        System.out.print("Enter Your Choice: ");
    }

    public void addBook() {
        System.out.println("\n--- Add Book ---");
        System.out.print("Enter book ID: ");
        BookId = sc.nextInt();
        sc.nextLine(); // Consume newline

        System.out.print("Enter book Name: ");
        BookName = sc.nextLine();

        System.out.print("Enter book Author: ");
        BookAuthor = sc.nextLine();

        System.out.print("Enter book Category: ");
        BookCategory = sc.nextLine();

        System.out.print("Enter Total Books: ");
        TotalBook = sc.nextInt();
        avlBook = TotalBook;
        
        isBookAdded = true;
        System.out.println("Book Added Successfully!");
    }

    public void view() {
        if (!isBookAdded) {
            System.out.println("\nNo book records found. Please add a book first.");
            return;
        }
        System.out.println("\n--- Book Details ---");
        System.out.println("Book ID: " + BookId);
        System.out.println("Book Name: " + BookName);
        System.out.println("Book Author: " + BookAuthor);
        System.out.println("Book Category: " + BookCategory);
        System.out.println("Total Books: " + TotalBook);
        System.out.println("Available Books: " + avlBook);
        System.out.println("Issued Books: " + (TotalBook - avlBook));
    }

    void SearchBook() {
        if (!isBookAdded) {
            System.out.println("\nNo book records found to search.");
            return;
        }
        System.out.print("\nEnter book ID to search: ");
        int s = sc.nextInt();
        if (s == BookId) {
            view();
        } else {
            System.out.println("Book with ID " + s + " not found.");
        }
    }

    void issueBook() {
        if (!isBookAdded) {
            System.out.println("\nNo books available in the library system.");
            return;
        }
        System.out.print("\nEnter Book ID to issue: ");
        int id = sc.nextInt();
        if (id == BookId) {
            if (avlBook > 0) {
                avlBook--;
                System.out.println("Book issued successfully! Remaining available: " + avlBook);
            } else {
                System.out.println("Sorry, all copies of this book are currently issued out.");
            }
        } else {
            System.out.println("Book ID does not match.");
        }
    }

    void returnBook() {
        if (!isBookAdded) {
            System.out.println("\nNo books exist to return.");
            return;
        }
        System.out.print("\nEnter Book ID to return: ");
        int id = sc.nextInt();
        if (id == BookId) {
            if (avlBook < TotalBook) {
                avlBook++;
                System.out.println("Book returned successfully! Current available: " + avlBook);
            } else {
                System.out.println("Error: All copies of this book are already in the library.");
            }
        } else {
            System.out.println("Book ID does not match.");
        }
    }

    void deleteBook() {
        if (!isBookAdded) {
            System.out.println("\nNo records available to delete.");
            return;
        }
        System.out.print("\nEnter Book ID to delete: ");
        int id = sc.nextInt();
        if (id == BookId) {
            BookId = 0;
            BookName = "";
            BookAuthor = "";
            BookCategory = "";
            TotalBook = 0;
            avlBook = 0;
            isBookAdded = false;
            System.out.println("Book record deleted successfully.");
        } else {
            System.out.println("Book ID does not match.");
        }
    }

    void libraryReport() {
        System.out.println("\n--- Overall Library Report ---");
        if (!isBookAdded) {
            System.out.println("The library is currently empty.");
        } else {
            System.out.println("Total Unique Title: 1");
            System.out.println("Total Stock Copies: " + TotalBook);
            System.out.println("Total Stock Available: " + avlBook);
            System.out.println("Total Stock Out on Loan: " + (TotalBook - avlBook));
        }
    }

    public static void main(String[] args) {
        LibraryManagement lib = new LibraryManagement();
        int choice;

        do {
            lib.mainMenu();
            choice = lib.sc.nextInt();

            switch (choice) {
                case 1:
                    lib.addBook();
                    break;
                case 2:
                    lib.view();
                    break;
                case 3:
                    lib.SearchBook();
                    break;
                case 4:
                    lib.issueBook();
                    break;
                case 5:
                    lib.returnBook();
                    break;
                case 6:
                    lib.deleteBook();
                    break;
                case 7:
                    lib.libraryReport();
                    break;
                case 8:
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid Choice! Please select an option between 1 and 8.");
            }
        } while (choice != 8);

        lib.sc.close(); // Clean up resource leaks
    }
}

