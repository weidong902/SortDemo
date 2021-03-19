package com.weidd.best.multiThread;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-02-19 23:22
 * @description 模拟多线程售票
 **/
public class SaleTicket {
    public static void main(String[] args) {

        TicketStation station = new TicketStation();
        new Thread(station,"售票站1").start();
        new Thread(station,"售票站2").start();
        new Thread(station,"售票站3").start();


    }
}
class TicketStation implements Runnable{
    //静态票数来保持票数一致
    static int ticks =50;
    //静态钥匙
    static Object obj="saleTick";

    @Override
    public void run() {
        while(ticks>0){
            synchronized(obj){//锁:当前线程进入,再有线程等待
                //再次判断票是否还有
                if(ticks>0){
                    System.out.println(Thread.currentThread()+"卖第"+ticks+"张票");
                    ticks--;
                }else{
                    System.out.println("票已经卖完~");
                }
            }
            try {
                Thread.sleep(1000);//休眠秒,否则可能看不到三窗口售卖的情况
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
