package com.weidd.best.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-06-21 21:15
 * <p>
 *     redis中setNX()
 * 限时的优惠活动
 * 网站数据缓存（对于一些需要定时更新的数据）
 * 限制网站访客访问频率（例如：1分钟最多访问10次）
 **/

/**
 * expire      设置生存时间（单位/秒）
 * pexpire    设置生存时间(单位/毫秒)
 * ttl/pttl     查看键的剩余生存时间
 * persist     取消生存时间
 * expireat [key] unix时间戳1351858600
 * pexpireat [key] unix时间戳(毫秒)1351858700000
 */
public class RedisTicket {
    static String host = "127.0.0.1";
    static int port = 6379;
    static JedisPool jedisPool = null;

    /**
     * 限制网站访客访问频率（例如：1分钟最多访问10次）,其中： 访客通过IP标识，即同一个IP在1分钟内仅能访问10次
     */
    public static void main(String[] args) {


        final String ip = "127.0.0.1";
        Jedis redis = null;
        //模拟同一个用户连续访问20次
        for (int i = 0; i < 20; i++) {
            boolean t = validate(ip);
            if (t) {
                System.out.println("恭喜你，购票成功！" + i);
            } else {
                //获取当前ip过期时间
                redis = getRedis();
                break;
            }
        }
        while (true && redis.ttl(ip) > 0) {
            System.out.println("抱歉，你访问过度频繁，请" + redis.ttl(ip) + "秒后再来访问！");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("你可以再次访问了");
        Jedis jedis = getRedis();
        String ip1 = jedis.get("ip");
        System.out.println(ip1);
    }

    /**
     * @param ip
     * @return true: 可以访问，false： 表示已经达到最大上线
     */
    public static boolean validate(String ip) {
        Jedis jedis = getRedis();
        String value = jedis.get(ip);
        if (value == null || value.length() == 0) { //第一次访问
            jedis.setex(ip, 60, String.valueOf(0));//此处用的是setex而不是setnx();
//            jedis.setnx(ip,String.valueOf(0));
        } else {
            int v = Integer.parseInt(value);
            if (v >= 10) {
                return false;
            }
        }
        jedis.incr(ip);
        return true;
    }

    /**
     * @return
     */
    public static Jedis getRedis() {
        jedisPool = getJedisPool();
        Jedis jedis = jedisPool.getResource();
        return jedis;
    }

    /**
     *
     */
    public static JedisPool getJedisPool() {

        JedisPoolConfig poolConfig = new JedisPoolConfig();
        // 控制一个pool最多有多少个 jedis实例。
        poolConfig.setMaxTotal(1000);
        // 控制一个pool最多有多少个状态为idle(空闲的)的 jedis实例。
        poolConfig.setMaxIdle(10);
        // 表示当borrow(引入)一个 jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；
        poolConfig.setMaxWaitMillis(200000);
        // 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的 jedis实例均是可用的；
        poolConfig.setTestOnBorrow(true);

        return new JedisPool(poolConfig, host, port);
    }
}
