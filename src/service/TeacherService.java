package service;

import entity.Human;
import entity.Student;
import entity.Teacher;
import service.proxy.Annotable;

import java.util.Scanner;
import static service.Database.HUMAN_WRAPPER;
import static service.proxy.ProxyUtil.save;

public class TeacherService extends AbstractEducationService {

    private TeacherService() {
        super(HUMAN_WRAPPER.teacher);
    }

    private static TeacherService instance;

    @Override
    public Teacher register() { // stays, special to Teacher
        System.out.println("Enter teacher's name");
        String name = new Scanner(System.in).nextLine();

        System.out.println("Enter teacher's surname");
        String surname = new Scanner(System.in).nextLine();

        System.out.println("Enter teacher's age");
        int age = new Scanner(System.in).nextInt();

        System.out.println("Enter teacher's email");
        String email = new Scanner(System.in).nextLine();

        System.out.println("Enter salary");
        Double salary = new Scanner(System.in).nextDouble();

        Teacher teacher = new Teacher(name, surname, age, email, salary);

        list.add(teacher);
        return teacher;
    }

    public void addStudentsToTeacher() { //stays, special to Teacher
        Teacher found = (Teacher) search(); // casting Teacher to Human type

        if(found==null) { //wrong input inserted
            System.out.println("Teacher not found");
            return;
        }

        for(int i = 0; i< HUMAN_WRAPPER.students.size(); i++) { // cant change Db.Students to list, not superclass
            System.out.println(i+". "+ HUMAN_WRAPPER.students.get(i));
        }

        String continueToAdd = "yes";
        while (continueToAdd.equalsIgnoreCase("yes")) {
            System.out.println("Which student do you want to add?");
            int index = new Scanner(System.in).nextInt();
            Student selectedStudent = (Student) HUMAN_WRAPPER.students.get(index); // casting, cant change to list, not superclass
            found.getStudents().add(selectedStudent); // teacher-in student siyahisina elave et

            System.out.println("Do you want to add another student?");
            continueToAdd = new Scanner(System.in).nextLine();
        }



    }

    @Override
    public int showMenu() { // stays, special
        System.out.println("Please enter the operation:\n" +
                "1. Register\n"+
                "2. Delete\n"+
                "3. Search\n"+
                "4. Show all\n"+
                "5. Add student to Teacher\n");

        return new Scanner(System.in).nextInt();
    }

    @Override
    public void executeSelectedMenu(int selectedMenu) { // stays, special
        switch (selectedMenu) {
            case 1-> register();
            case 2-> delete();
            case 3-> search();
            case 4-> showAll();
            case 5-> addStudentsToTeacher();
        }
    }

    public static TeacherService instance(boolean isSave) {
        if(instance == null) {
            if(isSave) {
                instance = new TeacherService$Proxy(new TeacherService());
            } else{
                instance = new TeacherService();
            }
        } return instance;
    }

    private static class TeacherService$Proxy extends TeacherService {

        private final TeacherService teacherService;

        public TeacherService$Proxy(TeacherService teacherService) {
            this.teacherService = teacherService;
        }


        @Override
        @Annotable
        public Teacher register() {
            Teacher teacher = this.teacherService.register();
            save("register", TeacherService.class);
            return teacher;
        }

        @Override
        public void showAll() {
            this.teacherService.showAll();
        }

        @Override
        public Human search() {
            return this.teacherService.search();
        }

        @Override
        @Annotable
        public void delete() {
            this.teacherService.delete();
            save("delete", TeacherService.class);
        }

        @Override
        public int showMenu() {
            return this.teacherService.showMenu();
        }
        @Override
        public void addStudentsToTeacher() {
            this.teacherService.addStudentsToTeacher();
            save("addStudentsToTeacher", TeacherService.class);
        }

        @Override
        public void executeSelectedMenu(int selectedMenu) {
            this.teacherService.executeSelectedMenu(selectedMenu);
        }
    }

}
