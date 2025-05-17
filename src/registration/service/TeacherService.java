package registration.service;

import registration.repository.StudentRepository;
import registration.repository.TeacherRepository;
import registration.repository.entity.HumanEntity;
import registration.repository.entity.StudentEntity;
import registration.repository.entity.TeacherEntity;
import registration.service.dto.HumanDto;
import registration.service.dto.StudentDto;
import registration.service.dto.TeacherDto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherService extends AbstractEducationService {

    TeacherRepository teacherRepository = new TeacherRepository();
    StudentRepository studentRepository = new StudentRepository();

    public TeacherService() {
        super(new ArrayList<>());
    }

    @Override
    public TeacherDto register() { // stays, special to Teacher
        System.out.println("Enter teacher's name");
        String name = new Scanner(System.in).nextLine();

        System.out.println("Enter teacher's surname");
        String surname = new Scanner(System.in).nextLine();

        System.out.println("Enter teacher's age");
        int age = new Scanner(System.in).nextInt();

        System.out.println("Enter teacher's email");
        String email = new Scanner(System.in).nextLine();

        System.out.println("Enter salary");
        BigDecimal salary = new Scanner(System.in).nextBigDecimal();

        TeacherEntity teacher = teacherRepository.register(new TeacherEntity(name, surname, age, email, salary));

        TeacherDto teacherDto = new TeacherDto(teacher.getId(), teacher.getName(), teacher.getSurname(),
                teacher.getAge(), teacher.getEmail(), teacher.getSalary());

        return teacherDto;
    }

    public void addStudentsToTeacher() { //stays, special to Teacher
        System.out.println("Enter the name of the teacher you want to add students to");
        String search_name = new Scanner(System.in).nextLine();
        System.out.println("Enter the surname of the teacher you want to add students to");
        String search_surname = new Scanner(System.in).nextLine();
        System.out.println("Enter the email of the teacher you want to add students to");
        String search_email = new Scanner(System.in).nextLine();
        List<TeacherEntity> result = teacherRepository.findBy(search_name, search_surname, search_email);

        System.out.println("Enter the ID of the teacher you want to update");
        int teacher_id = new Scanner(System.in).nextInt();
        TeacherEntity myTeacher = teacherRepository.findByID(teacher_id);

        System.out.println("Enter the ID of the student you want to add to the teacher");
        int student_id = new Scanner(System.in).nextInt();
        StudentEntity myStudents = studentRepository.findByID(student_id);

        teacherRepository.addStudentsToTeacher(myTeacher, myStudents);


//        String continueToAdd = "yes";
//        while (continueToAdd.equalsIgnoreCase("yes")) {
//            System.out.println("Which student do you want to add?");
//            int index = new Scanner(System.in).nextInt();
//
//            System.out.println("Do you want to add another student?");
//            continueToAdd = new Scanner(System.in).nextLine();
//        }



    }

    @Override
    public int showMenu() { // stays, special
        System.out.println("Please enter the operation:\n" +
                "1. Register\n"+
                "2. Delete\n"+
                "3. Search\n"+
                "4. Show all\n"+
                "5. Update\n"+
                "6. Add student to Teacher\n");

        return new Scanner(System.in).nextInt();
    }

    @Override
    public void showAll() {
        List<TeacherEntity> list = teacherRepository.getAll();

        List<TeacherDto> result = new ArrayList<>();
        for(TeacherEntity teacher : list) {
            result.add(new TeacherDto(teacher.getId(), teacher.getName(), teacher.getSurname(),
                    teacher.getAge(), teacher.getEmail(), teacher.getSalary()));
        }

        for (TeacherDto teachers: result) {
            System.out.println(teachers);
        }
    }

    @Override
    public void deleteByID(int id) {
        teacherRepository.deleteByID(id);
    }

    @Override
    public void executeSelectedMenu(int selectedMenu) { // stays, special
        switch (selectedMenu) {
            case 1-> register();
            case 2-> delete();
            case 3-> search();
            case 4-> showAll();
            case 5-> update();
            case 6-> addStudentsToTeacher();
        }
    }
    @Override
    public void update() {
        System.out.println("Enter the id of the teacher you want to update");
        int id = new Scanner(System.in).nextInt();

        System.out.println("Enter the name");
        String name = new Scanner(System.in).nextLine();

        System.out.println("Enter the surname");
        String surname = new Scanner(System.in).nextLine();

        System.out.println("Enter the age");
        int age = new Scanner(System.in).nextInt();

        System.out.println("Enter the email");
        String email = new Scanner(System.in).nextLine();

        System.out.println("Enter the salary");
        BigDecimal salary = new Scanner(System.in).nextBigDecimal();

        System.out.println("Enter university id");
        int uni_id = new Scanner(System.in).nextInt();
        TeacherEntity teachers = new TeacherEntity(id, name, surname, age, email, salary, uni_id);

        teacherRepository.update(teachers);
    }

    @Override
    public void search() {
        System.out.println("Enter the name you want to search");
        String name = new Scanner(System.in).nextLine();

        System.out.println("Enter the surname you want to search");
        String surname = new Scanner(System.in).nextLine();

        System.out.println("Enter the email you want to search");
        String email = new Scanner(System.in).nextLine();

        teacherRepository.findBy(name, surname, email);

    }

}
