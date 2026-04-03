abstract class Accounts {
    double balance;
    double minimumAccountBalance;

    Accounts(double balance, double minimumAccountBalance) {
        this.balance = balance;
        this.minimumAccountBalance = minimumAccountBalance;
    }

    abstract boolean deposit(User user, double amount);
    abstract boolean withdraw(User user, double amount);
    abstract void getInfo();
}
