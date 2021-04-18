package com.practice;

public class Recursion {
   // recursion practice goes from here
   public static void main(String[] args) {

      System.out.println(factorial(5));
   }

   // factorial using recursion
   public static int factorial(int num) {
      int fac = num;
      if (num == 0) {
         return 1;
      }
      System.out.println(fac);
      fac = fac * factorial(num - 1);
      return fac;
   }
}
