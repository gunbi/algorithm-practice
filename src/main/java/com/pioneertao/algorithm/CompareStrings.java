package com.pioneertao.algorithm;

public class CompareStrings {
    public static int compareStrings(String s1, String s2) {
        int num1 = Integer.parseInt(s1);
        int num2 = Integer.parseInt(s2);

        if (num1 > num2) {
            return 1;
        } else if (num1 == num2) {
            return 0;
        } else {
            return -1;
        }
    }

    public static int compareStrings2(String s1, String s2) {
        int num1 = convertStringToNumber(s1);
        int num2 = convertStringToNumber(s2);

        if (num1 > num2) {
            return 1;
        } else if (num1 == num2) {
            return 0;
        } else {
            return -1;
        }
    }

    private static int convertStringToNumber(String str) {
        int num = 0;
        int sign = 1;
        int i = 0;

        if (str.charAt(0) == '-') {
            sign = -1;
            i = 1;
        } else if (str.charAt(0) == '+') {
            i = 1;
        }

        while (i < str.length()) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            }
            i++;
        }

        return num * sign;
    }
}
