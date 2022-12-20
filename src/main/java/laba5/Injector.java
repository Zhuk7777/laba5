package laba5;

import java.util.Properties;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.io.FileInputStream;


/**
 * A class with one method
 * @see Injector#inject(Object, String) 
 */
public class Injector {
    /**
     *The  method, which takes an
     * object of any class as a parameter and, using
     * reflection mechanisms, searches for fields marked
     * with annotation and initializes these fields
     * with instances of classes that are specified as the implementation
     * of the corresponding interface in some
     * settings file
     * @param object - an empty object of any class
     * @param path - the path to the settings file
     * @return filled object
     * @throws IOException
     */
    public Object inject(Object object,String path) throws IOException {
        if (object==null) {
            throw new IOException();
        }
        Properties properties = new Properties();
        Class<?> anyClass = object.getClass();

        InputStream in =  new FileInputStream(path);

        try {
            properties.load(in);

            for (Field field : anyClass.getDeclaredFields()) {
                AutoInjectable annotation = field.getAnnotation(AutoInjectable.class);
                if (annotation != null ) {
                    field.setAccessible(true);


                    try {
                        Object name = Class.forName(properties.getProperty(field.getName())).newInstance();//Try create class instance by name
                        field.set(object, name);
                        }
                    catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                            System.out.println(e.getMessage());
                        }
                }
            }
        }
        catch (IOException e) {
                System.out.println(e.getMessage());
            }

        return object;
    }
}