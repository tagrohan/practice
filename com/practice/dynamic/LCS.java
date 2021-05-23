package com.practice.dynamic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LCS {
   public static void main(String[] args) {
      System.out.println(largestPalindromeSubsequence("agbcba"));
//      System.out.println(printLongestCommonSubsequence("agbcba","abcbga"));
   }


   // working fine abcba = 5
   private static int largestPalindromeSubsequence(String str1) {
//      System.out.println(largestPalindromeSubsequence("agbcba"));
      String str2 = new StringBuilder(str1).reverse().toString();
      int len1 = str1.length(), len2 = str2.length();
      int[][] dp = new int[len1 + 1][len2 + 1];
      for (int i = 0; i <= len1; i++) {
         for (int j = 0; j <= len2; j++) {
            if (i == 0 || j == 0) {
               dp[i][j] = 0;
            } else {
               if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                  dp[i][j] = 1 + dp[i - 1][j - 1];
               } else {
                  dp[i][j] = Integer.max(dp[i - 1][j], dp[i][j - 1]);
               }
            }
         }
      }
      return dp[len1][len2];
   }


   // find LCS and then str1 - LCS = insertion, str2 - LCS = deletion
   private static Map<Integer, Integer> minStepToConvertAtoB(String str1, String str2) {
//      System.out.println(minStepToConvertAtoB("heap", "pea")); {2,1}
      int len1 = str1.length(), len2 = str2.length();
      int[][] dp = new int[len1 + 1][len2 + 1];
      Map<Integer, Integer> map = new HashMap<>();
      for (int i = 0; i <= len1; i++) {
         for (int j = 0; j <= len2; j++) {
            if (i == 0 || j == 0) {
               dp[i][j] = 0;
            } else {
               if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                  dp[i][j] = 1 + dp[i - 1][j - 1];
               } else {
                  dp[i][j] = Integer.max(dp[i - 1][j], dp[i][j - 1]);
               }
            }
         }
      }
      map.put(len1 - dp[len1][len2], len2 - dp[len1][len2]);
      return map;
   }

   // ex: str1 = geek, str2 = eke, SCS = geeke
   private static int shortestCommonSuperSequence(String str1, String str2) {
//      System.out.println(shortestCommonSuperSequence("geek","eke")); = 5
//      System.out.println(shortestCommonSuperSequence("aggtab","gxtxayb")); = 9
      int len1 = str1.length(), len2 = str2.length();
      int[][] dp = new int[len1 + 1][len2 + 1];

      for (int i = 0; i <= len1; i++) {
         for (int j = 0; j <= len2; j++) {
            if (i == 0 || j == 0) {
               dp[i][j] = 0;
            } else {
               if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                  dp[i][j] = 1 + dp[i - 1][j - 1];
               } else {
                  dp[i][j] = Integer.max(dp[i - 1][j], dp[i][j - 1]);
               }
            }
         }
      }
      return len1 + len2 - dp[len1][len2];
   }


   private static int printLongestCommonSubsequence(String str1, String str2) {
//    System.out.println(longestCommonSubsequenceTabulation("abcd", "bcde"));
      int len1 = str1.length(), len2 = str2.length();
      int[][] dp = new int[len1 + 1][len2 + 1];
      int cI = 1; // this here is used to print.
      for (int i = 0; i <= len1; i++) {
         for (int j = 0; j <= len2; j++) {

            if (i == 0 || j == 0) {
               dp[i][j] = 0;
            } else {
               if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                  dp[i][j] = 1 + dp[i - 1][j - 1];
                  if (cI == dp[i][j]) {
                     System.out.print(str1.charAt(i - 1) + " ");
                     cI += 1;
                  }
               } else {
                  dp[i][j] = Integer.max(dp[i - 1][j], dp[i][j - 1]);
               }
            }

         }
      }
//      System.out.println();
//      for (int[] var :
//              dp) {
//         System.out.println(Arrays.toString(var));
//      }
      return dp[len1][len2];

   }

   // here it's diff from LCS , abcd abced = 3(a,b,c are common sub array but in LCS its 4)
   private static int longestCommonSubstring(String str1, String str2) {
      //      System.out.println(longestCommonSubstring("abcdde", "abced"));
      int len1 = str1.length(), len2 = str2.length();
      int[][] dp = new int[len1 + 1][len2 + 1];
      int max = 0;
      for (int i = 0; i <= len1; i++) {
         for (int j = 0; j <= len2; j++) {
            if (i == 0 || j == 0) {
               dp[i][j] = 0;
            } else {
               if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                  dp[i][j] = 1 + dp[i - 1][j - 1];
                  max = Integer.max(dp[i][j], max);
               } else {
                  dp[i][j] = 0;
               }
            }
         }
      }
      return max;
   }

   private static int longestCommonSubsequenceTabulation(String str1, String str2) {
//      System.out.println(longestCommonSubsequenceTabulation("abcd", "bcde"));
      int len1 = str1.length(), len2 = str2.length();
      int[][] dp = new int[len1 + 1][len2 + 1];
      for (int i = 0; i <= len1; i++) {
         for (int j = 0; j <= len2; j++) {

            if (i == 0 || j == 0) {
               dp[i][j] = 0;
            } else {
               if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                  dp[i][j] = 1 + dp[i - 1][j - 1];
               } else {
                  dp[i][j] = Integer.max(dp[i - 1][j], dp[i][j - 1]);
               }
            }

         }
      }
      for (int[] var :
              dp) {
         System.out.println(Arrays.toString(var));
      }
      return dp[len1][len2];
   }

   // memoization it worked on substring concept so if second string have it before then first it didn't count
   private static int longestCommonSubsequenceMemoization(String str1, String str2, int len1, int len2, int[][] dp) {
//      System.out.println(longestCommonSubsequenceMemoization("abcd", "bcde", 4, 4,new int[5][5]));
      if (len1 == 0 || len2 == 0) {
         return 0;
      }
      if (dp[len1][len2] != 0) {
         return dp[len1][len2];
      }

      if (str1.charAt(len1 - 1) == str2.charAt(len2 - 1)) {
//         System.out.println(str2.charAt(len2 - 1));
         return dp[len1][len2] = 1 + longestCommonSubsequenceMemoization(str1, str2, len1 - 1, len2 - 1, dp);
      } else {
         return dp[len1][len2] = Integer.max(longestCommonSubsequenceMemoization(str1, str2, len1, len2 - 1, dp),
                 longestCommonSubsequenceMemoization(str1, str2, len1 - 1, len2, dp));
      }
   }

   // memoization it worked on substring concept so if second string have it before then first it didn't count
   private static int longestCommonSubsequence(String str1, String str2, int len1, int len2) {
//      System.out.println(longestCommonSubsequence("abcd", "bcde", 4, 4));
      if (len1 == 0 || len2 == 0) {
         return 0;
      }

      if (str1.charAt(len1 - 1) == str2.charAt(len2 - 1)) {
         return 1 + longestCommonSubsequence(str1, str2, len1 - 1, len2 - 1);
      } else {
         return Integer.max(longestCommonSubsequence(str1, str2, len1, len2 - 1),
                 longestCommonSubsequence(str1, str2, len1 - 1, len2));
      }
   }
}
