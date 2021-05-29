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
//      levelTraversal(root);
//      preOrderUsingStack(root);
//      levelOrderLineWise(root);
//      levelOrderLineWiseTwoQueue(root);
//      zigzagLevelTraversal(root);
//      mirrorOfTree(root);
//      removeLeaves(root);
//      printTree(root);
      removeLeaves(root);
      printTree(root);
   }

   // it's working fine wow
   private static void removeLeaves(Node root) {

      for (int i = root.children.size() - 1; i >= 0; i--) {
         Node child = root.children.get(i);
         if (child.children.size() == 0) {
            root.children.remove(i);
         }
      }

      for (Node node : root.children) {
         removeLeaves(node);
      }
   }

   // this one is only for printing
   private static void printAfterRemoveLeaves(Node root) {
      Queue<Node> queue = new ArrayDeque<>();
      queue.add(root);
      while (!queue.isEmpty()) {
         Node node = queue.remove();
         if (node.children.size() > 0) {
            System.out.print(node.data + " ");
            queue.addAll(node.children);
         }
      }
   }

   // using recursion here
   private static void mirrorOfTree(Node root) {
      System.out.print(root.data + "-> ");
      Collections.reverse(root.children);
      for (Node node : root.children) {
         System.out.print(node.data + " ");
      }
      System.out.println();
      for (Node node : root.children) {
         mirrorOfTree(node);
      }
   }


   // working fine
   private static void zigzagLevelTraversal(Node root) {
      int rotation = 1;
      Stack<Node> primary = new Stack<>();
      Stack<Node> secondary = new Stack<>();
      primary.push(root);
      while (!primary.isEmpty()) {
         Node node = primary.pop();
         System.out.print(node.data + " ");

         if (node.children.size() > 0) {
            if (rotation == 1) {
               secondary.addAll(node.children);
            } else {
               for (int i = node.children.size() - 1; i >= 0; i--) {
                  secondary.push(node.children.get(i));
               }
            }
         }
         if (primary.isEmpty() && !secondary.isEmpty()) {
            primary = secondary;
            secondary = new Stack<>();
            rotation = rotation == 1 ? 0 : 1;
         }
      }
   }

   // working fine but below method uses less space
   // other ways 1: using 1 Queue check below, 2: each time take the size and after that we can hit enter, 3: using pair class to create levels, for each incremented levels we can hit enter
   private static void levelOrderLineWiseTwoQueue(Node root) {
      Queue<Node> primary = new ArrayDeque<>();
      Queue<Node> secondary = new ArrayDeque<>();
      primary.add(root);
      while (!primary.isEmpty()) {
         Node temp = primary.remove();
         if (temp.children.size() > 0) {
            secondary.addAll(temp.children);
         }
         System.out.print(temp.data + " ");
         if (primary.isEmpty() && !secondary.isEmpty()) {
            primary = secondary;
            secondary = new ArrayDeque<>();
            System.out.println();
         }
      }
   }

   // each level separated by line
   private static void levelOrderLineWise(Node root) {
      Queue<Node> queue = new LinkedList<>(); // using linked list as in queue null in not allowed to add, we we are checking of null  or we can use -1 is that case of ArrayQueue
      queue.add(root);
      queue.add(null);
      while (queue.size() > 1 || queue.peek() != null) {
         Node temp = queue.remove();
         if (temp != null) {
            System.out.print(temp.data + " ");
            if (temp.children.size() > 0) {
               queue.addAll(temp.children);
            }
         } else {
            System.out.println();
            queue.add(null);
         }
      }

   }

   // pre order traversal using stack
   private static void preOrderUsingStack(Node root) {
      Stack<Node> stack = new Stack<>();
      stack.push(root);
      while (!stack.isEmpty()) {
         Node temp = stack.pop();
         if (temp.children.size() > 0) {
            for (int i = temp.children.size() - 1; i >= 0; i--) {
               stack.push(temp.children.get(i));
            }
         }
         System.out.print(temp.data + " ");
      }
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
