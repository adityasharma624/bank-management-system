import java.util.HashMap;

class Manager {
    static HashMap<Integer, User> records = new HashMap<>();

    void put(int uid, User customer) {
        records.put(uid, customer);
    }

    boolean isUnique(int uid) {
        if (records.containsKey(uid))
            return false;
        return true;
    }
}
