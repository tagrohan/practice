package com.practice.stack;

import java.util.Stack;

public class StackAditya {
   public static void main(String[] args) {
      // stack questions by Aditya verma
      System.out.println(largestAreaHistogramPractice(new int[]{2, 4}));
      System.out.println(largestAreaOfRectangleInMatrix(new
              int[][]
              {
                      {0, 1, 1, 0},
                      {1, 1, 1, 1},
                      {1, 1, 1, 1},
                      {1, 1, 0, 0}
              }));
   }

   // little complicated but working fine man ... based on largestAreaHistogram : )
   private static int largestAreaOfRectangleInMatrix(int[][] matrix) {
//      System.out.println(largestAreaOfRectangleInMatrix(new
//              int[][]
//              {
//                      {0, 1, 1, 0},
//                      {1, 1, 1, 1},
//                      {1, 1, 1, 1},
//                      {1, 1, 0, 0}
//              }));
      int len = matrix.length;
      int max = 0;
      int[] res = new int[len];

      for (int[] arr : matrix) {
         for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
               res[i] = 0;

            } else {
               res[i] += arr[i];
            }

         }
         max = Integer.max(max, largestAreaHistogramPractice(res));
      }
      return max;
   }


   private static int largestAreaHistogramPractice(int[] arr) {
//            System.out.println(largestAreaHistogram(new int[]{6, 2, 5, 4, 5, 1, 6}));
      int len = arr.length;
      int[] NSR = new int[len];
      int[] NSL = new int[len];
      Stack<Integer> stack = new Stack<>();

      for (int i = len - 1; i >= 0; i--) {
         while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
            stack.pop();
         }
         if (stack.isEmpty()) {
            NSR[i] = len;
         } else {
            NSR[i] = stack.peek();
         }
         stack.push(i);
      }
      stack.clear();

      for (int i = 0; i < len; i++) {
         while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
            stack.pop();
         }
         if (stack.isEmpty()) {
            NSL[i] = -1;
         } else {
            NSL[i] = stack.peek();
         }
         stack.push(i);
      }
//      System.out.println(Arrays.toString(NSR));
//      System.out.println(Arrays.toString(NSL));
      int max = 0;
      for (int i = 0; i < len; i++) {
         max = Integer.max((NSR[i] - NSL[i] - 1) * arr[i], max);
      }

      return max;
   }
}
