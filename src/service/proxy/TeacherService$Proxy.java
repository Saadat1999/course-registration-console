package service.proxy;

import entity.Human;
import entity.Student;
import entity.Teacher;
import service.Database;
import service.TeacherService;

import static service.proxy.ProxyUtil.save;


public class TeacherService$Proxy extends TeacherService {

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
