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
        User admin = new User("admin", -1);
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

    int authentication(int uid, int pin) throws IOException, ClassNotFoundException {
        /*
            0: wrong credentials
            1: user authenticated
         */
        HashMap<Integer, User> records = getRecords();
        if (records.containsKey(uid) && records.get(uid).getPin() == pin) {
            return 1;
        }
        return 0;
    }

    // returns object input stream
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

    // returns object output stream
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
