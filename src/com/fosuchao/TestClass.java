package com.fosuchao;

import com.fosuchao.random.MaxRotate;
import org.junit.Test;

import java.util.*;

/**
 * @Description:
 * @Auther: Joker Ye
 * @Date: 2020/1/4 09:28
 * @noinspection Duplicates
 */
public class TestClass {

    public static void main(String[] args) {
//        System.out.println(add(2, 3));
//        int a = 49;
//        System.out.println((char) a);
        System.out.println(new TestClass().hashCode());
        System.out.println(new TestClass());
    }

    static int add(int num1, int num2)
    {
        int carry = (num1 & num2) << 1;// 计算进位
        int tmp = num1 ^ num2;// 无进位加法
        while(carry != 0){
            num1 = carry;
            num2 = tmp;

            carry = (num1 & num2) << 1;
            tmp = num1 ^ num2;
        }
        return tmp;
    }


    static boolean checkValue( int num )
    {
        int d1,d2,d3;
        int checkNum, nRemain, rem;

        checkNum = num % 10;
        nRemain = num /10;
        d3 = nRemain % 10;
        nRemain /= 10;
        d2 = nRemain % 10;
        nRemain /= 10;
        d1 = nRemain % 10;
        rem = (d1 + d2 + d3) % 7;
        return rem == checkNum;
    }


    @Test
    public void add(){
        System.out.println(100 - 'A');
    }
}

class A {
    static {
        System.out.print("A");
    }
}

class B extends A{
    static {
        System.out.print("B");
    }
    public final static String c = "C";
}