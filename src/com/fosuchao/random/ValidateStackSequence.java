package com.fosuchao.random;

import java.util.Stack;

/**
 * @Description:
 * @Auther: Joker Ye
 * @Date: 2019/11/9 22:25
 */
public class ValidateStackSequence {
    public static void main(String[] args) {
        int[] pushed = new int[]{1,2,3,4,5};
        int[] popped = new int[]{4,5,3,2,1};
        boolean b = validateStackSequences(pushed, popped);
        System.out.println("���Ϊ�� " + b);
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        int popCursor = 0;
        Stack<Integer> stack = new Stack<>();

        for (int p : pushed) {
            stack.push(p);
            while (!stack.isEmpty() && stack.peek() == popped[popCursor]){
                stack.pop();
                popCursor++;
            }
        }

        return popCursor == popped.length;
    }
}

