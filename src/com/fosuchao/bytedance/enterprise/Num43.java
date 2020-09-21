package com.fosuchao.bytedance.enterprise;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/multiply-strings/
 * 43. 字符串相乘
 *
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 *
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1和num2的长度小于110。
 * num1 和num2 只包含数字0-9。
 * num1 和num2均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class Num43 {

    /**
     *       1  2  3
     *       4  5  6
     *       ————————
     *       7  2  8
     *    6  1  5
     * 4  9  2
     *
     */
    public String multiply(String num1, String num2) {
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        int l1 = c1.length;
        int l2 = c2.length;

        char[] res = new char[l1 + l2];
        Arrays.fill(res, '0');
        // 分别将c2的每个元素与c1中的所有元素相乘
        for (int i = l2 - 1; i >= 0 ; i--) {
            for (int j = l1 - 1; j >= 0; j--) {
                int product = (c1[j] - '0') * (c2[i] - '0');
                int temp = (res[i + j + 1] - '0') + product;
                res[i + j + 1] = (char) (temp % 10 + '0');
                res[i + j] = (char) ((res[i + j] - '0' + temp / 10) + '0');
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean seen = false;
        for (char re : res) {
            if (re == '0' && !seen) {
                continue;
            }
            sb.append(re);
            seen = true;
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

}
