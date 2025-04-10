package service.proxy;

import entity.Human;
import entity.Student;
import service.Database;
import service.StudentService;
import static service.proxy.ProxyUtil.save;

public class StudentService$Proxy extends StudentService {

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
