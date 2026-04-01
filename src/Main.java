import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Scanner;

class Main {
    static Scanner input = new Scanner(System.in);
    static RecordHandling recordHandler = new RecordHandling();

    ObjectInputStream ois = recordHandler.getInputStream();
    ObjectOutputStream oos = recordHandler.getOutputStream();

    Main() throws IOException {
        System.out.println(new IOException().getMessage());
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int choice = 0;
        do {
            System.out.println("Welcome to Bank Management System");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            while (!input.hasNextInt()) {
                System.out.print("Try a number: ");
                input.next();       // clears bad input
            }

            choice = input.nextInt();

            System.out.println("Processing option " + choice + "...");
            switch (choice) {
                case (1):
                    System.out.println("Logging in...");
                    int uid = authenticationCaller();        // gives uid if username and pin correct, else 0 for wrong credentials
                    if (uid == 0) {
                        System.out.println("Incorrect Credentials");
                    }
                    else {
                        loginMenu(uid);
                    }
                    break;
                case (2):
                    System.out.println("Registering...");
                    break;
                case (3):
                    System.out.println("Shutting down the system...");
                    break;
                default:
                    System.out.println("This option does not exist!");
                    break;
            }
        } while (choice != 3);
    }

    static void loginMenu(int uid) throws IOException, ClassNotFoundException {
        User customer = recordHandler.getUserInfo(uid);
        System.out.printf("Welcome %s!%n",customer.getName());
        int choice = 0;
        do {
            System.out.println("Welcome to Bank Management System");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Transfer (Internal)");
            System.out.println("4. Get Account Information");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");


            while (!input.hasNextInt()) {
                System.out.print("Try a number: ");
                input.next();       // clears bad input
            }

            choice = input.nextInt();

            System.out.println("Processing Choice " + choice + "...");
            switch(choice) {
                case(1):
                    System.out.println("Withdrawing...");
                    break;
                case(2):
                    System.out.println("Depositing...");
                    break;
                case(3):
                    System.out.println("Transferring...");
                    break;
                case(4):
                    System.out.println("Getting...");
                    break;
                case(5):
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("This option does not exist!");
                    break;
            }
        } while (choice != 5);

    }

    static int authenticationCaller() throws IOException, ClassNotFoundException {
        System.out.print("Enter your UID: ");

        while (!input.hasNextInt()) {
            System.out.print("The UID is a number: ");
            input.next();
        }
        int uid = input.nextInt();
        System.out.print("Enter your PIN: ");
        int pin = input.nextInt();

        int status = recordHandler.authentication(uid, pin);
        if (status == 1) {
            System.out.println("User Authenticated Successfully");
            return uid;
        } else {
            return 0;
        }
    }
}