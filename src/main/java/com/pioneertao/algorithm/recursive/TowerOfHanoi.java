package com.pioneertao.algorithm.recursive;

public class TowerOfHanoi {

    public static void hannoi(int n, String ori, String target, String temp) {
        if (n == 1) {
            System.out.println("将第" + n + "号盘从" + ori + "移动到" + target);
        } else {
            hannoi(n - 1, ori, temp, target);
            System.out.println("将第" + n + "号盘从" + ori + "移动到" + target);
            hannoi(n - 1, temp, target, ori);
        }
    }


    public static void main(String[] args) {
        hannoi(10, "A", "B", "C");
    }
}
