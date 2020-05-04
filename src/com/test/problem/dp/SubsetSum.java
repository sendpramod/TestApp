package com.test.problem.dp;

public class SubsetSum {
    public static void main(String[] args) {
        System.out.println(subsetSum(new int[]{3, 34, 4, 12, 8, 2}, 9));
    }

    private static boolean subsetSum(int[] val, int sum) {
        boolean cache[][] = new boolean[val.length + 1][sum + 1];

        for (int i = 0; i <= val.length; i++) {
            cache[i][0] = true;
        }
        for (int i = 1; i <= sum; i++) {
            cache[0][i] = false;
        }

        for (int n = 1; n <= val.length; n++) {
            for (int sIndex = 0; sIndex <= sum; sIndex++) {
                cache[n][sIndex] = cache[n - 1][sIndex];
                if (val[n - 1] <= sIndex) {
                    cache[n][sIndex] = cache[n - 1][sIndex - val[n - 1]] || cache[n - 1][sIndex];
                }
            }
        }
        return cache[val.length][sum];
    }
}
