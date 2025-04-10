package service;
import entity.Human;
import entity.Student;
import java.util.Scanner;

import static service.Database.HUMAN_WRAPPER;
import static service.proxy.ProxyUtil.save;


public class StudentService extends AbstractEducationService {


    private StudentService() {
        super(HUMAN_WRAPPER.students);
    }

    private static StudentService instance;

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
        return student;
    }


    public static StudentService instance(boolean isSave) { // a static StudentService type var
        if(instance ==null) {                               // restricting the re-instantiation of the object
            if(isSave) {                                    // therefore object is created only once, used anytime
                instance = new StudentService$Proxy(new StudentService());
            } else {
                instance=new StudentService();
            }
        } return instance;
    }

    private static class StudentService$Proxy extends StudentService {

        private final StudentService studentService;

        public StudentService$Proxy(StudentService studentService) {
            this.studentService = studentService;
        }

        @Override
        public Student register() {
            Student student = this.studentService.register();
            save("register", StudentService.class);
            return student;
        }

        @Override
        public void showAll() {
            this.studentService.showAll();
        }

        @Override
        public Human search() {
            return this.studentService.search();
        }

        @Override
        public void delete() {
            this.studentService.delete();
            save("delete", StudentService.class);
        }

        @Override
        public int showMenu() {
            return this.studentService.showMenu();
        }
    }


}
