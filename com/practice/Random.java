package com.practice;

import java.util.Arrays;

public class Random {
   public static void main(String[] args) {

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
