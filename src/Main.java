import java.util.Scanner;

void main() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Welcome to Bank Management System");
    System.out.println("Would you like to create a bank account?%n" +
            "Select one of the options below:%n" +
            "1. Savings Account (Required to have a Minimum Account Balance)%n" +
            "2. Current Account%n" +
            "3. Both: ");
    int choice = sc.nextInt();

    System.out.println("Input Information Regarding the Creation of New Account");
    System.out.print("Name: ");
    String name = sc.next();
    System.out.print("%nID: ");
    int id = sc.nextInt();
    System.out.print("%nInitial Balance: ");
    float balance = sc.nextFloat();
    switch(choice) {
        case (1):
            System.out.print("%nSet your minimum account balance (Enter if you want the default 10,000 as minimum account balance): ");
            if (sc.hasNext()) {
                float mab = sc.nextFloat();
            }
            else {
                Savings savings = new Savings(id, name, balance);
            }
    }

}
