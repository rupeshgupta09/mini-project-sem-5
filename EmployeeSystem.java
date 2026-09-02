import java.util.Scanner;

public class EmployeeSystem {
    int employeId, age;
    String employeName, companyName, employeDepartment, gender;
    boolean isEmployeAdded = false;
    Scanner sc = new Scanner(System.in);

    void mainMenu() {
        System.out.println("\n=== EMPLOYEE MANAGEMENT SYSTEM ===");
        System.out.println("1. Add Employee");
        System.out.println("2. View Employee Details");
        System.out.println("3. Search Employee");
        System.out.println("4. Delete Employee");
        System.out.println("5. Exit");
        System.out.print("Enter Choice: ");
    }

    void addEmploye() {
        System.out.println("\n--- Add Employee ---");
        System.out.print("Enter Employee ID: ");
        employeId = sc.nextInt();
        sc.nextLine(); // Consume newline left-over
        
        System.out.print("Enter Employee Name: ");
        employeName = sc.nextLine();
        
        System.out.print("Enter Employee Age: ");
        age = sc.nextInt();
        sc.nextLine(); // Consume newline left-over
        
        System.out.print("Enter Employee Gender: ");
        gender = sc.nextLine();
        
        System.out.print("Enter Company Name: ");
        companyName = sc.nextLine();
        
        System.out.print("Enter Employee Department: ");
        employeDepartment = sc.nextLine();
        
        isEmployeAdded = true;
        System.out.println("Employee added successfully!");
    }

    void viewEmploye() {
        if (!isEmployeAdded) {
            System.out.println("\nNo employee records found. Please add an employee first.");
            return;
        }
        System.out.println("\n--- Employee Details ---");
        System.out.println("Employee ID: " + employeId);
        System.out.println("Employee Name: " + employeName);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Company Name: " + companyName);
        System.out.println("Department: " + employeDepartment);
    }

    void searchEmploye() {
        if (!isEmployeAdded) {
            System.out.println("\nNo employee records found. Please add an employee first.");
            return;
        }
        System.out.print("\nEnter the Employee ID to search: ");
        int newId = sc.nextInt();
        if (newId == employeId) {
            viewEmploye();
        } else {
            System.out.println("The Employee is not Found.");
        }
    }

    void deleteEmployee() {
        if (!isEmployeAdded) {
            System.out.println("\nNo employee records found to delete.");
            return;
        }
        System.out.print("\nEnter the Employee ID to delete: ");
        int delId = sc.nextInt();
        if (delId == employeId) {
            employeId = 0;
            employeName = null;
            age = 0;
            gender = null;
            companyName = null;
            employeDepartment = null;
            isEmployeAdded = false;
            System.out.println("Employee record deleted successfully.");
        } else {
            System.out.println("The Employee ID does not match.");
        }
    }

    public static void main(String[] args) {
        EmployeeSystem obj = new EmployeeSystem();
        int choice = 0;
        
        do {
            obj.mainMenu();
            
            // Check if input is a valid integer to prevent crashes
            if (obj.sc.hasNextInt()) {
                choice = obj.sc.nextInt();
                switch (choice) {
                    case 1:
                        obj.addEmploye();
                        break;
                    case 2:
                        obj.viewEmploye();
                        break;
                    case 3:
                        obj.searchEmploye();
                        break;
                    case 4:
                        obj.deleteEmployee();
                        break;
                    case 5:
                        System.out.println("Exit");
                        break;
                    default:
                        System.out.println("Invalid choice! Please select between 1 and 5.");
                }
            } else {
                System.out.println("Invalid input! Please enter a number.");
                obj.sc.next(); // Clear the invalid input
                choice = 0;    // Reset choice to loop again
            }
        } while (choice != 5);
        
        obj.sc.close();
    }
}
