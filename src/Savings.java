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

    boolean deposit(float amount) {
        this.balance += amount;
        System.out.printf("Transaction successful. Amount deposited: %.2f. Updated Savings Account balance: %.2f.%n", amount, this.balance);
        return true;
    }

    boolean withdraw(float amount) {
        float remaining = this.balance - amount;
        if (remaining < minimumBalance) {
            return false;
        }
        this.balance = remaining;
        return true;
    }

    void getAccountInfo() {
        System.out.println("Savings Account Information:");
        System.out.printf("Account Holder Name: %s%nAccount ID: %d%nBalance: %f%n",this.accountHolderName, this.id, this.balance);
    }
}