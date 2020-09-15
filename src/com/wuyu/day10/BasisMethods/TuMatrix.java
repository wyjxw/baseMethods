package com.wuyu.day10.BasisMethods;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * n个点，m条边，m约等于n2n2叫做稠密图，
 * 用邻接矩阵存储；
 * n个点，m条边，m远小于n2n2叫做稀疏图，用邻接表存储。
 */
public class TuMatrix {

    public static final int INF = Integer.MAX_VALUE;
    public static int n;
    public static int[][] g;
    public static int[] dist;
    public static boolean[] visit;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        int m = scan.nextInt();
        g = new int[n + 1][n + 1];
        dist = new int[n + 1];
        visit = new boolean[n + 1];
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                if (i == j) {
                    g[i][j] = 0;
                } else {
                    g[i][j] = INF;
                }
        for (int i = 0; i < m; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            int z = scan.nextInt();
            g[x][y] = Math.min(g[x][y], z);
        }
        int res = dijkstra();
        System.out.println(res);
    }

    /**
     * Dijkstra
     * 边权不能是负数！
     * 1.dist[1] = 0, dist[i] = +∞
     * 2.for i 1 ~ n
     * t <- 不在s中的，距离最近的点 – n2n2 / n
     * s <- t – n
     * 用t更新其他点的距离 – m / mlogn
     * @return
     */
    public static int dijkstra() {
        for (int i = 1; i <= n; i++) {
            dist[i] = INF;
        }
        dist[1] = 0;
        for (int i = 0; i < n - 1; i++) {
            int t = -1;
            for (int j = 1; j <= n; j++)
                if (!visit[j] && (t == -1 || dist[t] > dist[j]))
                    t = j;
            if (t == n)
                break;
            for (int j = 1; j <= n; j++)
                dist[j] = Math.min(dist[j], dist[t] + g[t][j]);
            visit[t] = true;
        }
        if (dist[n] == INF)
            return -1;
        return dist[n];
    }


    /**
     * 优化Dijkstra
     * @return
     */
//    public static int dijkstra1() {
//        for (int i = 1; i <= n; i++)
//            dist[i] = INF;
//        dist[1] = 0;
//        PriorityQueue<Node> heap = new PriorityQueue<>((node1, node2) -> node1.length - node2.length);
//        heap.add(new Node(1, 0));
//        while (!heap.isEmpty()) {
//            Node top = heap.poll();
//            int length = top.length, cur = top.node;
//            if (visit[cur])
//                continue;
//            visit[cur] = true;
//            for (Node next: map.get(cur)) {
//                int node = next.node, cost = next.length;
//                if (dist[node] > length + cost) {
//                    dist[node] = length + cost;
//                    heap.add(new Node(node, dist[node]));
//                }
//            }
//        }
//        if (dist[n] == INF)
//            return -1;
//        return dist[n];
//    }

    /**
     * Bellman-ford
     * O(nm)
     * @return
     */
//    public static int bellman_ford() {
//        for (int i = 1; i <= n; i++)
//            dist[i] = INF;
//        dist[1] = 0;
//        for (int i = 0; i < k; i++) {
//            for (int j = 1; j <= n; j++)
//                backup[j] = dist[j]; // deep copy
//            for (int k = 0; k < m; k++) {
//                int x = edges[k].x;
//                int y = edges[k].y;
//                int z = edges[k].z;
//                dist[y] = Math.min(dist[y], backup[x] + z);
//            }
//        }
//        if (dist[n] > INF / 2)
//            return -1;
//        else
//            return dist[n];
//    }

    /**
     * SPFA (队列优化的Bellman-ford算法)
     * 一般O(m)，最坏O(nm)。n表示点数，m表示边数。
     * @return
     */
//    public static int spfa() {
////        for (int i = 1; i <= n; i++)
////            dist[i] = INF;
////        dist[1] = 0;
////        Queue<Integer> queue = new LinkedList<>();
////        queue.add(1);
////        visit[1] = true;
////        while (!queue.isEmpty()) {
////            int t = queue.poll();
////            visit[t] = false;
////            for (Node cur: map.get(t)) {
////                int node = cur.node, length = cur.length;
////                if (dist[node] > dist[t] + length) {
////                    dist[node] = dist[t] + length;
////                    if (!visit[node]) {
////                        queue.add(node);
////                        visit[node] = true;
////                    }
////                }
////            }
////        }
////        return dist[n];
////    }


    /**
     * SPFA 判断图中是否存在负环
     * O(nm)，n表示点数，m表示边数。
     * @return
     */
//    public static boolean spfa() {
//        Queue<Integer> queue = new LinkedList<>();
//        for (int i = 1; i <= n; i++) {
//            queue.add(i);
//            visit[i] = true;
//        }
//        while (!queue.isEmpty()) {
//            int t = queue.poll();
//            visit[t] = false;
//            for (Node cur: map.get(t)) {
//                int node = cur.node, length = cur.length;
//                if (dist[node] > dist[t] + length) {
//                    dist[node] = dist[t] + length;
//                    count[node] = count[t] + 1;
//                    if (count[node] >= n)
//                        return true;
//                    if (!visit[node]) {
//                        queue.add(node);
//                        visit[node] = true;
//                    }
//                }
//            }
//        }
//        return false;
//    }

}
