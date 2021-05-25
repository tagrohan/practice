package com.practice.stack;

import java.util.Stack;

public class StackAditya {
   public static void main(String[] args) {
      // stack questions by Aditya verma
      System.out.println(largestAreaHistogramPractice(new int[]{6, 2, 5, 4, 5, 1, 6}));
   }

   private static int largestAreaHistogramPractice(int[] arr) {
      int len = arr.length;
      int[] NSR = new int[len];
      int[] NSL = new int[len];
      Stack<Integer> stack = new Stack<>();

      for (int i = len - 1; i >= 0; i--) {
         while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
            stack.pop();
         }
         if (stack.isEmpty()) {
            NSR[i] = 7;
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
      int max = 0;
      for (int i = 0; i < len; i++) {
         max = Integer.max((NSR[i] - NSL[i] - 1) * arr[i], max);
      }

      return max;
   }
}
