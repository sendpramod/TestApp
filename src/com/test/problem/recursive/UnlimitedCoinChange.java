package com.test.problem.recursive;

public class UnlimitedCoinChange {
    public static void main(String[] args) {
        System.out.println("Expected 4 -> Found: " + findNumberOfWays(new int[]{1, 2, 3}, 4, 3));
        System.out.println("Expected 5 -> Found: " + findNumberOfWays(new int[]{2, 5, 3, 6}, 10, 4));
    }

    private static int findNumberOfWays(int[] coins, int sum, int n) {
        if (n == 0) {
            return sum == 0 ? 1 : 0;
        }
        int res = 0;
        if (sum >= coins[n - 1]) {
            res += findNumberOfWays(coins, sum - coins[n - 1], n);
        }
        res += findNumberOfWays(coins, sum, n - 1);
        return res;
    }
}
