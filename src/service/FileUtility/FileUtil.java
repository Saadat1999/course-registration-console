package service.FileUtility;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FileUtil {
    private static final Logger LOGGER = Logger.getLogger(FileUtil.class.getName());

    public static void writeObjectToFile(Object obj, String fileName) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))){
            objectOutputStream.writeObject(obj);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Couldn't write to file ");
        }
    }
    public static Object readObjectFromFile(String fileName) {
        File file = new File(fileName);
        if(!file.exists()) {
            return null;
        }
        try (InputStream inputStream = new FileInputStream(fileName);
             ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)){

            return objectInputStream.readObject();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "File could not be found");
            return null;
        }
    }


}
