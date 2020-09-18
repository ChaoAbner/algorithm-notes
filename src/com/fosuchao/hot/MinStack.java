package com.fosuchao.hot;

import java.util.Stack;

/**
 * @Description:
 * @Auther: Joker Ye
 * @Date: 2020/1/11 23:46
 */

public class MinStack{
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

    }
}

class MStack {
    private int topPoint;
    private int min;
    private int[] stack;
    /** initialize your data structure here. */
    public MStack() {
        topPoint = -1;
        stack = new int[100];
    }

    public void push(int x) {
        if(x < min){
            min = x;
        }
        topPoint++;
        stack[topPoint] = x;
    }

    public void pop() {
        if(--topPoint > 0){
            if(stack[topPoint + 1] == min){
                min = Integer.MAX_VALUE;
                for(int i = 0; i < topPoint; i++){
                    if(stack[i] < min){
                        min = stack[i];
                    }
                }
            }
        }else {
            min = stack[0];
        }

    }

    public int top() {
        return stack[topPoint];
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */


