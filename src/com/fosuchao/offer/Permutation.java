package com.fosuchao.offer;


/**
 * @Description: 字符串的全排列
 * @Auther: Joker Ye
 * @Date: 2020/2/1 10:38
 */
public class Permutation {

    public static void main(String[] args) {
        String str = "aa";
        Permutation permutation = new Permutation();
        permutation.permutation(str);
    }

    public void permutation(String str) {
        if (str == null) {
            return;
        }
        permutation(str.toCharArray(), 0);
    }

    public void permutation(char[] charArrays, int start) {
        if (charArrays.length == start + 1) {
            System.out.println(charArrays);
        } else {
            for (int i = start; i < charArrays.length; i++) {
                char temp = charArrays[i];
                charArrays[i] = charArrays[start];
                charArrays[start] = temp;
                permutation(charArrays, start + 1);
                temp = charArrays[i];
                charArrays[i] = charArrays[start];
                charArrays[start] = temp;
            }
        }
    }
}
