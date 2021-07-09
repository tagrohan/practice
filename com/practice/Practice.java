package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice {
   public static void main(String[] args) {
      System.out.println(Arrays.toString(stairPath(5, "").toArray()));
   }

   private static List<String> stairPath(int n, String pathSoFar) {

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
