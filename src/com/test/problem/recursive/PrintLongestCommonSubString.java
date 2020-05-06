package com.test.problem.recursive;

public class LongestCommonSubString {
    public static void main(String[] args) {
        System.out.println("Expected 1 -> " + findLCS("abcd", "defg"));
        System.out.println("Expected 6 -> " + findLCS("abcdef", "abcdef"));
        System.out.println("Expected 1 -> " + findLCS("ABCDGH", "AEDFHR"));
        System.out.println("Expected 2 -> " + findLCS("AGGTABC", "GXTXAYBC"));
    }

    public static int findLCS(String str1, String str2) {
        return findLCSHelper(str1, str2, str1.length(), str2.length(), 0);
    }

    private static int findLCSHelper(String str1, String str2, int str1Index, int str2Index, int count) {
        if (str1Index == 0 || str2Index == 0) {
            return count;
        }
        if (str1.charAt(str1Index - 1) == str2.charAt(str2Index - 1)) {
            return findLCSHelper(str1, str2, str1Index - 1, str2Index - 1, ++count);
        }
        return Math.max(count, Math.max(findLCSHelper(str1, str2, str1Index - 1, str2Index, 0), findLCSHelper(str1, str2, str1Index, str2Index - 1, 0)));
    }
}
