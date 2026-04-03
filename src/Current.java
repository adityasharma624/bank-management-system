class Current extends Accounts{
    double overdraftLimit;

    Current(double balance, double minimumAccountBalance, double overdraftLimit) {
        super(balance, minimumAccountBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    int deposit(double amount) {
        if (amount <= 0) return -1;
        this.balance = amount;
        return 0;
    }

    @Override
    int withdraw(double amount) {
        if (this.balance - amount >= this.minimumAccountBalance && this.balance - amount <= overdraftLimit) {
            this.balance -= amount;
            return 0;
        }
        return -1;
    }

    @Override
    void getInfo() {
        System.out.println("Type of Account: Current");
        System.out.printf("Current Balance: %f%n", this.balance);
        System.out.printf("Overdraft Limit: %f%n", this.overdraftLimit);
    }
}
