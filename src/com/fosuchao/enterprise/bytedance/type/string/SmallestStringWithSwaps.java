package com.fosuchao.enterprise.bytedance.type.string;

import java.util.*;

/**
 * @description: 1202. 交换字符串中的元素
 * https://leetcode-cn.com/problems/smallest-string-with-swaps/submissions/
 * @author: Joker Ye
 * @create: 2020/6/30 22:22
 */
public class SmallestStringWithSwaps {

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> pairs = new ArrayList<>();
        pairs.add(new ArrayList<>(Arrays.asList(0, 3)));
        pairs.add(new ArrayList<>(Arrays.asList(1, 2)));
//        System.out.println(s.smallestStringWithSwaps("dcab", pairs));
        Solution.tet();
        System.out.println(Solution.tet(1));
        System.out.println(Solution.tet("1"));
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int len = s.length();

        DSU dsu = new DSU(100000);
        //构造下标集合
        for (List<Integer> list : pairs)
            dsu.union(list.get(0), list.get(1));
        //每个下标集合有1个leader，用leader作为key(唯一)，下标集合List作为value
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        //从小到大遍历，使得List<Integer>中的值是有序的(事后不用再排序了)
        for (int i = 0; i < len; ++i) {
            int key = dsu.find(i);
            map.computeIfAbsent(key, unused -> new ArrayList<>()).add(i);
        }

        StringBuilder res = new StringBuilder(s);
        //遍历所有每个下标集合，进行字符局部排序
        for (List<Integer> idx_list : map.values())
            if (idx_list.size() > 1)
                sort(res, idx_list);

        return res.toString();
    }

    //根据下标集合进行局部排序
    private void sort(StringBuilder res, List<Integer> idx_list) {
        int len = idx_list.size();
        char[] array = new char[len];
        //根据下标集合构建字符集合
        for (int i = 0; i < len; ++i)
            array[i] = res.charAt(idx_list.get(i));
        //将字符集合排序
        Arrays.sort(array);
        //将字符按序“插入”回StringBuilder
        for (int i = 0; i < len; ++i)
            res.setCharAt(idx_list.get(i), array[i]);
    }
}

class DSU {
    int[] parent;

    public DSU(int len) {
        parent = new int[len];
        for (int i = 0; i < len; ++i)
            parent[i] = i;
    }

    public int find(int x) {
        return parent[x] != x ? parent[x] = find(parent[x]) : x;
    }

    public void union(int x, int y) {
        parent[find(x)] = find(y);
    }
}

// 方法二
class Solution {
    int[] group;

    void union(int a, int b) {
        group[find(a)] = group[find(b)];
    }

    int find(int a) {
        if (group[a] != a) {
            group[a] = find(group[a]);
        }
        return group[a];
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        group = new int[s.length()];
        for (int i = 0; i < group.length; i++) {
            group[i] = i;
        }

        for (List<Integer> pair : pairs) {
            union(pair.get(0), pair.get(1));
        }

        Map<Integer, Queue<Character>> groupChar = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            groupChar.putIfAbsent(find(i), new PriorityQueue<>());
            groupChar.get(find(i)).add(s.charAt(i));
        }

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            output.append(groupChar.get(find(i)).poll());
        }

        return output.toString();
    }

    public static void tet() {
        System.out.println("void");
    }

    public static int tet(int a){
        return 1;
    }

    public static int tet(String a) {
        return 2;
    }
}