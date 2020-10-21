package com.dujingbo;


import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

/**
 * @package: com.dujingbo
 * @program: JAVA-000
 * @description: Java类加载器加载目录
 * @author: <a href="dujingbo@jd.com">Mr.Du</a>
 * @create: 2020-10-16
 **/
public class JvmClassLoaderPrintPath {

    public static void main(String[] args) {
        //方法一：
        /*System.out.println("启动类加载器：");
        Arrays.stream(System.getProperty("sun.boot.class.path").split(";")).forEach(System.out::println);
        System.out.println("=====================================================");
        System.out.println("扩展类加载器：");
        Arrays.stream(System.getProperty("java.ext.dirs").split(";")).forEach(System.out::println);
        System.out.println("=====================================================");
        System.out.println("应用类加载器：");
        Arrays.stream(System.getProperty("java.class.path").split(";")).forEach(System.out::println);
        System.out.println("=====================================================");*/
        //方法二：
        System.out.println("启动类加载器：");
        //Arrays.stream(Launcher.getBootstrapClassPath().getURLs()).forEach(System.out::println);

        printClassLoader("扩展类加载器: ", JvmClassLoaderPrintPath.class.getClassLoader().getParent());
        printClassLoader("应用类加载器: ", JvmClassLoaderPrintPath.class.getClassLoader());

    }

    private static void printClassLoader(String s, ClassLoader classLoader) {
        if (classLoader == null) {
            System.out.println("ClassLoader is null");
        }
        System.out.println(s);
        printURLClassLoader(classLoader);
    }

    private static void printURLClassLoader(ClassLoader classLoader) {

        final Object ucp = insightField(classLoader, "ucp");
        final Object path = insightField(ucp, "path");
        if(path instanceof ArrayList){
            ArrayList<URL> arrayList = (ArrayList) path;
            arrayList.forEach(System.out::println);
        }
    }

    private static Object insightField(Object classLoader, String filedName) {
        Field field;
        try {
            if (classLoader instanceof URLClassLoader) {
                field = URLClassLoader.class.getDeclaredField(filedName);
            } else {
                field = classLoader.getClass().getDeclaredField(filedName);
            }
            field.setAccessible(true);
            return field.get(classLoader);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
