import java.io.*;
import java.util.HashMap;

class RecordHandling {
    static final String FILEPATH = "../records/record.txt";

    HashMap<Integer, HashMap<String, String>> getRecord() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = getInputStream();
        return (HashMap<Integer, HashMap<String, String>>) ois.readObject();
    }

    HashMap<Integer, HashMap<String, String>> getUserInfo(int uid) {

    }

    int authentication(int uid, String password) throws IOException, ClassNotFoundException {
        /*
           -1: user not found
            0: password wrong
            1: user authenticated
         */
        HashMap<Integer, HashMap<String, String>> record = getRecord();
        if (record.containsKey(uid)) {
            if (record.get(uid).get("password").equals(password)) {
                return 1;
            }
            else {
                return 0;
            }
        }
        return -1;
    }

    ObjectInputStream getInputStream() throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(FILEPATH)){
        } catch (FileNotFoundException fnfe) {
            File record = new File(FILEPATH);
            record.createNewFile();
            System.out.println("Records Initialized...");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
        FileInputStream fileInputStream = new FileInputStream(FILEPATH);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        return objectInputStream;
    }

    ObjectOutputStream getOutputStream() throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(FILEPATH)){
        } catch (FileNotFoundException fnfe) {
            File record = new File(FILEPATH);
            record.createNewFile();
            System.out.println("Records Initialized...");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
        FileOutputStream fileOutputStream = new FileOutputStream(FILEPATH);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        return objectOutputStream;
    }
}
