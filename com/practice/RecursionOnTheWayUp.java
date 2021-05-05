package com.practice;

public class RecursionOnTheWayUp {
   public static void main(String[] args) {
      printSubsequence("abc", "");
   }

   private static void printSubsequence(String str, String ans) {
      if (str.length() == 0) {
         System.out.print("[" + ans + "],");
         return;
      }

      char ch = str.charAt(0);
      String sub = str.substring(1);

      printSubsequence(sub, ans + ch);
      printSubsequence(sub, ans);
   }

}
