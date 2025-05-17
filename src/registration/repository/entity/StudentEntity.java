package registration.repository.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class StudentEntity extends HumanEntity {
    private BigDecimal scholarship;
    private Integer uni_id;

    public StudentEntity( String name, String surname, Integer age, String email, BigDecimal scholarship) {
        super(null, name, surname, age, email);
        this.scholarship = scholarship;
    }

    public StudentEntity(Integer id, String name, String surname, Integer age, String email, BigDecimal scholarship,
                         Integer uni_id) {
        super(id, name, surname, age, email);
        this.scholarship = scholarship;
        this.uni_id = uni_id;
    }

    @Override
    public String toString() {
        return
                "id='" + getId() + '\'' +
                "name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", age=" + getAge() +
                ", email='" + getEmail() + '\'' +
                ", scholarship=" + scholarship ;
    }
}
