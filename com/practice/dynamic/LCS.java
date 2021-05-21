package com.practice.dynamic;

public class LCS {
   public static void main(String[] args) {
      System.out.println(longestCommonSubsequence("abcd", "bcde", 4, 4));
   }

   private static int longestCommonSubsequence(String str1, String str2, int len1, int len2) {
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
