class Savings extends Accounts{
    float interest;

    Savings(double balance, double minimumAccountBalance, float interest) {
        super(balance, minimumAccountBalance);
        this.interest = interest;
    }

    @Override
    boolean deposit(User user, double amount) {
        if (amount <= 0) {
            user.logTransactions("[Failed] Deposit " + amount + " to Savings - Amount in Negative");
            return false;
        }
        this.balance += amount;
        user.logTransactions("[Success] Deposit " + amount + " to Savings");
        return true;
    }

    @Override
    boolean withdraw(User user, double amount) {
        if (this.balance - amount >= this.minimumAccountBalance) {
            this.balance -= amount;
            user.logTransactions("[Success] Withdrawal of " + amount + " from Savings - Insufficient Balance");
            return true;
        }
        user.logTransactions("[Failure] Withdrawal of " + amount + " from Savings");
        return false;
    }

    @Override
    void getInfo() {
        System.out.println("Type of Account: Savings");
        System.out.printf("Current Balance: %f%n", this.balance);
        System.out.printf("Minimum Account Balance: %f%n", this.minimumAccountBalance);
        System.out.printf("Interest: %f/%%n", this.interest);
    }
}
