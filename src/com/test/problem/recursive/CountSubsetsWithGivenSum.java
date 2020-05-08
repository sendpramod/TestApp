package com.test.problem.recursive;

public class CountSubsetsWithGivenSum {

    public static void main(String[] args) {
        // how many subsets exists with a given sum
        System.out.println("Expected 3 -> found: " + findCountSubsetsWithSum(new int[]{1, 2, 3, 3}, 6, 4));
        System.out.println("Expected 2 -> found: " + findCountSubsetsWithSum(new int[]{1, 2, 3, 4}, 6, 4));
        System.out.println("Expected 3 -> found: " + findCountSubsetsWithSum(new int[]{1, 2, 3, 4, 5}, 7, 5));
    }

    private static int findCountSubsetsWithSum(int[] val, int sum, int n) {
        if (n == 0) {
            return (sum == 0) ? 1 : 0;
        }
        int res = 0;
        if (val[n - 1] <= sum) {
            res = findCountSubsetsWithSum(val, sum - val[n - 1], n - 1);
        }
       return res += findCountSubsetsWithSum(val, sum, n - 1);
    }
}