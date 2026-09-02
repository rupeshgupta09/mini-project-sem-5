import java.util.Scanner;

class BankManagementSystem {
    
    void bankDetails() {
        Scanner sc = new Scanner(System.in);
        String name;
        long accNo;
        float balance, amount;

        System.out.println("Enter Account Holder Name:");
        name = sc.nextLine();

        System.out.println("Enter Account Number:");
        accNo = sc.nextLong();

        System.out.println("Enter Initial Balance:");
        balance = sc.nextFloat();

        int choice;

        do {
            System.out.println("\n----- BANK MENU -----");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Display Account Details");
            System.out.println("5. Exit");
            System.out.print("Enter Your Choice: ");
            choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter Deposit Amount: ");
                amount = sc.nextFloat();
                balance = balance + amount;
                System.out.println("Amount Deposited Successfully.");
            } 
            else if (choice == 2) {
                System.out.print("Enter Withdraw Amount: ");
                amount = sc.nextFloat();

                if (amount <= balance) {
                    balance = balance - amount;
                    System.out.println("Amount Withdrawn Successfully.");
                } else {
                    System.out.println("Error: Insufficient Balance!");
                }
            } 
            else if (choice == 3) {
                System.out.println("Current Balance: $" + balance);
            } 
            else if (choice == 4) {
                System.out.println("\n--- Account Details ---");
                System.out.println("Holder Name: " + name);
                System.out.println("Account No : " + accNo);
                System.out.println("Balance    : $" + balance);
            } 
            else if (choice == 5) {
                System.out.println("Thank you for using our banking services system!");
            } 
            else {
                System.out.println("Invalid Choice! Please enter a number between 1 and 5.");
            }

        } while (choice != 5);

        sc.close(); // Clean up resource leak
    }

    public static void main(String[] args) {
        BankManagementSystem system = new BankManagementSystem();
        system.bankDetails();
    }
}
