import java.util.*;

public class ATMInterface {

    static double balance = 10000;
    static ArrayList<String> transactionHistory = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String userId = "user123";
        String pin = "1234";

        System.out.println("===== Welcome to ATM =====");

        System.out.print("Enter User ID: ");
        String inputId = sc.nextLine();

        System.out.print("Enter PIN: ");
        String inputPin = sc.nextLine();

        if (inputId.equals(userId) && inputPin.equals(pin)) {

            int choice;

            do {
                System.out.println("\n===== ATM Menu =====");
                System.out.println("1. Transaction History");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Transfer");
                System.out.println("5. Quit");
                System.out.print("Enter your choice: ");

                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        showHistory();
                        break;

                    case 2:
                        withdraw(sc);
                        break;

                    case 3:
                        deposit(sc);
                        break;

                    case 4:
                        transfer(sc);
                        break;

                    case 5:
                        System.out.println("Thank you for using ATM!");
                        break;

                    default:
                        System.out.println("Invalid Choice");
                }

            } while (choice != 5);

        } else {
            System.out.println("Invalid User ID or PIN");
        }

        sc.close();
    }

    public static void showHistory() {

        System.out.println("\n--- Transaction History ---");

        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String t : transactionHistory) {
                System.out.println(t);
            }
        }
    }

    public static void withdraw(Scanner sc) {

        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();

        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrawn: ₹" + amount);
            System.out.println("Please collect your cash");
            System.out.println("Remaining Balance: ₹" + balance);
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    public static void deposit(Scanner sc) {

        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();

        balance += amount;
        transactionHistory.add("Deposited: ₹" + amount);

        System.out.println("Amount deposited successfully");
        System.out.println("Current Balance: ₹" + balance);
    }

    public static void transfer(Scanner sc) {

        System.out.print("Enter recipient account number: ");
        sc.next();

        System.out.print("Enter amount to transfer: ");
        double amount = sc.nextDouble();

        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add("Transferred: ₹" + amount);
            System.out.println("Transfer successful");
            System.out.println("Remaining Balance: ₹" + balance);
        } else {
            System.out.println("Insufficient Balance");
        }
    }
}