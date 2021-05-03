package com.practice;

import java.util.ArrayList;
import java.util.List;

public class RecursionInArrayList {
   public static void main(String[] args) {
//      System.out.println(Arrays.toString(subsequenceTesting("abc").toArray()));

      System.out.println(kadane_algo(new int[]{1,1,0,0,0,1,0,1,0,0,0}));

   }


   private static int kadane_algo(int[] arr) {
      // kadane's algo for -ve numbers

      if (arr.length == 1) {
         return arr[0];
      }
      int sum = arr[0], ans = arr[0];
      for (int i = 1; i < arr.length; i++) {
         sum = Integer.max(sum + arr[i], arr[i]);
         ans = Integer.max(sum, ans);
      }
      return ans;
   }


   private static List<String> subsequenceTesting(String str) {

      if (str.length() == 0) {
         return List.of("");
      }

      char ch = str.charAt(0);

      List<String> subsequence = subsequenceTesting(str.substring(1));

      List<String> list = new ArrayList<>();

      for (String st : subsequence) {
         list.add(ch + st);
         list.add("" + st);
      }
      return list;
   }


   // arraylist subsequence (don't forget to do it in bit manipulation as well)
   private static List<String> subsequence(String str) {
//      System.out.println(Arrays.toString(subsequence("abc").toArray()));
      if (str.length() == 0) {
         return List.of("");
      }
      char ch = str.charAt(0);

      List<String> subsequence = subsequence(str.substring(1));

      List<String> list = new ArrayList<>();

      for (String st : subsequence) {
         list.add(ch + st);
         list.add("" + st);   // order is not maintained here
      }
      return list;
   }

}