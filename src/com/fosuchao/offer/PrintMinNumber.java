package com.fosuchao.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Description: offer pdf 195页 第三十三题
 * @Auther: Joker Ye
 * @Date: 2020/2/6 22:23
 */
public class PrintMinNumber {
    public static void main(String[] args) {
        int[] nums = {31, 32, 321};
        System.out.println(new PrintMinNumber().printMinNumber(nums));
    }

    public int printMinNumber(int[] nums) {
        ArrayList<String> strList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            // 转化为字符串
            strList.add(i, String.valueOf(nums[i]));
        }

        Collections.sort(strList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String str1 = o1 + o2;
                String str2 = o2 + o1;

                return str1.compareTo(str2);
            }
        });

        StringBuilder stringBuilder = new StringBuilder();
        for (String s : strList) {
            stringBuilder.append(s);
        }

        return Integer.valueOf(stringBuilder.toString());
    }

}
