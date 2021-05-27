package com.practice.linked;

public class MyLinkedList {
   Node head;
   Node tail;
   private int size;

   private class Node {
      int data;
      Node next;

      public Node(int data) {
         this.data = data;
      }
   }

   public void mergeTwoSortedList(MyLinkedList list1, MyLinkedList list2) {
      if (list1.size() == 0 && list2.size == 0) {
         System.out.println("both list empty");
         return;
      }
      Node head1 = list1.head;
      Node head2 = list2.head;

      MyLinkedList list = new MyLinkedList();

      while (head1 != null && head2 != null) {
         if (head1.data > head2.data) {
            list.addLast(head2.data);
            head2 = head2.next;
         } else {
            list.addLast(head1.data);
            head1 = head1.next;
         }
      }

      while (head1 != null) {
         list.addLast(head1.data);
         head1 = head1.next;
      }
      while (head2 != null) {
         list.addLast(head2.data);
         head2 = head2.next;
      }

      list.print();

   }

   public int midOfLinkedList() {
      if (size == 0) {
         System.out.println("list is empty");
         return -1;
      }

      Node first = head;
      Node second = head;

      while (first.next != null && first.next.next != null) {
         first = first.next.next;
         second = second.next;
      }

      return second.data;
   }


   public int getKthNodeFromLast(int k) {
      int val = -1;
      if (size == 0 || k >= size) {
         return -1;
      }
      Node first = head;
      Node second = head;

      for (int i = 1; first.next != null; i++) {
         if (i >= k) {
            second = second.next;
         }
         first = first.next;
      }
      return second.data;
   }


   public void reversePointer() {
      if (size == 0) {
         System.out.println("empty list man");
      } else if (size == 2) {
         Node temp = head;
         head = tail;
         tail = temp;
         tail.next = null;
      } else {
         Node current = head;
         Node prev = null;
         while (current != null) {
            Node temp = current.next;
            current.next = prev;
            prev = current;

            current = temp;
         }

         Node temp = head;
         head = tail;
         tail = temp;

      }
   }


   public void reverse() {
      if (size == 0) {
         System.out.println("empty list");
      } else {
         int i = 0, j = size - 1;
         while (i < j) {

            Node left = get(i);
            Node right = get(j);

            int temp = left.data;
            left.data = right.data;
            right.data = temp;
            i++;
            j--;
         }
      }
   }


   private Node get(int idx) {
      if (idx == 0) {
         return head;
      } else if (idx == size - 1) {
         return tail;
      } else {
         Node temp = head;
         for (int i = 0; i < idx; i++) {
            temp = temp.next;
         }
         System.out.println(temp.data);
         return temp;
      }
   }

   public int getFirst() {
      if (size == 0) {
         System.out.println("Linked list in empty");
         return -1;
      } else {
         return head.data;
      }
   }

   public int getLast() {
      if (size == 0) {
         System.out.println("Linked list in empty");
         return -1;
      } else {
         return tail.data;
      }
   }

   public int remove(int idx) {
      int val = -1;
      if (idx < 0 || idx > size - 1) {
         System.out.println("out of bound");
         return val;
      }
      if (idx == 0) {
         val = getFirst();
         removeFirst();
      } else if (idx == size - 1) {
         val = getLast();
         removeLast();
      } else {
         Node temp = head;
         for (int i = 0; i < idx - 1 && temp != null; i++) {
            temp = temp.next;
         }
         if (temp != null) {
            Node te = temp.next;
            val = te.data;
            temp.next = temp.next.next;
            te.next = null;
         }
      }
      size--;
      return val;
   }

   public int removeLast() {
      int val = -1;
      if (size == 0) {
         System.out.println("empty linked list");
         return val;
      }
      if (size == 1) {
         val = tail.data;
         size -= 1;
         head = tail = null;
      } else {
         Node temp = head;
         for (int i = 0; i < size - 2; i++) {
            temp = temp.next;
         }
         val = tail.data;
         tail = temp;
         tail.next = null;
      }
      size--;
      return val;
   }

   public void add(int idx, int val) {
      if (idx > size || idx < 0) {
         System.out.println("Out of bound man");
         return;
      }
      if (idx == 0) {
         addFirst(val);
      } else if (idx == size) {
         addLast(val);
      } else {
         Node node = new Node(val);
         Node temp = head;
         for (int i = 0; i < idx - 1 && temp != null; i++) {
            temp = temp.next;
         }
         if (temp != null) {
            node.next = temp.next;
            temp.next = node;
         }
      }
      size++;
   }

   public void addFirst(int val) {
      Node node = new Node(val);
      node.next = head;
      head = node;
   }

   public void addLast(int val) {
      Node node = new Node(val);
      if (size == 0) {
         head = tail = node;
      } else {
         tail.next = node;
         tail = node;
      }
      size++;
   }

   public int removeFirst() {
      if (size > 0) {
         int data = head.data;
         head = head.next;
         size--;
         if (head == null) {
            tail = null;
         }
         return data;
      } else {
         System.out.println("Linked List is empty");
         return -1;
      }
   }

   public void print() {
      Node temp = head;
      System.out.print("[");
      while (temp != null) {
         System.out.print(temp.data + " ");
         temp = temp.next;
      }
      System.out.print("]");
   }

   public int size() {
      return size;
   }
}
