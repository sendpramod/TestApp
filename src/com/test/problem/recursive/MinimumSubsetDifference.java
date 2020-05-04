package com.test.problem.recursive;

public class MinimumSubsetDifference {
    public static void main(String[] args) {
        // break the set into 2 subsets such that the difference is minimum
        System.out.println("Expected: 1 -> Found:   " +minimumSubsetDifference(new int[]{1, 6, 11, 5,3}, 23, 0, 4));
    }

    private static int minimumSubsetDifference(int[] arr, int sumTotal, int totalCalculated, int n) {
        if (n == 0) {
            return Math.abs((sumTotal - totalCalculated) - totalCalculated);
        }
        return Math.min(minimumSubsetDifference(arr, sumTotal, totalCalculated + arr[n-1], n - 1), minimumSubsetDifference(arr, sumTotal, totalCalculated, n - 1));
    }
}
