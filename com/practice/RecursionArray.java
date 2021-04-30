package com.practice;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecursionArray {
    public static void main(String[] args) {

        findAllIndex(new int[] { 1, 8, 5, 6, 8, 3, 8 }, 0, 8);
        System.out.println(Arrays.toString(index.toArray()));
    }


    // finding all indeces of the searched element in array
    static List<Integer> index = new ArrayList<>();
    private static void findAllIndex(int[] arr, int i, int key) {
        if (arr.length == i) {
            return;
        }
        if (arr[i] == key) {
            index.add(i);
        }

        findAllIndex(arr, i + 1, key);
    }

    // finding from last in array (it basically checking on at post calling)
    private static int findLast(int[] arr, int i, int key) {
        if (i == arr.length) {
            return -1;
        }

        int cIndex = findLast(arr, i + 1, key);
        if (cIndex == -1) {
            if (arr[i] == key) {
                return i;
            } else {
                return -1;
            }
        } else {
            return cIndex;
        }
    }

    // in this we are searching on the way up in stack
    private static int findFirstOnUp(int[] arr, int i, int key) {
        if (i == arr.length) {
            return -1;
        }
        if (arr[i] == key) {
            return i;
        }
        return findFirst(arr, i + 1, key);
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
