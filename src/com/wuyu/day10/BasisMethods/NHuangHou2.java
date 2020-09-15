package com.wuyu.day10.BasisMethods;

/**
 * 输出方案总数
 */
public class NHuangHou2 {

    int res = 0;
    public int totalNQueens(int n) {
        dfs(new int[n], 0, n);
        return res;
    }

    //pos[i]  mean we choose pos[i] in line i.
    //(i , pos[i])
    void dfs(int[] pos, int index, int n) {
        for (int i = 0; i < n; i++) {
            pos[index] = i;
            if (checkLegal(pos, index, i)) {
                if (index + 1 == n) {
                    res++;
                } else {
                    dfs(pos, index + 1, n);
                }
            }
        }
    }

    boolean checkLegal(int[] pos, int index, int i) {
        for (int j = 0; j < index; j++) {
            if (pos[index] == pos[j] || Math.abs(index - j) == Math.abs(pos[index] - pos[j])) {
                return false;
            }
        }
        return true;
    }

}
