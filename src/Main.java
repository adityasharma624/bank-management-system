import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

class Main {
    static Scanner input = new Scanner(System.in);
    static RecordHandling recordHandler = new RecordHandling();

    ObjectInputStream ois = recordHandler.getInputStream();
    ObjectOutputStream oos = recordHandler.getOutputStream();

    Main() throws IOException {
        System.out.println(new IOException().getMessage());
    }

    public static void main(String[] args) {
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

    static int authentication(ObjectInputStream ois) {
        int uid;
        String password;
        System.out.print("Enter your user ID: ");
        uid = input.nextInt();

        return 1;
    }
}