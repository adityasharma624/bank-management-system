abstract class Accounts {
    double balance;
    double minimumAccountBalance;

    Accounts(double balance, double minimumAccountBalance) {
        this.balance = balance;
        this.minimumAccountBalance = minimumAccountBalance;
    }

    abstract int deposit(double amount);
    abstract int withdraw(double amount);
    abstract void getInfo();
}
