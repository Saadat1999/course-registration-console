package registration.service;
import registration.repository.entity.HumanEntity;
import registration.service.dto.HumanDto;

import java.util.Scanner;

public interface EducationService {


    HumanDto register();

    void showAll();

    void search();

    void delete();

    int showMenu();

    void deleteByID(int id);

    void update();


    default void executeSelectedMenu(int selectedMenu) {
        switch (selectedMenu) {
            case 1-> register();
            case 2-> delete();
            case 3-> search();
            case 4-> showAll();
            case 5-> update();
        }
    }

    default void chooseAndExecuteSelectedMenu() {
        int selectedMenu = showMenu();
        executeSelectedMenu(selectedMenu);
    }

    static EducationService chooseService() {
        System.out.println("Please enter the option:\n"+
                "1. Student\n"+
                "2. Teacher\n"+
                "3. Show all\n"+
                "4. Exit");

        int index = new Scanner(System.in).nextInt();
        if(index==1) {
            return new StudentService();
        } else if(index==2) {
            return new TeacherService();
        }
        else if(index==3) {
            TeacherService teacherService = new TeacherService();
            StudentService studentService = new StudentService();
            System.out.println("Which list do you want to see?\n" +
                    "1. Teacher\n"+
                    "2. Student\n");
            int a = new Scanner(System.in).nextInt();
            if(a==1) {
                teacherService.showAll();
            } else if(a==2) {
                studentService.showAll();
            }
        }
        else if(index==4) {
            System.out.println("Exited");
            System.exit(1);
        }
        System.out.println("No such option");
        return null;
    }
}
