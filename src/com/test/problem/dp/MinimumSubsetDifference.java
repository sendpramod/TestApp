package com.test.problem.dp;

public class MinimumSubsetDifference {
    public static void main(String[] args) {
        System.out.println("Expected: 2 -> Found:   " + minimumSubsetDifference(new int[]{1, 3, 5, 6, 11}));
    }

    private static int minimumSubsetDifference(int[] set) {
        int sum = 0;
        for (int i : set) sum += i;
        boolean[][] cache = new boolean[set.length + 1][sum + 1];
        for (int i = 0; i < cache.length; i++) {
            cache[i][0] = true;
        }
        for (int j = 1; j < cache[0].length; j++) {
            cache[0][j] = false;
        }

        for (int i = 1; i < cache.length; i++) {
            for (int j = 1; j < cache[0].length; j++) {
                cache[i][j] = cache[i - 1][j];
                if (j >= set[i - 1]) {
                    cache[i][j] = cache[i - 1][j - set[i - 1]] || cache[i - 1][j];
                }
            }
        }

        int diff = 0;
        for (int i = sum / 2; i >= 0; i--) {
            if (cache[set.length][i] == true) {
                diff = sum - 2 * i;
                break;
            }
        }
        return diff;
    }
}
