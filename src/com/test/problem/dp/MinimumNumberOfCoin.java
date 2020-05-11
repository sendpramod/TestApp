package com.test.problem.dp;

public class MinimumNumberOfCoin {
    public static void main(String[] args) {
        // minimum number of coins required to achive a sum
        System.out.println("Expected 2 -> Found: " + findMinimumNumberOfCoin(new int[]{25, 10, 5}, 30));
        System.out.println("Expected 4 -> Found: " + findMinimumNumberOfCoin(new int[]{2, 3, 8}, 15));

        System.out.println("Expected 2 -> Found: " + findMinimumNumberOfCoin(new int[]{1, 50}, 100));
        System.out.println("Expected 2 -> Found: " + findMinimumNumberOfCoin(new int[]{1, 3, 4, 5}, 8));
    }

    private static int findMinimumNumberOfCoin(int[] coins, int sum) {
        double cache[][] = new double[coins.length + 1][sum + 1];
        // initialize the array
        for (int j = 0; j < cache[0].length; j++) {
            cache[0][j] = Double.POSITIVE_INFINITY;
        }
        for (int i = 1; i < cache.length; i++) {
            for (int j = 1; j < cache[0].length; j++) {
                //take the coin
                if (j >= coins[i - 1]) {
                    cache[i][j] = Math.min(1 + cache[i][j - coins[i - 1]], cache[i - 1][j]);
                } else {
                    // leave the coin
                    cache[i][j] = cache[i - 1][j];
                }
            }
        }
        return (int) cache[coins.length][sum];
    }
}
