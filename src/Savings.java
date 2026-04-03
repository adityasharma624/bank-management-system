class Savings extends Accounts{
    float interest;

    Savings(double balance, double minimumAccountBalance, float interest) {
        super(balance, minimumAccountBalance);
        this.interest = interest;
    }

    @Override
    int deposit(double amount) {
        if (amount <= 0) return -1;
        this.balance = amount;
        return 0;
    }

    @Override
    int withdraw(double amount) {
        if (this.balance - amount >= this.minimumAccountBalance) {
            this.balance -= amount;
            return 0;
        }
        return -1;
    }

    @Override
    void getInfo() {
        System.out.println("Type of Account: Current");
        System.out.printf("Current Balance: %f%n", this.balance);
        System.out.printf("Minimum Account Balance: %f%n", this.minimumAccountBalance);
        System.out.printf("Interest: %f/%%n", this.interest);
    }
}
