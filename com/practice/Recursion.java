package com.practice;

public class Recursion {
   // recursion practice goes from here
   public static void main(String[] args) {

//      System.out.println(testing(new int[]{1, 2, 3, 5}, 5));
      System.out.println(fac(10, 4));
      System.out.println(-5 / 2);

   }

   public static int fac(int n, int pow) {
      if (pow == 0) {
         return 1;
      }
      int res = fac(n, pow / 2) * fac(n, pow / 2);
//      int res = halfFact * halfFact;
      if (pow % 2 == 1) {
         res  = res * n;
      }
      return res;
   }

   // todo  linear search in array

   private static int linearSearch(int[] arr, int idx, int key) {
//      System.out.println(linearSearch(new int[]{6, 4, 7, 8, 3, 2}, 0,8));

      if (arr.length - 1 == idx) {
         return arr[idx];
      }
      int element = linearSearch(arr, idx + 1, key);
      if (element == key) {
         return idx;
      }
      return -1;
   }

   // max of an array
   private static int maxOfAnArray(int[] arr, int idx) {
//      System.out.println(maxOfAnArray(new int[]{6, 4, 7, 8, 3, 2}, 0));
      if (idx == arr.length - 1) {
         return arr[idx];
      }
      int misa = maxOfAnArray(arr, idx + 1);
      if (misa > arr[idx]) {
         return misa;
      }
      return arr[idx];
   }


   private static void printArrayInDec(int[] arr, int idx) {
//      printArrayInDec(new int[]{6, 4, 7, 8, 3, 2}, 0);
      if (idx == arr.length) {
         return;
      }
      printArrayInDec(arr, idx + 1);
      System.out.println(arr[idx]);
   }

   // array in order
   private static void printArray(int[] arr, int idx) {
//      printArray(new int[]{6, 4, 7, 8, 3, 2}, 6);
      if (idx == 0) {
         return;
      }
      System.out.println(arr[arr.length - idx]);
      printArray(arr, idx - 1);
   }


   public static int powerBigOLogN(int num, int pow) {


      return -1;
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
