package com.pioneertao.algorithm.search;

import com.pioneertao.algorithm.sort.QuickSort;

import java.util.Arrays;

public class BinarySearch {

    public static Integer binarySearch(int[] a, int low, int high, int target) {
        if (low > high)
            return null;
        int mid = (low + high) >>> 1;
        if (a[mid] == target) {
            return mid;
        } else if (a[mid] > target) {
            return binarySearch(a, low, mid - 1, target);
        } else {
            return binarySearch(a, mid + 1, high, target);
        }
    }

    public static void main(String[] args) {
        int[] a = {332, 46, 43456, 2234, 4, 64567, 1, 45, 67, 34545, 8, 234545, 83, 34, 85};
        QuickSort.quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
        System.out.println(binarySearch(a, 0, a.length - 1, 1));
    }

}
