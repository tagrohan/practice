package com.practice.stack;


import java.util.Stack;

public class StackPep {
   public static void main(String[] args) {
//      System.out.println(Arrays.toString(stockSpan(new int[]{2, 5, 9, 3, 1, 12, 6, 8, 7})));

   }


   // here we check for prev greatest from current position
   private static int[] stockSpan(int[] arr) {
//      System.out.println(Arrays.toString(stockSpan(new int[]{2, 5, 9, 3, 1, 12, 6, 8, 7})));
      Stack<Integer> stack = new Stack<>();
      int[] res = new int[arr.length];

      for (int i = 0; i < arr.length; i++) {
         int howMuchPop = 1;
         while (!stack.isEmpty() && stack.peek() < arr[i]) {
            stack.pop();
            howMuchPop += 1;
         }
         if (stack.isEmpty()) {
            res[i] = i + 1;
         } else {
            res[i] = howMuchPop;
         }
         stack.push(arr[i]);
      }
      return res;
   }

   // same as greatest with > check one below
   private static int[] nextSmallestElement(int[] arr) {
//      System.out.println(Arrays.toString(nextSmallestElement(new int[]{2, 4, 7, 1, 5})));
      Stack<Integer> stack = new Stack<>();
      int[] res = new int[arr.length];
      for (int i = arr.length - 1; i >= 0; i--) {
         while (!stack.isEmpty() && stack.peek() > arr[i]) {
            stack.pop();
         }
         res[i] = stack.isEmpty() ? -1 : stack.peek();
//             if (stack.isEmpty()) {
//            res[i] = -1;
//         } else {
//            res[i] = stack.peek();
//         }
         stack.push(arr[i]);
      }
      return res;
   }

   // done in by myself man
   private static int[] nextGreatestElement(int[] arr) {
//      System.out.println(Arrays.toString(nextGreatestElement(new int[]{2, 5, 9, 3, 1, 12, 6, 8, 7})));
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

   private static boolean balanceBrackets(String regex) {
//      System.out.println(balanceBrackets("[(a + b) + {(c + d) * (e / f)}]"));
      Stack<Character> stack = new Stack<>();
      for (int i = 0; i < regex.length(); i++) {
         char ch = regex.charAt(i);
         if (returnOpening(ch) != ' ') {
            if (stack.peek() != returnOpening(ch)) {
               return false;
            }
            while (stack.peek() != returnOpening(ch)) {
               stack.pop();
            }
            stack.pop();
         }
         if (ch == '(' || ch == '{' || ch == '[') {
            stack.push(ch);
         }
      }
      return stack.isEmpty();
   }

   // associate with balanceBrackets();
   private static Character returnOpening(Character ch) {
      switch (ch) {
         case ')':
            return '(';
         case '}':
            return '{';
         case ']':
            return '[';
      }
      return ' ';
   }


   // working fine not fully validated
   private static boolean duplicateBrackets(String regex) {
//      System.out.println(duplicateBrackets("(a+b)+((c+d))"));
      Stack<Character> stack = new Stack<>();
      stack.push(regex.charAt(0));
      for (int i = 1; i < regex.length(); i++) {
         char ch = regex.charAt(i);
         if (ch == ')') {
            if (stack.peek() == '(') {
               return true;
            }
            while (stack.peek() != '(') {
               stack.pop();
            }
            stack.pop();
         } else {
            if (ch != ' ')
               stack.push(ch);
         }
      }
      return false;
   }
}
