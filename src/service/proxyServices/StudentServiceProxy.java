package service.proxyServices;

import entity.Human;
import entity.Student;
import service.EducationService;
import service.StudentService;


public class StudentServiceProxy implements EducationService { // by implementing main Interface it creates a proxy service
    private StudentService proxyService;

    public StudentServiceProxy() {

    }
    @Override
    public Student register() { // calls real service, assigns to its proxy service and returns it
        if(proxyService==null) {
            proxyService= new StudentService();
        }
        return proxyService.register();
    }

    @Override
    public void showAll() {
        proxyService.showAll();
    }

    @Override
    public Human search() {
        if(proxyService==null) {
            new StudentService();
        }
        return proxyService.search();
    }

    @Override
    public void delete() {
        if (proxyService==null) {
            proxyService= new StudentService();
        }
        proxyService.delete();
    }

    @Override
    public int showMenu() {
        if(proxyService==null) {
            proxyService = new StudentService();
        }
        return proxyService.showMenu();
    }


}
