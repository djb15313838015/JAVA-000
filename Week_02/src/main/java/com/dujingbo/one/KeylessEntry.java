package com.dujingbo.one;

import java.util.HashMap;
import java.util.Map;

/**
 * @package: PACKAGE_NAME
 * @program: JAVA-000
 * @description:
 * @author: <a href="dujingbo@jd.com">Mr.Du</a>
 * @create: 2020-10-22
 **/
public class KeylessEntry {

    static class Key {
        Integer id;

        public Key(Integer id) {
            this.id = id;
        }

        @Override
        public int hashCode() {
            return id.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            boolean response = false;
            if (obj instanceof Key) {
                response = ((Key) obj).id.equals(this.id);
            }
            return response;
        }
    }

    public static void main(String[] args) {
        Map<Key, String> map = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            if (!map.containsKey(new Key(i))) {
                map.put(new Key(i), "Number: " + i);
            }
        }
        System.out.println("map.size()=" + map.size());
    }


}
