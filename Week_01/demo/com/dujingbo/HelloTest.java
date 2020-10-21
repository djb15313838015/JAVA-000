package com.dujingbo;

import java.util.stream.Stream;

/**
 * @package: com.dujingbo
 * @program: JAVA-000
 * @description:
 * @author: <a href="dujingbo@jd.com">Mr.Du</a>
 * @create: 2020-10-16
 **/
public class HelloTest extends HelloSuper implements HelloService {

    private int num = 0;
    private static final int STATIC_FINAL_NUM = 1;
    private static int staticNum = 2;
    private String str = "str";
    private Object object = new Object();

    @Override
    public int addition(int a, int b) {
        return a + b;
    }
    @Override
    public int subtraction(int a, int b) {
        return a - b;
    }

    public static int multiplication(int a, int b) {
        return a * b;
    }

    public static int division(int a, int b) {
        return a / b;
    }

    public static int surplus(int a, int b) {
        return a % b;
    }

    public static void staticLoop(int[] ints) {
        if (ints == null || ints.length == 0) {
            return;
        }
        for (int anInt : ints) {
            System.out.println(anInt);
        }
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
        Stream.of(ints).forEach(System.out::println);
    }

    @Override
    public void loop(int[] ints) {
        if (ints == null || ints.length == 0) {
            return;
        }
        for (int anInt : ints) {
            System.out.println(anInt);
        }
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
        Stream.of(ints).forEach(System.out::println);
    }

    public static void main(String[] args) {

    }

}
