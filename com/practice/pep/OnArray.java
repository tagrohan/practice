package com.practice.pep;

import java.util.Arrays;

public class OnArray {
    public static void main(String[] args) {

        
        
    }



//     google kikstart 2020 subarray video 8.4
//     link:
//     https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ff47/00000000003bf4ed#problem
//     10,7,4,6,8,10,11 5,5,4,5,5,5,4,5,6 9,7,5,3 5,4,3,2,1,2,3,4,5,6
    // have to start for it again
    private static void longestArithmatic(int[] arr) {
        // longestArithmatic(new int[] { 5, 4, 3, 2, 1, 2, 3, 4, 5, 6 });
        int diff = arr[1] - arr[0];
        int occur = 0, maxOccur = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] == diff) {
                occur += 1;
            } else {
                diff = arr[i] - arr[i - 1];
                occur = 1;
            }
            if (maxOccur < occur) {
                maxOccur = occur;
            }
        }
        System.out.println(maxOccur + 1);

    }

    // working
    private static void subArraySum(int[] arr) {
        // subArraySum(new int[]{1,2,2});
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                System.out.print(sum + " ");
            }
            System.out.println();
        }
    }

    // public static int kthSmallest(Integer[] arr, int l, int r, int k) {
    // System.out.println(kthSmallest(new Integer[] { 7, 10, 4, 3, 20, 15 }, 0, 5,
    // 3));
    // StringBuffer buffer = new StringBuffer(Arrays.toString(arr));
    // List<Integer> list = Arrays.asList(arr);
    // Collections.sort(list);
    // for (int var : list) {
    // System.out.println(var);
    // }
    // return 1;
    // }

    public static int[] runningSum(int[] nums) {
        // 1,1,1,1,1 -> [1, 2, 3, 4, 5] = [1,1+1,1+1+1 ...]
        // System.out.println(Arrays.toString(runningSum(new int[]{1,1,1,1,1})));
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        return nums;
    }

    private static void mainAndMaxInArray(int[] arr) {
        // mainAndMaxInArray(new int[] {1000, 11, 445, 1, 330, 3000});
        int min = arr[0], max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            } else if (max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.println(max + "::::" + min);
    }

    private static void reverseArray(int[] arr) {
        int end = arr.length - 1;
        int temp = 0;
        for (int i = 0; i < arr.length / 2; i++) {
            // temp = arr[i];
            // arr[i] = arr[end];
            // arr[end] = temp;

            // arr[i] = arr[i] + arr[end];
            // arr[end] = arr[i] - arr[end];
            // arr[i] = arr[i] - arr[end];

            arr[i] = arr[i] + arr[end] - (arr[end] = arr[i]);

            end -= 1;
        }

        System.out.println(Arrays.toString(arr));
    }
}
