class User {
    String name;
    private int pin;
    Current current;
    Savings savings;

    User(String name, int pin, boolean wantCurrent, boolean wantSavings) {
        this.name = name;
        this.pin = pin;
        if (wantCurrent) current = new Current(0, 0);
        if (wantSavings) savings = new Savings(0, 25000, 5);
    }

    boolean checkPin(int pin) {
        return (this.pin == pin);
    }

    boolean internalTransfer(Accounts from, Accounts to, double amount) {
        if (from.withdraw(amount)) {
            if (to.deposit(amount)) {
                return true;
            }
            from.deposit(amount);
        }
        return false;
    }

    void getInfo() {
        System.out.printf("Name: %s%n", this.name);
        System.out.println("Account Information: ");
        if (current != null) current.getInfo();
        if (savings != null) savings.getInfo();
    }

    Accounts getSavings() {
        return savings;
    }

    Accounts getCurrent() {
        return current;
    }
}
