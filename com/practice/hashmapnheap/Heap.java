package com.practice.hashmapnheap;

import java.util.*;

public class Heap {
   public static void main(String[] args) {

      closestPointToOrigin(new int[][]{{1, 3}, {-1, 2}, {5, 8}, {0, 1}}, 2);
   }

   // 2d gives far value from origin (0,0) to arr[][] values gives k min values distance arr
   private static void closestPointToOrigin(int[][] arr, int k) {
//      closestPointToOrigin(new int[][]{{1, 3}, {-1, 2}, {5, 8}, {0, 1}}, 2);
      Queue<Pair> queue = new PriorityQueue<>(Collections.reverseOrder());
      for (int i = 0; i < arr.length; i++) {
         queue.add(new Pair(arr[i][0], arr[i][1], (arr[i][0] * arr[i][0]) + (arr[i][1] * arr[i][1])));
         if (queue.size() > k) {
            queue.remove();
         }
      }
      for (Pair pair : queue) {
         System.out.println("[" + pair.val0 + ", " + pair.val1 + "]");
      }
   }

   // sort on the basis of frequency higher freq comes first
   private static void frequencySort(int[] arr) {
//      frequencySort(new int[]{1, 1, 1, 3, 2, 2, 4});
      Map<Integer, Integer> map = new HashMap<>();
      for (int i : arr) {
         if (map.containsKey(i)) {
            map.put(i, map.get(i) + 1);
         } else {
            map.put(i, 1);
         }
      }

      Queue<Pair> queue = new PriorityQueue<>(Collections.reverseOrder());
      for (int i : map.keySet()) {
         queue.add(new Pair(i, map.get(i)));
      }
      int size = queue.size();
      for (int i = 0; i < size; i++) {
         System.out.print(queue.remove().val1 + " ");
      }
   }

   // find top frequent number here k = 2, so top be [1,2] as 1 -> 3, 2 ->2
   private static void kFrequentNumber(int[] arr, int k) {
      Map<Integer, Integer> map = new HashMap<>();
      for (int i : arr) {
         if (map.containsKey(i)) {
            map.put(i, map.get(i) + 1);
         } else {
            map.put(i, 1);
         }
      }
      Queue<Pair> queue = new PriorityQueue<>();
      for (int i : map.keySet()) {
         queue.add(new Pair(i, map.get(i)));
         if (queue.size() > k) {
            queue.remove();
         }
      }
      for (Pair pair : queue) {
         System.out.println(pair.val1 + "(ans) " + pair.val2 + "(freq)");
      }
   }

   // we have implemented our own pair with dif at val2 to do pair questions in Heap
   private static class Pair implements Comparable<Pair> {
      // for origin question we need val0 as well
      int val0;
      int val1;
      int val2;


      public Pair(int val1, int val2) {
         this.val1 = val1;
         this.val2 = val2;
      }

      public Pair(int val0, int val1, int val2) {
         this.val0 = val0;
         this.val1 = val1;
         this.val2 = val2;
      }

      @Override
      public int compareTo(Pair o) {
         return val2 - o.val2;
      }
   }

   // ex arr = 5 6 7 8 9 k = 3, val = 7, so 3 closet to 7 = 5,6,8  (need pair as i check for diff, but store diff and value as well)
   private static void kClosetElement(int[] arr, int val, int k) {
      Queue<Pair> queue = new PriorityQueue<>(Collections.reverseOrder());
      for (int i = 0; i < arr.length; i++) {
         queue.add(new Pair(arr[i], Math.abs(val - arr[i])));
         if (queue.size() > k) {
            queue.remove();
         }
      }
      for (Pair pair : queue) {
         System.out.println(pair.val1 + "(ans) " + pair.val2 + "(diff)");
      }
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
