package com.study.concurrency;

public class Demo2 {

    public static void main(String[] args) throws InterruptedException {
        Thread worker = new WorkerThread();
        Thread sleeper = new SleeperThread();
        worker.setDaemon(true);
        sleeper.setDaemon(true);

        System.out.println("Starting threads");
        worker.start();
        sleeper.start();

        Thread.sleep(100L);

        System.out.println("Interupting threads");
        worker.interrupt();
        sleeper.interrupt();

        System.out.println("Joining threads");
        worker.join();
        sleeper.join();

        System.out.println("All done");

    }

    private static class WorkerThread extends Thread {

        @Override
        public void run() {
            long sum = 0;
            for (int i = 0; i < 1_000_000_000; ++i) {
                sum+=i;
                if (i%100 == 0 && isInterrupted()) {
                    System.out.println("Loop interupted at i " + i);
                    break;
                }
            }
        }

    }

    private static class SleeperThread extends Thread {

        @Override
        public void run() {
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                System.out.println("Sleep interupted");
            }
        }
    }

}
