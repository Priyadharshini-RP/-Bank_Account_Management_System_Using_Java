import java.util.Scanner;
/* ---------- Interface ---------- */ 
interface Transaction { 
void deposit(double amount);
 void withdraw(double amount);
 }
/* ---------- Abstraction ---------- */
 abstract class Account { 
public abstract void displayAccountDetails();
 }
/* ---------- Composition Class ---------- */
 class Address {
 public String city; public String state;
Address(String city, String state) {
    this.city = city;
    this.state = state;
}
 
}
/* ---------- BankAccount Class ---------- */ 
class BankAccount extends Account implements Transaction {
// Public variables (NO Encapsulation)
public String accountNumber;
public String accountHolderName;
public double balance;
public String accountType;

// Composition
Address address;

// Parameterized Constructor + this keyword
public BankAccount(String accountNumber, String accountHolderName,
                   double balance, String accountType, Address address) {


    this.accountNumber = accountNumber;
    this.accountHolderName = accountHolderName;
    this.balance = balance;
    this.accountType = accountType;
    this.address = address;
}

// Interface methods
public void deposit(double amount) {
    if (amount > 0) {
        balance += amount;
        System.out.println("Deposit Successful. Balance: " + balance);
    } else {
        System.out.println("Invalid Deposit");
    }
}

public void withdraw(double amount) {
    if (amount > 0 && amount <= balance) {
        balance -= amount;
        System.out.println("Withdrawal Successful. Balance: " + balance);
    } else {
        System.out.println("Invalid Withdrawal");
    }
}

// Abstract method implementation
public void displayAccountDetails() {
    System.out.println("\n--- Account Details ---");
    System.out.println("Account Number: " + accountNumber);
    System.out.println("Account Holder: " + accountHolderName);
    System.out.println("Account Type: " + accountType);
    System.out.println("Balance: " + balance);
    System.out.println("City: " + address.city);
    System.out.println("State: " + address.state);
}
 
}
/* ---------- Main Class ---------- */
 public class Main {
 public static void main(String[] args) {
   Scanner sc = new Scanner(System.in);

    System.out.print("Enter Account Number: ");
    String accNo = sc.nextLine();

    System.out.print("Enter Account Holder Name: ");
    String name = sc.nextLine();

    System.out.print("Enter Initial Balance: ");
    double bal = sc.nextDouble();
    sc.nextLine();

    System.out.print("Enter Account Type: ");
    String type = sc.nextLine();

    System.out.print("Enter City: ");
    String city = sc.nextLine();

    System.out.print("Enter State: ");
    String state = sc.nextLine();

    // Composition object
    Address addr = new Address(city, state);

    // Creating BankAccount object
    BankAccount account = new BankAccount(accNo, name, bal, type, addr);

    account.displayAccountDetails();

    System.out.print("\nEnter Deposit Amount: ");
    account.deposit(sc.nextDouble());

    System.out.print("Enter Withdrawal Amount: ");
    account.withdraw(sc.nextDouble());

    account.displayAccountDetails();

    sc.close();
}
 
}