package com.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeMap;

public class Random {
   public static void main(String[] args) {

//      printpairs(new int[]{0, -1, 2, -3, 1}, -2);

      TreeMap<Integer, Integer> t = new TreeMap<>();
      t.put(3, 3);
      t.put(1, 2);
      t.put(2, 1);


      for (Integer i : t.values()) {
         System.out.println(i);
      }

   }

   static void printpairs(int arr[], int sum) {
      HashSet<Integer> s = new HashSet<Integer>();
      for (int i = 0; i < arr.length; ++i) {
         int temp = sum - arr[i];
         // checking for condition
         if (s.contains(temp)) {
            System.out.println(
                    "Pair with given sum "
                            + sum + " is (" + arr[i]
                            + ", " + temp + ")");
         }
         s.add(arr[i]);
      }
   }


   private static int[] sort(int[] arr) {
      //      System.out.println(Arrays.toString(sort(new int[]{0, 2, 1, 2, 1, 0, 0, 0, 2, 1, 2})));
      int low = 0, mid = 0, high = arr.length - 1;
      while (mid <= high) {
         if (arr[mid] == 0) {
            swap(low++, mid++, arr);
         } else if (arr[mid] == 2) {
            swap(mid, high--, arr);
         } else if (arr[mid] == 1) {
            mid += 1;
         }
      }
      return arr;
   }

   private static void swap(int first, int second, int[] arr) {
      int temp = arr[first];
      arr[first] = arr[second];
      arr[second] = temp;
   }


   // it is a dp question, i'll do rest after exam
   private static int largestSquare(int[][] arr) {

//      System.out.println(largestSquare(new int[][]{
//              {0, 1, 0, 1, 0, 1},
//              {1, 0, 1, 0, 1, 0},
//              {0, 1, 1, 1, 1, 0},
//              {0, 0, 1, 1, 1, 0},
//              {1, 1, 1, 1, 1, 1}
//      }));

      int row = arr.length, col = arr[0].length, res = 0;
      int[][] dp = new int[row + 1][col + 1];
      for (int i = row - 1; i >= 0; i--) {
         for (int j = col - 1; j >= 0; j--) {
            if (i == row - 1) {
               dp[i][j] = arr[i][j];
            } else if (j == col - 1) {
               dp[i][j] = arr[i][j];
            } else {
               if (arr[i][j] == 0) {
                  dp[i][j] = 0;
               } else {
                  int min = Integer.min(Integer.min(dp[i + 1][j], dp[i][j + 1]), dp[i + 1][j + 1]);
                  dp[i][j] = min + 1;
                  res = Integer.max(min + 1, res);
               }
            }
         }
      }
      for (int[] ar : dp) {
         System.out.println(Arrays.toString(ar));
      }
      return res;
   }

}
