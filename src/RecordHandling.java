import java.io.*;
import java.util.HashMap;

class RecordHandling {
    static final String FILEPATH = "../records/record.txt";

    static {
        if (!new File(FILEPATH).isFile())
        {
            File record = new File(FILEPATH);
            try {
                boolean status = record.createNewFile();
                if (status) System.out.println("Records Initialized...");
                initializeRecords();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static void initializeRecords() throws IOException {
        User admin = new User("admin", null, false, false, 0, 0);
        ObjectOutputStream oos = new RecordHandling().getOutputStream();
        HashMap<Integer, User> map = new HashMap<>();
        map.put(10000, admin);
        oos.writeObject(map);
        oos.close();
    }

    HashMap<Integer, User> getRecords() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = getInputStream();
        return (HashMap<Integer, User>) ois.readObject();
    }

    User getUserInfo(int uid) throws IOException, ClassNotFoundException {
        HashMap<Integer, User> records = getRecords();
        return records.get(uid);
    }

    int authentication(int uid, String password) throws IOException, ClassNotFoundException {
        /*
           -1: user not found
            0: password wrong
            1: user authenticated
         */
        HashMap<Integer, User> records = getRecords();
        if (records.containsKey(uid)) {
            if (records.get(uid).getPassword().equals(password)) {
                return 1;
            }
            else {
                return 0;
            }
        }
        return -1;
    }

    ObjectInputStream getInputStream() throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(FILEPATH)) {}
        catch (IOException e)
        {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
        FileInputStream fileInputStream = new FileInputStream(FILEPATH);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        return objectInputStream;
    }

    ObjectOutputStream getOutputStream() throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(FILEPATH)){}
        catch (IOException e)
        {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
        FileOutputStream fileOutputStream = new FileOutputStream(FILEPATH);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        return objectOutputStream;
    }
}
