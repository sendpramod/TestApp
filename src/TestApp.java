import java.util.*;

public class TestApp {
    static Map<String, Integer> cache = new HashMap<>();
    static Map<String, String> cache2 = new HashMap<>();


    public static void main(String[] args) {
        // System.out.println(lcs("pmjghexybyrgzczy", "hafcdqbgncrcbihkd", 0, 0));

        // System.out.println(printLcs("ABCBDAB", "BDCABA", 0, 0));

       // System.out.println(longestCommonSubsequence("ABCBDAB", "BDCABA"));
        System.out.println(maxSubArray(new int []{4,-1,-2,1,4,-5}));
    }

    public static int maxSubArray(int[] nums) {
    return maxSubarray(nums,nums.length);
    }

    private static int maxSubarray(int[] A, int n) {
        if (n <= 0)
            return 0;
        int maxSum = A[0];
        int sum = A[0];
        for (int i = 1; i < n; ++i) {
            if (sum < 0) // no positive gain for following numbers
                sum = 0;
            sum += A[i];
            if (sum > maxSum)
                maxSum = sum;
        }

        return maxSum;
    }


    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] arr = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                } else {
                    arr[i][j] = Math.max(arr[i][j - 1], arr[i - 1][j]);
                }
            }
        }
        return arr[text1.length()][text2.length()];
    }

    public static int lcs(String str1, String str2, int i, int j) {
        if (i >= str1.length() || j >= str2.length()) {
            return 0;
        }
        String key = i + "_" + j;
        if (cache.get(key) != null) {
            return cache.get(key);
        }

        if (str1.charAt(i) == str2.charAt(j)) {
            int res = lcs(str1, str2, ++i, ++j) + 1;
            cache.put(key, res);
            return res;
        }
        return Math.max(lcs(str1, str2, i + 1, j), lcs(str1, str2, i, j + 1));
    }

    public static String printLcs(String str1, String str2, int i, int j) {
        String key = i + "_" + j;
        if (cache2.get(key) != null) {
            return cache2.get(key);
        }
        if (i >= str1.length() || j >= str2.length()) {
            return "";
        }
        if (str1.charAt(i) == str2.charAt(j)) {
            String res = str1.charAt(i) + printLcs(str1, str2, i + 1, j + 1);
            cache2.put(key, res);
            return res;
        }
        String s1 = printLcs(str1, str2, i + 1, j);
        String s2 = printLcs(str1, str2, i, j + 1);
        if (s1.length() > s2.length()) return s1;
        return s2;
    }


}

