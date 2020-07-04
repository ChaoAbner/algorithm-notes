package com.fosuchao.offer;

import java.util.Stack;

/**
 * @Description: 栈的压入、弹出序列
 * 如1, 2, 3, 4, 5的顺序压入，有可能是4, 5, 3, 2, 1 或 5, 4, 3, 2, 1的顺序弹出。但是不可能是4, 5, 3, 1, 2
 * @Auther: Joker Ye
 * @Date: 2020/1/28 19:06
 */
public class IsPopOrder {

    public static void main(String[] args) {
        int[] in = {1, 2, 3, 4, 5};
        int[] out = {5, 4, 3, 2, 1};
        IsPopOrder isPopOrder = new IsPopOrder();
        boolean popOrder = isPopOrder.isPopOrder(in, out);
        System.out.println(popOrder);
    }

    public boolean isPopOrder(int[] in, int[] out) {
        if (in.length != out.length || out.length == 0 || in.length == 0) {
            return false;
        }
        Stack<Integer> inStack = new Stack<>();
        int inIndex = 0;
        int outNum = out[0];
        int outIndex = 1;
        while (out.length + 1 != outIndex) {
            if (in.length != inIndex || inStack.isEmpty()) {
                inStack.push(in[inIndex]);
                inIndex++;
            }

            if (inStack.peek() == outNum) {
                inStack.pop();
                if (outIndex != out.length) {
                    outNum = out[outIndex];
                    outIndex++;
                }
                if (inStack.isEmpty())
                    break;
            } else {
                if (in.length == inIndex)
                    break;
            }

        }

        return inStack.isEmpty();
    }
}
