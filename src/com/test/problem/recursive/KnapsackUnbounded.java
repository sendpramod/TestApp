package com.test.problem.recursive;

public class KnapsackUnbounded {
    public static void main(String[] args) {
        // In this problem we need to take only those items where the  profit is maximum, one thing to note that same item can be included multiple times
        System.out.println("Expected 100 -> Found: " + findTheMaxVal(new int[]{1, 30}, new int[]{1, 50}, 100, 2));
        System.out.println("Expected 110 -> Found: " + findTheMaxVal(new int[]{10, 40, 50, 70}, new int[]{1, 3, 4, 5}, 8, 4));
    }

    private static int findTheMaxVal(int[] val, int[] weight, int capacity, int index) {
        if (capacity == 0 || index == 0) {
            return 0;
        }
        if (capacity >= weight[index - 1]) {
            // We can take the item, the same item can be taken multiple time which is achieved by not reducing the index by 1 and reject the item
            return Math.max(val[index - 1] + findTheMaxVal(val, weight, capacity - weight[index - 1], index), findTheMaxVal(val, weight, capacity, index - 1));
        }
        return findTheMaxVal(val, weight, capacity, index - 1);
    }
}
