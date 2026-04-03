abstract class Accounts {
    double balance;
    double minimumAccountBalance;

    Accounts(double balance, double minimumAccountBalance) {
        this.balance = balance;
        this.minimumAccountBalance = minimumAccountBalance;
    }

    abstract boolean deposit(double amount);
    abstract boolean withdraw(double amount);
    abstract void getInfo();
}
