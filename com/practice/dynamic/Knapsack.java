package com.practice.dynamic;

public class Knapsack {
   public static void main(String[] args) {
      System.out.println(subsetSum(new int[]{1, 2, 6, 4}, 8, 0, 0));
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


   // 0/1 Knapsack started
   // knapsack tabulation working fine here
   public static int knapsackDpTabulation(int[] wt, int[] val, int W, int n) {
//      System.out.println(knapsackDpTabulation(new int[]{1, 3, 4, 5, 20, 12, 3, 2, 12, 32, 13}, new int[]{1, 4, 5, 7, 12, 2, 32, 3, 21, 23, 32}, 499, 11));
      int[][] dp = new int[n + 1][W + 1];
      for (int i = 1; i <= n; i++) {
         for (int j = 1; j <= W; j++) {
            if (i - 1 == 0 && j - 1 == 0) {
               dp[i][j] = 0;
            } else if (wt[i - 1] <= j) {
               dp[i][j] = val[i - 1] + Integer.max(dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
            } else {
               dp[i][j] = dp[i - 1][j];
            }
         }
      }
      return dp[n][W];
   }

   // memoization Dp solution of knapsack 0/1 working fine
   public static int knapsackDpMemoization(int[] wt, int[] val, int W, int n, int[][] dp) {
//      System.out.println(knapsackDpMemoization(new int[]{1, 3, 4, 5, 20, 12, 3, 2, 12, 32, 13}, new int[]{1, 4, 5, 7, 12, 2, 32, 3, 21, 23, 32}, 499, 11, arr));
      if (n == 0 || W <= 0) {
         return 0;
      }
      if (dp[n][W] > 0) {
         return dp[n][W];
      }
      if (wt[n - 1] <= W) {
         int include = val[n - 1] + knapsackDpMemoization(wt, val, W - wt[n - 1], n - 1, dp);
         int notInclude = knapsackDpMemoization(wt, val, W, n - 1, dp);
         return dp[n][W] = Integer.max(include, notInclude);
      } else {
         return dp[n][W] = knapsackDpMemoization(wt, val, W, n - 1, dp);
      }
   }

}
