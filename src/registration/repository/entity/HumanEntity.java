package registration.repository.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class HumanEntity implements Serializable {

    private Integer id;
    private String name;
    private String surname;
    private Integer age;
    private String email;

    public HumanEntity() {

    }
    public HumanEntity(Integer id, String name, String surname, Integer age, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
    }

}
