package com.pioneertao.algorithm;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 给定两个人的可用时间槽数组 slots1 和 slots2，以及一个会议的持续时间 duration，
 * 请你计算可以预约成功的最早开始时间和最晚结束时间，并输出可以预约成功的时间段，如果不存在符合要求的时间段，返回空数组。
 */
public class MeetingScheduler {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        //对时间段数组进行排序
        Arrays.sort(slots1, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(slots2, Comparator.comparingInt(a -> a[0]));

        //然后使用两个指针i和j来遍历两个数组
        int i = 0, j = 0;
        while (i < slots1.length && j < slots2.length) {
            int start = Math.max(slots1[i][0], slots2[j][0]);
            int end = Math.min(slots1[i][1], slots2[j][1]);

            if (end - start >= duration) {
                return Arrays.asList(start, start + duration);
            }

            if (slots1[i][1] < slots2[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        return new ArrayList<>();
    }

    public static void main(String[] args) {
        MeetingScheduler scheduler = new MeetingScheduler();
        int[][] slots1 = {{10, 50}, {60, 120}, {140, 210}};
        int[][] slots2 = {{0, 15}, {60, 70}};
        int duration = 8;
        List<Integer> result = scheduler.minAvailableDuration(slots1, slots2, duration);
        System.out.println("Result: " + result); // Output: [60, 68]
    }

}
