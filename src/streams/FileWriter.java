package streams;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileWriter {


    public static void writeToFile(String filename, String text) {
        try(FileOutputStream fos = new FileOutputStream(filename, true)) {
            fos.write(text.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
