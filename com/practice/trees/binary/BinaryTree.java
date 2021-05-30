package com.practice.trees.binary;

import java.util.Stack;

public class BinaryTree {
   public static Node root;

   public static class Node {
      int data;
      Node left;
      Node right;

      public Node(int data) {
         this.data = data;
         this.left = this.right = null;
      }
   }

   public static class Pair {
      Node node;
      int state;

      public Pair(Node node, int state) {
         this.node = node;
         this.state = state;
      }
   }

   public static void main(String[] args) {

      Integer[] arr = new Integer[]{50, 25, 12, null, null, 37, 30,
              null, null, null, 75, 68, null, 70, null, null, 57, null, null};

      createTree(arr);
      printRecursive(root);
   }

   private static void printRecursive(Node root) {
      if (root == null) {
         return;
      }
      String builder =
              (root.left == null ? "" : root.left.data) + " <- " +
                      root.data + " -> " +
                      (root.right == null ? "" : root.right.data);
      System.out.println(builder);

      printRecursive(root.left);
      printRecursive(root.right);


   }

   private static Node createTree(Integer[] arr) {
      Stack<Pair> stack = new Stack<>();
      Node node = new Node(arr[0]);
      root = node;
      stack.push(new Pair(node, -1));

      int i = 0;
      while (!stack.isEmpty()) {
         Pair pair = stack.peek();
         if (pair.state == -1) {
            i += 1;
            if (arr[i] != null) {
               Node tem = new Node(arr[i]);
               pair.node.left = tem;
               stack.push(new Pair(tem, -1));
            } else {
               pair.node.left = null;
            }
            pair.state += 1;
         } else if (pair.state == 0) {
            i += 1;
            if (arr[i] != null) {
               Node tem = new Node(arr[i]);
               pair.node.right = tem;
               stack.push(new Pair(tem, -1));
            } else {
               pair.node.right = null;
            }
            pair.state += 1;
         } else {
            stack.pop();
         }
      }
      return root;
   }
}
