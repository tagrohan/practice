package com.practice;

public class RecursionBacktracking {
   public static void main(String[] args) {
      printTargetSumSubsets(new int[]{1, 2, 3, 4, 5}, 0, "", 0, 9);
   }

   // print target sum in subset simple question in recursion
   public static void printTargetSumSubsets(int[] arr, int idx, String set, int sos, int tar) {
//      printTargetSumSubsets(new int[]{1, 2, 3, 4, 5}, 0, "", 0, 9);
      if (arr.length == idx) {
         if (sos == tar) {
            System.out.println(set);
         }
         return;
      }

      printTargetSumSubsets(arr, idx + 1, set + " " + arr[idx], sos + arr[idx], tar);
      printTargetSumSubsets(arr, idx + 1, set, sos, tar);
   }
}
