package com.fosuchao.random;

import org.junit.Test;

/**
 * @Description: ʵ��strStr()���� https://leetcode-cn.com/problems/implement-strstr/
 * ����һ��?haystack �ַ�����һ�� needle �ַ������� haystack �ַ������ҳ� needle �ַ������ֵĵ�һ��λ�� (��0��ʼ)����������ڣ��򷵻�? -1��
 *
 * @Auther: Joker Ye
 * @Date: 2019/11/25 18:37
 */
public class realizestrStr {

    public static void main(String[] args) {
        String haystack = "mississippi", needle = "issip";
        int i = strStr(haystack, needle);
        System.out.println("���ֵ�λ���ڣ�" + i);
    }

    public static int strStr(String haystack, String needle) {
        int pos = -1;

        if(needle.length() == 0){
            return 0;
        } else if(needle.length() > haystack.length()){
            return pos;
        }

        for(int i = 0; i < haystack.length() - needle.length() + 1; i++){
            if(haystack.substring(i, (i + needle.length())).equals(needle)){
                pos = i;
                break;
            }
        }
        return pos;
    }

    @Test
    public void test(){
        String testStr1 = "abcd";
        String testStr2 = "abc";
        String substring = testStr1.substring(0, (0 + testStr2.length()));
        System.out.println(substring.equals(testStr2));
    }
}
