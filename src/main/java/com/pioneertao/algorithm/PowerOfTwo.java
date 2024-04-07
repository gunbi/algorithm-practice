package com.pioneertao.algorithm;

/**
 * 判断一个数是不是2的幂次方
 */
public class PowerOfTwo {


    //一个数如果是 2 的幂次方，那么它的二进制表示中只有最高位是 1，其余位都是 0。
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        PowerOfTwo solution = new PowerOfTwo();
        int num1 = 16;
        int num2 = 17;

        System.out.println(num1 + " is power of two: " + solution.isPowerOfTwo(num1));
        System.out.println(num2 + " is power of two: " + solution.isPowerOfTwo(num2));
    }

}
