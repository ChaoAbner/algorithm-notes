package com.fosuchao.random;



import java.util.*;

/**
 * @Description:
 * @Auther: Joker Ye
 * @Date: 2019/11/11 16:29
 */
public class MaxRotate {
    public static void main(String[] args) {
        int[] A = {4, 3, 2, 6};
//        Integer[] A = new Integer[]{1,2,3};
//        String[] fruits = {"Apple", "Banana", "Orange"};

//        List<String> strings = Arrays.asList(fruits);
//        Arrays.asList(A);

        int i = maxRotateFunction(A);
        System.out.println("���ֵΪ��" + i);
    }

    public static int maxRotateFunction(int[] A) {
        if(A.length==0)return 0;
        int a = 0;//f(0)
        int b = 0;
        for(int i =0;i<A.length;i++){
            a+=A[i]*i;
            b+=A[i];
        }
        int max = a;
        for(int i=A.length-1;i >= 1;i--){
            a = a + b - A[i]*(A.length);
            max = Math.max(a, max);
        }
        return max;
    }


    public void test(){
        String[] str = new String[]{"you", "wu"};
        List<String> strings = Arrays.asList(str);
        // ��UnsupportedOperationException�쳣���ײ���Ȼ�����飬�޷�ʹ��add��remove��clear
//        strings.add("add");

        System.out.println(strings.get(0));
    }

}
