package com.practice.time_space;

import java.util.Arrays;

public class TNS {

   public static void main(String[] args) {
      pivotPartitioning(new int[]{1, 5, 8, 2, 3, 4, 5, 2, 1, 9}, 4);
   }

   private static void pivotPartitioning(int[] arr, int pivotElement) {
//      pivotPartitioning(new int[]{1, 5, 8, 2, 3, 41, 5, 2, 1, 9}, 4);
      int smaller = 0, greater = 0;

      while (greater < arr.length - 1) {
         if (arr[greater] < pivotElement) {
            int temp = arr[smaller];
            arr[smaller++] = arr[greater];
            arr[greater++] = temp;
         } else if (arr[greater] >= pivotElement) greater++;
      }
      System.out.println(Arrays.toString(arr));

   }
}
