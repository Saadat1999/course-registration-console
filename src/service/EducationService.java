package service;
import entity.Human;
import service.proxyServices.StudentServiceProxy;
import service.proxyServices.TeacherServiceProxy;

import java.util.Scanner;

public interface EducationService {


    Human register();

    void showAll();

    Human search();

    void delete();

    int showMenu();

    default void executeSelectedMenu(int selectedMenu) {
        switch (selectedMenu) {
            case 1-> register();
            case 2-> delete();
            case 3-> search();
            case 4-> showAll();
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
                "3. Exit");

        int index = new Scanner(System.in).nextInt();
        if(index==1) {
            return ObjectCreator.checkStudent(); // call invokes proxy service which has private object of real service inside
        } else if(index==2) {
            return ObjectCreator.checkTeacher();
        } else if(index==3) {
            System.out.println("Exited");
            System.exit(1);
        }
        System.out.println("No such option");
        return null;
    }
}
