public class Current extends Accounts {
    float balance;

    Current(int id, String accountHolderName, float balance) {
        super(id, accountHolderName);
        this.balance = balance;
    }

    void deposit(float amount) {
        this.balance += amount;
        System.out.printf("Transaction successful. Amount deposited: %.2f. Updated Current Account balance: %.2f.%n", amount, this.balance);
    }

    void withdraw(float amount) {
        float remaining = this.balance - amount;
        if (remaining < 0) {
            System.out.print("Transaction declined: insufficient available balance to process the requested withdrawal.");
        }
        else {
            System.out.printf("Transaction successful. Amount withdraw: %.2f. Updated Current Account balance: %.2f.%n", amount, this.balance);
        }
    }

    void getAccountInfo() {
        System.out.println("Current Account Information");
        System.out.printf("Account Holder Name: %s%nAccount ID: %d%nBalance: %f%n", this.accountHolderName, this.id, this.balance);
    }
}