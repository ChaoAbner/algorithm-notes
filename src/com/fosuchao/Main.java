package com.fosuchao;



import java.util.*;

/**
 * @noinspection Duplicates
 */
public class Main {

    private final static int SIZE = 10;

    private final static Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        Vector<Integer> array = new Vector<>();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    array.add(1);
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    array.add(1);
                }
            }
        }).start();
    }

    public static String add (String num1, String num2) {
        double n1 = Double.valueOf(num1);
        double n2 = Double.valueOf(num2);

        double res = n1 + n2;

        StringBuilder sb = new StringBuilder();

        // write code here
        String preNum = String.valueOf(res).split(".")[0];
        String postNum = String.valueOf(res).split(".")[1];

        int intPre = Integer.valueOf(preNum);
        int i = 0;
        int[] temp = new int[100];
        // 整数部分
        while (intPre / 9 != 0) {
            temp[i] = intPre % 9;
            intPre = intPre / 9;
            i++;
        }
        for (int j = i - 1; j >= 0; j--) {
            sb.append(temp[j]);
        }

        // 小数部分
//
//        String post_num1 = num1.split(".")[1];
//        String post_num2 = num2.split(".")[1];

//        StringBuilder post = new StringBuilder();
//
//        for (int i = Math.min(post_num1.length(), post_num2.length()); i >= 0; --i) {
//            int n = post_num1.charAt(i) + post_num2.charAt(i);
//        }

        return sb.toString();
    }



    public void test() {
        String a = "123.22";
        double n1 = Double.valueOf(a);
        System.out.println(n1);
    }

}
