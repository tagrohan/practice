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
//      printTree(root1);
//      System.out.println("---------------------------------");
//      printTree(root2);
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
//      removeLeaves(root);
//      linearizeGenericV2(root);
//      printTree(root);
//      linearize(root);
//      printTree(root);
//      System.out.println(find(root, 110));
//      System.out.println(nodeToRootPath(root, 110));
//      lowestCommonAncestor(root, 70, 30);
//      System.out.println(areTreeSimilarRecursive(root1, root1));

//      System.out.println(areTreeMirror(root1, root2));
      Node n1 = createTree(arr5);
      printTree(n1);
      System.out.println(isTreeSymmetric(n1));
   }

   // as we know each symmetric tree is also mirror of each other so we are checking here
   private static boolean isTreeSymmetric(Node root) {
      return areTreeMirror(root, root);
   }

   // wow working fine man, it's bug fixes
   private static boolean areTreeMirror(Node root1, Node root2) {
      if (root1.children.size() != root2.children.size()) {
         return false;
      }

      for (int i = 0; i < root1.children.size(); i++) {
         boolean isMirror = areTreeMirror(root1.children.get(i), root2.children.get(root2.children.size() - 1 - i));
         if (!isMirror) {
            return false;
         }
      }
      return true;
   }

   // working fine
   private static boolean areTreeSimilarRecursive(Node root1, Node root2) {
      if (root1.children.size() != root2.children.size()) {
         return false;
      }
      for (int i = 0; i < root1.children.size(); i++) {
         boolean isSimilar = areTreeSimilarRecursive(root1.children.get(i), root2.children.get(i));
         if (!isSimilar) {
            return false;
         }
      }
      return true;
   }

   private static boolean areTreeSimilar(Node root1, Node root2) {
      Queue<Node> queue1 = new ArrayDeque<>();
      Queue<Node> queue2 = new ArrayDeque<>();
      queue1.add(root1);
      queue2.add(root2);
      while (!queue1.isEmpty() && !queue2.isEmpty()) {
         Node n1 = queue1.remove();
         Node n2 = queue2.remove();
         if (n1.children.size() > 0) {
            if (n1.children.size() == n2.children.size()) {
               queue1.addAll(n1.children);
               queue2.addAll(n2.children);
            } else {
               return false;
            }
         }
      }
      return true;
   }

   // same as lowest common ancestor but at last we add remaining i + j and done
   private static void distanceBetweenNodes(Node root, int first, int second) {
      List<Integer> firstPath = nodeToRootPath(root, first);
      List<Integer> secondPath = nodeToRootPath(root, second);
      System.out.println(firstPath);
      System.out.println(secondPath);

      int i = firstPath.size() - 1;
      int j = secondPath.size() - 1;
      while (i >= 0 && j >= 0 && firstPath.get(i).equals(secondPath.get(j))) {
         i -= 1;
         j -= 1;
      }
      i += 1;
      j += 1;
      System.out.println(i + j);
   }

   // working fine based on nodeToRootPath
   private static void lowestCommonAncestor(Node root, int first, int second) {
      List<Integer> firstPath = nodeToRootPath(root, first);
      List<Integer> secondPath = nodeToRootPath(root, second);
      System.out.println(firstPath);
      System.out.println(secondPath);

      int i = firstPath.size() - 1;
      int j = secondPath.size() - 1;
      while (i >= 0 && j >= 0 && firstPath.get(i).equals(secondPath.get(j))) {
         i -= 1;
         j -= 1;
      }
      i += 1;
      j += 1;
      System.out.println(firstPath.get(i));
      System.out.println(i + j);

   }

   // working fine man
   private static List<Integer> nodeToRootPath(Node root, int key) {
      if (root.data == key) {
         List<Integer> list = new ArrayList<>();
         list.add(root.data);
         return list;
      }
      for (Node node : root.children) {
         List<Integer> list = nodeToRootPath(node, key);
         if (list.size() > 0) {
            list.add(root.data);
            return list;
         }
      }
      return List.of();
   }

   // kind of linearize modified version, give it a look
   public static void linearize(Node node) {
      List<Node> child = node.children;
      for (int j = child.size() - 1; j > 0; j--) {
         child.get(j - 1).children.add(child.get(j));
         child.remove(j);
      }
      if (child.size() != 0) {
         linearize(child.get(0));
      }
   }

   private static boolean find(Node root, int key) {
      if (root.data == key) {
         return true;
      }
      System.out.println("called");
      boolean found = false;
      for (Node node : root.children) {
         if (!found) {
            found = find(node, key);
         } // another approach (didn't require extra variable found but isTrue is used)
//         boolean isTrue = find(node,key);
//         if(isTrue){
//            return true;
//         }
      }
      return found;
   }

   // O(n) time complexity , omg it's working
   private static Node linearizeGenericV2(Node root) {
      if (root.children.size() == 0) {
         return root;
      }

      Node lastNodeTail = linearizeGenericV2(root.children.get(root.children.size() - 1));
      while (root.children.size() > 1) {
         Node last = root.children.remove(root.children.size() - 1);
         Node sLast = root.children.get(root.children.size() - 1);
         Node sLastTail = linearizeGenericV2(sLast);
         sLastTail.children.add(last);
      }
      return lastNodeTail;
   }


   // each note have one children on single order
   private static void linearizeGeneric(Node root) {
      for (Node node : root.children) {
         linearizeGeneric(node);
      }

      while (root.children.size() > 1) {
         Node lc = root.children.remove(root.children.size() - 1);
         Node sl = root.children.get(root.children.size() - 1);
         Node tail = getTail(sl);
         tail.children.add(lc);
      }
   }

   private static Node getTail(Node node) {
      while (node.children.size() == 1) {
         node = node.children.get(0);
      }
      return node;
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
