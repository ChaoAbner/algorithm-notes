package com.fosuchao.random;

/**
 * @Description:
 * @Auther: Joker Ye
 * @Date: 2019/11/22 12:21
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = new String[]{"dog","racecar","car"};
        String s = longestCommonPrefix(strs);
        System.out.println(s);
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder("");

        int shortestLength = strs[0].length();
        // �ó�����ַ����ĳ���
        for(int i = 1; i < strs.length; i++){
            if(shortestLength > strs[i].length()){
                shortestLength = strs[i].length();
            }
        }

        for(int j = 0; j < shortestLength; j++){
//            if(isEquals(strs, j, 0, strs.length / 2) && isEquals(strs, j, strs.length / 2, strs.length)){
            if(isEquals(strs, j)){
                stringBuilder.append(String.valueOf(strs[0].charAt(j)));
            } else {
                break;
            }
        }

        return stringBuilder.toString();
    }

    public static Boolean isEquals(String[] strs, int pattern){
        for (int i = 0; i < strs.length - 1; i++){
            if(strs[i].charAt(pattern) != strs[i + 1].charAt(pattern)){
                return false;
            }
        }
        return true;
    }

//    public static Boolean isEquals(String[] strs, int pattern, int start, int end){
//        isEquals(strs, pattern, start, end/2);
//        isEquals(strs, pattern, end/2, end);
//        return strs[start].charAt(pattern) == strs[end].charAt(pattern);
//    }

    /**
     * �����ⷨ
     * https://leetcode-cn.com/problems/longest-common-prefix/solution/zui-chang-gong-gong-qian-zhui-by-leetcode/
     */

}
