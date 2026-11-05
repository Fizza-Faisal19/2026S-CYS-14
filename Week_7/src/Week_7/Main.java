package Week_7;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank("UET Bank");
        int choice;

        do {
            System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Client");
            System.out.println("2. Add Account");
            System.out.println("3. Deposit Amount");
            System.out.println("4. Withdraw Amount");
            System.out.println("5. Search Account");
            System.out.println("6. Search Client");
            System.out.println("7. Display Client Details");
            System.out.println("8. Display Total Amount of Client");
            System.out.println("9. Display Total Bank Amount");
            System.out.println("10. Display Bank Details");
            System.out.println("11. Remove Client");
            System.out.println("0. Exit");

            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1: {
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter CNIC: ");
                    String cnic = sc.nextLine();

                    System.out.print("Enter Phone Number: ");
                    String phone = sc.nextLine();

                    Person p = new Person(name, cnic, phone);

                    Client c = bank.addClient(p);

                    System.out.println("Client Added Successfully!");
                    System.out.println("Client ID: " + c.getId());
                    break;
                }

                case 2: {
                    System.out.print("Enter Client CNIC: ");
                    String cnic = sc.nextLine();

                    Client c = bank.searchCustomerDetail(cnic);

                    if (c != null) {
                        System.out.print("Enter Account Number: ");
                        String accNo = sc.nextLine();

                        System.out.print("Enter Initial Amount: ");
                        float amount = sc.nextFloat();
                        sc.nextLine();

                        Account a = bank.addAccount(accNo, amount, c);

                        if (a != null) {
                            System.out.println("Account Added Successfully!");
                            System.out.println(a);
                        }
                    } else {
                        System.out.println("Client Not Found!");
                    }
                    break;
                }

                case 3: {
                    System.out.print("Enter Account Number: ");
                    String accNo = sc.nextLine();

                    Account a = bank.searchAccount(accNo);

                    if (a != null) {
                        System.out.print("Enter Deposit Amount: ");
                        float amount = sc.nextFloat();
                        sc.nextLine();

                        Client c = a.getACholder();
                        c.deposit(amount, accNo);

                        System.out.println("Deposit Completed!");
                        System.out.println("Current Balance: " + a.getAmount());
                    } else {
                        System.out.println("Account Not Found!");
                    }
                    break;
                }

                case 4: {
                    System.out.print("Enter Account Number: ");
                    String accNo = sc.nextLine();

                    Account a = bank.searchAccount(accNo);

                    if (a != null) {
                        System.out.print("Enter Withdrawal Amount: ");
                        float amount = sc.nextFloat();
                        sc.nextLine();

                        Client c = a.getACholder();
                        c.withdraw(amount, accNo);

                        System.out.println("Remaining Balance: " + a.getAmount());
                    } else {
                        System.out.println("Account Not Found!");
                    }
                    break;
                }

                case 5: {
                    System.out.print("Enter Account Number: ");
                    String accNo = sc.nextLine();

                    Account a = bank.searchAccount(accNo);

                    if (a != null) {
                        System.out.println(a);
                    } else {
                        System.out.println("Account Not Found!");
                    }
                    break;
                }

                case 6: {
                    System.out.print("Enter Client CNIC: ");
                    String cnic = sc.nextLine();

                    Client c = bank.searchCustomerDetail(cnic);

                    if (c != null) {
                        System.out.println("Client Found!");
                        System.out.println(c.getId());
                    } else {
                        System.out.println("Client Not Found!");
                    }
                    break;
                }

                case 7: {
                    System.out.print("Enter Client CNIC: ");
                    String cnic = sc.nextLine();

                    Client c = bank.searchCustomerDetail(cnic);

                    if (c != null) {
                        System.out.println(c);
                    } else {
                        System.out.println("Client Not Found!");
                    }
                    break;
                }

                case 8: {
                    System.out.print("Enter Client CNIC: ");
                    String cnic = sc.nextLine();

                    Client c = bank.searchCustomerDetail(cnic);

                    if (c != null) {
                        System.out.println("Client Total Amount: "
                                + c.totalAmount());
                    } else {
                        System.out.println("Client Not Found!");
                    }
                    break;
                }

                case 9: {
                    System.out.println("Total Bank Amount: " + bank.totalAmount());
                    break;
                }

                case 10: {
                    System.out.println(bank);
                    break;
                }

                case 11: {
                    System.out.print("Enter Client ID: ");
                    String id = sc.nextLine();

                    if (bank.removeClient(id)) {
                        System.out.println("Client Removed Successfully!");
                    } else {
                        System.out.println("Client Not Found!");
                    }
                    break;
                }

                case 0:
                    System.out.println("Program Ended!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 0);

        sc.close();
    }
}