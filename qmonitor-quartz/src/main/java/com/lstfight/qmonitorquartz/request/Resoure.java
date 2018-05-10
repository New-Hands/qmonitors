package com.lstfight.qmonitorquartz.request;

/**
 * <P>定义需要被访问的资源被获取的方式</P>
 * @author lst
 * Created on 2018/5/8.
 */
public interface Resoure {
    /**
     *
     * @return
     */
    String getAndIncrement();

    int incrementAndGet();

}
