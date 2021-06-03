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
      push(3);
      push(2);
      push(4);
      push(1);
//      System.out.println(stack);
      pop();
      pop();
      System.out.println(getMin());
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

   private static int getMin() {
      return minStack.isEmpty() ? -1 : minStack.peek();
   }

   // in O(1) space complexity in getMin
   static int min = -1;

   private static int popV2() {
      if (stack.isEmpty()) {
         System.out.println("stack is empty :(");
         return -1;
      } else {
         if (stack.peek() <= min) {
            int cMin = min;
            min = 2 * min - stack.peek(); // decoding part
            stack.pop();
            return cMin;
         } else {
            return stack.pop();
         }
      }
   }

   private static int pushV2(int var) {
      if (stack.isEmpty()) {
         min = var;
         return stack.push(var);
      } else {
         if (var <= min) {
            stack.push(2 * var - min); // encoding part
            min = var;
            return min;
         }
      }
      return min;
   }

   private static int getMinV2() {
      return min;
   }
}
