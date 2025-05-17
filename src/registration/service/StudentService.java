package registration.service;

import registration.repository.StudentRepository;
import registration.repository.entity.StudentEntity;
import registration.service.dto.StudentDto;

import java.math.BigDecimal;
import java.util.*;

public class StudentService extends AbstractEducationService {

    StudentRepository studentRepository = new StudentRepository();


    protected StudentService() {
        super(new ArrayList<>());
    }

    @Override
    public StudentDto register() {
        System.out.println("Enter student's name");
        String name = new Scanner(System.in).nextLine();

        System.out.println("Enter student's surname");
        String surname = new Scanner(System.in).nextLine();

        System.out.println("Enter student's age");
        int age = new Scanner(System.in).nextInt();

        System.out.println("Enter student's email");
        String email = new Scanner(System.in).nextLine();

        System.out.println("Enter scholarship");
        BigDecimal scholarship = new Scanner(System.in).nextBigDecimal();

        StudentEntity students = studentRepository.register(new StudentEntity(name, surname, age, email,
                scholarship));
        StudentDto result = new StudentDto(students.getId(), students.getName(), students.getSurname(), students.getAge(),
                students.getEmail(), students.getScholarship());
        return result;
    }


    @Override
    public void showAll() {
        List<StudentEntity> list = studentRepository.getAll();
        List<StudentDto> result = new ArrayList<>();
        for(StudentEntity student : list) {
            result.add(new StudentDto(student.getId(), student.getName(), student.getSurname(), student.getAge(), student.getEmail(),
                    student.getScholarship()));
        }

        for (StudentDto student: result) {
            System.out.println(student);
        }
    }



    public void deleteByID(int id) {
        studentRepository.deleteByID(id);
    }

    @Override
    public void update() {
        System.out.println("Enter the id of the student you want to update");
        int search_id = new Scanner(System.in).nextInt();

        System.out.println("Enter student's name");
        String name = new Scanner(System.in).nextLine();

        System.out.println("Enter student's surname");
        String surname = new Scanner(System.in).nextLine();

        System.out.println("Enter student's age");
        int age = new Scanner(System.in).nextInt();

        System.out.println("Enter scholarship");
        BigDecimal scholarship = new Scanner(System.in).nextBigDecimal();

        System.out.println("Enter student's email");
        String email = new Scanner(System.in).nextLine();

        System.out.println("Enter university ID");
        int uni_id = new Scanner(System.in).nextInt();

        StudentEntity student = new StudentEntity(search_id, name, surname, age, email, scholarship, uni_id);

        studentRepository.update(student);
    }

    @Override
    public void search() {
        System.out.println("Enter the name you want to search");
        String name = new Scanner(System.in).nextLine();

        System.out.println("Enter the surname you want to search");
        String surname = new Scanner(System.in).nextLine();

        System.out.println("Enter the email you want to search");
        String email = new Scanner(System.in).nextLine();

        List<StudentEntity> myList = studentRepository.findBy(name, surname, email);

        for(StudentEntity student : myList) {
            System.out.println(student);
        }
    }
}
