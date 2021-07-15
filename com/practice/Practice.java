package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Practice {
   public static void main(String[] args) {
      System.out.println(Arrays.toString(nextSmallestElement(new int[]{1, 2, 9, 4, 5})));
   }

   private static int[] nextSmallestElement(int[] arr) { // 1 2 9 4 3
      int len = arr.length;
      int[] res = new int[len];
      Stack<Integer> stack = new Stack<>();
      for (int i = len - 1; i >= 0; i--) {
         while (!stack.isEmpty() && stack.peek() > arr[i]) {
            stack.pop();
         }
         if (stack.isEmpty()) {
            res[i] = -1;
         } else {
            res[i] = stack.peek();
         }
         stack.push(arr[i]);
      }
      return res;
   }


   private static int[] nextGreatestElement(int[] arr) {
      Stack<Integer> stack = new Stack<>();
      int[] res = new int[arr.length];
      for (int i = arr.length - 1; i >= 0; i--) {
         while (!stack.isEmpty() && stack.peek() < arr[i]) {
            stack.pop();
         }
         if (stack.isEmpty()) {
            res[i] = -1;
         } else {
            res[i] = stack.peek();
         }
         stack.push(arr[i]);
      }
      return res;
   }

   static int Is_Possible(int N, int K, String str) {
//      System.out.println(Is_Possible(0, 2, ""));
      char[] cha = str.toCharArray();
      for (int i = 1; i < N; i++) {
         if ((i + 1) % K == 0) {
            cha[i] = '0';
         }
      }
      System.out.println(Arrays.toString(cha));
      for (int i = 0; i < N; i++) {
         if (cha[i] != '0') {
            return 0;
         }
      }
      return 1;
   }

   // stack prepration started
   private static void stackPractice() {

   }


   // (a+b)+(c+d) -> false (means no bracket duplicate) (a+b)+((c+d)) -> true
   private static boolean duplicateBrackets(String regex) {
      System.out.println(duplicateBrackets("(a+b)+(c+d)"));
      Stack<Character> stack = new Stack<>();
      for (int i = 0; i < regex.length(); i++) {
         char ch = regex.charAt(i);
         if (ch != ')') {
            stack.push(ch);
         } else {
            if (!stack.isEmpty() && stack.peek() == '(') {
               return true;
            }
            while (!stack.isEmpty() && stack.peek() != '(') {
               stack.pop();
            }
            if (stack.isEmpty()) return true;
            stack.pop();
         }
      }
      return false;
   }


   private static List<String> maze(int x, int y, int dX, int dY) {
//      System.out.println(Arrays.toString(maze(1, 1, 3, 3).toArray()));
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
