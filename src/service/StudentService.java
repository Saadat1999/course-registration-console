package service;
import entity.HumanWrapper;
import entity.Student;
import service.FileUtility.FileUtil;

import java.util.Scanner;

import static service.Database.HUMAN_WRAPPER;


public class StudentService extends AbstractEducationService {


    public StudentService() {
        super(Database.STUDENTS);
    }

    @Override
    public Student register() {
        System.out.println("Enter student's name");
        String name = new Scanner(System.in).nextLine();

        System.out.println("Enter student's surname");
        String surname = new Scanner(System.in).nextLine();

        System.out.println("Enter student's age");
        int age = new Scanner(System.in).nextInt();

        System.out.println("Enter student's email");
        String email = new Scanner(System.in).nextLine();

        System.out.println("Enter scholarship");
        Double scholarship = new Scanner(System.in).nextDouble();

        Student student = new Student(name, surname, age, email, scholarship);

        list.add(student);

        FileUtil.writeObjectToFile(HUMAN_WRAPPER);
        System.out.println(FileUtil.readObjectFromFile());
        return student;
    }


}
