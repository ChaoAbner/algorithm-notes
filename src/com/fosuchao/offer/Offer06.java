package com.fosuchao.offer;


import java.util.ArrayList;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */
public class Offer06 {

    public int[] reversePrint(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        help(head, list);
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    private void help(ListNode head, ArrayList<Integer> list) {
        if (head == null) {
            return;
        }
        help(head.next, list);
        list.add(head.val);
    }
}
