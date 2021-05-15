package com.practice.pep;

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

//      searchInMatrix(arr);

   }



   // recursion practice
   private static int fact(int n) {
      if (n > 1) {
         return n * fact(n - 1);
      }
      return 1;
   }

   //search in 2D matrix of ascending order elements
   private static void searchInMatrix(int[][] arr) {
      int a = -4;
      int b = 1;

      a = a + b;
      b = a - b;
      a = a - b;

      System.out.println(a);
      System.out.println(b);
   }


   // multiplication working fine
   private static void multiplication(int[][] arr1, int[][] arr2) {
      printMatrix(arr1);
      printMatrix(arr2);
      int row = arr2.length, column = arr1[0].length;
      if (row != column) {
         return;
      }
      int[][] ans = new int[row][column];

      for (int i = 0; i < row; i++) {
         for (int j = 0; j < row; j++) {
            for (int k = 0; k < row; k++) {
               ans[i][j] += arr1[i][k] * arr2[k][j];
            }
         }
      }
      printMatrix(ans);

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
      System.out.println();
   }

}
