package com.practice;

import java.util.Arrays;

public class Matrix {
   public static void main(String[] args) {
      int[][] arr = new int[3][3];
      int count = 1;
      for (int i = 0; i < arr.length; i++) {
         for (int j = 0; j < arr.length; j++) {
            arr[i][j] = count;
            count += 1;
         }
      }

      transpose(arr);
   }


   // transpose working fine
   private static void transpose(int[][] arr) {
      printMatrix(arr);
      for (int i = 0; i < arr.length; i++) {
         for (int j = i; j < arr.length; j++) {
           int temp = arr[i][j];
            arr[i][j] = arr[j][i];
            arr[j][i] = temp;
         }
      }
      System.out.println("\n");
      printMatrix(arr);
   }

   private static void matrix() {
      int[][] arr = new int[3][3];

      for (int i = 0; i < arr.length; i++) {
         for (int j = 0; j < arr.length; j++) {
            arr[i][j] = i + j;
         }
      }


      for (int i = 0; i < arr.length; i++) {
         for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[i][j] + " ");
         }
         System.out.println();
      }
   }

   // helper method
   private static void printMatrix(int[][] matrix) {
      for (int[] row : matrix) {
         System.out.println(Arrays.toString(row));
      }
   }

}
