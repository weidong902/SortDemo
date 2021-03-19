package com.weidd.best.redis;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-02-27 18:58
 **/
public class TestBloomFilter {
    //测试使用布隆过滤器解决缓存穿透问题
    //需引入:guava包
    private static final int capacity = 10000000;
    private static final int key = 92222222;
    private static BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), capacity);

    static {
        for (int i = 0; i < capacity; i++) {
            bloomFilter.put(i);
        }
    }


    public static void main(String[] args) {

        long star=System.nanoTime();//微秒: 1 秒=1000000 微秒
        if(bloomFilter.mightContain(key)){
            System.out.println("布隆过滤器过滤到"+key);
        }
        long end=System.nanoTime();//微秒: 1 秒=1000000 微秒
        System.out.println("过滤消耗时间:"+(end-star)+"微秒");

    }


}
