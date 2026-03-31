import java.io.*;

class RecordHandling {
    static final String FILEPATH = "../records/record.txt";

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
