package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecursionInArrayList {
   public static void main(String[] args) {
      System.out.println(Arrays.toString(getMazePath(1, 1, 3, 3).toArray()));
   }

   //                                                1X1      ->            3X3
   private static List<String> getMazePath(int row, int col, int endRow, int endCol) {

      if (row == endRow && col == endCol) {
         return List.of("");
      }
      List<String> horizontalPath = new ArrayList<>();
      List<String> verticalPath = new ArrayList<>();

      if (col < endCol) {
         horizontalPath = getMazePath(row, col + 1, endRow, endCol);
      }
      if (row < endCol) {
         verticalPath = getMazePath(row + 1, col, endRow, endCol);
      }
      List<String> paths = new ArrayList<>();

      for (String hp : horizontalPath) {
         paths.add("h" + hp);
      }
      for (String vp : verticalPath) {
         paths.add("v" + vp);
      }
      return paths;
   }


   // get stair path with certain condition that we can only use 1 2 3 steps at a time
   private static List<String> getStairPaths(int n) {
//      System.out.println(Arrays.toString(getStairPaths(4).toArray()));
      if (n == 0) {
         return List.of("");
      }
      if (n < 0) {
         return List.of();
      }

      List<String> path1 = getStairPaths(n - 1);
      List<String> path2 = getStairPaths(n - 2);
      List<String> path3 = getStairPaths(n - 3);

      List<String> list = new ArrayList<>();
      for (String str : path1) {
         list.add("1" + str);
      }
      for (String str : path2) {
         list.add("2" + str);
      }
      for (String str : path3) {
         list.add("3" + str);
      }
      return list;
   }


   // working condition (done by myself)
   static String[] str = {"abc", "def", "ghi", "jkl", "mnop", "qrst", "uv", "wxyz", ".;", "?!"};

   private static List<String> getKeypadCombination(int[] arr, int idx) {
//      List<String> res = getKeypadCombination(new int[]{5, 7, 3}, 3);
      if (idx == 0) {
         return List.of("");
      }
      String[] sub = str[arr[idx - 1] - 1].split(""); // - 1 at the last because of str start from 0 and keypad from 1

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