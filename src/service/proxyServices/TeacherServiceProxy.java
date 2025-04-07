package service.proxyServices;

import entity.Human;
import entity.Teacher;
import service.EducationService;
import service.TeacherService;

public class TeacherServiceProxy implements EducationService {
    private TeacherService proxyService;
    @Override
    public Teacher register() {
        if(proxyService==null) {
            proxyService = new TeacherService();
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
            proxyService = new TeacherService();
        }
        return proxyService.search();
    }

    @Override
    public void delete() {
        if(proxyService==null) {
            proxyService = new TeacherService();
        }
        proxyService.delete();
    }

    @Override
    public int showMenu() {
        if(proxyService==null) {
            proxyService = new TeacherService();
        }
        return proxyService.showMenu();
    }
}
