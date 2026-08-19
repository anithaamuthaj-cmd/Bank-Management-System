import java.util.LinkedHashMap;
import java.util.Scanner;

public class BankApplication {

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        LinkedHashMap<Integer, Account> accounts = new LinkedHashMap<>();

        int choice;

        do {
            System.out.println("\n===== BANKING APPLICATION =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. View All Accounts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter account number: ");
                    int accountNumber =sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter account holder name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter initial balance: ");
                    double balance = sc.nextDouble();

                    if (accounts.containsKey(accountNumber)) {
                        System.out.println("Account already exists.");

                    } else if (balance < 0) {
                        System.out.println("Balance cannot be negative.");

                    } else {

                        Account account =
                                new Account(accountNumber, name, balance);

                        accounts.put(accountNumber, account);

                        System.out.println("Account created successfully.");
                    }

                    break;

                case 2:

                    System.out.print("Enter account number: ");
                    int depositAccountNumber = sc.nextInt();

                    Account depositAccount =
                            accounts.get(depositAccountNumber);

                    if (depositAccount == null) {
                        System.out.println("Account not found.");

                    } else {

                        System.out.print("Enter amount to deposit: ");
                        double amount = sc.nextDouble();

                        depositAccount.deposit(amount);
                    }

                    break;

                case 3:

                    System.out.print("Enter account number: ");
                    int withdrawAccountNumber = sc.nextInt();

                    Account withdrawAccount =
                            accounts.get(withdrawAccountNumber);

                    if (withdrawAccount == null) {
                        System.out.println("Account not found.");

                    } else {

                        System.out.print("Enter amount to withdraw: ");
                        double amount = sc.nextDouble();

                        withdrawAccount.withdraw(amount);
                    }

                    break;

                case 4:

                    System.out.print("Enter account number: ");
                    int balanceAccountNumber = sc.nextInt();

                    Account balanceAccount =
                            accounts.get(balanceAccountNumber);

                    if (balanceAccount == null) {
                        System.out.println("Account not found.");

                    } else {

                        System.out.println(
                                "Account Number: "
                                + balanceAccount.getAccountNumber());

                        System.out.println(
                                "Account Holder: "
                                + balanceAccount.getName());

                        System.out.println(
                                "Current Balance: "
                                + balanceAccount.getBalance());
                    }
                    break;
                case 5:
                    if (accounts.isEmpty()) {
                        System.out.println("No accounts available.");
                    } else {
                        System.out.println("\n===== ALL ACCOUNTS =====");
                        for (Account account : accounts.values()) {
                            System.out.println(
                                    "Account Number: "
                                    + account.getAccountNumber());
                            System.out.println(
                                    "Name: "
                                    + account.getName());
                            System.out.println(
                                    "Balance: "
                                    + account.getBalance());
                            System.out.println("-----------------------");
                        }
                    }
                    break;
                case 6:
                    System.out.println( "Thank you for using the Banking Application.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice!=6);
        sc.close();
    }
}