package com.fosuchao.type.greedy;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by Chao Ye on 2020/12/30
 * https://leetcode-cn.com/problems/last-stone-weight/
 * 1046. 最后一块石头的重量
 */
public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            heap.offer(stone);
        }
        while (heap.size() > 1) {
            int a = heap.poll();
            int b = heap.poll();
            if (a != b) {
                heap.offer(Math.abs(a - b));
            }
            if (heap.isEmpty()) {
                return 0;
            }
        }
        return heap.poll();
    }
}
