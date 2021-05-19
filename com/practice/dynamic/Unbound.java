package com.practice.dynamic;

import java.util.Arrays;

public class Unbound {
   public static void main(String[] args) {
//      System.out.println(unboundedKnapsack(new int[]{2, 4, 6}, new int[]{8, 3, 4}, 6, 3));
      System.out.println(unboundedKnapsack(new int[]{1, 50}, new int[]{1, 30}, 100, 2));
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
