package com.test.problem.recursive;

public class Knapsack {
    public static void main(String[] args) {
        System.out.println("Expected: 220 -> Found:   " + findTheMaxVal(new int[]{60, 100, 120}, new int[]{10, 20, 30}, 50, 3));
        System.out.println("Expected: 90 -> Found:   " + findTheMaxVal(new int[]{10, 40, 30, 50}, new int[]{5, 4, 6, 3}, 10, 4));
    }

    public static int findTheMaxVal(int[] val, int weight[], int capacity, int size) {
        //1: in recursion find the base case
        if (capacity == 0 || size == 0) {
            return 0;
        }
        // if weight is less that the capacity of the sack then we can either accept it or reject the item;
        if (weight[size - 1] <= capacity) {
            return Math.max(val[size - 1] + findTheMaxVal(val, weight, capacity - weight[size - 1], size - 1), findTheMaxVal(val, weight, capacity, size - 1));
        }
        // when weight is more than the capacity ignore the item move to other item
        return findTheMaxVal(val, weight, capacity, size - 1);
    }
}
