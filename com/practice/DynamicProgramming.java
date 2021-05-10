package com.practice;

public class DynamicProgramming {
   public static void main(String[] args) {
      System.out.println(fibonacciDP(10, new int[11]));
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
      if (n == 0 || n == 1) {
         return n;
      }
      if (dp[n] > 0) {
         return dp[n];
      }
      System.out.println("calling time " + n);
      return dp[n] = fibonacciDP(n - 1, dp) + fibonacciDP(n - 2, dp);
   }


}
