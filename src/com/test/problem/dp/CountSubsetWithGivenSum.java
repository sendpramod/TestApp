package com.test.problem.dp;

public class CountSubsetWithGivenSum {
    public static void main(String[] args) {

        System.out.println(subsetSum(new int[]{1, 2, 3, 3}, 6));
        System.out.println(subsetSum(new int[]{1, 2, 3, 4}, 6));
        System.out.println(subsetSum(new int[]{1, 2, 3, 4, 5}, 7));
    }

    private static int subsetSum(int[] val, int sum) {
        int cache[][] = new int[val.length + 1][sum + 1];

        for (int i = 0; i <= val.length; i++) {
            cache[i][0] = 1;
        }
        for (int i = 1; i <= sum; i++) {
            cache[0][i] = 0;
        }

        for (int n = 1; n <= val.length; n++) {
            for (int sIndex = 0; sIndex <= sum; sIndex++) {
                cache[n][sIndex] = cache[n - 1][sIndex];
                if (val[n - 1] <= sIndex) {
                    cache[n][sIndex] = cache[n - 1][sIndex - val[n - 1]] + cache[n - 1][sIndex];
                }
            }
        }
        return cache[val.length][sum];
    }
}
