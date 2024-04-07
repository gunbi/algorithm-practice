package com.pioneertao.algorithm;

/**
 * 下面是一个使用快速排序思想查找第 K 大的数的
 */
public class KthLargestNumber {

    private int quickSelect(int[] nums, int left, int right, int k) {
        int pivot = partition(nums, left, right);

        if (pivot == k - 1) {
            return nums[pivot];
        } else if (pivot < k - 1) {
            return quickSelect(nums, pivot + 1, right, k);
        } else {
            return quickSelect(nums, left, pivot - 1, k);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;

        for (int j = left; j < right; j++) {
            if (nums[j] >= pivot) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }

        int temp = nums[i];
        nums[i] = nums[right];
        nums[right] = temp;

        return i;
    }

    public static void main(String[] args) {
        KthLargestNumber solution = new KthLargestNumber();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

        System.out.println("Kth largest number: " + solution.quickSelect(nums, 0, nums.length - 1, k));
    }

}
