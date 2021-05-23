package com.practice.stack;

import java.util.Stack;

public class StackPep {
   public static void main(String[] args) {
      testin("2 + 6 * 4 / 8 - 3");
      System.out.println(infixEvaluation("2 + 6 * 4 / 8 - 3"));
   }

   public static void testin(String exp) {
      // code
//      Stack<Integer> operands = new Stack<>();
//      Stack<Character> operators = new Stack<>();
//
//      for (int i = 0; i < exp.length(); i++) {
//         char ch = exp.charAt(i);
//
//         if (ch == '(') {
//            operators.push(ch);
//         } else if (Character.isDigit(ch)) {
//            operands.push(ch - '0');
//         } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
//            while (operators.size() > 0 && operators.peek() != '(' &&
//                    precedence(ch) <= precedence(operators.peek())) {
//               int val2 = operands.pop();
//               int val1 = operands.pop();
//               char op = operators.pop();
//
//               int opval = operation(val1, val2, op);
//               operands.push(opval);
//            }
//
//            operators.push(ch);
//         } else if (ch == ')') {
//            while (operators.size() > 0 && operators.peek() != '(') {
//               int val2 = operands.pop();
//               int val1 = operands.pop();
//               char op = operators.pop();
//
//               int opval = operation(val1, val2, op);
//               operands.push(opval);
//            }
//
//            if (operators.size() > 0) {
//               operators.pop();
//            }
//         }
//      }
//
//      while (operators.size() > 0) {
//         int val2 = operands.pop();
//         int val1 = operands.pop();
//         char op = operators.pop();
//
//         int opval = operation(val1, val2, op);
//         operands.push(opval);
//      }
//
//      int val = operands.pop();
//      System.out.println(val);
//   }
//
//   public static int precedence(char op) {
//      if (op == '+') {
//         return 1;
//      } else if (op == '-') {
//         return 1;
//      } else if (op == '*') {
//         return 2;
//      } else {
//         return 2;
//      }
//   }
//
//   public static int operation(int val1, int val2, char op) {
//      if (op == '+') {
//         return val1 + val2;
//      } else if (op == '-') {
//         return val1 - val2;
//      } else if (op == '*') {
//         return val1 * val2;
//      } else {
//         return val1 / val2;
//      }
   }


   //      2 + 6 * 4 / 8 - 3
   private static double infixEvaluation(String regex) {
      Stack<Integer> oprnds = new Stack<>();
      Stack<Character> oper = new Stack<>();

      for (int i = 0; i < regex.length(); i++) {
         char ch = regex.charAt(i);
         if (ch != ' ') {
            if (ch == '(') {
               oper.push(ch);
            } else if (Character.isDigit(ch)) {
               oprnds.push(ch - '0');
            } else if (ch == ')') {
               while (!oper.isEmpty() && oper.peek() != '(') {
                  int num2 = oprnds.pop();
                  int num1 = oprnds.pop();
                  oprnds.push(operation(num1, num2, oper.peek()));
               }
               if (!oper.isEmpty()) {
                  oper.pop();
               }

            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
               while (!oper.isEmpty() && oper.peek() != '(' && priority(oper.peek()) >= priority(ch)) {
                  int num2 = oprnds.pop();
                  int num1 = oprnds.pop();
                  oprnds.push(operation(num1, num2, oper.peek()));
               }
               oper.push(ch);
            }
         }
      }
      while (!oper.isEmpty()) {
         int num2 = oprnds.pop();
         int num1 = oprnds.pop();
         oprnds.push(operation(num1, num2, oper.peek()));
      }
      for (int var : oprnds) {
         System.out.print(var + " ");
      }
      System.out.println();
      return oprnds.peek();
   }

   private static int priority(char ch) {
      switch (ch) {
         case '+':
         case '-':
            return 1;

         case '*':
         case '/':
            return 2;

         case ')':
            return 3;
      }
      return -1;
   }

   private static int operation(int num1, int num2, char operation) {
      switch (operation) {
         case '+':
            return num1 + num2;
         case '-':
            return num1 - num2;

         case '*':
            return num1 * num2;
      }
      return num1 / num2;
   }

   // working fine : ) here we have to find the greatest in sub array of len k here it's 4 ex
//   in question 2 9 3 8 = 9 then in 3 8 1 7 = 8 ...
   private static void slidingWindowMaximum(int[] arr, int k) {
//      slidingWindowMaximum(new int[]{2, 9, 3, 8, 1, 7, 12, 6, 14, 4, 32, 0, 7, 19, 8, 12, 6}, 4);
      int length = arr.length;
      int[] nge = new int[length];
      Stack<Integer> stack = new Stack<>();
      for (int i = length - 1; i >= 0; i--) {
         while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
            stack.pop();
         }
         if (stack.isEmpty()) {
            nge[i] = arr.length;
         } else {
            nge[i] = stack.peek();
         }
         stack.push(i);
      }
//      System.out.println(Arrays.toString(nge));
      int j = 0;
      for (int i = 0; i <= length - k; i++) {
         if (j < i) {
            j = i;
         }
         while (nge[j] < i + k) {
            j = nge[j];
         }
         System.out.print(arr[j] + " ");
      }
   }


   // working fine here next smallest to left and right concept is used (hard)
   private static int largestAreaHistogram(int[] arr) {
//      System.out.println(largestAreaHistogram(new int[]{6, 2, 5, 4, 5, 1, 6}));
      int length = arr.length;
      int[] rightSmallest = new int[length];
      int[] leftSmallest = new int[length];
      Stack<Integer> stack = new Stack<>();
      // here smallest to the right
      for (int i = length - 1; i >= 0; i--) {
         while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
            stack.pop();
         }
         if (stack.isEmpty()) {
            rightSmallest[i] = length;
         } else {
            rightSmallest[i] = stack.peek();
         }
         stack.push(i);
      }
      stack.clear();
// smallest to the left
      for (int i = 0; i < length; i++) {
         while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
            stack.pop();
         }
         if (stack.isEmpty()) {
            leftSmallest[i] = -1;
         } else {
            leftSmallest[i] = stack.peek();
         }
         stack.push(i);
      }
      int ma = Integer.MIN_VALUE;
      for (int i = 0; i < length; i++) {
         ma = Integer.max(ma, arr[i] * (rightSmallest[i] - leftSmallest[i] - 1));
      }
      return ma;
   }


   // same as stock span but using index of arrays
   private static int[] stockSpanUsingIndex(int[] arr) {
      int[] res = new int[arr.length];
      Stack<Integer> stack = new Stack<>();
      for (int i = 0; i < arr.length; i++) {
         while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
            stack.pop();
         }
         if (stack.isEmpty()) {
            res[i] = i + 1;
         } else {
            res[i] = i - stack.peek();
         }
         stack.push(i);
      }
      return res;
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

   // in leet code in this we assume circular array to work
   private static int[] nextGreatestElementIncludingLastIndex(int[] arr) {
//      System.out.println(Arrays.toString(nextGreatestElementIncludingLastIndex(new int[]{1, 2, 3, 4, 3})));
      Stack<Integer> stack = new Stack<>();
      int[] res = new int[arr.length];
      for (int i = (arr.length) * 2 - 1; i >= 0; i--) {
         int cI = i % arr.length;
         System.out.println(cI);
         while (!stack.isEmpty() && stack.peek() <= arr[cI]) {
            stack.pop();
         }
         if (stack.isEmpty()) {
            res[cI] = -1;
         } else {
            res[cI] = stack.peek();
         }
         stack.push(arr[cI]);
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
