package com.fosuchao.random;

import org.junit.Test;

/**
 * @Description: ������
 * �ж�һ�������Ƿ��ǻ���������������ָ���򣨴������ң��͵��򣨴������󣩶�����һ����������
 * @Auther: Joker Ye
 * @Date: 2019/11/20 19:36
 */
public class Ispalindrome {

    public static void main(String[] args) {

    }


//    public boolean isPalindrome(int x){
//        // ת�ַ���
//        String s = String.valueOf(x);
//        for(int i = 0; i < s.length() / 2; i++){
//            if(s.charAt(i) != s.charAt(s.length() - i - 1)){
//                return false;
//            }
//        }
//        return true;
//    }

    /**
     *
     * �ⷨ�������׽ⷨ---��ѧ�ⷨ
     * ͨ��ȡ����ȡ�������ȡ�����ж�Ӧ�����ֽ��бȽϡ�
     *
     * �ٸ����ӣ�1221 ������֡�
     *
     * ͨ������ 1221 / 1000�� ����λ1
     * ͨ������ 1221 % 10�� �ɵ�ĩλ 1
     * ���бȽ�
     * �ٽ� 22 ȡ���������Ƚ�
     * ��������
     *
     *
     * ����ʵ��
     * Java
     * class Solution {
     *     public boolean isPalindrome(int x) {
     *         //�߽��ж�
     *         if (x < 0) return false;
     *         int div = 1;
     *         //
     *         while (x / div >= 10) div *= 10;
     *         while (x > 0) {
     *             int left = x / div;
     *             int right = x % 10;
     *             if (left != right) return false;
     *             x = (x % div) / 10;
     *             div /= 100;
     *         }
     *         return true;
     *     }
     * }
     * �ⷨ�������׽ⷨ---����ⷨ
     * ֱ�����������������Ļ����͸о����ǽ����ֽ��ж��ۺ��ܷ�һһ��Ӧ��
     *
     * ��������ⷨ�Ĳ������� ȡ���������ֽ��з�ת��
     *
     * ������Ҫע���һ����������ڻ�������λ�������ż�����Ե����ĳ�����ż��ʱ�������۹���Ӧ������ȵģ������ĳ���������ʱ����ô�����۹�������һ���ĳ�����Ҫȥ��һλ�������� 10 ��ȡ������
     *
     * �����������£�
     *
     * ÿ�ν���ȡ����� �� %10����ȡ����͵����֣�y = x % 10
     * ����͵����ּӵ�ȡ������ĩβ��revertNum = revertNum * 10 + y
     * ÿȡһ�����λ���֣�x ��Ҫ�Գ��� 10
     * �ж� x �ǲ���С�� revertNum ������С�ڵ�ʱ��˵�������Ѿ��԰���߹�����
     * ����ж���ż������������ż���Ļ���revertNum �� x ��ȣ�����������Ļ������м�����־���revertNum �����λ�ϣ��������� 10 �Ժ�Ӧ�ú� x ��ȡ�
     * ��������
     *
     *
     * ����ʵ��
     * Java
     * class Solution {
     *     public boolean isPalindrome(int x) {
     *         //˼���������ҿ���˼��һ�£�ΪʲôĩβΪ 0 �Ϳ���ֱ�ӷ��� false
     *         if (x < 0 || (x % 10 == 0 && x != 0)) return false;
     *         int revertedNumber = 0;
     *         while (x > revertedNumber) {
     *             revertedNumber = revertedNumber * 10 + x % 10;
     *             x /= 10;
     *         }
     *         return x == revertedNumber || x == revertedNumber / 10;
     *     }
     * }
     * @Param []
     * @return void
     */

    @Test
    public void test(){

    }
}
