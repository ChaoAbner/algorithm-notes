package com.fosuchao.random;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Description: ��ת����
 * @Auther: Joker Ye
 * @Date: 2019/11/20 18:54
 */
public class Reverse {

    public static void main(String[] args) {
        int x = 1534236469;
        int reverse = reverse(x);
        System.out.println(reverse);
    }

    /**
     *�������������������� & ���ǰ���м��
     * ˼·
     *
     * ���ǿ���һ�ι�����ת������һλ���֡�����������ʱ�����ǿ���Ԥ�ȼ����ԭ����������һλ�����Ƿ�ᵼ�������
     *
     * �㷨
     *
     * ��ת�����ķ��������뷴ת�ַ���������ȡ�
     *
     * �������ظ��������� xx �����һλ���֣������������롱�� \text{rev}rev �ĺ��档���\text{rev}rev ���� xx �෴��
     *
     * Ҫ��û�и�����ջ / ����İ����� �������� �� �����롱 ���֣����ǿ���ʹ����ѧ������
     * @Param [x]
     * @return int
     */
    public static int reverse(int x){
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    @Test
    public void test(){
        int num = 123;
        // תΪ����
        String[] split = String.valueOf(num).split("");
        System.out.println(Arrays.toString(split));
        Integer integer = Integer.valueOf("123");

        System.out.println(0 - integer);
    }
}
