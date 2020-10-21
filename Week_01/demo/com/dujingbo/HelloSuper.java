package com.dujingbo;

/**
 * @package: com.dujingbo
 * @program: JAVA-000
 * @description:
 * @author: <a href="dujingbo@jd.com">Mr.Du</a>
 * @create: 2020-10-16
 **/
public abstract class HelloSuper {

    protected int num = 2;

    public abstract int addition(int a, int b);

    public int subtraction(int a, int b) {
        return a - b;
    }
}
