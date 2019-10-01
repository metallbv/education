package com.study.patterns.singleton;

/**
 * https://habr.com/ru/post/27108/
*/

public final class Singleton {

  private static Singleton instance;

  private Singleton() {
  }

  public static Singleton getInstance() {
    if (instance == null) {
      instance = new Singleton();
    }
    return instance;
  }
}
