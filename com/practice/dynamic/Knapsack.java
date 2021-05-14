package com.practice.dynamic;

public class Knapsack {
   public static void main(String[] args) {
      System.out.println(subsetSum(new int[]{1, 3, 4, 5}, 11, 0, 0));
   }

   private static boolean subsetSum(int[] arr, int key, int sum, int idx) {

      if (sum == key) {
         return true;
      } else if (arr.length == idx) {
         return false;
      }

      boolean include = subsetSum(arr, key, arr[idx] + sum, idx + 1);
      boolean notInclude = subsetSum(arr, key, sum, idx + 1);

      return include || notInclude;
   }
}
