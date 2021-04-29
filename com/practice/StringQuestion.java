package com.practice;

public class StringQuestion {
   public static void main(String[] args) {
      palindrome("abcba");
      String str = "Rohan";

//      System.out.println(str.substring(1,4));

   }

   private static void palindrome(String str) {
      for (int i = 0; i <= str.length(); i++) {
         for (int j = i + 1; j <= str.length(); j++) {
            String sub = str.substring(i, j);
            if (isPalindrome(sub)) {
               System.out.println(sub);
            }
         }
      }
   }

   private static boolean isPalindrome(String sub) {
      int i = 0, j = sub.length() - 1;
      while (i < j) {
         if (sub.charAt(i) != sub.charAt(j)) {
            return false;
         }
         i++;
         j--;
      }
      return true;
   }
}
