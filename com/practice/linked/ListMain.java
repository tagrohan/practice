package com.practice.linked;

public class ListMain {
   public static void main(String[] args) {

      MyLinkedList list = new MyLinkedList();


//      System.out.println(list.remove(0));
//      list.print();
//      System.out.println();
//      list.reversePointer();
//      list.print();

//      list.print();
//      System.out.println(list.size());
//
//      System.out.println(list.getFirst());
//      System.out.println(list.getLast());
//
//      list.addFirst(23);


      list.addLast(1);
      list.addLast(2);
      list.addLast(3);
      list.addLast(4);
      list.addLast(5);
      list.addLast(6);

      list.print();

      list.oddAndEven(list);



//      MyLinkedList ll = list.mergeSortAList(list.head, list.tail);
//
//      ll.print();
//
//      MyLinkedList li2 = new MyLinkedList();
//      li2.addLast(2);
//      li2.addLast(4);
//      li2.addLast(6);
//      li2.addLast(8);
//      li2.addLast(10);
//
//      list.mergeTwoSortedList(list, li2);


//      System.out.println(list.midOfLinkedList());


//      System.out.println(list.getKthNodeFromLast(3));

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
