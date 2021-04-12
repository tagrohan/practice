package com.practice;

import java.util.*;

public class Sorting {
   public static void main(String[] args) {

   }





   // insertion working fine
   private static void insertionSort(int[] arr) {
      for (int i = 1; i < arr.length; i++) {
         int key = arr[i];
         int j;
         for (j = i - 1; j > -1 && arr[j] > key; j--) {
            arr[j + 1] = arr[j];
         }
         arr[j + 1] = key;
      }
      System.out.println(Arrays.toString(arr));
   }


   private static void bubbleSort(int[] arr) {

      for (int i = 1; i <= arr.length; i++) {
         for (int j = 0; j < arr.length - i; j++) {
            if (arr[j] > arr[j + 1]) {
               int temp = arr[j];
               arr[j] = arr[j + 1];
               arr[j + 1] = temp;
            }
         }
      }
      System.out.println(Arrays.toString(arr));
   }

   private static void selectionSort(int[] arr) {

      for (int i = 0; i < arr.length; i++) {
         for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] < arr[i]) {
               // swapping here
               int temp = arr[i];
               arr[i] = arr[j];
               arr[j] = temp;
            }
         }

      }
      System.out.println(Arrays.toString(arr));
   }

}
