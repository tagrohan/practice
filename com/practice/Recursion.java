package com.practice;

public class Recursion {
   // recursion practice goes from here
   public static void main(String[] args) {

      System.out.println(power(2, 4));
   }


   // power is working fine here
   public static int power(int num, int pow) {
      if (pow == 0) {
         return 1;
      }
      int result = num * power(num, pow - 1);
      return result;
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
