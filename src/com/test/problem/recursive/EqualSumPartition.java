package com.test.problem.recursive;

import java.util.Arrays;
import java.util.stream.Collectors;

public class EqualSumPartition {
    public static void main(String[] args) {
        // find if 2 subsets exists with same sum
        System.out.println("Expected true -> found:  " + equalSumPartition(new Integer[]{1, 5, 5, 11}));
        System.out.println("Expected false -> found:  " + equalSumPartition(new Integer[]{1, 5, 3}));
        System.out.println("Expected true -> found:  " + equalSumPartition(new Integer[]{1, 2, 3, 4}));
    }

    private static boolean equalSumPartition(Integer arr[]) {
        int sum = Arrays.asList(arr).stream().collect(Collectors.summingInt(Integer::intValue));
        // if remainder is not 0 that means it cannot be divided into equal subsets
        if (sum % 2 != 0) return false;
        return equalSumPartitionHelper(arr, sum / 2, arr.length);
    }

    private static boolean equalSumPartitionHelper(Integer arr[], int sum, int n) {
        if (n == 0) {
            return sum == 0;
        }
        if (sum >= arr[n - 1]) {
            return equalSumPartitionHelper(arr, sum - arr[n - 1], n - 1) || equalSumPartitionHelper(arr, sum, n - 1);
        }
        return equalSumPartitionHelper(arr, sum, n - 1);
    }
}
