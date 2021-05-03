package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecursionInArrayList {
   public static void main(String[] args) {
      List<String> res = getKeypadCombination(new int[]{5, 7, 3}, 3);
      System.out.println(res.size());
      System.out.println(Arrays.toString(res.toArray()));
   }

   // ex - 573
   static String[] str = {"abc", "def", "ghi", "jkl", "mnop", "qrst", "uv", "wxyz", ".;", "?!"};

   private static List<String> getKeypadCombination(int[] arr, int idx) {
      if (idx == 0) {
         return List.of("");
      }
      String[] sub = str[arr[idx - 1] - 1].split("");

      List<String> toGet = getKeypadCombination(arr, idx - 1);
      List<String> list = new ArrayList<>();
      for (String val : toGet) {
         for (String each : sub) {
            list.add(val + each);
         }
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