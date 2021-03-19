package com.weidd.best.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-02-17 12:05
 **/
public class RedisTest1 {
    public static void main(String[] args) {
        Jedis jedis =new Jedis("localhost");
        jedis.set("key" , "value");
        String key = jedis.get("key");
        System.out.println(key);
        System.out.println(jedis.ping());
        System.out.println("************");
        //连接本地的 Redis 服务
        Jedis jedis1 = new Jedis("localhost");
        System.out.println("连接成功");
        //存储数据到列表中
        jedis1.lpush("site-list", "Runoob");
        jedis1.lpush("site-list", "Google");
        jedis1.lpush("site-list", "Taobao");
        // 获取存储的数据并输出
        List<String> list = jedis1.lrange("site-list", 0 ,2);
        for(int i=0; i<list.size(); i++) {
            System.out.println("列表项为: "+list.get(i));
        }



    }
    @Test
    public void test2(){
        Jedis jedis =new Jedis("localhost");
        jedis.publish("news-sport","姚明当选主席");
        jedis.publish("news-wheath","小雨");
        jedis.publish("news-cctv","CCTV春节联欢晚会");

    }
    @Test//订阅
    public void test4(){
        Jedis jedis =new Jedis("localhost");

    }
    @Test
    public void test3() {
        Jedis jedis = new Jedis("localhost");
        List<String> strings = jedis.pubsubChannels("news-sport");

        for (String str : strings) {
            System.out.println(str);
            JedisPubSub jps = new JedisPubSub() {
                @Override
                public void onMessage(String str, String message) {
                    super.onMessage(str, message);
                }
            };
            jedis.subscribe(jps);
        }

    }

        @Test
    public void test1(){
        Jedis jedis =new Jedis("localhost");
        Map<String, String> strMap = jedis.hgetAll("");
        Set<Map.Entry<String, String>> entries = strMap.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            String key1 = entry.getKey();
            String value = entry.getValue();
            System.out.println(key1+"***"+value);
        }
    }


/*
    public Boolean getLock(Object lockObject){
        jedisUtil = getJedisConnetion();
        boolean flag = jedisUtil.setNX(lockObj, 1);
        if(flag){
            expire(locakObj,10);
        }
        return flag;
    }
​
    public void releaseLock(Object lockObject){
        del(lockObj);
    }*/
}
