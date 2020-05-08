package com.test.problem.recursive;

public class PrintLongestCommonSubString {
    public static void main(String[] args) {
        System.out.println("Expected d -> " + findLCS("abcd", "defg"));
        System.out.println("Expected abcdef -> " + findLCS("abcdef", "abcdef"));
        System.out.println("Expected A -> " + findLCS("ABCDGH", "AEDFHR"));
        System.out.println("Expected BC -> " + findLCS("AGGTABC", "GXTXAYBC"));
    }

    public static String findLCS(String str1, String str2) {

       return new StringBuilder(findLCSHelper(str1, str2, str1.length(), str2.length(), "")).reverse().toString();
    }

    private static String findLCSHelper(String str1, String str2, int str1Index, int str2Index, String value) {
        if (str1Index == 0 || str2Index == 0) {
            return value;
        }
        if (str1.charAt(str1Index - 1) == str2.charAt(str2Index - 1)) {
            return findLCSHelper(str1, str2, str1Index - 1, str2Index - 1, value += str1.charAt(str1Index - 1));
        }
        String strIndx = findLCSHelper(str1, str2, str1Index - 1, str2Index, "");
        String str2Indx = findLCSHelper(str1, str2, str1Index, str2Index - 1, "");
        if (strIndx.length() > str2Indx.length()) {
            return value.length() > strIndx.length() ? value : strIndx;
        }
        return value.length() > str2Indx.length() ? value : str2Indx;
    }
}
