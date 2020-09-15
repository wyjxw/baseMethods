package com.wuyu.day10.BasisMethods;

/**
 * 朴素并查集
 */
public class PuSuBingChaJi {

    public static int[] p;

    public static int find(int x) {
        if (p[x] != x)
            p[x] = find(p[x]);
        return p[x];
    }

//    p[find(a)] = find(b);

}
