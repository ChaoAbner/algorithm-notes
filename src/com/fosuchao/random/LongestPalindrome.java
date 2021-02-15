package com.fosuchao.random;



/**
 * @Description: ���ַ�������Ļ�����
 * @Auther: Joker Ye
 * @Date: 2019/11/18 23:02
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String lzmabadcda = longestPalindrome("abb");
        System.out.println(lzmabadcda);
    }

    /**
     *�����ģ�������չ�㷨
     * ��ʵ�ϣ�ֻ��ʹ�ú㶨�Ŀռ䣬���ǾͿ����� O(n^2)O(n
     * 2
     *  ) ��ʱ���ڽ��������⡣
     *
     * ���ǹ۲쵽�������ĵ����໥Ϊ������ˣ����Ŀ��Դ���������չ��������ֻ�� 2n - 12n?1 �����������ġ�
     *
     * ����ܻ��ʣ�Ϊʲô���� 2n - 12n?1 ���������� nn �����ģ�ԭ������������ĸ��Ϊż���Ļ��ĵ����Ŀ��Դ�������ĸ֮�䣨���� \textrm{��abba��}��abba�� ������������ \textrm{��b��}��b�� ֮�䣩��
     * @Param [s]
     * @return java.lang.String
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }


    public void test(){
        String test = "lzbabadcda";
        String longestStr = "";
        System.out.println(longestStr.length() < 2);
        int cursor1 = 0;
        int cursor2 = 1;
        int cursor3 = 2;
    }


}
