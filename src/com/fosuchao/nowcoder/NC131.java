package com.fosuchao.nowcoder;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created by Chao Ye on 2021/2/15
 */
public class NC131 {

    public static void main(String[] args) {
        int[][] operations = {{1,5},{2},{1,3},{2},{1,6},{2},{1,7},{2}};
        new NC131().flowmedian(operations);
    }

    MedianHolder holder = new MedianHolder();

    public double[] flowmedian (int[][] operations) {
        ArrayList<Double> list = new ArrayList<>();
        // write code here
        for (int[] i : operations) {
            if (i[0] == 1) {
                holder.addNum(i[1]);
            } else {
                if (holder.isEmpty()) {
                    list.add(Double.valueOf(-1L));
                } else {
                    list.add(holder.getMid());
                }
            }
        }
        double[] res = new double[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}

class MedianHolder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    MedianHolder() {
        this.maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        this.minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (maxHeap.size() == minHeap.size()) {
            // 偶数，将元素加到minHeap
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        } else {
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        }
    }

    public double getMid() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return minHeap.peek();
        }
    }

    public boolean isEmpty() {
        return maxHeap.isEmpty() && minHeap.isEmpty();
    }
}