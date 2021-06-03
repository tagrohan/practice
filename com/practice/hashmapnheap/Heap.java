package com.practice.hashmapnheap;

import java.util.*;

public class Heap {
   public static void main(String[] args) {
      List<List<Integer>> list = new ArrayList<>();
      list.add(List.of(1, 4, 5));
      list.add(List.of(1, 3, 4));
      list.add(List.of(2, 6));
      List<Integer> merge = mergeKSortedList(list);
      System.out.println(Arrays.toString(merge.toArray()));
   }


   //todo: some basic implementation left in this section + aditya 2-3 video left as well

   // woooo hooooo it's working fine man
   private static List<Integer> mergeKSortedList(List<List<Integer>> lists) {
//      List<List<Integer>> list = new ArrayList<>();
//      list.add(List.of(1, 4, 5));
//      list.add(List.of(1, 3, 4));
//      list.add(List.of(2, 6));
//      List<Integer> merge = mergeKSortedList(list);
//      System.out.println(Arrays.toString(merge.toArray()));
      List<Integer> ans = new ArrayList<>();
      Queue<PairV2> queue = new PriorityQueue<>();
      for (int i = 0; i < lists.size(); i++) {
         queue.add(new PairV2(i, 0, lists.get(i).get(0)));
      }

      while (queue.size() > 0) {
         PairV2 pair = queue.remove();

         ans.add(pair.data);
         pair.dataIndex++;
         if (pair.dataIndex < lists.get(pair.listIndex).size()) {
            pair.data = lists.get(pair.listIndex).get(pair.dataIndex);
            queue.add(pair);
         }
      }
      return ans;
   }

   private static class PairV2 implements Comparable<PairV2> {
      int listIndex;
      int dataIndex;
      int data;

      public PairV2(int listIndex, int dataIndex, int data) {
         this.listIndex = listIndex;
         this.dataIndex = dataIndex;
         this.data = data;
      }

      @Override
      public int compareTo(PairV2 o) {
         return this.data - o.data;
      }
   }


   // working fine we have to find media in given i/o stream (check leetcode)
   private static class Median {
//      Median.add(1);
//      Median.add(2);
//      Median.add(3);
//      Median.add(4);
//      Median.add(5);
//      System.out.println(Median.findMedian());

      private static final Queue<Double> max = new PriorityQueue<>();
      private static final Queue<Double> min = new PriorityQueue<>(Collections.reverseOrder());

      private static void add(int val) {
         if (max.isEmpty() && min.isEmpty()) {
            max.add((double) val);
         } else if (val <= max.peek()) {
            min.add((double) val);
            if (min.size() > max.size()) {
               max.add(min.remove());
            }
         } else {
            max.add((double) val);
            if (max.size() > min.size()) {
               min.add(max.remove());
            }
         }
      }

      private static double findMedian() {

         if (max.isEmpty() && min.peek() != null) {
            return min.peek();
         } else if (min.isEmpty() && max.peek() != null) {
            return max.peek();
         }
         if (min.size() > max.size()) {
            return min.peek();
         } else if (min.size() < max.size()) {
            return max.peek();
         }
         if (min.peek() != null && max.peek() != null) {
            System.out.println(min.peek() + " " + max.peek());
            return (max.peek() + min.peek()) / 2;
         }
         return -1;
      }
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
