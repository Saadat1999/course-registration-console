package service;

import entity.Human;
import entity.HumanWrapper;
import service.FileUtility.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class Database {
    public static final HumanWrapper HUMAN_WRAPPER = (HumanWrapper) FileUtil.readObjectFromFile(); //if there's
    // ready file, finds and writes into it in the next call

    public static final List<Human> STUDENTS = HUMAN_WRAPPER.students;
    public static final List<Human> TEACHERS = HUMAN_WRAPPER.teacher;
}
