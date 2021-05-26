package com.practice.stack;

import java.util.Stack;

public class StackPep {

   public static void main(String[] args) {

      System.out.println(celebrity(
              new int[][]{{0, 0, 0, 0},
                      {1, 0, 1, 1},
                      {1, 1, 0, 1},
                      {1, 1, 1, 0}}));

   }

   // celerity is the one who knows no body but every one knows her, so in question row 0 is celebrity as she knows no one
   private static boolean celebrity(int[][] arr) {

//      System.out.println(celebrity(
//              new int[][]{{0, 0, 0, 0},
//                      {1, 0, 1, 1},
//                      {1, 1, 0, 1},
//                      {1, 1, 1, 0}}));

      Stack<Integer> stack = new Stack<>();
      for (int i = 0; i < arr.length; i++) {
         stack.push(i);
      }
      while (stack.size() != 1) {
         int var1 = stack.pop();
         int var2 = stack.pop();
         if (arr[var1][var2] == 1) {
            stack.push(var2);
         } else {
            stack.push(var1);
         }
      }
      for (int i = 0; i < arr.length; i++) {
         if (arr[stack.peek()][i] != 0) {
            return false;
         }
      }
      return true;
   }

   // same as postfixEval with reverse loop and reverse push in stacks, give it a shot
   private static void prefixEvalAndConversion(String regex) {
//      prefixEvalAndConversion("-+2/*6483");
      Stack<String> postfix = new Stack<>();
      Stack<String> infix = new Stack<>();
      Stack<Integer> eval = new Stack<>();

      for (int i = regex.length() - 1; i >= 0; i--) {
         char ch = regex.charAt(i);
         if (Character.isDigit(ch)) {
            postfix.push(ch + "");
            infix.push(ch + "");
            eval.push(ch - '0');
         } else {
            int num2 = eval.pop();
            int num1 = eval.pop();
            eval.push(operation(num2, num1, ch));
            String str1 = postfix.pop();
            String str2 = postfix.pop();
            postfix.push(str1 + str2 + ch);
            str1 = infix.pop();
            str2 = infix.pop();
            infix.push(str1 + ch + str2);
         }
      }
      System.out.println(postfix.peek());
      System.out.println(infix.peek());
      System.out.println(eval.peek());

   }


   // postfix to infix prefix and solve as well
   private static void postfixEvalAndConversion(String regex) {
//      postfixEvalAndConversion("264*8/+3-");
      Stack<String> prefix = new Stack<>();
      Stack<String> infix = new Stack<>();
      Stack<Integer> eval = new Stack<>();

      for (int i = 0; i < regex.length(); i++) {
         char ch = regex.charAt(i);
         if (Character.isDigit(ch)) {
            prefix.push(ch + "");
            infix.push(ch + "");
            eval.push(ch - '0');
         } else {
            int num2 = eval.pop();
            int num1 = eval.pop();
            eval.push(operation(num1, num2, ch));
            String str1 = prefix.pop();
            String str2 = prefix.pop();
            prefix.push(ch + str2 + str1);
            str1 = infix.pop();
            str2 = infix.pop();
            infix.push(str2 + ch + str1);
         }
      }
      System.out.println(prefix.peek());
      System.out.println(infix.peek());
      System.out.println(eval.peek());

   }

   // working fine man : ) but it will only work for equations not for numbers as we are testing equation here
   private static void infixToPreAndPost(String regex) {
//      infixToPreAndPost("a * (b - c) / d + e");
      Stack<Character> operator = new Stack<>();
      Stack<String> prefix = new Stack<>();
      Stack<String> postfix = new Stack<>();
      for (int i = 0; i < regex.length(); i++) {
         char ch = regex.charAt(i);
         if (ch != ' ') {
            if (ch >= 'a' && ch <= 'z') {
               prefix.push(ch + "");
               postfix.push(ch + "");
//               System.out.println(prefix);
//               System.out.println(postfix);
            } else if (ch == '(') {
               operator.push(ch);
            } else if (ch == ')') {
               while (!operator.isEmpty() && operator.peek() != '(') {
                  String pre1 = prefix.pop();
                  String pre2 = prefix.pop();
                  prefix.push(operator.peek() + pre2 + pre1);
                  String post1 = postfix.pop();
                  String post2 = postfix.pop();
                  postfix.push(post2 + post1 + operator.pop());
               }
               operator.pop();
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
               while (!operator.isEmpty() && priority(operator.peek()) >= priority(ch)) {
                  String pre1 = prefix.pop();
                  String pre2 = prefix.pop();
                  prefix.push(operator.peek() + pre2 + pre1);
//                  System.out.println(pre2 + pre1);
                  String post1 = postfix.pop();
                  String post2 = postfix.pop();
                  postfix.push(post2 + post1 + operator.pop());
               }
               operator.push(ch);
            }
         }

      }
      if (!operator.isEmpty()) {
         String pre1 = prefix.pop();
         String pre2 = prefix.pop();
         prefix.push(operator.peek() + pre2 + pre1);
         String post1 = postfix.pop();
         String post2 = postfix.pop();
         postfix.push(post2 + post1 + operator.pop());
      }
      System.out.println(prefix.peek());
      System.out.println(postfix.peek());
   }

   //      2 + 6 * 4 / 8 - 3    it's working fine man : )
   private static double infixEvaluation(String regex) {
//      System.out.println(infixEvaluation("2 + 6 * 4 / 8 - 3")); = 2
//      System.out.println(infixEvaluation("(2 + 6 * 4) / 8 - 3")); = 0
      Stack<Integer> operands = new Stack<>();
      Stack<Character> operator = new Stack<>();

      for (int i = 0; i < regex.length(); i++) {
         char ch = regex.charAt(i);
         if (ch != ' ') {
            if (ch == '(') {
               operator.push(ch);
            } else if (Character.isDigit(ch)) {
               operands.push(ch - '0');
            } else if (ch == ')') {
               while (!operator.isEmpty() && operator.peek() != '(') {
                  int num2 = operands.pop();
                  int num1 = operands.pop();
                  operands.push(operation(num1, num2, operator.pop()));
               }
               operator.pop();

            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
               while (!operator.isEmpty() && operator.peek() != '(' && priority(operator.peek()) >= priority(ch)) {
                  int num2 = operands.pop();
                  int num1 = operands.pop();
                  operands.push(operation(num1, num2, operator.pop()));
               }
               operator.push(ch);
            }
         }
      }
      while (!operator.isEmpty()) {
         int num2 = operands.pop();
         int num1 = operands.pop();
         operands.push(operation(num1, num2, operator.pop()));
      }
//      for (int var : operands) {
//         System.out.print(var + " ");
//      }
//      System.out.println();
      return operands.peek();
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
