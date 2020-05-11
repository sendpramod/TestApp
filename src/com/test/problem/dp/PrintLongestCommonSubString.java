package com.test.problem.dp;

public class PrintLongestCommonSubString {
    public static void main(String[] args) {
        System.out.println("1: Expected 4 -> " + findLongestCommonSubstring("abcdxyzq", "efgxyzq") + "\n");
        System.out.println("2: Expected 6 -> " + findLongestCommonSubstring("abcdef", "abcdef") + "\n");
        System.out.println("3: Expected 1 -> " + findLongestCommonSubstring("ABCDGH", "AEDFHR") + "\n");
        System.out.println("4: Expected 2 -> " + findLongestCommonSubstring("AGGTABC", "GXTXAYBC") + "\n");
    }

    private static int findLongestCommonSubstring(String str1, String str2) {
        int[][] cache = new int[str1.length() + 1][str2.length() + 1];
        int maxSubstring = 0;
        int x = 0, y = 0;
        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < cache[i].length; j++) {
                if (i == 0 || j == 0) {
                    cache[i][j] = 0;
                } else {
                    cache[i][j] = 0;
                    if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                        cache[i][j] = 1 + cache[i - 1][j - 1];
                        if (maxSubstring < cache[i][j]) {
                            maxSubstring = cache[i][j];
                            x = i;
                            y = j;
                        }

                    }
                }
            }
        }
        int length = cache[str1.length()][str2.length()];
        //print
        //int len = maxSubstring;
        String resultStr = "";
        while (cache[x][y] != 0) {
            resultStr = str1.charAt(x - 1) + resultStr;
            x--;
            y--;
        }
        System.out.println("LCS: " + resultStr);

        return maxSubstring;
    }
}
