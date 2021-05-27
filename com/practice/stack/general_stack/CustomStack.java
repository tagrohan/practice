package com.practice.stack.general_stack;

import java.util.Arrays;

// implementing custom stack
public class CustomStack {
   private int[] data;
   private int pointer;

   public CustomStack() {
      this.data = new int[5];
      this.pointer = -1;
   }

   public int push(int val) {
      if (pointer == data.length - 1) {
         data = Arrays.copyOf(data, data.length + 5);
      }
      pointer++;
      return data[pointer] = val;
   }

   public int pop() {
      if (pointer <= -1) {
         System.out.println("stack underflow");
         return -1;
      } else {
         pointer--;
         return data[pointer + 1];

      }
   }

   public int peek() {
      if (pointer <= -1) {
         System.out.println("stack underflow");
         return -1;
      } else {
         return data[pointer];
      }
   }

   public void print() {
      if (pointer <= -1) {
         System.out.println("stack underflow");
      } else {
         for (int i = 0; i <= pointer; i++) {
            System.out.print(data[i] + " ");
         }
         System.out.println();
      }

   }

   public int size() {
      if (pointer <= -1) {
         System.out.println("stack underflow");
         return -1;
      } else {
         return pointer + 1;
      }
   }
}
