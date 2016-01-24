package com.epam.module5.controller;

import com.epam.module5.classloader.CustomClassLoader;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Controller {

    public static void main(String[] args) {
        int count = 2;
        while (count-- > 0) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter class full name: ");
                String fullClassName = scanner.next();
                CustomClassLoader loader = new CustomClassLoader();
                Class<?> c = loader.findClass(fullClassName);
                System.out.println("STATUS: success");
                Object o = c.newInstance();
                Method m = c.getMethod("lever");
                System.out.println(m.invoke(o));
            } catch (Exception exception) {
                System.out.println("STATUS: error");
            }
        }
    }

}
