package com.fosuchao.hot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Description:
 * @Auther: Joker Ye
 * @Date: 2020/1/3 20:16
 */
public class PhoneNumCombination {

    static HashMap<String, String> hashMap = initMap();
    static ArrayList<String> output = new ArrayList<>();


    public static void main(String[] args) {
        List<String> strings = letterCombinations("23");
        System.out.println(strings);
    }

    public static List<String> letterCombinations(String digits){
        if(digits.length() != 0){
            back(digits, "");
        }
        return output;
    }

    public static void back(String digits, String part){
        // 1、明确函数功能是进行全排列
        // 2、终止条件，digits=""
        if(digits.length() == 0){
            output.add(part);
        } else{
            String digit = digits.substring(0, 1);
            // 获取当前数字对应字符串
            String s = hashMap.get(digit);
            for(int i = 0; i < s.length(); i++){
                String letter = hashMap.get(digit).substring(i, i + 1);
                back(digits.substring(1),part + letter);
            }
        }
    }

    public static HashMap<String, String> initMap(){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("2", "abc");
        hashMap.put("3", "def");
        hashMap.put("4", "ghi");
        hashMap.put("5", "jkl");
        hashMap.put("6", "mno");
        hashMap.put("7", "pqrs");
        hashMap.put("8", "tuv");
        hashMap.put("9", "wxyz");
        return hashMap;
    }
}
