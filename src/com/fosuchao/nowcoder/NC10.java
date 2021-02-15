package com.fosuchao.nowcoder;

/**
 * Created by Chao Ye on 2021/2/15
 * 题目描述
 * 以字符串的形式读入两个数字，编写一个函数计算它们的乘积，以字符串形式返回。
 * （字符串长度不大于10000，保证字符串仅由'0'~'9'这10种字符组成）
 * 示例1
 * 输入
 * 复制
 * "11","99"
 * 返回值
 * 复制
 * "1089"
 * 说明
 * 11*99=1089
 * <p>
 * https://www.nowcoder.com/practice/c4c488d4d40d4c4e9824c3650f7d5571?tpId=117&tqId=37843&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */
public class NC10 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param s string字符串 第一个整数
     * @param t string字符串 第二个整数
     * @return string字符串
     */
    public String solve(String s, String t) {
        // 数字数组，高位在数组左，低位在数组右，处理时需注意
        int[] arrOne = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arrOne[i] = s.charAt(i) - '0';
        }
        int[] arrTwo = new int[t.length()];
        for (int i = 0; i < t.length(); i++) {
            arrTwo[i] = t.charAt(i) - '0';
        }

        return getRes(arrOne, arrTwo);
    }

    public String getRes(int[] arrOne, int[] arrTwo) {
        int lenOne = arrOne.length;
        int lenTwo = arrTwo.length;

        // 开辟结果数组，结果长度至多为 lenOne + lenTwo
        int[] result = new int[lenOne + lenTwo];

        // 开始计算，先不考虑进位,每次结果存在result[i + j + 1]位置
        // 为什么是i + j + 1?
        // 因为结果数组计算处理高位在数组左，低位在数组右。i+j+1实际上是往低位存，这样后面进位处理才正确
        for (int i = 0; i < lenOne; i++) {
            for (int j = 0; j < lenTwo; j++) {
                // !!!这里是i + j + 1这样最后的进位才能正确计算
                result[i + j + 1] += arrOne[i] * arrTwo[j];
            }
        }

        // 计算该位进位和结果数,从最低位(数组末尾)开始向前计算
        int carry = 0;
        for (int i = result.length - 1; i >= 0; i--) {
            int sum = carry + result[i];
            result[i] = sum % 10;
            carry = sum / 10;
        }

        // 转为String，需要无视前置0,如果最终builder长度为0,则代表输入类似"0" "0"的用例，结果应该输出“0”
        StringBuilder builder = new StringBuilder();
        int curPos = 0;
        while (curPos < result.length && result[curPos] == 0) {
            curPos++;
        }
        for (int i = curPos; i < result.length; i++) {
            builder.append(result[i]);
        }
        return builder.length() != 0 ? builder.toString() : "0";
    }

    public static void main(String[] args) {

        System.out.println(new NC10().solve("234567123897470000", "45637567732323"));
    }
}
