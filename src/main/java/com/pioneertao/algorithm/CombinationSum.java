package com.pioneertao.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result, currentList, candidates, target, 0);
        return result;
    }

    //在 backtrack 方法中，我们尝试将数组中的元素加入到当前列表中，并继续递归地搜索剩余的目标值。如果目标值减到 0，
    //则说明找到了一个满足条件的组合，将其加入结果集中；如果目标值小于 0，则直接返回；否则继续尝试添加新的元素。
    private void backtrack(List<List<Integer>> result, List<Integer> currentList, int[] candidates, int remain, int start) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            result.add(new ArrayList<>(currentList));
        } else {
            for (int i = start; i < candidates.length; i++) {
                currentList.add(candidates[i]);
                // 由于可以重复使用元素，所以递归调用的起始位置仍为 i
                backtrack(result, currentList, candidates, remain - candidates[i], i);
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum solution = new CombinationSum();
        int[] candidates = {3, 2, 6, 7};
        int target = 7;
        List<List<Integer>> combinations = solution.combinationSum(candidates, target);
        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }

}
