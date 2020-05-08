package com.test.problem.dp;

import java.util.Arrays;
import java.util.stream.Collectors;

public class EqualSumPartition {
    public static void main(String[] args) {

        System.out.println("Expected: true  -> Found: " + equalSumPartition(new Integer[]{1, 5, 11, 5}));
        System.out.println("Expected: false -> Found: " + equalSumPartition(new Integer[]{1, 5, 3}));
    }

    private static boolean equalSumPartition(Integer arr[]) {
        int sum = Arrays.asList(arr).stream().collect(Collectors.summingInt(Integer::intValue));
        // if remainder is not 0 that means it cannot be divided into equal subsets
        if (sum % 2 != 0) return false;
        return equalSumPartitionHelper(arr, sum / 2);
    }

    private static boolean equalSumPartitionHelper(Integer val[], int sum) {
        Boolean[][] cache = new Boolean[val.length + 1][sum + 1];
        for (int i = 0; i <= val.length; i++) {
            cache[i][0] = Boolean.TRUE;
        }
        for (int i = 1; i <= sum; i++) {
            cache[0][i] = Boolean.FALSE;
        }

        for (int n = 1; n <= val.length; n++) {
            for (int sIndex = 1; sIndex <= sum; sIndex++) {
                cache[n][sIndex] = cache[n - 1][sIndex];
                if (val[n - 1] <= sIndex) {
                    cache[n][sIndex] = cache[n - 1][sIndex - val[n - 1]] || cache[n - 1][sIndex];
                }
            }
        }
        return cache[val.length][sum];
    }
}
