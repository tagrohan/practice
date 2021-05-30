package com.practice.trees.binary;

import java.util.LinkedList;
import java.util.Queue;
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
      levelOrderTraversal(root);
   }

   private static void levelOrderTraversal(Node root) {
      Queue<Node> queue = new LinkedList<>();
      queue.add(root);
      queue.add(null);

      while (queue.size() > 1 || queue.peek() != null) {

         Node node = queue.remove();
         if (node != null) {
            System.out.print(node.data + " ");
            if (node.left != null) {
               queue.add(node.left);
            }
            if (node.right != null) {
               queue.add(node.right);
            }
         } else {
            System.out.println();
            queue.add(null);
         }
      }
   }

   // working fine
   private static void prePostInOrderTraversal(Node root) {
      if (root == null) {
         return;
      }
      System.out.println("pre -> " + root.data);
      prePostInOrderTraversal(root.left);
      System.out.println("In -> " + root.data);
      prePostInOrderTraversal(root.right);
      System.out.println("post -> " + root.data);

   }


   private static int size(Node root) {
      if (root == null) {
         return 0;
      }
      int left = size(root.left);
      int right = size(root.right);
      return left + right + 1;
   }

   private static int sum(Node root) {
      if (root == null) {
         return 0;
      }
      int left = sum(root.left);
      int right = sum(root.right);
      return root.data + left + right;

   }

   private static int max(Node root) {
      if (root == null) {
         return Integer.MIN_VALUE;
      }
      int left = max(root.left);
      int right = max((root.right));

      return Integer.max(Integer.max(left, right), root.data);
   }

   private static int height(Node root) {
      if (root == null) {
         return -1; // -1m bcz we want edges, if we want nodes height it would be 0
      }
      int left = height((root.left));
      int right = height((root.right));

      return Integer.max(left, right) + 1;
   }

   // working fine it's preorder traversal
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
