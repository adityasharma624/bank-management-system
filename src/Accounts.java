abstract class Accounts {
    int id;
    String accountHolderName;
    int pin;
    Accounts(int id, String accountHolderName) {
        this.id = id;
        this.accountHolderName = accountHolderName;
    }

    abstract boolean deposit(float amount);
    abstract boolean withdraw(float amount);
    abstract void getAccountInfo();
}