package com.practice;

public class RecursionArray {
    public static void main(String[] args) {
        maxInArray(new int[] { 1, 2, 5, 6, 8, 3, 9 }, 0);
    }

    static int max = Integer.MIN_VALUE;

    private static void maxInArray(int[] is, int i) {
        if (i == is.length) {
            System.out.println("max is " + max);
            return;
        }
        max = Integer.max(is[i], max);

        maxInArray(is, i + 1);
        System.out.println("called after that");
    }
}
