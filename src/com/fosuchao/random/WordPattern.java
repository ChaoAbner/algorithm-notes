package com.fosuchao.random;

/**
 * @Description:
 * @Auther: Joker Ye
 * @Date: 2019/11/12 19:35
 */
public class WordPattern {

    public static void main(String[] args) {
        boolean b = wordPattern("abba", "dog cat cat dog");
        System.out.println(b);
    }

    public static boolean wordPattern(String pattern, String str) {
        String[] arr = str.split(" ");
        if (pattern.length() != arr.length) return false;
        int len = pattern.length();
        for (int i = 0; i < len; i++) {
            System.out.print(pattern.indexOf(pattern.charAt(i)));
            System.out.print(indexOf(arr, arr[i]));
            if(pattern.indexOf(pattern.charAt(i)) != indexOf(arr, arr[i])){
                return false;
            }
            System.out.println();
        }
        return true;
    }

    public static int indexOf(String[] arrays, String searchString) {
        int ans = -1;
        for(int i = 0; i < arrays.length; i++) {
            if (arrays[i].equals(searchString)) {
                ans = i;
                break;
            };
        };
        return ans;
    }
}
