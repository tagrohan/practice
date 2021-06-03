package com.practice.hashmapnheap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Heap {
   public static void main(String[] args) {

      kSortedArray(new int[]{3, 2, 4, 1, 6, 5, 7, 9, 8}, 3);
   }

   private static class Median {

      Queue<Integer> max = new PriorityQueue<>();
      Queue<Integer> min = new PriorityQueue<>(Collections.reverseOrder());

      private static void add(int val) {

      }

      private static int findNum() {
         return -1;
      }
   }

   // some how sorted at k length
   private static void kSortedArray(int[] arr, int k) {
//      kSortedArray(new int[]{3, 2, 4, 1, 6, 5, 7, 9, 8}, 3);
      Queue<Integer> queue = new PriorityQueue<>();
      for (int i : arr) {
         queue.add(i);
         if (queue.size() > k) {
            System.out.print(queue.remove() + " ");
         }
      }
      for (int i : queue) {
         System.out.print(i + " ");
      }
   }

   private static int kLargestElement(int[] arr, int k) {
//      System.out.println(kLargestElement(new int[]{1, 23, 12, 9, 30, 2, 50}, 3));
      Queue<Integer> queue = new PriorityQueue<>();
      for (int i : arr) {
         queue.add(i);
         if (queue.size() > k) {
            queue.remove();
         }
      }
      if (queue.peek() == null) {
         return 0;
      } else {
         return queue.peek();
      }
   }

   // elements s keep in mind
   private static void kLargestElements(int[] arr, int k) {
//      kLargestElements(new int[]{1, 23, 12, 9, 30, 2, 50}, 3);
      Queue<Integer> queue = new PriorityQueue<>();

      for (int i : arr) {
         queue.add(i);
         if (queue.size() > k) {
            queue.remove();
         }
      }
      System.out.println(queue);

   }
}
