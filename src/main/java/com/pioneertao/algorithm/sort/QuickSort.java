package com.pioneertao.algorithm.sort;

import java.util.Arrays;

public class QuickSort {


    public static void quickSort(int[] a, int low, int high) {
        if (low == high)
            return;
        int i = low;
        int j = high;
        int key = a[low];
        while (i < j) {
            while (i < j && a[j] >= key) j--;
            while (i < j && a[i] <= key) i++;
            if (i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        a[low] = a[i];
        a[i] = key;
        quickSort(a, low, i);
        quickSort(a, i + 1, high);
    }


    public static void main(String[] args) {
        int[] a = {332, 46, 43456, 2234, 4, 64567, 1, 45, 67, 34545, 8, 234545, 83, 34, 85};
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

}
