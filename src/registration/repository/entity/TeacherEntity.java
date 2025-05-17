package registration.repository.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.ArrayList;

@EqualsAndHashCode(callSuper = false)
@Data
public class TeacherEntity extends HumanEntity {
    private BigDecimal salary;
    private Integer uni_id;
    @Getter
    private final ArrayList<StudentEntity> students = new ArrayList<>();
    public TeacherEntity() {

    }

    public TeacherEntity(String name, String surname, Integer age, String email, BigDecimal salary) {
        super(null, name, surname, age, email);
        this.salary = salary;
    }

    public TeacherEntity(Integer id, String name, String surname, Integer age, String email, BigDecimal salary, Integer uni_id) {
        super(id, name, surname, age, email);
        this.salary = salary;
        this.uni_id = uni_id;
    }


    @Override
    public String toString() {
        return "name=" +getName()+
                "surname=" +getSurname()+
                "age=" +getAge()+
                "email=" +getEmail()+
                "salary=" + salary +
                ", uni_id=" + uni_id +
                ", students=" + students;
    }
}
