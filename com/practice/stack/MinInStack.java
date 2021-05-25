package com.practice.stack;

import java.util.Stack;

public class MinInStack {
   // we have to keep minimum in stack at all time even at pop or push
   static Stack<Integer> stack = new Stack<>();
   static Stack<Integer> minStack = new Stack<>();

   // working fine at O(1) time and O(N) space complexity
   // we have to do it in O(1) space complexity // in simple word remove minStack do this without it
   // TODO : whenever ask in O(1) space that means asking in variable terms as all DS take some how O(n) ex: arr,stack LL etc.
   public static void main(String[] args) {
      push(12);
      push(13);
      push(11);
      push(10);

      pop();
      System.out.println(min());
   }


   private static int pop() {
      if (minStack.peek().equals(stack.peek())) {
         minStack.pop();
      }
      return stack.pop();
   }

   private static int push(int var) {
      if (minStack.isEmpty() || minStack.peek() >= var) {
         minStack.push(var);
      }
      return stack.push(var);
   }

   private static int min() {
      return stack.isEmpty() ? -1 : stack.peek();
   }
}
