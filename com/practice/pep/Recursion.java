package com.practice.pep;

public class Recursion {

   // recursion practice goes from here
   public static void main(String[] args) {

//      System.out.println(testing(new int[]{1, 2, 3, 5}, 5));

//      System.out.println(arrayTesting(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 0));
      towerOfHanoi(3, 11, 22, 33);
   }

   private static int arrayTesting(int[] arr, int idx) {

      if (arr.length - 1 == idx) {
         return arr[idx];
      }

      int cMax = arrayTesting(arr, idx + 1);
      if (cMax > arr[idx]) {
         return cMax;
      }
      return arr[idx];
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

   // t -> tower number
   private static void towerOfHanoi(int noOfDisk, int t1, int t2, int t3) {
//      towerOfHanoi(3, 11, 22, 33);

      if (noOfDisk == 0) {
         return;
      }

      towerOfHanoi(noOfDisk - 1, t1, t3, t2);
      System.out.println(noOfDisk + " -> " + t1 + " to " + t2);
      towerOfHanoi(noOfDisk - 1, t3, t2, t1);
   }

   // to understand Pre In Post in recursion
   private static void zigzag(int n) {
//      zigzag(2);
      if (n == 0) {
         return;
      }
      System.out.println("pre ->" + n);
      zigzag(n - 1);
      System.out.println("In ->" + n);
      zigzag(n - 1);
      System.out.println("post ->" + n);

   }


   // factorial with O(log n)
   private static int fac(int n, int pow) {
      if (pow == 0) {
         return 1;
      }
      int res = fac(n, pow / 2) * fac(n, pow / 2);
//      int res = halfFact * halfFact;
      if (pow % 2 == 1) {
         res = res * n;
      }
      return res;
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
