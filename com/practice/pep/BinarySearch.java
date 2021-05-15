package com.practice.pep;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++) {
            System.out.println(binarySearch(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, i));
        }
    }

    // perfect working binary search
    private static int binarySearch(int[] arr, int key) {

        int start = 0, end = arr.length - 1, middle = 0;

        while (start <= end) { 
            middle = (start + end) / 2;
            if (key == arr[middle]) {
                return middle;
            }
            if (key > arr[middle]) {
                start = middle + 1; 
            }
            if (key < arr[middle]) {
                end = middle - 1;
            }
        }
        return -1;
    }
}
