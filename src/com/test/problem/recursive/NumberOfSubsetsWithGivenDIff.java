package com.test.problem.recursive;

public class NumberOfSubsetsWithGivenDIff {
    public static void main(String[] args) {
        System.out.println("Expected: 3 -> Found:   " +countOfSubsetWithGivenDiff(new int[]{1, 1, 2, 3}, 1, 0, 7, 4));
    }

    private static int countOfSubsetWithGivenDiff(int[] arr, int diff, int subSetSum, int totalSum, int n) {
        if (n == 0) {
            return ((totalSum - subSetSum) - subSetSum) == diff ? 1 : 0;
        }
        return countOfSubsetWithGivenDiff(arr, diff, subSetSum + arr[n - 1], totalSum, n - 1) +
                countOfSubsetWithGivenDiff(arr, diff, subSetSum, totalSum, n - 1);
    }
}
