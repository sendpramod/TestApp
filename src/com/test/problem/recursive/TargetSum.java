package com.test.problem.recursive;

public class TargetSum {
    public static void main(String[] args) {
        System.out.println("Expected 3 -> found: " + findNoOfWaysWIthTargetSum(new int[]{1, 1, 1, 1, 1}, 3, 5));
        System.out.println("Expected 3 -> found: " + findNoOfWaysWIthTargetSum(new int[]{1, 2, 3, 4, 5}, 7, 5));

    }

    private static int findNoOfWaysWIthTargetSum(int[] arr, int sum, int n) {
        if (n == 0) {
            return sum == 0 ? 1 : 0;
        }
        int res = 0;
        if (sum >= arr[n - 1]) {
            res += findNoOfWaysWIthTargetSum(arr, sum - arr[n - 1], n - 1);
        }
        res += findNoOfWaysWIthTargetSum(arr, sum, n - 1);
        return res;
    }
}
