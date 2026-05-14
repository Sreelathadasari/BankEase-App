import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        BankOperations bank = new BankOperations();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n=== BankEase ===");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            switch(choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    System.out.print("Enter Balance: ");
                    double bal = sc.nextDouble();
                    System.out.print("Account Type: ");
                    String type = sc.next();
                    bank.createAccount(name, bal, type);
                    break;
                case 2:
                    System.out.print("Account ID: ");
                    int id = sc.nextInt();
                    System.out.print("Amount: ");
                    double amt = sc.nextDouble();
                    bank.deposit(id, amt);
                    break;
                case 3:
                    System.out.print("Account ID: ");
                    int wid = sc.nextInt();
                    System.out.print("Amount: ");
                    double wamt = sc.nextDouble();
                    bank.withdraw(wid, wamt);
                    break;
                case 4:
                    System.out.print("Account ID: ");
                    int bid = sc.nextInt();
                    bank.checkBalance(bid);
                    break;
            }
        } while(choice != 0);
    }
}