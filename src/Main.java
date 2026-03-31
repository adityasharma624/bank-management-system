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
                    int user = authenticationCaller();
                    switch (user) {
                        case (-1):
                            System.out.println("User Not Found");
                            break;
                        case (0):
                            System.out.println("Wrong Password");
                            break;
                        default:
                            loginMenu(user);
                            break;
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

    static void loginMenu(int user) throws IOException, ClassNotFoundException {
        User customer = recordHandler.getUserInfo(user);
        String username = customer.getName();
        System.out.printf("Welcome %s!%n",username);

    }

    static int authenticationCaller() throws IOException, ClassNotFoundException {
        System.out.print("Enter your UID: ");

        while (!input.hasNextInt()) {
            System.out.print("The UID is a number: ");
            input.next();
        }
        int uid = input.nextInt();
        System.out.print("Enter your password: ");
        String password = input.nextLine();

        int status = recordHandler.authentication(uid, password);
        if (status == 0) {
            System.out.println("Wrong Password");
            return -1;
        } else if (status == 1) {
            System.out.println("User Authenticated Successfully");
            return uid;
        }
        System.out.println("User Not Found");
        return -1;
    }
}