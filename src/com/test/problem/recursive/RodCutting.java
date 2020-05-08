package com.test.problem.recursive;

public class RodCutting {
    public static void main(String[] args) {
        // In this problem we need to cut the rod such that the profit is maximum, one thing that we need to take care is same item can be included multiple times
        System.out.println("Expected 10 -> Found: " + maxProfitFromRod(new int[]{1, 5, 8, 9, 10, 17, 17, 20}, new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 4, 8));
        System.out.println("Expected 12 -> Found: " + maxProfitFromRod(new int[]{2, 5, 7, 8}, new int[]{1, 2, 3, 4}, 5, 4));
    }

    private static int maxProfitFromRod(int[] price, int[] length, int size, int n) {
        if (n == 0 || size == 0) {
            return 0;
        }
        if (size >= length[n - 1]) {
            // Here there are 2 possibilities available, take the item one or more times(achieved by not reducing the index by 1) or reject the item
            return Math.max(price[n - 1] + maxProfitFromRod(price, length, size - length[n - 1], n), maxProfitFromRod(price, length, size, n - 1));
        }
        // reject the item
        return maxProfitFromRod(price, length, size, n - 1);
    }
}
