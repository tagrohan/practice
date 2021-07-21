package com.practice.pep;

public class Practice {
   public static void main(String[] args) {
            printTargetSumSubsets(new int[]{1, 2, 3, 4, 5}, 0, "", 0, 9);
   }


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

   private static void printPermutation(String str, String ans) {
      if (str.length() == 0) {
         System.out.print(ans + " ");
      }

      for (int i = 0; i < str.length(); i++) {
         char ch = str.charAt(i);
         printPermutation(str.substring(0, i) + str.substring(i + 1), ans + ch);
      }
   }
}
