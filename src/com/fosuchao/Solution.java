package com.fosuchao;

import java.util.*;

/**
 * @description:
 * @author: Joker Ye
 * @create: 2020/3/20 13:52
 */

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] ans = new int[n][2];
        for(int i=0;i<n;i++){
            ans[i][0] = scanner.nextInt();
            ans[i][1] = scanner.nextInt();
        }
        Arrays.sort(ans,(a,b)->a[0]!=b[0]?a[0]-b[0]:a[1]-b[1]);
        int[] arr = new int[n];
        for(int i=0;i<n;i++)arr[i] = ans[i][1];
        System.out.println(Arrays.toString(arr));
        for (int[] an : ans) {
            System.out.print(Arrays.toString(an));
        }
        System.out.println();
        System.out.println(LIS(arr));
    }

    public static int LIS(int[] arr){
        int[] dp = new int[arr.length];
        int res = 0;
        for(int num:arr){
            int l = 0,r = res;
            while (l<r){
                int m = (l+r)/2;
                if(dp[m] < num)
                    l = m+1;
                else
                    r = m;
            }
            dp[l] = num;
            if(l==res)res++;
        }
        System.out.println(Arrays.toString(dp));
        return res;
    }

}
