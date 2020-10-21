package com.dujingbo;

import java.io.*;
import java.lang.invoke.MethodHandle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @package: com.dujingbo
 * @program: JAVA-000
 * @description:
 * @author: <a href="dujingbo@jd.com">Mr.Du</a>
 * @create: 2020-10-16
 **/
public class MyClassLoader extends ClassLoader {

    private final File file;

    public MyClassLoader(File file) {
        this.file = file;
    }

    public static void main(String[] args) {
        try {

            Class<?> hello = new MyClassLoader(new File("E:", "/study/geekbang/Week-01/Hello/Hello.xlass")).findClass("Hello");
            System.out.println(hello.getClassLoader());
            Object h1 = hello.getDeclaredConstructor().newInstance();
            Method method = hello.getMethod("hello");
            method.invoke(h1);
            /*final Object instance = new MyClassLoader(new File("E:", "/study/geekbang/Week-01/Hello/Hello.xlass")).findClass("Hello").getDeclaredConstructor().newInstance();
            System.out.println(instance.getClass().getClassLoader());
            Method method = instance.getMethod("hello");
            method.invoke(h1);*/
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        final byte[] bytes = readIn(file);
        return defineClass(name, bytes, 0, bytes.length);
    }

    private byte[] readIn(File file) {
        try (FileInputStream is = new FileInputStream(file);
             ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
            final byte[] bytes = bos.toByteArray();
            byte[] newBytes = new byte[bytes.length];
            for (int i = 0; i < bytes.length; i++) {
                newBytes[i] = (byte) (255 - bytes[i]);
            }
            return newBytes;
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }
}
