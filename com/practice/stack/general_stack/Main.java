package com.practice.stack.general_stack;

public class Main {
   public static void main(String[] args) {

      CustomStack stack = new CustomStack();

      stack.push(7);
      stack.push(6);
      stack.push(5);
      stack.push(4);
      stack.push(4);
      stack.push(4);
      stack.push(7);
      stack.push(6);
      stack.push(5);
      stack.push(4);
      stack.push(4);
      stack.push(4);

      System.out.println(stack.peek());
      System.out.println(stack.size());
      stack.print();
   }
}
