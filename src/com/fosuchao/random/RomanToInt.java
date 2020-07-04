package com.fosuchao.random;

import org.junit.Test;

import java.util.HashMap;

/**
 * @Description: ������ת����
 * �������ְ������������ַ�: I�� V�� X�� L��C��D �� M��
 * @Auther: Joker Ye
 * @Date: 2019/11/20 20:11
 */
public class RomanToInt {

    public static void main(String[] args) {
        String s = "MCMXCIV";

        int i = romanToInt(s);
        System.out.println(i);
    }

    public static int romanToInt(String s) {
            int sum = 0;
            int preNum = getValue(s.charAt(0));
            for (int i = 1; i < s.length(); i++) {
                int num = getValue(s.charAt(i));
                if (preNum < num) {
                    sum -= preNum;
                } else {
                    sum += preNum;
                }
                preNum = num;
            }
            sum += preNum;
            return sum;
        }

    private static int getValue ( char ch){
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    @Test
    public void test(){

    }
}
