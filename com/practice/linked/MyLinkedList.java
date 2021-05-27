package com.practice.linked;

public class MyLinkedList {
   Node head;
   Node tail;
   int size;

   private class Node {
      int data;
      Node next;

      public Node(int data) {
         this.data = data;
      }
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

   public void print() {
      Node temp = head;
      System.out.print("[");
      while (temp != null) {
         System.out.print(temp.data + ", ");
         temp = temp.next;
      }
      System.out.print("]");
   }

   public int size() {
      return size;
   }
}
