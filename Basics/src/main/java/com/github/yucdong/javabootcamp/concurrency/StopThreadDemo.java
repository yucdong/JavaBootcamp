package com.github.yucdong.javabootcamp.concurrency;

public class StopThreadDemo {
    static class MyRunnable implements Runnable {
        private boolean stopped = false;

        public synchronized void doStop() {
            this.stopped = true;
        }

        public synchronized boolean keepRunning() {
            return this.stopped == false;
        }

        @Override
        public void run() {
            while (keepRunning()) {
                System.out.println("Running");
                try {
                    Thread.sleep(3L * 1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Stopped gracefully");
        }
    }

    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();

        try {
            Thread.sleep(10L * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Called from another thread
        runnable.doStop();
    }
}

