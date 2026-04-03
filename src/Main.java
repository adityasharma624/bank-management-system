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
                System.out.print("Enter your UID: ");
                int loginid = input.nextInt();
                if (login(loginid) == -1) {
                    System.out.println("UID Not Found!");
                }
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
            default:
                System.out.println("Not a choice");
                break;
        }

    } while (choice != 3);
}

int login(int uid) {
    if (manager.isUnique(uid)) {
        int choice = 0;
        User user = manager.getUser(uid);
        do {
            System.out.printf("Welcome! %s%n",user.name);
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Internal Transfer");
            System.out.println("4. Get Account Info");
            System.out.println("5. Exit");
            System.out.print("Select a choice: ");

            while (!input.hasNextInt()) {
                System.out.println("Try a number: ");
                input.next();
            }

            choice = input.nextInt();
            input.next();

            switch (choice) {
                case (1):
                    Accounts depositAccount = getAccount(user);
                    System.out.print("Deposit Amount: ");
                    double amount = input.nextDouble();
                    if (depositAccount.deposit(amount)) System.out.println("Success!");
                    else System.out.println("Failure!");
                    break;
                case (2):
                    Accounts withdrawAccount = getAccount(user);
                    System.out.print("Deposit Amount: ");
                    double withdrawal = input.nextDouble();
                    if (withdrawAccount.withdraw(withdrawal)) System.out.println("Success!");
                    else System.out.println("Failure!");
                    break;
                case (3):
                    if (internalTransfer(user)) System.out.println("Success!");
                    else System.out.println("Failure!");
                    break;
                case (4):
                    Accounts infoAccount = getAccount(user);
                    infoAccount.getInfo();
                    break;
                case (5):
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("Not a choice!");
                    break;
            }
        } while (choice != 5);
        return 0;
    }
    return -1;
}

boolean internalTransfer(User user) {
    System.out.println("1. Savings to Current");
    System.out.println("2. Current to Savings");

    System.out.print("Select a choice: ");

    while (!input.hasNextInt()) {
        System.out.println("Try a number: ");
        input.next();
    }

    int choice = input.nextInt();
    input.next();

    System.out.print("Enter the amount: ");
    double amount = input.nextDouble();

    switch(choice) {
        case (1):
            return (user.internalTransfer(user.savings, user.current, amount));
        case (2):
            return (user.internalTransfer(user.current, user.savings, amount));
        default:
            System.out.println("Not a choice!");
            break;
    }
    return false;
}

Accounts getAccount(User user) {
    System.out.println("1. Savings Account");
    System.out.println("2. Current Account");

    System.out.print("Select a choice: ");

    while (!input.hasNextInt()) {
        System.out.println("Try a number: ");
        input.next();
    }

    int choice = input.nextInt();
    input.next();

    switch (choice) {
        case (1):
            return user.getSavings();
        case (2):
            return user.getCurrent();
        default:
            System.out.println("Not a choice!");
            break;
    }
    return null;
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