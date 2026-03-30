public abstract class Accounts {
    int id;
    String accountHolderName;
//    int pin;
    Accounts(int id, String accountHolderName) {
        this.id = id;
        this.accountHolderName = accountHolderName;
    }

    abstract void deposit(float amount);
    abstract void withdraw(float amount);
}

class Savings extends Accounts{
    float minimumBalance = 10000f;
    float balance;

    Savings(int id, String accountHolderName, float balance) {
        super(id, accountHolderName);
        this.balance = balance;
    }

    Savings(int id, String accountHolderName, float minimumBalance, float balance) {
        super(id, accountHolderName);
        this.minimumBalance = minimumBalance;
        this.balance = balance;
    }

    void deposit(float amount) {
        this.balance += amount;
        System.out.printf("Transaction successful. Amount deposited: %.2f. Updated Savings Account balance: %.2f.%n", amount, this.balance);
    }

    void withdraw(float amount) {
        float remaining = this.balance - amount;
        if (remaining < minimumBalance) {
            System.out.printf(
                    "Transaction declined: the requested withdrawal would result in the account falling below the required minimum balance of %.2f.%n",
                    this.minimumBalance
            );
        }
        else {
            this.balance = remaining;
            System.out.printf("Transaction successful. Amount withdraw: %.2f. Updated Savings Account balance: %.2f.%n", amount, this.balance);
        }
    }
}

class Current extends Accounts {
    float balance;

    Current(int id, String accountHolderName, float balance) {
        super(id, accountHolderName);
        this.balance = balance;
    }

    void deposit(float amount) {
        this.balance += amount;
        System.out.printf("Transaction successful. Amount deposited: %.2f. Updated Current Account balance: %.2f.%n", amount, this.balance);
    }

    void withdraw(float amount) {
        float remaining = this.balance - amount;
        if (remaining < 0) {
            System.out.print("Transaction declined: insufficient available balance to process the requested withdrawal.");
        }
        else {
            System.out.printf("Transaction successful. Amount withdraw: %.2f. Updated Current Account balance: %.2f.%n", amount, this.balance);
        }
    }
}