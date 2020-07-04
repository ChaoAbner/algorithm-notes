package com.fosuchao.hot;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @Description: https://leetcode-cn.com/problems/combination-sum/
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 

 * @Auther: Joker Ye
 * @Date: 2020/1/8 14:19
 */
public class CombinationSum {
    private List<List<Integer>> res = new ArrayList<>();
    private int[] candidates;
    private int len;

//    private void findCombinationSum(int residue, int start, Stack<Integer> pre) {
//        if (residue == 0) {
//            // Java 中可变对象是引用传递，因此需要将当前 path 里的值拷贝出来
//            res.add(new ArrayList<>(pre));
//            return;
//        }
//        // 优化添加的代码2：在循环的时候做判断，尽量避免系统栈的深度
//        // residue - candidates[i] 表示下一轮的剩余，如果下一轮的剩余都小于 0 ，就没有必要进行后面的循环了
//        // 这一点基于原始数组是排序数组的前提，因为如果计算后面的剩余，只会越来越小
//        for (int i = start; i < len && residue - candidates[i] >= 0; i++) {
//            pre.add(candidates[i]);
//            // 【关键】因为元素可以重复使用，这里递归传递下去的是 i 而不是 i + 1
//            findCombinationSum(residue - candidates[i], i, pre);
//            pre.pop();
//        }
//    }
//
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        int len = candidates.length;
//        if (len == 0) {
//            return res;
//        }
//        // 优化添加的代码1：先对数组排序，可以提前终止判断
//        Arrays.sort(candidates);
//        this.len = len;
//        this.candidates = candidates;
//        findCombinationSum(target, 0, new Stack<>());
//        return res;
//    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer,Set<List<Integer>>> map = new HashMap<>();
        //对candidates数组进行排序
        Arrays.sort(candidates);
        int len = candidates.length;
        for(int i = 1;i <= target;i++){
            //初始化map
            map.put(i,new HashSet<>());
            //对candidates数组进行循环
            for(int j = 0;j < len&&candidates[j] <= target;j++){
                if(i == candidates[j]){
                    //相等即为相减为0的情况，直接加入set集合即可
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    map.get(i).add(temp);
                }else if(i > candidates[j]){
                    //i-candidates[j]是map的key
                    int key = i-candidates[j];
                    //使用迭代器对对应key的set集合进行遍历
                    //如果candidates数组不包含这个key值，对应的set集合会为空，故这里不需要做单独判断
                    for(Iterator iterator = map.get(key).iterator();iterator.hasNext();){
                        List list = (List) iterator.next();
                        //set集合里面的每一个list都要加入candidates[j]，然后放入到以i为key的集合中
                        List tempList = new ArrayList<>();
                        tempList.addAll(list);
                        tempList.add(candidates[j]);
                        //排序是为了通过set集合去重
                        Collections.sort(tempList);
                        map.get(i).add(tempList);
                    }
                }
            }
        }
        result.addAll(map.get(target));
        return result;
    }


    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        CombinationSum solution = new CombinationSum();
        List<List<Integer>> combinationSum = solution.combinationSum(candidates, target);
        System.out.println(combinationSum);
    }
}
