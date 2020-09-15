package com.wuyu.day10.BasisMethods;

import java.util.Scanner;

public class DFS {
    static int[] get=new int [1000];
    static int[][] path;
    static int n;
    static int min_dis=Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner((System.in));
        n=sc.nextInt();
        int m=sc.nextInt();
        sc.nextLine();
        path=new int [n+1][n+1];
        for(int i=0;i<m;i++){
            String s=sc.nextLine();
            String [] str=s.split(" ");
            int a=Integer.parseInt(str[0]);
            int b=Integer.parseInt(str[1]);
            int v=Integer.parseInt(str[2]);
            path[a][b]=v;
            path[b][a]=v;
        }
        String [] target=sc.nextLine().split(" ");
        int start=Integer.parseInt(target[0]);
        int end=Integer.parseInt(target[1]);
        get[start]=1;
        dfs(start,end,0);
        System.out.println(min_dis);
    }
    private static void dfs(int start, int end, int dis) {
        if(dis>min_dis) return;
        if(start==end){
            if(dis<min_dis){
                min_dis=dis;
                return;
            }
        }
        for(int i=1;i<=n;i++){
            if(path[start][i]!=0 &&get[i]==0 ){
                get[i]=1;
                dfs(i,end,dis+path[start][i]);
                get[i]=0;
            }
        }
        return;
    }

}
