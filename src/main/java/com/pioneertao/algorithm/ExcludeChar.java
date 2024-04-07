package com.pioneertao.algorithm;

/**
 * 给你一个字符串数组 char[] clist 跟一个字符c, clist中可能包含多个c可能不包含c，排除clist中等于c的元素，不能利用额外的数组空间
 */
public class ExcludeChar {

    public static void excludeChar(char[] clist, char c) {
        int writeIndex = 0;
        for (int i = 0; i < clist.length; i++) {
            if (clist[i] != c) {
                clist[writeIndex] = clist[i];
                writeIndex++;
            }
        }

        // 将剩余位置的元素置为空格
        while (writeIndex < clist.length) {
            clist[writeIndex] = ' ';
            writeIndex++;
        }
    }
}
