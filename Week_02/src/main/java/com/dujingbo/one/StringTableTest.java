package com.dujingbo.one;

import java.util.UUID;

/**
 * @package: PACKAGE_NAME
 * @program: JAVA-000
 * @description:
 * @author: <a href="dujingbo@jd.com">Mr.Du</a>
 * @create: 2020-10-22
 **/
public class StringTableTest {

    public static void main(String args[]) {
        for (int i = 0; i < 10000000; i++) {
            uuid();
        }
    }

    public static void uuid() {
        UUID.randomUUID().toString().intern();
    }
}
