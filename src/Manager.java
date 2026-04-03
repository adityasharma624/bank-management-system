import java.util.HashMap;

class Manager {
    static HashMap<Integer, User> records = new HashMap<>();

    void put(int uid, User customer) {
        records.put(uid, customer);
    }

    User getUser(int uid) {
        return records.get(uid);
    }

    boolean exists(int uid) {
        if (records.containsKey(uid))
            return true;
        return false;
    }
}
