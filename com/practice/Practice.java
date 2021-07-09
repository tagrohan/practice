package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice {
   public static void main(String[] args) {
      System.out.println(Arrays.toString(maze(1, 1, 3, 3).toArray()));
   }

   private static List<String> maze(int x, int y, int dX, int dY) {

      if (x == dX && y == dY) return List.of("");
      if (x > dX || y > dY) return List.of();

      List<String> xAxis = maze(x + 1, y, dX, dY);
      List<String> yAxis = maze(x, y + 1, dX, dY);

      List<String> paths = new ArrayList<>();
      for (String inX : xAxis) {
         paths.add("x" + inX);
      }
      for (String inY : yAxis) {
         paths.add("y" + inY);
      }
      return paths;
   }


   // no of operations to make it equal [2,4,7,9]
   private static int noOfOperations(int[] arr) {
//      System.out.println(noOfOperations(new int[]{2, 4, 7, 9}));
      int len = arr.length;
      int median = 0;
      int max = Integer.MIN_VALUE;
      for (int i = 0; i < len; i++) {
         median += arr[i];
         max = Integer.max(arr[i], max);
      }
      median /= len;
      return Math.abs(median - max);

   }

   private static List<String> stairPath(int n, String pathSoFar) {
//      System.out.println(Arrays.toString(stairPath(5, "").toArray()));
      if (n == 0) {
         List<String> list = new ArrayList<>();
         list.add(pathSoFar);
         return list;
      }
      if (n < 0) {
         return List.of();
      }

      List<String> pathOne = stairPath(n - 1, pathSoFar + " " + 1);
      List<String> pathTwo = stairPath(n - 2, pathSoFar + " " + 2);
      List<String> pathThree = stairPath(n - 3, pathSoFar + " " + 3);

      List<String> res = new ArrayList<>();
      res.addAll(pathOne);
      res.addAll(pathTwo);
      res.addAll(pathThree);
      return res;
   }
}
