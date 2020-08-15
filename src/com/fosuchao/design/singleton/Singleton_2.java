package com.fosuchao.design.singleton;

/**
 * @description: 饿汉式 变种
 * @author: Joker Ye
 * @create: 2020/8/15 17:21
 */
public class Singleton_2 {

    private static Singleton_2 instance;

    static {
        instance = new Singleton_2();
    }

    private Singleton_2() {}

    public static Singleton_2 getInstance() {
        return instance;
    }
}
