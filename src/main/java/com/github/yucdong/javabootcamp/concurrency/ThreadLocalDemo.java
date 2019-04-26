package com.github.yucdong.javabootcamp.concurrency;

public class ThreadLocalDemo {

    static class MyRunnable implements Runnable {

        private ThreadLocalDemo demo;

        public MyRunnable(ThreadLocalDemo demo) {
            this.demo = demo;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5000; i++) {
                demo.incr();
            }

            try {
                Thread.sleep(3L * 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            demo.print();
        }
    }

    private ThreadLocal<Integer> localCount = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 1;
        }
    };

    private int shared_count = 0;

    public void incr() {
        Integer count = localCount.get();
        ++count;
        localCount.set(count);
        shared_count = shared_count + 1;
    }

    public void print() {
        System.out.println(this.localCount.get());
        System.out.println("Shared count is " + shared_count);
    }

    public static void main(String[] args) throws java.lang.InterruptedException {
        ThreadLocalDemo demo = new ThreadLocalDemo();
        MyRunnable runnable1 = new MyRunnable(demo);
        MyRunnable runnable2 = new MyRunnable(demo);

        Thread t1 = new Thread(runnable1);
        Thread t2 = new Thread(runnable2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
