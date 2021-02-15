package com.fosuchao.random;



import java.util.Arrays;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Description: ���������� N?�����ǰ��κ�˳�򣨰���ԭʼ˳�򣩽�������������ע����ǰ�����ֲ���Ϊ�㡣
 *
 * ������ǿ���ͨ��������ʽ�õ�?2 ���ݣ����� true�����򣬷��� false��
 *
 * @Auther: Joker Ye
 * @Date: 2019/11/15 12:10
 */
public class ReorderedPowerOf2 {

    public static void main(String[] args) {
        long start = System.nanoTime();
        boolean b = reorderedPowerOf2(64);
        long end = System.nanoTime();
        long l = TimeUnit.NANOSECONDS.toMillis(end - start);
//        System.out.println(b);
    }

    public static boolean reorderedPowerOf2(int N) {
        int[] A = count(N);
        for (int i = 0; i < 31; ++i){
            System.out.println(i);
            if (Arrays.equals(A, count(1 << i)))
                return true;
        }

        return false;
    }

    // Returns the count of digits of N
    // Eg. N = 112223334, returns [0,2,3,3,1,0,0,0,0,0]
    public static int[] count(int N) {
        int[] ans = new int[10];
        while (N > 0) {
            ans[N % 10]++;
            N /= 10;
        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }




    public void test(){
        long start = System.nanoTime();
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString().replaceAll("-", ""));
        long end = System.nanoTime();
        System.out.printf("spend time %d ms", TimeUnit.NANOSECONDS.toMillis(end - start));
        System.out.println();
    }
}
