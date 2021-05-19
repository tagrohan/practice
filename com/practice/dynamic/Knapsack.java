package com.practice.dynamic;

import java.util.Arrays;

public class Knapsack {
   public static void main(String[] args) {

//      System.out.println(subsetWithMinDiff(new int[]{1,2,7}));

   }

   // diff is given main code is int set = (diff + sum) / 2; here we are doing
//   (s1 + s2 = range) and (s1 - s2 = diff) now sum them up
   private static int subsetWithGivenDiff(int[] arr, int diff) {
//      System.out.println(subsetWithGivenDiff(new int[]{1, 1, 2, 3}, 1));
      int sum = 0;
      int length = arr.length;

      for (int i : arr) {
         sum += i;
      }
      int set = (diff + sum) / 2;
      int[][] dp = new int[length + 1][set + 1];
      for (int i = 0; i <= length; i++) {
         for (int j = 0; j <= set; j++) {
            if (i == 0) {
               dp[i][j] = 0;
            }
            if (j == 0) {
               dp[i][j] = 1;
            }
            if (i > 0 && j > 0) {
               if (arr[i - 1] <= j) {
                  dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
               } else {
                  dp[i][j] = dp[i - 1][j];
               }
            }
         }
      }
      return dp[length][set];
   }

   // working fine check video no : 10 by aditya in DP or watch notes for logic man
   // although (range - 2s1) is the formula i have used here
   private static int subsetWithMinDiff(int[] arr) {
      int sum = 0;
      for (int i : arr) {
         sum += i;
      }
      int n = sum / 2;
      boolean[][] dp = new boolean[arr.length + 1][n + 1];
      for (int i = 0; i <= arr.length; i++) {
         for (int j = 0; j <= n; j++) {
            if (i == 0) {
               dp[i][j] = false;
            }
            if (j == 0) {
               dp[i][j] = true;
            }
            if (i > 0 && j > 0) {
               if (arr[i - 1] <= j) {
                  dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
               } else {
                  dp[i][j] = dp[i - 1][j];
               }
            }
         }
      }
      for (boolean[] bool :
              dp) {
         System.out.println(Arrays.toString(bool));
      }
      int min = Integer.MAX_VALUE;
      for (int j = 0; j <= n; j++) {
         if (dp[arr.length][j]) {
            min = Integer.min(min, sum - 2 * j);
         }
      }
      return min;
   }

   // it's working fine here based on subset sum (which based on 0/1 knapsack)
   private static int countOfSubsetSum(int[] arr, int sum) {
//      System.out.println(countOfSubsetSum(new int[]{2, 3, 5, 6, 8, 10}, 10));
      int[][] dp = new int[arr.length + 1][sum + 1];
      for (int i = 0; i <= arr.length; i++) {
         for (int j = 0; j <= sum; j++) {
            if (i == 0) {
               dp[i][j] = 0;
            }
            if (j == 0) {
               dp[i][j] = 1;
            }
            if (i > 0 && j > 0) {
               if (arr[i - 1] <= j) {
                  dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
               } else {
                  dp[i][j] = dp[i - 1][j];
               }
            }
         }
      }
      return dp[arr.length][sum];
   }

   // working fine man validation of even odd + subsetSum makes it working
   private static boolean sumPartitionProblemDpIncludeSubsetSum(int[] arr) {
      int sum = 0;
      for (int i : arr) {
         sum += i;
      }
      if (sum % 2 != 0) {
         return false;
      } // subsetSum code start from here actually which is same to find sum n in this case
      int n = (sum / 2);
      boolean[][] dp = new boolean[arr.length + 1][n + 1];

      for (int i = 0; i <= arr.length; i++) {
         for (int j = 0; j <= n; j++) {
            if (i == 0) {
               dp[i][j] = false;
            }
            if (j == 0) {
               dp[i][j] = true;
            }
            if (i > 0 && j > 0) {
               if (arr[i - 1] <= j) {
                  dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
               } else {
                  dp[i][j] = dp[i - 1][j];
               }
            }
         }
      }
      return dp[arr.length][n];
   }

   private static boolean sumPartitionProblem(int[] arr) {
      int sum = 0;
      for (int i : arr) {
         sum += i;
      }
      if (sum % 2 != 0) {
         return false;
      }
      return subsetSumDpTabulation(arr, sum / 2);
//      here i am using subsetSumDpTabulation() bcz now i have to find the half os sum / 2 (which is 11 in this case)
//      and the rest of the 11 is already there (use ur brain man)
   }

   //   it's working fine
   private static boolean subsetSumDpTabulation(int[] arr, int key) {
//      System.out.println(subsetSumDpTabulation(new int[]{4, 2, 7, 1, 3,}, 10));
      boolean[][] dp = new boolean[arr.length + 1][key + 1];
      for (int i = 0; i <= arr.length; i++) {
         for (int j = 0; j <= key; j++) {
            if (i == 0) {
               dp[i][j] = false;
            }
            if (j == 0) {
               dp[i][j] = true;
            }
            if (i > 1 && j > 1) {
               if (arr[i - 1] <= j) {
                  dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
               } else {
                  dp[i][j] = dp[i - 1][j];
               }
            }
         }
      }
      for (boolean[] val :
              dp) {
         System.out.println(Arrays.toString(val));
      }
      return dp[arr.length][key];
   }

   // working fine
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
      for (int[] arr :
              dp) {
         System.out.println(Arrays.toString(arr));
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
