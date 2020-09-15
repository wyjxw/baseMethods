package com.wuyu.day10.BasisMethods;

import java.util.ArrayList;
import java.util.List;

/**
 * 得到的是所有的摆放结果
 */
public class NHuangHou {

    int Max;// 表示有多少个皇后
    int[] check; //索引i表示第i个皇后,check[i]表示第i个皇后下的位子,也就是第check[i]列
    List<List<String>> res;//结果集
    StringBuilder sb = new StringBuilder();//由于每个字符串都有n-1个'.'和一个Q,所以直接初始化为n个'.'

    public  List<List<String>> solveNQueens(int n) {
        Max = n;
        check = new int[n];
        res = new ArrayList<>();
        //初始化字符串为n个'.'
        for (int i = 0; i < Max; i++) {
            sb.append(".");
        }
        doCheck(0);
        return res;
    }

    private  void doCheck(int i) {
        if (i == Max) { //如果i=max,说明之前的i-1个旗子都已经下好了,将该棋盘加入结果集
            ArrayList<String> list = new ArrayList<>();
            for (int j = 0; j < Max; j++) {
                //将每个皇后下的位子的'.'替换为'Q'
                String s = replace(sb.toString(), check[j]);
                list.add(s);
            }
            res.add(list);
            return;
        }
        for (int j = 0; j < Max; j++) { //下棋
            check[i] = j;
            //判断这步棋是否合法
            if (isValid(i)) { //合法,继续下下一步棋
                doCheck(i + 1);
            }
        }
    }

    private  boolean isValid(int n) {
        for (int i = 0; i < n; i++) {
            if (check[i] == check[n] || Math.abs(check[i] - check[n]) == Math.abs(i - n)) {
                return false;
            }
        }
        return true;
    }

    private  String replace(String s, int i) {
        char[] chs = s.toCharArray();
        chs[i] = 'Q';
        return new String(chs);
    }
}
