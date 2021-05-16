package com.practice.pep;

import java.util.Arrays;

public class DynamicProgramming {
   public static void main(String[] args) {
      System.out.println(climbStairsWithJumps(4, 3, new int[5]));
   }

   public static int climbStairsWithJumps(int n, int jump, int[] dp)  {

      if (n == 0) {
         return 1;
      } else if (n < 0) {
         return 0;
      }

      if (dp[n] > 0) {
         return dp[n];
      }
      System.out.println("called ->" + n);
      for (int i = 1; i <= jump; i++) {
         dp[n] += climbStairsWithJumps(n - i, 3, dp);
      }
      return dp[n];
   }


   // tabulation
   private static int climbStairs(int n) {
      int[] dp = new int[n + 1];

      dp[0] = 1;
      dp[1] = 1;
      for (int i = 2; i <= n; i++) {
         if (i == 2) {
            dp[i] = dp[i - 1] + dp[i - 2];
         } else {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
         }
      }
      System.out.println(Arrays.toString(dp));
      return dp[n];
   }

   // memoization works fine
   private static int climbStairs(int n, int[] dp) {
      if (n < 0) {
         return 0;
      } else if (n == 0) {
         return 1;
      }
      if (dp[n] > 0) {
         return dp[n];
      }

      System.out.println("called " + n);
      int n1 = climbStairs(n - 1, dp);
      int n2 = climbStairs(n - 2, dp);
      int n3 = climbStairs(n - 3, dp);
      return dp[n] = n1 + n2 + n3;
   }

   private static int fibonacci(int n) {
      if (n == 0 || n == 1) {
         return n;
      }
      System.out.println("calling time " + n);
      return fibonacci(n - 1) + fibonacci(n - 2);
   } // solving upper using Dp here

   // dp solution of fibonacci where each time it called only one
   private static int fibonacciDP(int n, int[] dp) {
//      System.out.println(fibonacciDP(10, new int[11]));
      if (n == 0 || n == 1) {  // or if(n <= 2) return 1;
         return n;
      }
      if (dp[n] > 0) {
         return dp[n];
      }
      System.out.println("calling time " + n);
      return dp[n] = fibonacciDP(n - 1, dp) + fibonacciDP(n - 2, dp);
   }

   // tabulation of fibonacci is here
   private static int fibTabulation(int n) {
      int[] dp = new int[n + 1];
      dp[0] = 0;
      dp[1] = 1;
      for (int i = 2; i <= n; i++) {
         dp[i] = dp[i - 1] + dp[i - 2];
      }
      return dp[n];
   }

}
