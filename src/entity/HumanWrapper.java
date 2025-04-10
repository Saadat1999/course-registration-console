package entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HumanWrapper implements Serializable {

    @Serial
    public static final long serialVersionUID = 1L;
    public List<Human> teacher = new ArrayList<>();
    public List<Human> students = new ArrayList<>();

    public String toString() {
        return teacher.toString()+students.toString();
    }
}
