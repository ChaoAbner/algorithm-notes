package com.fosuchao.exercise;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @description: 银行家算法, 动态避免死锁
 * @author: Joker Ye
 * @create: 2020/2/24 20:18
 * @noinspection Duplicates
 */
public class Bankers {
    // max[i][j]表示第i个进程的对第j个资源的最大需求数
    private Integer[][] max;

    // allocation[i][j]表示第i个进程对第j个资源分配的个数
    private Integer[][] allocation;

    // need[i][j]表示第i个进程还需要多少个第j个资源才能满足工作需求, need[i][j] = max[i][j] - allocation[i][j]
    private Integer[][] need;

    // remain[j]来表示系统第j个资源的剩余量
    private Integer[] avaliable;

    // 判断已进入安全队列的进程
    private boolean[] finish;

    // 安全进程序列
    private List<String> processes = new LinkedList<>();

    public Bankers(Integer[][] max, Integer[][] allocation, Integer[][] need, Integer[] avaliable) {
        this.max = max;
        this.allocation = allocation;
        this.need = need;
        this.avaliable = avaliable;
        this.finish = new boolean[allocation.length];
        show();
    }

    /**
     * @Param i: 进程号
     * @Param resource: 请求的资源数
     * @return void
     */    
    public void request(int i, int[] resource) {
        if (finish[i]) {
            System.out.println("进程" + i + "已经完成工作了，不需要再次分配");
            return;
        }
        // 判断请求的资源数量是否大于剩余量
        for (int j = 0; j < resource.length; j++) {
            if (resource[j] > avaliable[j]) {
                System.out.println("资源不能满足需求！！分配失败");
                return;
            }
            if (resource[j] > need[i][j]) {
                System.out.println("请求分配的资源数量大于需求数了！！分配失败");
                return;
            }
        }

        // 判断扣除请求的资源后，是否满足安全性
        for (int j = 0; j < resource.length; j++) {
            // 需求数和资源剩余量减少
            need[i][j] -= resource[j];
            avaliable[j] -= resource[j];
        }

        // 验证安全性
        if (!safe()) {
            System.out.println("分配后将不满足安全性，不予分配！");
            // 资源数量复位
            for (int j = 0; j < resource.length; j++) {
                need[i][j] += resource[j];
                avaliable[j] += resource[j];
            }
            return;
        } else {
            System.out.println("分配合理，资源获取成功！");
            processes.add("process" + i);
            recycle(i, resource);
        }
        show();
    }

    private void recycle(int i, int[] resource) {
        Integer[] curr = need[i];
        boolean flag = true;
        // 判断并回收第i个线程的资源
        for (int j = 0; j < curr.length; j++) {
            if (curr[j] != 0) {
                flag = false;
                break;
            }
        }
        if (flag) {
            // 回收资源
            for (int j = 0; j < allocation[i].length; j++) {
                avaliable[j] += allocation[i][j];
                avaliable[j] += resource[j];
                allocation[i][j] = 0;
            }
            finish[i] = true;
        }
    }

    public boolean safe() {
        // 安全性监测
        boolean flag = true;
        for (int i = 0; i < need.length; i++) {
            for (int j = 0; j < need[i].length; j++) {
                // 不满足需求量
                if (need[i][j] > avaliable[j] && !finish[i]){
                    flag = false;
                    break;
                }
            }
            if (flag) return flag;
            flag = true;
        }
        return false;
    }

    public void show() {
        String split = "---";
        // 当前资源分配情况
        System.out.println("当前资源分配情况如下");
        for (int i = 0; i < allocation.length; i++) {
            System.out.print("进程" + i + ":");
            for (int j = 0; j < allocation[i].length; j++) {
                System.out.print(allocation[i][j] + split);
            }
            System.out.println();
        }

        // 当前各个进程需求情况
        System.out.println("当前进程需求情况如下");
        for (int i = 0; i < need.length; i++) {
            System.out.print("进程" + i + ":");
            for (int j = 0; j < need[i].length; j++) {
                System.out.print(need[i][j] + split);
            }
            System.out.println();
        }

        // 当前系统剩余资源情况
        System.out.println("当前系统剩余资源情况");
        for (int i = 0; i < avaliable.length; i++) {
            System.out.print(avaliable[i] + split);
        }
        System.out.println();
    }

    public void showSafeQueue() {
        System.out.println("安全队列如下");
        processes.forEach(System.out::println);
    }
}


class Main {
    // 5个进程， 3个资源a, b, c
    private static Integer[][] max = {{3,2,2},{6,1,3},{3,1,4},{4,2,2}};
    private static Integer[][] allocation = {{1,0,0},{6,1,2},{2,1,1},{0,0,2}};
    private static Integer[][] need = {{2,2,2},{0,0,1},{1,0,3},{4,2,0}};
    private static Integer[] remain = {3,2,3};

    public static void main(String[] args) {
        Bankers bankers = new Bankers(max, allocation, need, remain);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("输入要分配的线程：");
            int i = scanner.nextInt();
            int [] resource = new int[3];
            for (int j = 0; j < 3; j++) {
                System.out.print("输入想要分配第" + (j + 1) + "个资源的数量");
                resource[j] = scanner.nextInt();
                System.out.println();
            }
            bankers.request(i, resource);
        }
    }
}