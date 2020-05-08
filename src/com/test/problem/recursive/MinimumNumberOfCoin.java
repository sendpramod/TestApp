package com.test.problem.recursive;

public class MinimumNumberOfCoin {
    public static void main(String[] args) {
        System.out.println("Expected 2 -> Found: " + minimumNumberOfCoin(new int[]{25, 10, 5}, 30, 3 ));
    }

    private static int minimumNumberOfCoin(int[] coins, int sum, int n) {
        if (n == 0) {
            return sum == 0 ? 1 : 0;
        }
        // unlimited coin supply
        int res = 0;
        if (sum >= coins[n - 1]) {
            res+= minimumNumberOfCoin(coins, sum - coins[n - 1], n);
        }
        return res+= minimumNumberOfCoin(coins, sum, n - 1);

    }
}
