package com.practice;

import java.util.Arrays;

public class Practice {
   public static void main(String[] args) {
      System.out.println(Arrays.toString(findIndexes(new int[]{1, 2, 3, 2, 2, 2}, 0, 2, 0)));
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

   private static int[] findIndexes(int[] arr, int idx, int key, int no) {
      if (arr.length == idx) {
         return new int[no];
      }

      if (arr[idx] == key) {
         int[] cIndex = findIndexes(arr, idx + 1, key, no + 1);
         cIndex[no] = idx;
         return cIndex;
      } else {
         return findIndexes(arr, idx + 1, key, no);
      }
   }
}
