class Current extends Accounts{

    Current(double balance, double minimumAccountBalance) {
        super(balance, minimumAccountBalance);
    }

    @Override
    boolean deposit(User user, double amount) {
        if (amount <= 0) {
            user.logTransactions("[Failed] Deposit " + amount + " to Current - Amount in Negative");
            return false;
        }
        this.balance += amount;
        user.logTransactions("[Success] Deposit " + amount + " to Current");
        return true;
    }

    @Override
    boolean withdraw(User user, double amount) {
        if (this.balance - amount >= this.minimumAccountBalance) {
            this.balance -= amount;
            user.logTransactions("[Success] Withdrawal of " + amount + " from Current - Insufficient Balance");
            return true;
        }
        user.logTransactions("[Failure] Withdrawal of " + amount + " from Current");
        return false;
    }

    @Override
    void getInfo() {
        System.out.println("Type of Account: Current");
        System.out.printf("Current Balance: %f%n", this.balance);
    }
}
