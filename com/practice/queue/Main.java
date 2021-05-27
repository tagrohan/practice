package com.practice.queue;

public class Main {
   public static void main(String[] args) {
//      Queue<Integer> queue = new ArrayDeque<>();
//      queue.add(1);
//      queue.add(2);
//      queue.add(3);
//      queue.add(4);
//
//      System.out.println(queue.poll()); // it remove the head
//      System.out.println(queue.remove()); // it remove based on FIFO
//
//      System.out.println(queue.peek()); // checking head
//      System.out.println(queue.element()); // this give first element similar to peek in stack
//
//      System.out.println(queue); // printing queue
//
      CustomQueue queue = new CustomQueue();

      queue.peek();
      queue.add(1);
      queue.add(2);
      queue.add(3);
      queue.add(4);
      queue.remove();
      queue.remove();
      queue.remove();
      queue.add(1);
      queue.add(2);
      queue.add(3);
      queue.add(4);

      queue.print();
      System.out.println(queue.size());
//      System.out.println(queue.size());
//      System.out.println(queue.peek());


   }
}
