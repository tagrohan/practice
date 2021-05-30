package com.practice.trees.generic_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//TODO i'll do it later
public class GenTreeLoop {
   private static Node root;

   public static class Node {
      int data;
      List<Node> children;

      public Node(int data) {
         this.data = data;
         children = new ArrayList<>();
      }
   }

   public static void main(String[] args) {
      int[] arr = new int[]{10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120,
              -1, -1, 90, -1, -1, 40, 100, -1, -1, -1}; // main tree
      int[] arr2 = new int[]{10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120,
              -1, -1, -1, 40, 100, -1, -1, -1};// tree with diff leaf size
      int[] arr3 = new int[]{10, 20, 50, -1, 60, -1, -1, 30, 70, 110, -1, 120, -1, -1, 80, -1, 90,
              -1, -1, 40, 100, -1, -1, -1}; // tree with one sided heavy leaf
      int[] arr4 = new int[]{10, 40, 100, -1, -1, 30, 90, -1, 80, -1, 70, 120, -1, 110, -1, -1, -1,
              20, 60, -1, 50, -1, -1, -1}; // mirror of above tree (arr4)
      int[] arr5 = new int[]{10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120,
              -1, -1, 90, -1, -1, 40, 100, -1, 105, -1, -1, -1}; // symmetric tree

      createTree(arr);
      printTree(root);
   }


   //working fine
   private static void printTree(Node root) {
      System.out.print(root.data + "-> ");
      for (Node node : root.children) {
         System.out.print(node.data + " ");
      }
      System.out.println();
      for (Node node : root.children) {
         printTree(node);
      }
   }

   // working fine
   private static Node createTree(int[] arr) {
//      int[] arr = new int[]{10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120,
//              -1,-1, 90, -1,-1, 40, 100, -1, -1, -1};
      Stack<Node> stack = new Stack<>();
      for (int i = 0; i < arr.length; i++) {
         if (arr[i] == -1) {
            stack.pop();
         } else {
            Node node = new Node(arr[i]);
            if (!stack.isEmpty()) {
               stack.peek().children.add(node);
            } else {
               root = node;
            }
            stack.push(node);
         }
      }
      return root;
   }
}
