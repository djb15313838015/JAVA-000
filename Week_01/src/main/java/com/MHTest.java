package com;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @package: com.dujingbo
 * @program: JAVA-000
 * @description:
 * @author: <a href="dujingbo@jd.com">Mr.Du</a>
 * @create: 2020-10-16
 **/
public class MHTest {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException {
        final MethodType methodType = MethodType.methodType(int.class, Boolean.class);
        final MethodHandles.Lookup lookup = MethodHandles.lookup();
        lookup.findVirtual(MHSuper.class, "x", methodType);
    }
}

class MHSuper{
    public static int y(Boolean a){
        System.out.println("super::static");
        return 1;
    }

    public static int z(Boolean a){
        System.out.println("super::static");
        return 1;
    }

    public int x(boolean a){
        System.out.println("super::primitive");
        return 1;
    }
    public int x(Boolean a){
        System.out.println("super::boxed");
        return 1;
    }
}

class MHSub extends MHSuper {
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
