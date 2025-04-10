package service;

import entity.HumanWrapper;
import service.FileUtility.FileUtil;

public class Database {

    public static final String FILENAME = "database.obj";
    public static HumanWrapper HUMAN_WRAPPER;

    public static HumanWrapper getHumanWrapper() {
        HumanWrapper humanWrapper = (HumanWrapper) FileUtil.readObjectFromFile(FILENAME);

        return humanWrapper == null ? new HumanWrapper() : humanWrapper;
    }

    public static void save() {
        FileUtil.writeObjectToFile(HUMAN_WRAPPER, FILENAME);
    }

    public static void init(boolean saveToFile) {
        if(saveToFile) {
            HUMAN_WRAPPER = getHumanWrapper();
        }
        HUMAN_WRAPPER = new HumanWrapper();
    }

}
