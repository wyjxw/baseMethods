package com.wuyu.day10.BasisMethods;

/**
 * 字典树
 */
public class Trie {

    public static final int SIZE = 26;

    public static class TrieNode {
        TrieNode[] children = new TrieNode[SIZE];
        int times;

        TrieNode() {
            times = 0;
            for (int i = 0; i < SIZE; i++)
                children[i] = null;
        }
    }

    public static TrieNode root = new TrieNode();

    public static void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null)
                node.children[index] = new TrieNode();
            node = node.children[index];
        }
        node.times++;
    }

    public static int query(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null)
                return 0;
            node = node.children[index];
        }
        return node.times;
    }

}
