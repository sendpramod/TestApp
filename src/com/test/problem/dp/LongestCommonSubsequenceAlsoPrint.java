package com.test.problem.dp;

public class LongestCommonSubsequenceAlsoPrint {
    public static void main(String[] args) {
        System.out.println("Expected 1 -> " + findLCS("def", "defg")+"\n");
        System.out.println("Expected 6 -> " + findLCS("abcdef", "abcdef")+"\n");
        System.out.println("Expected 3 -> " + findLCS("ABCDGH", "AEDFHR")+"\n");
        System.out.println("Expected 4 -> " + findLCS("AGGTAB", "GXTXAYB")+"\n");
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
        // print lcs
        int s1 = str1.length();
        int s2 = str2.length();
        String finalStr = "";
        while (s1 != 0 && s2 != 0) {
            if (str1.charAt(s1 - 1) == str2.charAt(s2 - 1)) {
                finalStr = str1.charAt(s1 - 1) + finalStr;
                s1--;
                s2--;
            } else if (cache[s1][s2 - 1] > cache[s1 - 1][s2]) {
                s2--;
            } else {
                s1--;
            }
        }
        System.out.println("LCS String: " + finalStr);
        return cache[str1.length()][str2.length()];
    }
}
