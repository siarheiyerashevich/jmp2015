package com.epam.module5.classloader;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CustomClassLoader extends ClassLoader {

    private final Map<String, Class<?>> classes = new HashMap<>();

    @Override
    public String toString() {
        return CustomClassLoader.class.getName();
    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        if (classes.containsKey(name)) {
            return classes.get(name);
        }
        byte[] classData = null;
        try {
            classData = loadClassData(name);
        } catch (IOException exception) {
        }
        Class<?> c = defineClass(name, classData, 0, classData.length);
        resolveClass(c);
        classes.put(name, c);
        return c;
    }

    private byte[] loadClassData(String name) throws IOException {
        System.out.println("STATUS: in progress");
        BufferedInputStream in = new BufferedInputStream(ClassLoader.getSystemResourceAsStream(name.replace(".", "/") + ".class"));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int i;
        while ((i = in.read()) != -1) {
            out.write(i);
        }
        in.close();
        byte[] classData = out.toByteArray();
        out.close();
        return classData;
    }

}
