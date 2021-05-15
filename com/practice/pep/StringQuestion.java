package com.practice.pep;

public class StringQuestion {
   public static void main(String[] args) {
      String str = "Rohan";




   }


   private static void toggleCase(String str) {
//      toggleCase("rOhAn"); // making upper to small and small to upper
      StringBuilder builder = new StringBuilder(str);
      for (int i = 0; i < str.length(); i++) {
         char ch = builder.charAt(i);
         if (ch >= 'a' && ch <= 'z') {
            ch = (char) ('A' + ch - 'a');
         } else {
            ch = (char) ('a' + ch - 'A');
         }
         builder.setCharAt(i, ch);
      }
      System.out.println(builder.toString());
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
