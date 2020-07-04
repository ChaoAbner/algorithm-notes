package com.fosuchao.hot;

import com.fosuchao.random.Ispalindrome;
import org.hamcrest.core.Is;

import java.util.Stack;

/**
 * @Description:
 * @Auther: Joker Ye
 * @Date: 2020/1/18 16:03
 */
public class IsPalindrome {

    public static void main(String[] args) {

//        IsPalindrome isPalindrome = new IsPalindrome();
//
//        ListNode listNode = new ListNode(1);
//        ListNode listNode2 = new ListNode(2);
//        listNode.next = listNode2;
//        boolean res = isPalindrome.isPalindrome(listNode);
//        System.out.println(res);

        String a = "广州";
    }

    public boolean isPalindrome(ListNode head) {
        // 先将链表中的值赋给数组，再通过双指针法来判断是否回文
        if(head == null || head.next == null) return true;

        ListNode temp = head;
        int length = 0;
        while(temp != null){
            temp = temp.next;
            length++;
        }

        int[] list = new int[length];
        for(int i = 0; i < length; i++){
            list[i] = head.val;
            head = head.next;
        }

        int start = 0;
        int end = length - 1;

        while(start < end){
            if(list[start] != list[end]){
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
