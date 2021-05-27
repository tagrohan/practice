package com.practice.linked.ll_to_stack;

public class StackListMain {
   public static void main(String[] args) {

      StackList<Integer> list = new StackList<>();

      list.push(1);
      list.push(2);
      list.push(3);
      list.push(4);

      System.out.println(list.peek());
      System.out.println(list.peek());
//      System.out.println(list.pop());
      list.print();
      System.out.println(list.size());
      System.out.println(list.head());

   }
}
