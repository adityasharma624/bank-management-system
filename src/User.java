import java.util.HashMap;

class User {
    String name;
    private String password;
    boolean hasCurrent;
    boolean hasSavings;
    int current;
    int savings;

    public User(String name, String password, boolean hasCurrent, boolean hasSavings, int current, int savings) {
        this.name = name;
        this.password = password;
        this.hasCurrent = hasCurrent;
        this.hasSavings = hasSavings;
        this.current = current;
        this.savings = savings;
    }

    boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public boolean isHasCurrent() {
        return hasCurrent;
    }

    public boolean isHasSavings() {
        return hasSavings;
    }

    public int getCurrent() {
        return current;
    }

    public int getSavings() {
        return savings;
    }
}
