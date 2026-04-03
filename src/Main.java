import java.util.Scanner;

Manager manager = new Manager();
Scanner input = new Scanner(System.in);

void main() {
    int choice = 0;
    do {
        System.out.println("Bank Management System");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        System.out.print("Select a choice: ");

        while (!input.hasNextInt()) {
            System.out.println("Try a number: ");
            input.next();
        }

        choice = input.nextInt();
        input.next();
        switch (choice) {
            case (1):
                break;
            case (2):
                System.out.print("Enter your UID: ");
                int uid = input.nextInt();
                if (register(uid) == 0) System.out.println("Account created!");
                else System.out.println("UID already in use");
                break;
            case (3):
                System.out.println("Exiting");
                break;
        }

    } while (choice != 3);
}

int register(int uid) {
    if (manager.isUnique(uid)) {
        System.out.print("Enter your name: ");
        String name = input.next();
        System.out.print("Enter your pin: ");
        int pin = input.nextInt();
        System.out.println("Creating both savings and current accounts for you.");
        User customer = new User(name, pin, true, true);
        manager.put(uid, customer);
        return 0;
    }
    return -1;
}