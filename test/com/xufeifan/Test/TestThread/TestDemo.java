package com.xufeifan.Test.TestThread;

/**
 * @author DZRABDemo
 * @version 1.0.0
 * @ClassName TestDemo
 * @Description TODO
 * @createTime 2022年02月18日 16:43:00
 */
public class TestDemo {
    public static void main(String[] args) {
        Runnable runnable = new Runnable(){
            public void run(){
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(runnable,"thread").start();
    }
}
