package com.practice.linked;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListMain {
   public static void main(String[] args) {

      MyLinkedList list = new MyLinkedList();

      list.addLast(1);
      list.addLast(2);
      list.addLast(3);
      list.addLast(4);

      System.out.println(list.size);
      list.print();



   }

   public static void experiment() {
      // experiment here
//      LinkedList<Integer> list = new LinkedList<>();
//
//      List<Integer> ar = new ArrayList<>();
//      long startTime = System.currentTimeMillis();
//      for (int i = 0; i < 100000; i++) {
//         ar.add(0, i);
//      }
//      long endTime = System.currentTimeMillis();
//      System.out.println(endTime - startTime);
//
//      System.out.println("--------------------------------");
//      startTime = System.currentTimeMillis();
//      for (int i = 0; i < 100000; i++) {
//         list.add(0, i);
//      }
//       endTime = System.currentTimeMillis();
//      System.out.println(endTime - startTime);

//      list.add(1);
//      list.add(2);
//      list.add(3);
//      System.out.println(list);
//
//      list.addFirst(0);
//      list.addLast(4);
//      System.out.println(list);
//      list.removeFirst();
//      list.removeLast();
//      System.out.println(list);
      // and many more

   }
}
