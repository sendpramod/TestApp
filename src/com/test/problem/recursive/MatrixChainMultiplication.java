package com.test.problem.recursive;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 3, 4, 3};
        System.out.println(matrixChainMultiplication(new int[]{1, 2, 3, 4, 3}, 1, arr.length-1));
    }

    private static int matrixChainMultiplication(int p[], int i, int j) {
        if (i >= j) {
            return 0;
        }
        int rest = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int temp = matrixChainMultiplication(p, i, k) +
                    matrixChainMultiplication(p, k + 1, j) +
                    p[i - 1] * p[k] * p[j];
            if (temp < rest) {
                rest = temp;
            }

        }
        return rest;
    }

}
