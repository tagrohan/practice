package com.practice.dynamic;

import java.util.Arrays;

public class Unbound {
   public static void main(String[] args) {
//      System.out.println(unboundedKnapsack(new int[]{2, 4, 6}, new int[]{8, 3, 4}, 6, 3));
      System.out.println(coinChangeMin(new int[]{2}, 3));
      System.out.println(Integer.MAX_VALUE);
   }

   // always pay attention to base case
   // it's working fine for 123 and s = 5, 3+2 = 5 which is total min number 2
   private static int coinChangeMin(int[] arr, int amount) {
//      System.out.println(coinChangeMax(new int[]{1, 2, 3}, 5));
      int length = arr.length;
      int[][] dp = new int[length + 1][amount + 1];
      for (int i = 0; i <= length; i++) {
         for (int j = 0; j <= amount; j++) {
            if (i == 0) {
               dp[i][j] = Integer.MAX_VALUE - 1;
            }
            if (j == 0) {
               dp[i][j] = 0;
            }
            if (i > 0 && j > 0) {
               if (arr[i - 1] <= j) {
                  dp[i][j] = Integer.min(dp[i][j - arr[i - 1]] + 1, dp[i - 1][j]);
               } else {
                  dp[i][j] = dp[i - 1][j];
               }
            }
         }
      }
      return dp[length][amount];
   }


   // working fine (here we have to find how many ways are there to give amount of 5 using 1,2 3 where we can use infinite coins(unbound))
   private static int coinChangeMax(int[] arr, int amount) {
//      System.out.println(coinChangeMax(new int[]{1, 2, 3}, 5));
      int length = arr.length;
      int[][] dp = new int[length + 1][amount + 1];
      for (int i = 0; i <= length; i++) {
         for (int j = 0; j <= amount; j++) {
            if (i == 0) {
               dp[i][j] = 0;
            }
            if (j == 0) {
               dp[i][j] = 1;
            }
            if (i > 0 && j > 0) {
               if (arr[i - 1] <= j) {
                  dp[i][j] = dp[i][j - arr[i - 1]] + dp[i - 1][j];
               } else {
                  dp[i][j] = dp[i - 1][j];
               }
            }
         }
      }
      return dp[length][amount];
   }

   // working fine. here we have to maximize the price by cutting rod in len given (we can cut at given len as much as we want(basically unbound))
   private static int rodCutting(int[] rodLen, int[] price, int availableLen, int length) {
//      System.out.println(rodCutting(new int[]{1, 2, 3, 4}, new int[]{1, 3, 6, 5}, 4, 4));
      int[][] dp = new int[length + 1][availableLen + 1];
      for (int i = 0; i <= length; i++) {
         for (int j = 0; j <= availableLen; j++) {
            if (i == 0 || j == 0) {
               dp[i][j] = 0;
            } else if (rodLen[i - 1] <= j) {
               dp[i][j] = Integer.max(price[i - 1] + dp[i][j - rodLen[i - 1]], dp[i - 1][j]);
            } else {
               dp[i][j] = dp[i - 1][j];
            }
         }
      }

      return dp[length][availableLen];
   }

   // after hours working fine now : )
   private static int unboundedKnapsack(int[] wt, int[] val, int sum, int n) {
      int[][] dp = new int[n + 1][sum + 1];

      for (int i = 0; i <= n; i++) {
         for (int j = 0; j <= sum; j++) {
            if (i == 0 || j == 0) {
               dp[i][j] = 0;
            } else if (wt[i - 1] <= j) {
               // this is the line where magic happen as dp[i][j - wt[i - 1]] not dp[i - 1][j - wt[i - 1]]
               dp[i][j] = Integer.max(val[i - 1] + dp[i][j - wt[i - 1]], dp[i - 1][j]);
            } else {
               dp[i][j] = dp[i - 1][j];
            }
         }
      }
      for (int[] var : dp) {
         System.out.println(Arrays.toString(var));
      }
      return dp[n][sum];
   }
}
