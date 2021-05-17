package com.practice.stack;

import java.util.Stack;

public class StackPep {
   public static void main(String[] args) {

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
