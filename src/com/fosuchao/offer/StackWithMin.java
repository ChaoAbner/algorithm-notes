package com.fosuchao.offer;

import java.util.Stack;

/**
 * @Description: 定义一个栈的数据结构，实现能得到栈的最小值，Pop, push, min都是 O(1)时间复杂度
 * @Auther: Joker Ye
 * @Date: 2020/1/28 17:09
 */
public class StackWithMin {

    private Stack<Integer> minStack = new Stack<Integer>();
    private Stack<Integer> dataStack = new Stack<Integer>();

    public void push(int num){
        if(minStack.isEmpty() || minStack.peek() > num){
            minStack.push(num);
        } else {
            minStack.push(minStack.peek());
        }

        dataStack.push(num);
    }

    public int min(){
        return minStack.peek();
    }

    public int pop(){
        if(minStack.isEmpty() || dataStack.isEmpty()){
            return -1;
        }
        minStack.pop();
        return dataStack.pop();
    }

    public void show(){
        System.out.print("minstack:");
        System.out.println(minStack);
        System.out.print("datastack:");
        System.out.println(dataStack);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,2,5,0};
        StackWithMin stackWithMin = new StackWithMin();
        for (int num : nums) {
            stackWithMin.push(num);
        }
        System.out.println(stackWithMin.min());
        stackWithMin.show();
    }

}
