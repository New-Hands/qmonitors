package com.lstfight.qmonitorquartz.request;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;

/**
 * <p>执行获取任务 </p>
 * <p>定义为线程安全的类</p>
 * @author lst
 * Created on 2018/5/8.
 */
public class Requester {

    private static final Logger LOGGER = LoggerFactory.getLogger(Requester.class);

    private final CloseableHttpAsyncClient httpAsyncClient;


   private Resoure resoure;

    @Autowired
    public Requester(CloseableHttpAsyncClient httpAsyncClient) {
        this.httpAsyncClient = httpAsyncClient;
        httpAsyncClient.start();
    }

    /**
     * 有点被作用域这个东西弄蒙了
     * @return
     */
    public void execute() {


        final String[] res = new String[1];

        while (true) {

            String key = resoure.getAndIncrement();

            if (key == null) {
                return;
            }

            httpAsyncClient.execute(new HttpGet(key), new FutureCallback<HttpResponse>() {
                @Override
                public void completed(HttpResponse httpResponse) {
                    HttpEntity entity = httpResponse.getEntity();
                    try {
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(entity.getContent());
                        Reader reader = new InputStreamReader(bufferedInputStream);
                        BufferedReader bufferedReader = new BufferedReader(reader);
                        LOGGER.info(key+bufferedReader.readLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void failed(Exception e) {
                    LOGGER.error("以获取使用量失败");
                }

                @Override
                public void cancelled() {
                    LOGGER.info("获取任务被取消");
                }
            });
        }
    }

    public Requester initialResource(Resoure resoure) {
        this.resoure = resoure;
        return this;
    }
    /**
     * 静态类是一个什么样的位置 什么样的存在
     */
    private static class Geter implements Runnable {

        @Override
        public void run() {


        }
    }

}
