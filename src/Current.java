class Current extends Accounts {
    float balance;

    Current(int id, String accountHolderName, float balance) {
        super(id, accountHolderName);
        this.balance = balance;
    }

    boolean deposit(float amount) {
        if (amount <= 0) return false;
        this.balance += amount;
        return true;
    }

    boolean withdraw(float amount) {
        float remaining = this.balance - amount;
        if (remaining < 0) {
            return false;
        }
        this.balance = remaining;
        return true;
    }

    void getAccountInfo() {
        System.out.println("Current Account Information");
        System.out.printf("Account Holder Name: %s%nAccount ID: %d%nBalance: %f%n", this.accountHolderName, this.id, this.balance);
    }
}