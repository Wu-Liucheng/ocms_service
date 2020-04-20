package com.ocms;

import com.ocms.util.RedisUtil;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author Wu Liucheng
 * @date 2020/4/20 12:10 下午
 * @description
 */
public class RedisTest extends OcmsApplicationTests {

    @Resource
    RedisUtil redisUtil;

    @Test
    public void t1(){
        redisUtil.set("25021599041","123456",60);
    }
    @Test
    public void t2(){
        System.out.println(redisUtil.get("2502159904"));
    }
}
