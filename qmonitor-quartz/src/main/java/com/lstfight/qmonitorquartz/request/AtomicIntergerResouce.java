package com.lstfight.qmonitorquartz.request;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>resource的原子类实现方式</p>
 * @author lst
 * Created on 2018/5/9.
 */
public class AtomicIntergerResouce implements Resoure {

    private  final AtomicInteger START_NUM = new AtomicInteger(1000000001);
    private final int end = 1000032768;

    private String defaultURL = "http://localhost:8088/useAmount/query/";
    @Override
    public String getAndIncrement() {
        int res = START_NUM.getAndIncrement();
        if (res <= end) {
            return defaultURL+res;
        }
        return null;
    }

    @Override
    public int incrementAndGet() {
        return 0;
    }


}
