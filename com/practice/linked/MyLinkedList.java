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

   public void revereKGroup(Node node, int k) {
      if (node.next == null) {
         System.out.println(node.data);
         return;
      }
      Node prev = null;
      Node cHead = node;
      Node track;
      while (cHead != null) {
         track = cHead.next;
         cHead.next = prev;
         prev = cHead;
         cHead = track;
      }
      this.head = prev;
      print();
   }

   // it's working fine
   public int addTwoLinkedList(Node first, Node second, int pFirst, int pSecond, MyLinkedList res) {

      if (first == null && second == null) {
         return 0;
      }

      int carry = 0;
      int data = 0;
      if (pFirst > pSecond) {
         carry = addTwoLinkedList(first.next, second, pFirst - 1, pSecond, res);
         data = carry + first.data;
      } else if (pSecond > pFirst) {
         carry = addTwoLinkedList(first, second.next, pFirst, pSecond - 1, res);
         data = carry + second.data;
      } else {
         carry = addTwoLinkedList(first.next, second.next, pFirst - 1, pSecond - 1, res);
         data = carry + first.data + second.data;
      }
      carry = data / 10;
      data = data % 10;
      res.addFirst(data);
      return carry;
   }

   public MyLinkedList addTwoLinkedList(MyLinkedList list2) {
      MyLinkedList res = new MyLinkedList();
//      System.out.println(this.head.data);
//      System.out.println(list2.head.data);
//      System.out.println(this.size);
//      System.out.println(list2.size);
      int carry = addTwoLinkedList(this.head, list2.head, this.size, list2.size, res);
      System.out.println(carry);
      if (carry > 0) {
         res.addFirst(carry);
      }
      return res;
   }

   public void join(MyLinkedList l1, int idx) {
      Node temp = l1.head;
      for (int i = 0; i < idx; i++) {
         temp = temp.next;
      }
      this.tail.next = temp;
      this.size += idx - 1;
   }


   public void insertionPoint() {
      MyLinkedList l1 = new MyLinkedList();
      MyLinkedList l2 = new MyLinkedList();
      for (int i = 0; i < 7; i++) {
         l1.addLast(i);
      }
      for (int i = 2; i < 4; i++) {
         l2.addLast(i);
      }
      l2.join(l1, 4);
      System.out.println(l1.size);
      System.out.println(l2.size);
      insertionPoint(l1, l2);
   }

   // TODO i have write max code but still problem so do it after wake up
   public void insertionPoint(MyLinkedList list1, MyLinkedList list2) {
      int diff = Math.abs(list1.size - list2.size);

      if (list1.size > list2.size) {
         for (int i = 0; i < diff; i++) {
            list1.head = head.next;
         }
      } else {
         for (int i = 0; i < diff; i++) {
            list2.head = head.next;
         }
      }

      while (list1.head != list2.head) {
         list1.head = list1.head.next;
         list2.head = list2.head.next;
      }
      System.out.println(list1.head.data);
   }

   // working fine give them a look in 50/50
   public void foldLinkedList() {
      plef = this.head;
      foldLinkedListHelper(head, 0);
      this.print();
   }

   private void foldLinkedListHelper(Node node, int floor) {
      if (node == null) {
         return;
      }

      foldLinkedListHelper(node.next, floor + 1);

      if (floor > this.size / 2) {
         Node temp = plef.next;
         plef.next = node;
         node.next = temp;
         plef = temp;
      } else if (floor == this.size / 2) {
         tail = node;
         tail.next = null;
      }
   }


   Node plef;

   public boolean isPalindrome() {
      plef = head;
      return palindromeRecursionHelper(head);
   }

   private boolean palindromeRecursionHelper(Node head) {
      if (head == null) {
         return true;
      }

      boolean cState = palindromeRecursionHelper(head.next);
      if (cState) {
         if (head.data == plef.data) {
            plef = plef.next;
            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   // REVERSE WORKING FINE
   public void reverseRecursionPointer(Node head) {
      reverseRecursionPointerHelper(head);
      head.next = null;
      Node temp = head;
      head = tail;
      tail = temp;

      this.head = head;

      this.print();
   }

   private void reverseRecursionPointerHelper(Node head) {
      if (head == null) {
         return;
      }
      reverseRecursionPointerHelper(head.next);
      if (head != tail) {
         head.next.next = head;
      }
   }

   // working fine
   public void printReverseRecursion(Node head) {
      if (head == null) {
         return;
      }
      printReverseRecursion(head.next);
      System.out.print(head.data + " ");
   }

   // TODO not working fine
   // k is given ex 3 and using this as a LL here
   public void kReverse(int k) {
      if (k <= 0) {
         System.out.println("k can't be zero or negative");
         return;
      }
      MyLinkedList prev = null;
      while (this.size > 0) {
         MyLinkedList cur = new MyLinkedList();
         if (this.size >= k) {
            for (int i = 0; i < k; i++) {
               int val = this.getFirst();
               this.removeFirst();
               cur.addFirst(val);
            }
         } else {
            int cSize = this.size;
            for (int i = 0; i < cSize; i++) {
               int val = this.getFirst();
               this.removeFirst();
               cur.addLast(val);
            }
         }
         if (prev == null) {
            prev = cur;
         } else {
            prev.tail.next = cur.head;
            prev.tail = cur.tail;
            prev.size += cur.size;
         }
      }
      this.head = prev.head;
      this.tail = prev.tail;
      this.size = prev.size;

      this.print();
   }

   // working fine
   public void oddAndEven(MyLinkedList list) {
      MyLinkedList odd = new MyLinkedList();
      MyLinkedList even = new MyLinkedList();

      Node temp = list.head;

      while (temp != null) {
         if (temp.data % 2 == 0) {
            even.addLast(temp.data);
         } else {
            odd.addLast(temp.data);
         }
         temp = temp.next;
      }

      list.head = odd.head;
      odd.tail.next = even.head;
      list.tail = even.tail;

      Node t = list.head;
      while (list.head != null) {
         System.out.print(list.head.data + " ");
         list.head = list.head.next;
      }
   }

   public void removeDuplicate(MyLinkedList list) {
      MyLinkedList res = new MyLinkedList();

      res.addLast(list.head.data);

      while (list.head != null) {
         if (list.head.data != res.getLast()) {
            res.addLast(list.head.data);
         }
         list.head = list.head.next;
      }
      res.print();
   }

   public MyLinkedList mergeSortAList(Node head, Node tail) {
      if (head == tail) {
         MyLinkedList li = new MyLinkedList();
         li.addLast(head.data);
         return li;
      }

      Node mid = midOfLinkedListForMergeSort(head, tail);

      MyLinkedList fh = mergeSortAList(head, mid);
      MyLinkedList sh = mergeSortAList(mid.next, tail);

      return mergeTwoSortedList(fh, sh);

   }

   public Node midOfLinkedListForMergeSort(Node head, Node tail) {
      if (head == tail) {
         return head;
      }

      Node first = head;
      Node second = head;

      while (first != tail && first.next != tail) {
         first = first.next.next;
         second = second.next;
      }

      return second;
   }

   public MyLinkedList mergeTwoSortedList(MyLinkedList list1, MyLinkedList list2) {
      if (list1.size() == 0 && list2.size == 0) {
         System.out.println("both list empty");
         return new MyLinkedList();
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

//      list.print();
      return list;
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
      if (size == 0) {
         head = tail = node;
      } else {
         node.next = head;
         head = node;
      }
      size++;
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
      Node temp = this.head;
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
