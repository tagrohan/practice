package com.practice.getting_started;

public class Getting {
   public static void main(String[] args) {
      rotateANumberV2(12345, -2);
   }


   // input is in int format
   private static void rotateANumberV2(int num, int by) {
//      rotateANumberV2(12345, -2);
      int len = 0, temp = num;
      while (temp > 0) {
         len += 1;
         temp = temp / 10;
      }

      by = (len + by) % len;
      int first = 1, second = 1;
      for (int i = 0; i < len; i++) {
         if (i < by) {
            first *= 10;
         } else second *= 10;
      }
      System.out.println(second);
      System.out.println(first);

      second = (num % first) * second;
      first = num / first;
      System.out.println(second + first);

   }


   // -2 anti - clock, 2 - clock
   private static void rotateANumber(String num, int by) {
//      rotateANumber("12345", 2);
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
