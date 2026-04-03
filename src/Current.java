class Current extends Accounts{
    double overdraftLimit;

    Current(double balance, double minimumAccountBalance, double overdraftLimit) {
        super(balance, minimumAccountBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    boolean deposit(double amount) {
        if (amount <= 0) return false;
        this.balance += amount;
        return true;
    }

    @Override
    boolean withdraw(double amount) {
        if (this.balance - amount >= this.minimumAccountBalance && this.balance - amount <= overdraftLimit) {
            this.balance -= amount;
            return true;
        }
        return false;
    }

    @Override
    void getInfo() {
        System.out.println("Type of Account: Current");
        System.out.printf("Current Balance: %f%n", this.balance);
        System.out.printf("Overdraft Limit: %f%n", this.overdraftLimit);
    }
}
