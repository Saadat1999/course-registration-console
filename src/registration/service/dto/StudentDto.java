package registration.service.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class StudentDto extends HumanDto {
    private String name;
    private String surname;
    private Integer age;
    private String email;
    private BigDecimal scholarship;

    public StudentDto(Integer id, String name, String surname, Integer age, String email, BigDecimal scholarship) {
        super.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.scholarship = scholarship;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", scholarship=" + scholarship ;
    }
}
