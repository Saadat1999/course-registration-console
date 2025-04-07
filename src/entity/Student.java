package entity;

public class Student extends Human {
    private Double scholarship;

    public Student(String name, String surname, Integer age, String email, Double scholarship) {
        super(name, surname, age, email);
        this.scholarship = scholarship;
    }

    public Double getScholarship() {
        return scholarship;
    }

    public void setScholarship(Double scholarship) {
        this.scholarship = scholarship;
    }

    public String toString() {
        return getName()+" "+getSurname()+", "+getAge()+", "+getEmail()+", "+getScholarship()+".";
    }
}
