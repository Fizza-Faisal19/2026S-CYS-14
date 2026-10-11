import java.util.Scanner;
class SavingAccount {
    private double balance;
    // Constructor
    SavingAccount(double initialBalance) {
        balance = initialBalance;
    }
    void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Money deposited successfully.");
        }
        else {
            System.out.println("Enter a valid amount.");
        }
    }
    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Enter a valid amount.");
        }
        else if (amount > balance) {
            System.out.println("Insufficient balance.");
        }
        else {
            balance = balance - amount;
            System.out.println("Money withdrawn successfully.");
        }
    }
    void checkBalance() {
        System.out.printf("Current balance: %.2f%n", balance);
    }
}
class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SavingAccount account = new SavingAccount(1000);
        int choice;
        do {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);
        sc.close();
    }
}