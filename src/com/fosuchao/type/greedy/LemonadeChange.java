package com.fosuchao.type.greedy;

/**
 * Created by Chao Ye on 2020/12/29
 *
 * 860 柠檬水找零: https://leetcode-cn.com/problems/lemonade-change/
 *
 */
public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {
        // 顾客能支付5，10，20元的钞票，使用变量来计数
        int fiveCount = 0;
        int tenCount = 0;

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                fiveCount++;
            }
            if (bills[i] == 10) {
                if (fiveCount == 0) {
                    return false;
                }
                tenCount++;
                fiveCount--;
            }
            // 20元有可能找零 1张10元和1张5元或者3张5元
            if (bills[i] == 20) {
                if (fiveCount > 0 && tenCount > 0) {
                    fiveCount--;
                    tenCount--;
                } else if (fiveCount >= 3) {
                    fiveCount -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
