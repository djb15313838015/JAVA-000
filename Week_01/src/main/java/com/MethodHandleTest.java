package com;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.Arrays;
import java.util.List;

/**
 * @package: com.dujingbo
 * @program: JAVA-000
 * @description:
 * @author: <a href="dujingbo@jd.com">Mr.Du</a>
 * @create: 2020-10-16
 **/
public class MethodHandleTest {

    public static void main(String[] args) {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        try {
            MethodHandle mh = lookup.findStatic(MethodHandleTest.class, "doubleVal", MethodType.methodType(int.class, int.class));
            List<Integer> dataList = Arrays.asList(1, 2, 3, 4, 5);
            MethodHandleTest.transform(dataList, mh);// 方法做为参数
            for (Integer data : dataList) {
                System.out.println(data);//2,4,6,8,10
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static List<Integer> transform(List<Integer> dataList, MethodHandle handle) throws Throwable {
        for (int i = 0; i < dataList.size(); i++) {
            dataList.set(i, (Integer) handle.invoke(dataList.get(i)));//invoke
        }
        return dataList;
    }

    public static int doubleVal(int val) {
        return val * 2;
    }

}
