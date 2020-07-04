package com.fosuchao.hot;

import java.util.*;

/**
 * @Description:
 * @Auther: Joker Ye
 * @Date: 2020/1/8 16:27
 */
public class Permute {
    private List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return res;
        }
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[nums.length];
        combine(stack, nums, visited);
        return res;
    }

    public void combine(Stack<Integer> stack, int[] nums, boolean[] visited) {
        if (stack.size() == nums.length) {
            res.add(new ArrayList<>(stack));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!visited[i]) {
                    stack.add(nums[i]);
                    visited[i] = true;
                    combine(stack, nums, visited);
                    // 回溯
                    visited[i] = false;
                    stack.pop();
                }
            }
        }
    }

//    public void backtrack(int n,
//                          ArrayList<Integer> nums,
//                          List<List<Integer>> output,
//                          int first) {
//        // if all integers are used up
//        if (first == n)
//            output.add(new ArrayList<Integer>(nums));
//        for (int i = first; i < n; i++) {
//            // place i-th integer first
//            // in the current permutation
//            Collections.swap(nums, first, i);
//            // use next integers to complete the permutations
//            backtrack(n, nums, output, first + 1);
//            // backtrack
//            Collections.swap(nums, first, i);
//        }
//    }
//
//    public List<List<Integer>> permute(int[] nums) {
//        // init output list
//        List<List<Integer>> output = new LinkedList();
//
//        // convert nums into list since the output is a list of lists
//        ArrayList<Integer> nums_lst = new ArrayList<Integer>();
//        for (int num : nums)
//            nums_lst.add(num);
//
//        int n = nums.length;
//        backtrack(n, nums_lst, output, 0);
//        return output;
//    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        Permute permute = new Permute();
        List<List<Integer>> permute1 = permute.permute(a);
        System.out.println(permute1);
    }
}

/**
 * class Solution {
 * public void backtrack(int n,
 * ArrayList<Integer> nums,
 * List<List<Integer>> output,
 * int first) {
 * if (first == n)
 * output.add(new ArrayList<Integer>(nums));
 * for (int i = first; i < n; i++) {
 * Collections.swap(nums, first, i);
 * backtrack(n, nums, output, first + 1);
 * Collections.swap(nums, first, i);
 * }
 * }
 * <p>
 * public List<List<Integer>> permute(int[] nums) {
 * List<List<Integer>> output = new LinkedList();
 * <p>
 * ArrayList<Integer> nums_lst = new ArrayList<Integer>();
 * for (int num : nums)
 * nums_lst.add(num);
 * <p>
 * int n = nums.length;
 * backtrack(n, nums_lst, output, 0);
 * return output;
 * }
 * }
 */