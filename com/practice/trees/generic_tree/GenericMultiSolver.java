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
      int[] arr6 = new int[]{10, 20, -50, -1, -60, -1, -1, 30, -70, -1, 80, -110, -1, 120, -1, -1, 90,
              -1, -1, 40, -100, -1, -1, -1};// used for subset sum

//      Node root1 = createTree(arr3); //used them to check for mirror
//      Node root2 = createTree(arr4); // root1 and root2 are actually mirror
      // TODO these strategy called as travel and change
      createTree(arr);
//      printTree(root);
//      multiSolver(root, 0);
//      System.out.println(min + " " + max + " " + height + " " + NoOfNodes);
//      predecessorAndSuccessor(root, 10);
      // make sure for Null pointer exception cases
//      System.out.println("for " + curr.data + "-> pre: " + pre.data + " succ: " + suc.data);
//      findCeilAndFloor(root, 65);
//      System.out.println(ceil);
//      System.out.println(floor);
//      findKthLargest(root,3);
//      Node n = createTree(arr6);
//      maxSubsetTree(n);
//      System.out.println(nodeValue + " " + subsetMaxValue);
//      calculateDiameter(root);
//      System.out.println(dia);
      preAndPostOrder(root);
   }


   // iteratively
   private static class Pair {
      Node node;
      int state;

      public Pair(Node node, int state) {
         this.node = node;
         this.state = state;
      }
   }
 // working fine logic is great try again in practice
   private static void preAndPostOrder(Node node) {
      Stack<Pair> stack = new Stack<>();
      stack.push(new Pair(node, -1));
      StringBuilder pre = new StringBuilder();
      StringBuilder post = new StringBuilder();

      while (!stack.isEmpty()) {
         Pair pair = stack.peek();
         if (pair.state == -1) {
            pre.append(pair.node.data).append(" ");
            pair.state += 1;
         } else if (pair.state == pair.node.children.size()) {
            post.append(pair.node.data).append(" ");
            stack.pop();
         } else {
            Pair cPair = new Pair(pair.node.children.get(pair.state), -1);
            stack.push(cPair);
            pair.state += 1;
         }
      }
      System.out.println(pre);
      System.out.println(post);
   }

   private static int dia = 0;

   // working fine but need to understand better at 50:50
   private static int calculateDiameter(Node root) {
      int secondHeight = -1;
      int firstHeight = -1;

      for (Node node : root.children) {
         int currentHeight = calculateDiameter(node);
         if (currentHeight > firstHeight) {
            secondHeight = firstHeight;
            firstHeight = currentHeight;
         } else if (currentHeight > secondHeight) {
            secondHeight = currentHeight;
         }
      }

      int height = firstHeight + secondHeight + 2;
      dia = Integer.max(height, dia);
      return firstHeight + 1;
   }

   // working fine need practice at next 50:50
   private static int subsetMaxValue = Integer.MIN_VALUE;
   private static int nodeValue = 0;

   private static int maxSubsetTree(Node root) {
      int sum = 0;
      for (Node node : root.children) {
         sum += maxSubsetTree(node);
      }
      sum += root.data;
      if (sum > subsetMaxValue) {
         subsetMaxValue = sum;
         nodeValue = root.data;
      }
      return sum;
   }

   // working fine based on floor check below this method code
   private static void findKthLargest(Node node, int kth) {
      int kthMax = Integer.MAX_VALUE;
      for (int i = 0; i < kth; i++) {
         findCeilAndFloor(node, kthMax);
         kthMax = floor;
         floor = Integer.MIN_VALUE;
      }
      System.out.println(kthMax);
   }


   // i have pulled this off
   private static int ceil = Integer.MAX_VALUE;
   private static int floor = Integer.MIN_VALUE;

   private static void findCeilAndFloor(Node root, int key) {
      if (key <= root.data) {
         ceil = Integer.min(root.data, ceil);
      } else {
         floor = Integer.max(root.data, floor);
      }
      for (Node node : root.children) {
         findCeilAndFloor(node, key);
      }
   }

   private static int state = 0;
   private static Node pre, suc, curr;

   private static void predecessorAndSuccessor(Node root, int key) {
      if (state == 0) {
         if (root.data == key) {
            state = 1;
            curr = root;
         } else {
            pre = root;
         }
      } else if (state == 1) {
         suc = root;
         state = 2;
      }

      for (Node node : root.children) {
         predecessorAndSuccessor(node, key);
      }

   }

   // here we don't need to call that much and we get max min height, no of nodes here, that's the beauty of this
   private static void multiSolver(Node root, int depth) {
      min = Integer.min(root.data, min);
      max = Integer.max(root.data, max);
      height = Integer.max(height, depth);
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

