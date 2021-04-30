package com.practice;

public class RecursionArray {
    public static void main(String[] args) {

        System.out.println(findFirstOnUp(new int[] { 1, 2, 5, 6, 8, 3, 9 }, 0, 8));
    }

    // in this we are searching on the way up in stack
    private static int findFirstOnUp(int[] arr, int i, int key) {
        if (i == arr.length) {
            return -1;
        }
        if (arr[i] == key) {
            return i;
        }
        return findFirst(arr, i, key);
    }

    // its comparing on the way down so we have to change strategy
    private static int findFirst(int[] arr, int i, int key) {
        if (i == arr.length) {
            return -1;
        }
        int cIndex = findFirst(arr, i + 1, key);
        if (arr[i] == key) {
            return i;
        }
        return cIndex;
    }

    static int max = Integer.MIN_VALUE;

    // max on the way up in stack
    private static void maxInArray(int[] is, int i) {
        if (i == is.length) {
            System.out.println("max is " + max);
            return;
        }
        max = Integer.max(is[i], max);

        maxInArray(is, i + 1);
    }

    // max on the way down in stack
    private static int maxInArrayOnReturn(int[] is, int i) {
        if (i == 0) {
            return is[i];
        }
        int toCheck = maxInArrayOnReturn(is, i - 1);
        if (toCheck > is[i]) {
            return toCheck;
        }
        return is[i];
    }

}
