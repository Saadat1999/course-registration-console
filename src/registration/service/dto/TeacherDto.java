package registration.service.dto;

import java.math.BigDecimal;

public class TeacherDto extends HumanDto{

    private String name;
    private String surname;
    private Integer age;
    private String email;
    private BigDecimal salary;


    public TeacherDto(Integer id, String name, String surname, Integer age, String email, BigDecimal salary) {
        super.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", salary=" + salary;
    }
}
