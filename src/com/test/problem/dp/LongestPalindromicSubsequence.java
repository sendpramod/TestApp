package com.test.problem.dp;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        System.out.println("Expected: 5 -> found: " + findLPS("BBABCBCAB"));
        System.out.println("Expected: 5 -> found: " + findLPS("BBAB"));
    }

    public static int findLPS(String str) {
        String s1 = str;
        String s2 = new StringBuilder(str).reverse().toString();
        int[][] cache = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < cache[0].length; j++) {
                if (i == 0 || j == 0) {
                    cache[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    cache[i][j] = 1 + cache[i - 1][j - 1];
                } else {
                    cache[i][j] = Math.max(cache[i - 1][j], cache[i][j - 1]);
                }
            }
        }
        return cache[s1.length()][s2.length()];

    }
}
