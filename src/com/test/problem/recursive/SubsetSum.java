package com.test.problem.recursive;

public class SubsetSum {
    public static void main(String[] args) {
        // find if a subset with given sum exists
        System.out.println("Expected true -> found: "+subsetSum(new int[]{3, 34, 4, 12, 8, 2}, 9, 6));
        System.out.println("Expected true -> found: "+subsetSum(new int[]{1, 2, 3, 7}, 6, 4));
        System.out.println("Expected true -> found: "+subsetSum(new int[]{1, 2, 7, 1, 5}, 10, 5));
        System.out.println("Expected false -> found: "+subsetSum(new int[]{1, 3, 4, 8}, 6, 4));
    }

    private static boolean subsetSum(int[] val, int sum, int n) {
        if (n == 0) {
            return (0 == sum);
        }
        if (sum >= val[n - 1]) {
            return subsetSum(val, sum - val[n - 1], n - 1) || subsetSum(val, sum, n - 1);
        }
        return subsetSum(val, sum, n - 1);
    }
}
