package com.practice.trees.binary;

import java.util.Stack;

public class BinarySearchTree {

   public static class Node {
      int data;
      Node left;
      Node right;

      public Node() {
      }

      public Node(int data, Node left, Node right) {
         this.data = data;
         this.left = left;
         this.right = right;
      }
   }

   public static void main(String[] args) {

      int[] bst = new int[]{12, 25, 30, 37, 40, 50, 60, 62, 70, 75, 87};
      int[] bst2 = new int[]{12, 25, 37, 50, 62, 75, 87};
      Node root = createTree(bst, 0, 11);
//      Node root = createTree(bst2,0,7);
//      printRecursive(root);
      System.out.println(find(root, 75));
   }

   // find working fine as BST its goes laser recursion
   private static boolean find(Node root, int key) {
      if (root == null) {
         return false;
      }

      if (root.data == key) {
         return true;
      }
      if (root.data > key) {
         return find(root.left, key);
      } else {
         return find(root.right, key);
      }
   }

   // if can't understand it check in BTree or generic
   private static int size(Node node) {
      if (node == null) {
         return -1;
      }
      return Integer.max(size(node.left), size(node.right)) + 1;
   }


   private static int sum(Node node) {
      if (node == null) {
         return 0;
      }
      int left = sum(node.left);
      int right = sum(node.right);
      return left + right + node.data;
   }


   private static int max(Node root) {
      if (root == null) {
         return Integer.MIN_VALUE;
      }

      int right = max(root.right);

      return Integer.max(right, root.data);

   }

   private static int min(Node node) {
      if (node == null) {
         return Integer.MAX_VALUE;
      }
      int left = min(node.left);
      return Integer.min(node.data, left);
   }

   // working fine but out may be differ as we can create multiple BST from data node
   private static Node createTree(int[] arr, int start, int length) {
      if (length <= start) {
         return null;
      }

      int mid = (start + length) / 2;
      int data = arr[mid];

      Node left = createTree(arr, start, mid);
      Node right = createTree(arr, mid + 1, length);

      return new Node(data, left, right);
   }

   private static void printUsingStack(Node root) {
      Stack<Node> stack = new Stack<>();
      stack.push(root);
      while (!stack.isEmpty()) {
         Node node = stack.pop();
         if (node.right != null) {
            stack.push(node.right);
         }
         if (node.left != null) {
            stack.push(node.left);
         }
         System.out.println(node.data);
      }
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

   static class BST {
      int min;
      int max;
      boolean isBst;
   }

   // seems working fine
   private static boolean isBstV2(Node root) {
      BST bst = isBstV2Helper(root);
//      System.out.println(bst.min + " " + bst.max);
      return bst.isBst;
   }

   private static BST isBstV2Helper(Node root) {

      if (root == null) {
         BST b = new BST();
         b.min = Integer.MAX_VALUE;
         b.max = Integer.MIN_VALUE;
         b.isBst = true;
         return b;
      }

      BST left = isBstV2Helper(root.left);
      BST right = isBstV2Helper(root.right);

      BST bst = new BST();
      bst.isBst = left.isBst && right.isBst && (root.data > left.max && root.data < right.min);


      bst.max = Integer.max(root.data, Integer.max(left.max, right.max));
      bst.min = Integer.min(root.data, Integer.min(left.min, right.min));
      return bst;
   }


}
