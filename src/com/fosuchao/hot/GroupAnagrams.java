package com.fosuchao.hot;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Description:
 * @Auther: Joker Ye
 * @Date: 2020/1/11 22:09
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs){
        HashMap<String, List<String>> booleanHashMap = new HashMap<>();
        char[] chars;
        for(int i = 0; i < strs.length; i++){
            chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if(!booleanHashMap.containsKey(key)){
                booleanHashMap.put(key, new ArrayList<>());
                booleanHashMap.get(key).add(strs[i]);
            } else {
                booleanHashMap.get(key).add(strs[i]);
            }
        }

        return new ArrayList<>(booleanHashMap.values());
    }

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams.groupAnagrams(strs);
        for (List<String> list : lists) {
            System.out.println(list);
        }
    }

    @Test
    public void test(){
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        char[] chars = strs[0].toCharArray();
        Arrays.sort(chars);
        System.out.println(Arrays.toString(chars));

        HashMap<char[], Boolean> booleanHashMap = new HashMap<>();
        booleanHashMap.put(chars, true);
        System.out.println(booleanHashMap.containsKey(chars));
        System.out.println(strs[0]);

    }
}
