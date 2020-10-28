package com.dujingbo.two.test;

import okhttp3.*;
import org.junit.Test;

import java.io.IOException;
import java.util.Objects;

/**
 * @package: com.dujingbo.two.test
 * @program: JAVA-000
 * @description:
 * @author: <a href="dujingbo@jd.com">Mr.Du</a>
 * @create: 2020-10-26
 **/
public class OKHttpTest {

    @Test
    public void testOKHttp() {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .get()
                .url("http://localhost:8804/test")
                .build();

        Call call = client.newCall(request);
        /*String body = "";
        try {
            final Response response = call.execute();
            if (response.isSuccessful()) {
                System.out.println(Objects.requireNonNull(response.body()).string());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(body);*/
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.err.println(e.getLocalizedMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println(Objects.requireNonNull(response.body()).string());
                System.out.println(response.protocol());
                System.out.println(response.headers());
            }
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
