package com.dujingbo.two;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @package: com.dujingbo.two
 * @program: JAVA-000
 * @description:
 * @author: <a href="dujingbo@jd.com">Mr.Du</a>
 * @create: 2020-10-26
 **/
public class HttpServer03 {

    public static void main(String[] args) throws IOException {
        ExecutorService service = Executors.newFixedThreadPool(40);
        ServerSocket serverSocket = new ServerSocket(8803);
        while (true) {
            final Socket socket = serverSocket.accept();
            service.execute(() -> service(socket));
        }


    }

    private static void service(Socket socket) {
        try {
            Thread.sleep(20);
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("HTTP/1.1 200 OK");
            writer.println("Content-Type:text/html;charset=utf-8");
            writer.println();
            writer.write("hello, Nio");
            writer.close();
            socket.close();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
