package com.weidd.best.redis;

import redis.clients.jedis.Jedis;

import java.util.UUID;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-04-18 23:38
 **/
public class RedisLock {

    //保存客户端标识
    private static final ThreadLocal<String> LOCAL = new ThreadLocal<String>();
    /**
     *
     * @param jedis
     * @param lockKey 锁key
     * @param expires 过期时间 一般为  System.currentTimeMillis()+ 过期时间
     * @return
     */
        public static boolean getDistributedLock(Jedis jedis, String lockKey, long expires) {
        //客户端标识 在释放锁时 确保由设置锁的客户端来释放自己的锁
        String uuid = UUID.randomUUID().toString();
        LOCAL.set(uuid);
        String expiresStr = uuid+"#"+expires;

        // 如果当前锁不存在，返回加锁成功
        if (jedis.setnx(lockKey, expiresStr) == 1) {
            return true;
        }

        // 如果锁存在，获取锁的过期时间
        String currentValue = jedis.get(lockKey);
        String currentValueStr = null==currentValue?null:currentValue.split("#")[1];
        // 判断当前锁是否过期
        if (currentValueStr != null && Long.parseLong(currentValueStr) < System.currentTimeMillis()) {
            // 锁已过期，获取上一个锁的过期时间，并设置现在锁的过期时间 此处多个客户端会覆盖锁的过期时间
            String oldValue = jedis.getSet(lockKey,expiresStr);
            String oldValueStr = null ==oldValue?null:oldValue.split("#")[1];
            // 考虑多线程并发的情况，只有一个线程的设置值和当前值相同，它才有权利加锁
            if (oldValueStr != null && oldValueStr.equals(currentValueStr)) {
                //由于上面会覆盖锁的过期时间 此处让获取锁的客户端 重新设置为自己的过期时间
                jedis.set(lockKey,expiresStr);
                return true;
            }
        }
        // 其他情况，一律返回加锁失败
        return false;
    }

    /**
     *
     * @param jedis
     * @param lockKey 锁key
     * @param value 过期时间 一般为  System.currentTimeMillis()+ 过期时间
     * @return
     */
    public static boolean releaseDistributedLock(Jedis jedis, String lockKey, long value) {
        String uuid = LOCAL.get();
        String valueStr = uuid+"#"+value;
        //根据uuid 这个标识 让客户端 去释放自己的锁 不能释放别人的锁
        if(valueStr.equals(jedis.get(lockKey))){
            jedis.del(lockKey);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Jedis jedis =new Jedis("localhost");
        boolean lock = getDistributedLock(jedis, "xxx", 20000l);
        System.out.println(lock);
    }

}
