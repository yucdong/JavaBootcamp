package com.github.yucdong.javabootcamp.concurrency;

public class WaitAndSignalDemo {
    Object monitor = new Object();

    // wasSignaled for missed signal before waiting
    // and condition check for multiple consumers/spurious wakeups
    private volatile boolean wasSignaled = false;

    public void waitForCondition() {
        synchronized (monitor) {
            while (!wasSignaled) {
                System.out.println("Condition not met, Go back to waiting");
                try {
                    monitor.wait();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }

            wasSignaled = false;
        }

        System.out.println("Condition Taken");
    }

    public void giveCondition() {
        synchronized (monitor) {
            System.out.println("Condition Given");
            wasSignaled = true;
            monitor.notifyAll();
        }
    }

    public static void main(String[] args) throws java.lang.InterruptedException {
        WaitAndSignalDemo demo = new WaitAndSignalDemo();

        Thread t1_1 = new Thread(new Runnable() {
            @Override
            public void run() {
                demo.waitForCondition();
            }
        });

        Thread t1_2 = new Thread(new Runnable() {
            @Override
            public void run() {
                demo.waitForCondition();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3L * 1000L);
                    demo.giveCondition();

                    Thread.sleep(3L * 1000L);
                    demo.giveCondition();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1_1.start();
        t1_2.start();
        t2.start();

        t1_1.join();
        t1_2.join();
        t2.join();
    }
}
