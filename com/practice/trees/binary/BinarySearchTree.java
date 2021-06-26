package com.practice.trees.binary;

import java.util.ArrayList;
import java.util.List;
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

//      targetSumPair(root, 100);
//      System.out.println(find(root,25));

      System.out.println(isBstUsingInOrderProperty(root));
   }


   // as in order gives acceding order, then after getting data, we'll check it's sorted or not
   private static boolean isBstUsingInOrderProperty(Node root) {
      List<Integer> list = new ArrayList<>();
      isBstHelper(root, list);
      for (int i = 1; i < list.size() - 1; i++) {
         if (list.get(i) <= list.get(i - 1)) return false;
      }
      return true;
   }


   private static void isBstHelper(Node root, List<Integer> list) {
      if (root == null) return;
      isBstHelper(root.left, list);
      list.add(root.data);
      isBstHelper(root.right, list);
   }


   // about to do
   private static void targetSumPairV2(Node root, int sum) {

   }


   // better time complexity then below one O(N)
   private static void targetSumPair(Node root, int sum) {
      List<Integer> list = targetSumHelper(root, new ArrayList<>());
      int i = 0, j = list.size() - 1;
      while (i < j) {
         if (list.get(i) + list.get(j) == sum) {
            System.out.println("[" + list.get(i) + ", " + list.get(j) + "]");
            i++;
            j--;
         } else if (list.get(i) + list.get(j) < sum) {
            i++;
         } else {
            j--;
         }
      }
   }

   private static List<Integer> targetSumHelper(Node root, List<Integer> list) {
      if (root == null) {
         return null;
      }
      targetSumHelper(root.left, list);
      list.add(root.data);
      targetSumHelper(root.right, list);

      return list;
   }

//   private static

   // working fine (here we have to find pairs whose some is equal to given sum)
   private static void targetSumPair(Node currentNode, int sum, Node root) {
      if (currentNode == null) {
         return;
      }

      targetSumPair(currentNode.left, sum, root);
      int comp = sum - currentNode.data;
      if (comp > currentNode.data) {
         if (find(root, comp)) {
            System.out.println("[" + currentNode.data + ", " + comp + "]");
         }
      }
      targetSumPair(currentNode.right, sum, root);
   }


   // it's an effective approach as we are using BST property to go in left and right in recursion
   private static void printRange(Node root, int from, int to) {
//      printRange(root, 50, 87);
      if (root == null) {
         return;
      }

      if (root.data > from && root.data > to) {
         printRange(root.left, from, to);
      } else if (root.data < from && root.data < to) {
         printRange(root.right, from, to);
      } else {
         printRange(root.left, from, to);
         System.out.print(root.data + " ");
         printRange(root.right, from, to);
      }

   }

   // working fine find the common point which exist when both left and right separate
   private static int lowestCommonAncestor(Node root, int val1, int val2) {
//      System.out.println(lowestCommonAncestor(root, 60, 87));
      if (root == null) {
         return 0;
      }

      if (root.data > val1 && root.data > val2) {
         return lowestCommonAncestor(root.left, val1, val2);
      } else if (root.data < val1 && root.data < val2) {
         return lowestCommonAncestor(root.right, val1, val2);
      } else {
         // meeting point
         return root.data;
      }
   }


   private static int currentSum = 0;

   //  working fine  root,data = sum of all the larger nodes
   private static void replaceWithSumOfLarger(Node root) {
      if (root == null) {
         return;
      }
      replaceWithSumOfLarger(root.right);

      int temp = root.data;
      root.data = currentSum;
      currentSum += temp;

      replaceWithSumOfLarger(root.left);
   }


   // working for some trees whose max don't have child
   private static Node removeViaData(Node root, int value) {
      if (root == null) {
         return null;
      }

      if (root.data > value) {
         root.left = removeViaData(root.left, value);
      } else if (root.data < value) {
         root.right = removeViaData(root.right, value);
      } else {
         // here we have found value equivalent node
         if (root.left != null && root.right != null) {
            int temp = root.data;
            Node toRemove = min(root.right);
            root.data = toRemove.data;
            toRemove.data = temp;
            root.right = removeViaData(root.right, toRemove.data);
            return root;
         } else if (root.left != null) {
            return root.left;
         } else if (root.right != null) {
            return root.right;
         } else {
            return null;
         }

      }
      return root;
   }

   // V2 of it working fine
   private static Node addNodeV2(Node root, int value) {
      if (root == null)
         return new Node(value, null, null);

      if (root.data > value) {
         root.left = addNodeV2(root.left, value);
      } else if (root.data < value) {
         root.right = addNodeV2(root.right, value);
      }  // for == case, data is equal to any node data so we don't add

      return root;
   }

   // working fine
   private static void addNodeWithValue(Node root, int value) {
      if (root == null) {
         return;
      }
      if (value > root.data) {
         if (root.right == null) {
            root.right = new Node(value, null, null);
            return;
         }
         addNodeWithValue(root.right, value);
      } else {
         if (root.left == null) {
            root.left = new Node(value, null, null);
            return;
         }
         addNodeWithValue(root.left, value);
      }
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
      if (root.right != null) {
         return max(root.right);
      } else {
         return root.data;
      }

   }

   private static Node min(Node node) {
      if (node.left != null) {
         return min(node.left);
      } else {
         return node;
      }
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
