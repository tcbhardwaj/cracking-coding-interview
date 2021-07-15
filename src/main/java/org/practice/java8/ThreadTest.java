package org.practice.java8;

public class ThreadTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(()-> {
            for(int i = 0; i< 10; i++) {
                System.out.println("inside thread1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(()-> {
            for(int i = 0; i< 10; i++) {
                System.out.println("inside thread2");
            }
        });

        t1.start(); 
        t2.start();
    }
}
