package com.weidd.best.redis;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-06-21 22:03
 * 测试redis加锁
 **/
public class Test {
    public static void main(String[] args) {

        //模拟多个5个客户端
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new LockRunnable());
            thread.start();
        }
    }

    private static class LockRunnable implements Runnable {
        @Override
        public void run() {
            RedisUtil singleRedisLock = new RedisUtil();

            String requestId = UUID.randomUUID().toString();
            boolean lockResult = singleRedisLock.tryLock("lock", requestId);
            if (lockResult) {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            singleRedisLock.releaseLock("lock", requestId);
        }
    }
}
