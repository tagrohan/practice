package com.practice;

public class Practice {
   public static void main(String[] args) {
      towerOfHanoi(1, 3, 2, 3);
   }

   // working fine practice it, aditya verma god
   private static void towerOfHanoi(int s, int d, int h, int n) {
      if (n == 1) {
         System.out.println(s + " " + d);
         return;
      }
      towerOfHanoi(s, h, d, n - 1);
      System.out.println(s + " " + d);
      towerOfHanoi(h, d, s, n - 1);
   }
}
