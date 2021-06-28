package com.practice.getting_started;

public class Getting {
   public static void main(String[] args) {
      rotateANumber("12345", 2);
   }

   // -2 anti - clock, 2 - clock
   private static void rotateANumber(String num, int by) {
      int len = num.length();
      by = (len + by) % len;
      for (int i = len - by; i < len; i++) {
         System.out.print(num.charAt(i));
      }
      for (int i = 0; i < len - by; i++) {
         System.out.print(num.charAt(i));
      }
   }
}
