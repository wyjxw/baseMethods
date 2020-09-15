package com.wuyu.day10.BasisMethods;

public class JiaQuanKuaiSuHeBing {

    int[] father;
    int[] sz;
    int num;

    public int find(int p) {
        if (p != father[p]) {
            p = find(father[p]);
        }
        return p;
    }
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        num -= 1;
        if (sz[i] < sz[j]) {
            father[i] = j;
            sz[j] += sz[i];
        } else {
            father[j] = i;
            sz[i] += sz[j];
        }
    }

    public void initUF(int n) {
        father = new int[n];
        sz = new int[n];
        num = n;
        for (int i = 0; i < n; i++) {
            father[i] = i;
            sz[i] = 1;
        }
    }

}
