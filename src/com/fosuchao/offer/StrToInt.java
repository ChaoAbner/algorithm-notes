package com.fosuchao.offer;

/**
 * @Description:
 * @Auther: Joker Ye
 * @Date: 2020/2/12 17:06
 */
public class StrToInt {
    public static void main(String[] args) {
        System.out.println(new StrToInt().strToInt("-2147483649"));
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);

    }

    public int strToInt(String str) {
        if (str == null || str.length() == 0)
            return 0;
        // 先判断符号，正or负
        boolean minus = false;
        char [] charArray = str.toCharArray();
        int i = 0;
        if (charArray[0] == '-'){
            minus = true;
            i++;
        }
        else if (charArray[0] == '+')
            i++;
        long res = 0;
        for (; i < charArray.length; i++) {
            if (charArray[i] < 48 || charArray[i] > 57 || !valid(res))
                return 0;
            res = res * 10 + charArray[i] - 48;
            if (!valid(res))
                return 0;
        }
        if (minus)
            res *= -1;
        return (int) res;
    }

    private boolean valid(long num) {
        if (num > Integer.MAX_VALUE || (num * -1) < Integer.MIN_VALUE)
            return false;
        return true;
    }
}
