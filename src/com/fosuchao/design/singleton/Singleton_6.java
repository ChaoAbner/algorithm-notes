package com.fosuchao.design.singleton;

/**
 * @description: 懒汉式 静态内部类
 * @author: Joker Ye
 * @create: 2020/8/15 17:25
 */
public class Singleton_6 {

    private Singleton_6() {}

    private static class InnerSingleton {
        private static final Singleton_6 instance = new Singleton_6();
    }

    public static Singleton_6 getInstance() {
        return InnerSingleton.instance;
    }
}
