abstract class Accounts {
    int id;
    String accountHolderName;
//    int pin;
    Accounts(int id, String accountHolderName) {
        this.id = id;
        this.accountHolderName = accountHolderName;
    }

    abstract void deposit(float amount);
    abstract void withdraw(float amount);
    abstract void getAccountInfo();
}