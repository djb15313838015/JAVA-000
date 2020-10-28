package com;

import java.util.ArrayList;
import java.util.List;

/**
 * @package: com.dujingbo
 * @program: JAVA-000
 * @description:
 * @author: <a href="dujingbo@jd.com">Mr.Du</a>
 * @create: 2020-10-20
 **/
public class OOMTest {

    static class OOMObject {
        public byte[] placeholder = new byte[64 * 1024 * 10];
    }

    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            // 稍作延时，令监视曲线的变化更加明显
            Thread.sleep(30);
            list.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args) throws Exception {
        fillHeap(10000);
        //System.gc();
    }
}
