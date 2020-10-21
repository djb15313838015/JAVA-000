package com.dujingbo;

import java.lang.reflect.InvocationTargetException;
import java.util.Base64;

/**
 * @package: com.dujingbo
 * @program: JAVA-000
 * @description: 自定义类加载器
 * @author: <a href="dujingbo@jd.com">Mr.Du</a>
 * @create: 2020-10-16
 **/
public class HelloClassLoader extends ClassLoader {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        try {
            final Object instance = new HelloClassLoader().findClass("com.dujingbo.Hello").getDeclaredConstructor().newInstance();
            System.out.println(instance.getClass().getClassLoader());
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String helloBase64 = "yv66vgAAADQAHwoABgARCQASABMIABQKABUAFgcAFwcAGAEABjxpbml0PgEAAygpVgEABENvZGUB" +
                "AA9MaW5lTnVtYmVyVGFibGUBABJMb2NhbFZhcmlhYmxlVGFibGUBAAR0aGlzAQAUTGNvbS9kdWpp" +
                "bmdiby9IZWxsbzsBAAg8Y2xpbml0PgEAClNvdXJjZUZpbGUBAApIZWxsby5qYXZhDAAHAAgHABkM" +
                "ABoAGwEAGEhlbGxvIENsYXNzIEluaXRpYWxpemVkIQcAHAwAHQAeAQASY29tL2R1amluZ2JvL0hl" +
                "bGxvAQAQamF2YS9sYW5nL09iamVjdAEAEGphdmEvbGFuZy9TeXN0ZW0BAANvdXQBABVMamF2YS9p" +
                "by9QcmludFN0cmVhbTsBABNqYXZhL2lvL1ByaW50U3RyZWFtAQAHcHJpbnRsbgEAFShMamF2YS9s" +
                "YW5nL1N0cmluZzspVgAhAAUABgAAAAAAAgABAAcACAABAAkAAAAvAAEAAQAAAAUqtwABsQAAAAIA" +
                "CgAAAAYAAQAAAAoACwAAAAwAAQAAAAUADAANAAAACAAOAAgAAQAJAAAAJQACAAAAAAAJsgACEgO2" +
                "AASxAAAAAQAKAAAACgACAAAADAAIAA0AAQAPAAAAAgAQ";
        final byte[] bytes = decode(helloBase64);
        return defineClass(name, bytes, 0, bytes.length);
    }

    public byte[] decode(String base64) {
        return Base64.getDecoder().decode(base64);
    }
}
