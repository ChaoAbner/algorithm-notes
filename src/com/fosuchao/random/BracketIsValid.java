package com.fosuchao.random;

import java.util.Stack;

/**
 * @Description: ��Ŀ��ַ��https://leetcode-cn.com/problems/valid-parentheses/submissions/
 * @Auther: Joker Ye
 * @Date: 2019/11/22 13:09
 */
public class BracketIsValid {
    public static void main(String[] args) {
        String s = "()[]{";
        boolean valid = isValid(s);
        System.out.println(valid);
    }

    public static boolean isValid(String s){
        /**
         * �ɹ�����
         * ִ����ʱ :
         * 2 ms ������ java �ύ�л�����
         * 95.91% ���û�
         * �ڴ����� :
         * 33.9 MB
         * , ������ java �ύ�л�����
         * 90.32%���û�
         * @Param [s]
         * @return boolean
         */
        if((s.length() & 1) == 1){
            return false;
        }
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
            } else {
                switch (s.charAt(i)){
                    case ')': {
                        if(stack.pop() != '('){
                            return false;
                        }
                        break;
                    }
                    case ']': {
                        if(stack.pop() != '['){
                            return false;
                        }
                        break;
                    }
                    case '}': {
                        if(stack.pop() != '{'){
                            return false;
                        }
                        break;
                    }
                    default: stack.push(s.charAt(i));
                }
            }
        }
        if(!stack.isEmpty())
            return false;
        return true;
    }


}
