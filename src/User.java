import java.util.List;

class User {
    String name;
    private int pin;
    Savings saving;
    Current current;

    public User(String name, int pin) {
        this.name = name;
        this.pin = pin;
    }

    public String getName() {
        return name;
    }

    public int getPin() {
        return pin;
    }

    public List<Accounts> getAccountlist() { return accountlist; }
}
