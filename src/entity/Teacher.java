package entity;

import java.util.ArrayList;

public class Teacher extends Human {
    private Double salary;
    private final ArrayList<Student> students = new ArrayList<>();

    public Teacher(String name, String surname, Integer age, String email, Double salary) {
        super(name, surname, age, email);
        this.salary = salary;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public String toString() {
        return getName()+" "+getSurname()+"\n"+getAge()+"\n"+getEmail()+"\n"+getStudents()+ "\n" +getSalary()+"\n";
    }
}
