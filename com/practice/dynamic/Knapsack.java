package com.practice.dynamic;

public class Knapsack {
   public static void main(String[] args) {
//      System.out.println(subsetSumDpTabulation(new int[]{1, 2, 3}, 5));
      System.out.println(knapsack(new int[]{1, 3, 4, 5}, new int[]{1, 4, 5, 7}, 7, 4));
   }

   // basic recursive solution of knapsack 0/1
   public static int knapsack(int[] wt, int[] val, int W, int n) {
      if (n == 0 || W <= 0) {
         return 0;
      }
      if (wt[n - 1] <= W) {
         int include = val[n - 1] + knapsack(wt, val, W - wt[n - 1], n - 1);
         int notInclude = knapsack(wt, val, W, n - 1);
         return Integer.max(include, notInclude);
      } else {
         return knapsack(wt, val, W, n - 1);
      }
   }

   private static boolean subsetSum(int[] arr, int key, int sum, int idx) {
      if (sum == key) {
         return true;
      } else if (arr.length == idx) {
         return false;
      }
      System.out.println("called ->" + arr[idx]);
      boolean include = subsetSum(arr, key, arr[idx] + sum, idx + 1);
      boolean notInclude = subsetSum(arr, key, sum, idx + 1);

      return include || notInclude;
   }

   // memoization method
   private static boolean subsetSumDpMemoization(int[] arr, int key, int sum, int idx, Boolean[][] dp) {
//      System.out.println(subsetSumDp(new int[]{1, 3, 4, 5, 6, 7, 8, 9, 10}, 11, 0, 0, new Boolean[10][12]));
      if (sum == key) {
         return true;
      } else if (arr.length == idx || sum > key) {
         return false;
      }

      if (dp[idx][sum] != null) {
         return dp[idx][sum];
      }

      boolean include = subsetSumDpMemoization(arr, key, arr[idx] + sum, idx + 1, dp);
      boolean notInclude = subsetSumDpMemoization(arr, key, sum, idx + 1, dp);

      return dp[idx][sum] = include || notInclude;
   }

   private static boolean subsetSumDpTabulation(int[] arr, int key) {
      boolean[][] dp = new boolean[arr.length + 1][key + 1];

      for (int i = 1; i <= arr.length; i++) {
         for (int j = 1; j <= key; j++) {
            if (j - 1 == 0) {
               dp[i][j] = false;
            }
            if (i - 1 == 0) {
               dp[i][j] = true;
            }
            if (arr[i - 1] < j) {
               dp[i][j] = dp[i][j - arr[i - 1]] || dp[i - 1][j];
            } else {
               dp[i][j] = dp[i - 1][j];
            }

         }
      }
      return dp[arr.length][key];
   }

}
