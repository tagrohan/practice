package com.practice;

public class WorthConsidering {

   public static void main(String[] args) {
      System.out.println(palindrome("0p"));
   }

   // working but not for numeric (learn regex)
   private static int palindrome(String str) {

      String tes = str.replaceAll("[^a-zA-Z]+", "").toLowerCase();
      System.out.println(tes);

      for (int i = 0; i < tes.length() / 2; i++) {
         char start = tes.charAt(i);
         char fromLast = tes.charAt(tes.length() - i - 1);
         if (start != fromLast) {
            return -1;
         }
      }
      return 1;
   }
}
