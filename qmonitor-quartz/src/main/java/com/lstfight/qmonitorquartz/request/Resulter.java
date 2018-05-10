package com.lstfight.qmonitorquartz.request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * <p>定义结果集</p>
 * @author lst
 * Created on 2018/5/8.
 */
public class Resulter {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public Resulter() {
        stringRedisTemplate.opsForValue().set("sdf","dfsd");
    }


}
