package com.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class Matrix {
   public static void main(String[] args) {
      matrix2();
   }

   private static void matrix2(){
      String str = "rohan singh";
      String ro = str.replaceFirst("ro", "");
      boolean s = str.contains("s");
      int s1 = str.indexOf(" ");
      char arr[] = str.toCharArray();
      Arrays.sort(arr);
      Collections.sort(List.of(arr.clone()), Collections.reverseOrder());
      for (int i = 0; i < arr.length; i++) {
      }
   }


   private static void matrix(){
      int[][] arr = new int[3][3];

      for (int i = 0; i < arr.length; i++) {
         for (int j = 0; j < arr.length; j++) {
            arr[i][j] = i + j;
         }
      }


      for (int i = 0; i < arr.length; i++) {
         for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[i][j]+" ");
         }
         System.out.println();
      }
   }

}
