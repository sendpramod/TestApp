package com.test.problem.dp;

public class KnapsackUnbounded {
    public static void main(String[] args) {
        System.out.println("Expected 100 -> Found: " + findTheMaximumValueUnbounded(new int[]{1, 30}, new int[]{1, 50}, 100));
        System.out.println("Expected 110 -> Found: " + findTheMaximumValueUnbounded(new int[]{10, 40, 50, 70}, new int[]{1, 3, 4, 5}, 8));
    }

    public static int findTheMaximumValueUnbounded(int[] val, int[] weight, int capacity) {
        int[][] cache = new int[val.length + 1][capacity + 1];
        for (int n = 0; n < cache.length; n++) {
            for (int wt = 0; wt < cache[n].length; wt++) {
                if (n == 0 || wt == 0) {
                    cache[n][wt] = 0;
                } else if (wt >= weight[n - 1]) {
                    // difference between bounded and unbounded is we can take the same item multiple time,
                    // here we achieved by not decrementing the n by 1(cache[n][wt - weight[n - 1]])
                    cache[n][wt] = Math.max(val[n - 1] + cache[n][wt - weight[n - 1]], cache[n - 1][wt]);
                } else {
                    cache[n][wt] = cache[n - 1][wt];
                }
            }
        }
        return cache[val.length][capacity];
    }
}
