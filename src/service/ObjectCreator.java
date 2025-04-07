package service;

import service.proxyServices.StudentServiceProxy;
import service.proxyServices.TeacherServiceProxy;

public class ObjectCreator {
    public static StudentServiceProxy studentServiceProxy;
    public static TeacherServiceProxy teacherServiceProxy;

    public static StudentServiceProxy checkStudent() {
        if(studentServiceProxy == null) {
            studentServiceProxy = new StudentServiceProxy();
        }
        return studentServiceProxy;
    }

    public static TeacherServiceProxy checkTeacher() {
        if(teacherServiceProxy == null) {
            teacherServiceProxy = new TeacherServiceProxy();
        }
        return teacherServiceProxy;
    }
}
