package com.test.problem.dp;

import sun.print.SunMinMaxPage;

public class NumberOfSubsetsWithGivenDIff {
    public static void main(String[] args) {
        System.out.println("Expected: 1 -> Found:   " + findNumOfSubsetWIthGivenDiff(new int[]{}, 0));
        System.out.println("Expected: 3 -> Found:   " + findNumOfSubsetWIthGivenDiff(new int[]{1, 1, 2, 3}, 1));
        System.out.println("Expected: 0 -> Found:   " + findNumOfSubsetWIthGivenDiff(new int[]{1, 5, 9}, 6));
        System.out.println("Expected: 0 -> Found:   " + findNumOfSubsetWIthGivenDiff(new int[]{1, 5, 9}, 6));
        System.out.println("Expected: 0 -> Found:   " + findNumOfSubsetWIthGivenDiff(new int[]{2, 4, 9}, 6));
        System.out.println("Expected: 10 -> Found:   " + findNumOfSubsetWIthGivenDiff(new int[]{1, 1, 1, 1, 1}, 1));
    }

    private static int findNumOfSubsetWIthGivenDiff(int set[], int diff) {
        int totalSum = 0;
        for (int i : set) totalSum += i;
        //s1-(s2)=diff
        //s1 -(sum-s1)=diff
        //2s1-sum=diff
        //2s1=diff+ sum
        //s1=(diff+sum)/2
        // {1, 1, 2, 3}, 1
        //s1=(1+7)/2
        //s1=4
        //now the problem stands to find the number of subsets with given sum
        ////s1=(diff+sum)/2
        int s1 = (diff + totalSum) / 2;
        int[][] cache = new int[set.length + 1][s1 + 1];
        for (int i = 0; i < cache.length; i++) {
            cache[i][0] = 1;
        }
        for (int j = 1; j < cache[0].length; j++) {
            cache[0][j] = 0;
        }
        for (int i = 1; i < cache.length; i++) {
            for (int j = 1; j < cache[0].length; j++) {
                cache[i][j] = cache[i - 1][j];
                if (j >= set[i - 1]) {
                    cache[i][j] = cache[i - 1][j - set[i - 1]] + cache[i - 1][j];
                }
            }
        }

        return cache[set.length][s1];
    }
}
