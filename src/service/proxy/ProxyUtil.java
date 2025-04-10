package service.proxy;

import service.Database;

import java.lang.reflect.Method;

public class ProxyUtil {

    public static void save(String name, Class myClass) {
        try {
            Method method = myClass.getMethod(name);
            if(method.isAnnotationPresent(Annotable.class)) {
                Database.save();
            }
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
