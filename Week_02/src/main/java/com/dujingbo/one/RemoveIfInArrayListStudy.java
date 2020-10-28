package com.dujingbo.one;

import java.util.ArrayList;

/**
 * @package: PACKAGE_NAME
 * @program: JAVA-000
 * @description:
 * @author: <a href="dujingbo@jd.com">Mr.Du</a>
 * @create: 2020-10-22
 **/
public class RemoveIfInArrayListStudy {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            list.add(i + 1);
        }
        System.out.println(list);

        list.removeIf(t -> t % 2 == 0);
        System.out.println(list);
    }
}
