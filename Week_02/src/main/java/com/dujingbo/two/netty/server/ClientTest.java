package com.dujingbo.two.netty.server;

import com.dujingbo.two.netty.client.EchoClient;

/**
 * @package: com.dujingbo.two.netty.server
 * @program: JAVA-000
 * @description:
 * @author: <a href="dujingbo@jd.com">Mr.Du</a>
 * @create: 2020-10-27
 **/
public class ClientTest {

    public static void main(String[] args) {
        EchoClient client = new EchoClient(8805,"localhost");
        client.start();
    }
}
