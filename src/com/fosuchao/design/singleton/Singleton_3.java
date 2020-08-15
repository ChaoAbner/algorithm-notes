package com.fosuchao.design.singleton;

/**
 * @description: 懒汉式 线程不安全
 * @author: Joker Ye
 * @create: 2020/8/15 17:22
 */
public class Singleton_3 {

    private static Singleton_3 instance;

    private Singleton_3() {}

    public static Singleton_3 getInstance() {
        if (instance == null) {
            instance = new Singleton_3();
        }
        return instance;
    }
}
