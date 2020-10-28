package com.dujingbo.one;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

/**
 * @package: PACKAGE_NAME
 * @program: JAVA-000
 * @description: GC日志分析
 * @author: <a href="dujingbo@jd.com">Mr.Du</a>
 * @create: 2020-10-21
 **/
public class GCLogAnalysis {

    private static Random random = new Random();

    public static void main(String[] args) {
        //起始毫秒时间戳
        final long startMillis = System.currentTimeMillis();
        //持续运行毫秒数
        final long millis = TimeUnit.SECONDS.toMillis(1);
        //结束毫秒时间戳
        long endMillis = startMillis + millis;

        LongAdder counter = new LongAdder();
        System.out.println("正在执行。。。");
        // 缓存一部分对象进入老年代
        int cacheSize = 2000;
        Object[] cachedGarbage = new Object[2000];
        // 在此时间范围内持续循环
        while (System.currentTimeMillis() < endMillis){
            //生成垃圾对象
            final Object garbage = generatingGarbage(1024 * 100);
            counter.increment();
            final int randomIndex = random.nextInt(2 * cacheSize);
            if(randomIndex < cacheSize){
                cachedGarbage[randomIndex] = garbage;
            }
        }
        System.out.println("执行结束！共生成对象次数" + counter.longValue());
    }

    private static Object generatingGarbage(int max) {
        final int randomSize = random.nextInt(max);
        int type = randomSize % 4;
        Object obj;
        switch (type){
            case 0:
                obj = new int[randomSize];
                break;
            case 1:
                obj = new byte[randomSize];
                break;
            case 2:
                obj = new double[randomSize];
                break;
            default:
                StringBuilder builder = new StringBuilder();
                String randomString = "randomString-Anything";
                while (builder.length() < randomSize){
                    builder.append(randomString)
                            .append(max)
                            .append(randomSize);
                }
                obj = builder.toString();
                break;
        }
        return obj;
    }
}
