package com.fosuchao.design.singleton;

/**
 * @description: 懒汉式 线程安全 性能较差
 * @author: Joker Ye
 * @create: 2020/8/15 17:23
 */
public class Singleton_4 {

    private static Singleton_4 instance;

    private Singleton_4() {}

    public static synchronized Singleton_4 getInstance() {
        if (instance == null) {
            instance = new Singleton_4();
        }
        return instance;
    }
}
