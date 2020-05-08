package com.test.problem.dp;

public class Knapsack {
    public static void main(String[] args) {
        System.out.println("Expected: 220 -> Found:   " + findTheMaxVal(new int[]{60, 100, 120}, new int[]{10, 20, 30}, 50));
        System.out.println("Expected:  90 -> Found:   " + findTheMaxVal(new int[]{10, 40, 30, 50}, new int[]{5, 4, 6, 3}, 10));
    }

    public static int findTheMaxVal(int[] val, int weight[], int capacity) {
        //1: in dp soln, use the base case of recursive and fill the table
        int cache[][] = new int[weight.length + 1][capacity + 1];
        for (int n = 0; n < cache.length; n++) {
            for (int wt = 0; wt < cache[n].length; wt++) {
                if (n == 0 || wt == 0) {
                    cache[n][wt] = 0;
                } else if (weight[n - 1] <= wt) {
                    cache[n][wt] = Math.max(val[n - 1] + cache[n - 1][wt - weight[n - 1]], cache[n - 1][wt]);
                } else {
                    cache[n][wt] = cache[n - 1][wt];
                }
                //printMatrix(cache);
            }
        }
        return cache[cache.length - 1][cache[0].length - 1];
    }

    private static void printMatrix(int cache[][]) {
        for (int n = 0; n < cache.length; n++) {
            for (int wt = 0; wt < cache[n].length; wt++) {
                System.out.print(cache[n][wt] + " ");
            }
            System.out.println("");
        }
        System.out.println("________________________________________________________");
    }
}
