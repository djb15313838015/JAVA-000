package com.dujingbo.two.netty.server;

/**
 * @package: com.dujingbo.two.netty.server
 * @program: JAVA-000
 * @description:
 * @author: <a href="dujingbo@jd.com">Mr.Du</a>
 * @create: 2020-10-27
 **/
public class ServerTest {

    public static void main(String[] args) {
        EchoServer server = new EchoServer(8805);
        server.start();
    }
}
