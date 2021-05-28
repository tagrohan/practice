package com.practice.trees.generic_tree;

import java.util.*;

public class GenericMain {
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
              -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
      createTree(arr);
//      printTree(root);

//      System.out.println();
//      System.out.println("No. of Nodes -> " + size(root));
//      System.out.println();
//      System.out.println("max node -> " + max(root));
//      System.out.println();
//      System.out.println("height->" + heightOf(root));
//      System.out.println("height->" + heightOf(new Node(12)));

//      prePostTraversal(root);
      levelTraversal(root);
   }



   // using queue here
   private static void levelTraversal(Node root) {
      Queue<Node> queue = new ArrayDeque<>();
      queue.add(root);
      while (!queue.isEmpty()) {
         Node temp = queue.remove();
         if (temp.children.size() != 0) {
            queue.addAll(temp.children);
//            for (Node node : temp.children) {
//               queue.add(node);
//            }

         }
         System.out.print(temp.data + " ");
      }

   }

   // working fine it's just to teach pre post traversal
   private static void prePostTraversal(Node root) {
      System.out.println("pre -> " + root.data);
      for (Node node : root.children) {
         System.out.println("pre Edge-> " + root.data + " - " + node.data);
         prePostTraversal(node);
         System.out.println("post Edge-> " + root.data + " - " + node.data);
      }
      System.out.println("post -> " + root.data);
   }


   // height here is depth of the deepest node means level length
   private static int heightOf(Node root) {
      int height = -1;
      for (Node node : root.children) {
         height = Integer.max(height, heightOf(node)); // we need max bcz we have to handle base condition when only one root node is there
      }
      return height + 1;
   }


   // working fine
   private static int max(Node root) {
      int max = 0;
      for (Node node : root.children) {
         max = Integer.max(max, max(node));
      }
      return Integer.max(root.data, max);
   }

   // tells how many nodes in the tree
   private static int size(Node root) {
      int cSize = 0;
      for (Node node : root.children) {
         cSize += size(node);
      }
      return 1 + cSize;
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
   private static void createTree(int[] arr) {
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
   }
}
