package com.test.problem.dp;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println("Expected 1 -> " + findLCS("abcd", "defg"));
        System.out.println("Expected 6 -> " + findLCS("abcdef", "abcdef"));
        System.out.println("Expected 3 -> " + findLCS("ABCDGH", "AEDFHR"));
        System.out.println("Expected 4 -> " + findLCS("AGGTAB", "GXTXAYB"));
    }

    private static int findLCS(String str1, String str2) {
        int[][] cache = new int[str1.length() + 1][str2.length() + 1];
        for (int m = 0; m < cache.length; m++) {
            for (int n = 0; n < cache[m].length; n++) {
                if (m == 0 || n == 0) {
                    cache[m][n] = 0;
                } else if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
                    cache[m][n] = 1 + cache[m - 1][n - 1];
                } else {
                    cache[m][n] = Math.max(cache[m][n - 1], cache[m - 1][n]);
                }
            }
        }
        return cache[str1.length()][str2.length()];
    }
}
