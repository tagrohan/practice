package com.practice.queue;

import java.util.Arrays;

public class CustomQueue {
   private int[] data;
   private int size;
   private int start;

   CustomQueue() {
      data = new int[5];
      size = 0;
      start = 0;
   }

   public int add(int val) {
      if (size == data.length) {
         data = Arrays.copyOf(data, data.length * 2);
         start = 0;
         return -1;
      } else {
         int rear = (start + size) % data.length;
         data[rear] = val;
         size += 1;
         return val;
      }
   }

   public int remove() {
      if (size >= 0) {
         int var = data[start];
         start = (start + 1) % data.length;
         size--;
         return var;
      } else {
         System.out.println("queue underflow");
         return -1;
      }
   }

   public int peek() {
      if (size >= 0) {
         return data[start];
      } else {
         System.out.println("queue underflow");
         return -1;
      }
   }

   public int size() {
      return size;
   }


   public void print() {
      for (int i = 0; i <= size - 1; i++) {
         int idx = (start + i) % data.length;
         System.out.print(data[idx] + " ");
      }
      System.out.println();
   }

}
