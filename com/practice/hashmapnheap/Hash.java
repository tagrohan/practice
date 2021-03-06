package com.practice.hashmapnheap;

import java.util.*;

 class Hash {
   public static void main(String[] args) {

      System.out.println(longestConsecutiveSeq(new Integer[]{0, 0, -1}));
   }

   private static int longestConsecutiveSeq(Integer[] arr) {
//      System.out.println(longestConsecutiveSeq(new Integer[]{102, 4, 100, 1, 101, 3, 2}));
//      System.out.println(longestConsecutiveSeq(new Integer[]{10, 5, 9, 1, 11, 8, 6, 15, 3, 12, 2}));
      Set<Integer> set = new HashSet<>(Arrays.asList(arr));
//      for (int i : arr) {
//         set.add(i);
//      }
      System.out.println(set);
      int counter = 0, max = Integer.MIN_VALUE;
      for (int i = 0; i < arr.length; i++) {
         if (!set.contains(arr[i] - 1)) {
            while (set.contains(arr[i] + counter)) {
               counter += 1;
            }
            max = Integer.max(max, counter);
            counter = 0;
         }
      }
      return max;
   }


   // here intersection will be printed -> intersection depends on arr2 here
   private static void printCommon2(int[] arr, int[] arr2) {
//      printCommon2(new int[]{1, 1, 2, 2, 2, 3, 5}, new int[]{1, 1, 1, 2, 2, 4, 5});
      Map<Integer, Integer> map = new HashMap<>();
      for (int i = 0; i < arr2.length; i++) {
         if (map.containsKey(arr2[i])) {
            map.put(arr2[i], map.get(arr2[i]) + 1);
         } else {
            map.put(arr2[i], 1);
         }
      }
      for (int i = 0; i < arr.length; i++) {
         if (map.containsKey(arr[i]) && map.get(arr[i]) > 0) {
            System.out.print(arr[i] + " ");
            map.put(arr[i], map.get(arr[i]) - 1);

         }
      }
   }


   // working great
   private static void printCommon(int[] arr, int[] arr2) {
//      printCommon(new int[]{1, 3, 4, 5, 6, 7, 2, 3, 4, 5, 6}, new int[]{5, 4, 0, 2, 6, 7, 8, 9, 5, 4});
      Map<Integer, Integer> map = new HashMap<>();
      for (int i : arr) {
         if (!map.containsKey(i)) {
            map.put(i, 1);
         }
      }
      for (int i : arr2) {
         if (map.containsKey(i)) {
            System.out.println(i);
            map.remove(i);
         }
      }
   }

   // O(N) - time, O(N) - space
   private static char getFrequencyCharacter(String str) {
//      System.out.println(getFrequencyCharacter("zmszeqxllzvheqwrofgcuntypejcxovtaqbnqyqlmrwitc"));
      Map<Character, Integer> map = new HashMap<>();
      for (int i = 0; i < str.length(); i++) {
         char ch = str.charAt(i);
         if (map.containsKey(ch)) {
            map.put(str.charAt(i), map.get(ch) + 1);
         } else {
            map.put(ch, 1);
         }
      }
      char maxChar = ' ';
      int max = -1;
      for (char ch : map.keySet()) {
         if (map.get(ch) > max) {
            maxChar = ch;
            max = map.get(ch);
         }
      }
      return maxChar;
   }
}
