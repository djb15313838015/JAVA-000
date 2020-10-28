package com.dujingbo.one;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;
import org.openjdk.jol.vm.VM;

import java.util.*;

/**
 * @package: PACKAGE_NAME
 * @program: JAVA-000
 * @description:
 * @author: <a href="dujingbo@jd.com">Mr.Du</a>
 * @create: 2020-10-23
 **/
public class JolDemo {

    static Object generate(){
        Map<String, Object> map = new HashMap<>();
        map.put("a", new Integer(1));
        map.put("b", "b");
        map.put("c", new Date());

        for (int i = 0; i < 10; i++) {
            map.put(String.valueOf(i), String.valueOf(i));
        }
        return map;
    }

    static Object generate1(){
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        return list;
    }

    static Object generate2(){
        int[] ints = new int[10];
        for (int i = 0; i < 10; i++) {
            ints[i] = i;
        }
        return ints;
    }

    static Object generate3(){
        Integer[] ints = new Integer[10];
        for (int i = 0; i < 10; i++) {
            ints[i] = i;
        }
        return ints;
    }

    static class A{
        int result0;
        Integer result;
    }

    static void print(String message) {
        System.out.println(message);
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {
        System.out.println(VM.current().details());
        /*Integer[] obj = new Integer[3];
        obj[0] = 1;
        obj[1] = 1;
        obj[2] = 1;*/
        B obj = new B();
        /*obj[1] = new Object();*/
        //查看对象内部信息
        print("对象内部信息: " + ClassLayout.parseInstance(obj).toPrintable());
        //查看对象外部信息
        print("对象外部信息: " + GraphLayout.parseInstance(obj).toPrintable());

        //获取对象总大小
        print("size : " + GraphLayout.parseInstance(obj).totalSize());

        print("headerSize : " + ClassLayout.parseInstance(obj).headerSize());
        print("instanceSize : " + ClassLayout.parseInstance(obj).instanceSize());
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
