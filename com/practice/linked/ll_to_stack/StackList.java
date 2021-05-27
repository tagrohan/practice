package com.practice.linked.ll_to_stack;

import java.util.LinkedList;

public class StackList<E> {

   LinkedList<E> list;

   public StackList() {
      list = new LinkedList<>();
   }

   public E push(E val) {
      list.addFirst(val);
      return list.getFirst();
   }

   public E pop() {
      return list.removeFirst();
   }

   public int size() {
      return list.size();
   }

   public E peek() {
      return list.peek();
   }

   public E head() {
      return list.element();
   }


   public void print() {
      System.out.println(list);
   }
}
