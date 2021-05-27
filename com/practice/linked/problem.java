package com.practice.linked;

import java.util.LinkedList;

public class problem {
   public static void main(String[] args) {

      LinkedList<Integer> list = new LinkedList<>();
      list.add(1);
      list.add(2);
      list.add(3);
      list.add(4);
      list.add(5);
      list.add(6);

      System.out.println(kthFromLast(list,3));

   }

   private static int kthFromLast(LinkedList<Integer> list, int k) {
      if (list.size() <= k) {
         return -1;
      } else if (k == list.size() - 1) {
         return list.getFirst();
      }
      return list.get(list.size() - k);
   }
}
