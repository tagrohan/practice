package com.practice.stack.general_stack;

import java.util.Stack;

public class Main {
   public static void main(String[] args) {

      CustomStack stack = new CustomStack();
      Stack<Integer> stack1 = new Stack<>();


      stack.push(7);
      stack.push(6);
      stack1.push(7);
      stack1.push(6);

      stack.print();
      System.out.println(stack1.peek());
      System.out.println(stack.peek());
   }
}
