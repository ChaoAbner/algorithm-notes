package com.fosuchao.type.greedy;

import java.util.Arrays;

/**
 * Created by Chao Ye on 2020/12/30
 * 455. 分发饼干 https://leetcode-cn.com/problems/assign-cookies/
 *
 * 1. 给一个孩子的饼干应该尽可能小
 * 2. 因为满足度小的孩子最容易满足，因此先满足满足度小的孩子
 */
public class FindContentChildren {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int childIndex = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] >= g[childIndex]) {
                childIndex++;
            }
            if (childIndex == g.length - 1) {
                return g.length;
            }
        }
        return childIndex;
    }
}
