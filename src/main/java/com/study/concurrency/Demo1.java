package com.study.concurrency;

public class Demo1 {

  public static void main(String[] args) {

    HelloRunnable helloRunnable = new HelloRunnable();

    for (int i = 0; i < 10; i++) {
      //new HelloWorld().start();
      //new Thread(() -> System.out.println("Hello")).start();
      //new Thread(new HelloRunnable()).start();
      new Thread(helloRunnable).start();
    }

    System.out.println("Hello from main thread");

  }

  public static class HelloWorld extends Thread {
    @Override
    public void run() {
      System.out.println("Hello from " + getName());
    }
  }

  private static class HelloRunnable implements Runnable {

    @Override
    public void run() {
      System.out.println("Hello from " + Thread.currentThread().getName());
    }
  }
}
