package com.fosuchao.design.singleton;

/**
 * @description: 饿汉式
 * @author: Joker Ye
 * @create: 2020/8/15 17:19
 */

public class Singleton_1 {

    private static Singleton_1 instance = new Singleton_1();

    private Singleton_1(){}

    public static Singleton_1 getInstance() {
        return instance;
    }
}
