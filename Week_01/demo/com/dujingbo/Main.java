package com.dujingbo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @package: com.dujingbo
 * @program: JAVA-000
 * @description:
 * @author: <a href="dujingbo@jd.com">Mr.Du</a>
 * @create: 2020-10-16
 **/
public class Main {
    public static void main(String[] args) {
        try {
            Method method = Super.class.getMethod("x", boolean.class);
            method.invoke(new Super(), false);
            method.invoke(new Super(), Boolean.FALSE);
            method.invoke(new Sub(), false);
            method.invoke(new Sub(), Boolean.FALSE);

            method = Sub.class.getMethod("x", Boolean.class);
            method.invoke(new Sub(), false);
            method.invoke(new Sub(), Boolean.FALSE);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

class Super{
    public int x(boolean a){
        System.out.println("super::primitive");
        return 1;
    }
    public int x(Boolean a){
        System.out.println("super::boxed");
        return 1;
    }
}

class Sub extends Super {
    @Override
    public int x(boolean a) {
        System.out.println("sub::primitive");
        return 1;
    }

    @Override
    public int x(Boolean a) {
        System.out.println("sub::boxed");
        return 1;
    }
}
