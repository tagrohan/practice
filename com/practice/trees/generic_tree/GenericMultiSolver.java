package com.practice.trees.generic_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenericMultiSolver {
   private static Node root;
   private static int max = Integer.MIN_VALUE;
   private static int min = Integer.MAX_VALUE;
   private static int height = 0;
   private static int NoOfNodes = 0;

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

//      Node root1 = createTree(arr3); //used them to check for mirror
//      Node root2 = createTree(arr4); // root1 and root2 are actually mirror
      createTree(arr);
//      printTree(root);
      multiSolver(root, 0);
      System.out.println(min + " " + max + " " + height + " " + NoOfNodes);

   }

   private static void multiSolver(Node root, int depth) {
      min = Integer.min(root.data, min);
      max = Integer.max(root.data, max);
      height = depth;
      NoOfNodes += 1;
      for (Node node : root.children) {
         multiSolver(node, depth + 1);
      }
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

