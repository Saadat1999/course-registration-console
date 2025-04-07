package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HumanWrapper implements Serializable {
    public List<Human> teacher = new ArrayList<>();
    public List<Human> students = new ArrayList<>();

    public String toString() {
        return teacher.toString()+students.toString();
    }
}
