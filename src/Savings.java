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

    void getAccountInfo() {
        System.out.println("Savings Account Information:");
        System.out.printf("Account Holder Name: %s%nAccount ID: %d%nBalance: %f%n",this.accountHolderName, this.id, this.balance);
    }
}