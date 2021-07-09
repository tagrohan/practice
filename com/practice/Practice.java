package com.practice;

import java.util.ArrayList;
import java.util.List;

public class Practice {
   public static void main(String[] args) {
      System.out.println(noOfOperations(new int[]{2, 4, 7, 9}));
   }

   // no of operations to make it equal [2,4,7,9] [3,1,-2,-4]
//                                      [3,5,6,8]
//                                      [4,5,5,7]
//                                      [5,5,5,6]
//                                      [5,5,5,5]
   private static int noOfOperations(int[] arr) {
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
