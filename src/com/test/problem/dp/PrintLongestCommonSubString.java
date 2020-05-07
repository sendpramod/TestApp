package com.test.problem.dp;

public class LongestCommonSubString {
    public static void main(String[] args) {
        System.out.println("Expected 4 -> " + findLongestCommonSubstring("abcdxyzq", "efgxyzq"));
        System.out.println("Expected 6 -> " + findLongestCommonSubstring("abcdef", "abcdef"));
        System.out.println("Expected 1 -> " + findLongestCommonSubstring("ABCDGH", "AEDFHR"));
        System.out.println("Expected 2 -> " + findLongestCommonSubstring("AGGTABC", "GXTXAYBC"));
    }

    private static int findLongestCommonSubstring(String str1, String str2) {
        int[][] cache = new int[str1.length() + 1][str2.length() + 1];
        int maxSubstring = 0;
        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < cache[i].length; j++) {
                if (i == 0 || j == 0) {
                    cache[i][j] = 0;
                } else {
                    cache[i][j] = 0;
                    if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                        maxSubstring = Math.max(maxSubstring, cache[i][j] = 1 + cache[i - 1][j - 1]);
                    }
                }
            }
        }
        return maxSubstring;
    }
}
