import java.util.ArrayList;
import java.util.Scanner;

public class Main{

    static class BankAccount {
        int accountNumber;
        String name;
        double balance;

        BankAccount(int accountNumber, String name, double balance) {
            this.accountNumber = accountNumber;
            this.name = name;
            this.balance = balance;
        }
    }

    static ArrayList<BankAccount> accounts = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    
    static void createAccount() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        accounts.add(new BankAccount(accNo, name, balance));
        System.out.println("Account Created Successfully!");
    }

    
    static void deposit() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        for (BankAccount acc : accounts) {
            if (acc.accountNumber == accNo) {
                System.out.print("Enter Amount: ");
                double amount = sc.nextDouble();

                acc.balance += amount;
                System.out.println("Amount Deposited Successfully!");
                return;
            }
        }

        System.out.println("Account Not Found!");
    }

    static void withdraw() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        for (BankAccount acc : accounts) {
            if (acc.accountNumber == accNo) {
                System.out.print("Enter Amount: ");
                double amount = sc.nextDouble();

                if (amount <= acc.balance) {
                    acc.balance -= amount;
                    System.out.println("Withdrawal Successful!");
                } else {
                    System.out.println("Insufficient Balance!");
                }
                return;
            }
        }

        System.out.println("Account Not Found!");
    }

  
    static void checkBalance() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        for (BankAccount acc : accounts) {
            if (acc.accountNumber == accNo) {
                System.out.println("Balance: " + acc.balance);
                return;
            }
        }

        System.out.println("Account Not Found!");
    }

    
    static void displayAccounts() {

        if (accounts.isEmpty()) {
            System.out.println("No Accounts Available.");
            return;
        }

        System.out.println("\n----- Account Details -----");

        for (BankAccount acc : accounts) {
            System.out.println("Account Number : " + acc.accountNumber);
            System.out.println("Name           : " + acc.name);
            System.out.println("Balance        : " + acc.balance);
            System.out.println("---------------------------");
        }
    }

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Display All Accounts");
            System.out.println("6. Exit");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    displayAccounts();
                    break;
                case 6:
                    System.out.println("Thank You!");
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}