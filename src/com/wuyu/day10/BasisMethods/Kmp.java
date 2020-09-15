package com.wuyu.day10.BasisMethods;

/**
 * 字符串匹配算法
 */
public class Kmp {

    public int kmp(String text, String pattern) {
        int m = pattern.length();
        if (m == 0)
            return 0;
        int n = text.length();
        int[] next = new int[m + 1];
        for (int i = 2, j = 0; i <= m; i++) {
            while (j > 0 && pattern.charAt(i - 1) != pattern.charAt(j))
                j = next[j];
            if (pattern.charAt(i - 1) == pattern.charAt(j))
                j++;
            next[i] = j;
        }
        for (int i = 1, j = 0; i <= n; i++) {
            while (j > 0 && text.charAt(i - 1) != pattern.charAt(j))
                j = next[j];
            if (text.charAt(i - 1) == pattern.charAt(j))
                j++;
            if (j == m)
                return i - m;
        }
        return -1;
    }

}
