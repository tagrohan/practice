package com.practice;

import java.util.Locale;

public class WorthConsidering {

   public static void main(String[] args) {
      System.out.println(largeString("ma name is roha singh"));
   }


   private static int largeString(String str) {
      str = str + " ";
      int max = 0, counter = 0;
      int cIndex = 0, index = 0;

      for (int i = 0; i < str.length(); i++) {
         if (str.charAt(i) != ' ') {
            counter += 1;
         } else {
            if (max < counter) {
               max = counter;
               index = cIndex;
            }
            cIndex = i + 1;
            counter = 0;
         }

      }
      System.out.println(index + "->" + max);
      return max;
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
