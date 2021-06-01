package com.practice.trees.binary;

import java.util.*;

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
              null, null, null, 75, 62, null, 70, null, null, 57, null, null};

      Integer[] bst = new Integer[]{50, 40, 20, null, null, 45, 43
              , null, null, null, 60, 55, null, 56, null, null, 70, null, null};
      createTree(bst);

//      System.out.println(isBstV2(root));
      BST b = LargestBstSubtree(root);
      System.out.println(b.node.data + " @ " + b.size);
   }

   // todo : same as isBst + need size who is valid bst so
   private static BST LargestBstSubtree(Node root) {
//      BST b = LargestBstSubtree(root);
//      System.out.println(b.node.data + " @ " + b.size);

      if (root == null) {
         BST b = new BST();
         b.min = Integer.MAX_VALUE;
         b.max = Integer.MIN_VALUE;
         b.isBst = true;
         b.size = 0;
         b.node = null;
         return b;
      }

      BST left = LargestBstSubtree(root.left);
      BST right = LargestBstSubtree(root.right);

      BST bst = new BST();
      // this line is equivalent to upper lines
      bst.isBst = left.isBst && right.isBst && (root.data > left.max && root.data < right.min);
      bst.max = Integer.max(root.data, Integer.max(left.max, right.max));
      bst.min = Integer.min(root.data, Integer.min(left.min, right.min));

      if (bst.isBst) {
         bst.node = root;
         bst.size = left.size + right.size + 1;
      } else if (left.size > right.size) { // size represent largest bst size not current bst size
         bst.node = left.node;
         bst.size = left.size;
      } else {
         bst.node = right.node;
         bst.size = right.size;
      }

      return bst;
   }


   static class BST {
      int min;
      int max;
      boolean isBst;
      // these properties are for above question LargestBstSubtree
      int size;
      Node node;
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
//      bst.isBst = true;

//      if (left.isBst && right.isBst) {
//         if (root.data < left.max || root.data > right.min) {
//            System.out.println(root.data);
//            bst.isBst = false;
//         }
//      } else {
//         bst.isBst = false;
//      }
      // this line is equivalent to upper lines
      bst.isBst = left.isBst && right.isBst && (root.data > left.max && root.data < right.min);


      bst.max = Integer.max(root.data, Integer.max(left.max, right.max));
      bst.min = Integer.min(root.data, Integer.min(left.min, right.min));
      return bst;
   }

   // balanced tree working fine
   private static BT isBalancedTree(Node root) {
//      System.out.println(!isBalancedTree(root).is); as i am returning true for false so i inverted it
      if (root == null) {
         BT bt = new BT();
         bt.height = 0;
         bt.is = false;
         return bt;
      }

      BT left = isBalancedTree(root.left);
      BT right = isBalancedTree(root.right);

      BT bt = new BT();

      bt.height = 1 + Integer.max(left.height, right.height);

      if (Math.abs(left.height - right.height) > 1 && !left.is && !right.is) {
         bt.is = true;
      }

      return bt;
   }

   private static class BT {
      int height;
      boolean is;
   }

   private static int tilt = 0;

   // using static variable tilt to get output -> todo: travel and change strategy
   private static int sumOfTiltOfBinaryTree(Node node) {

//      sumOfTiltOfBinaryTree(root);
//      System.out.println(tilt);
      if (node == null) {
         return 0;
      }

      int left = sumOfTiltOfBinaryTree(node.left);
      int right = sumOfTiltOfBinaryTree(node.right);

      tilt += Math.abs(left - right);

      return left + right + node.data;
   }

   static class DiaPair {
      int ht;
      int dia;
   }

   // omg its working with O(n) time complexity
   private static DiaPair diameterOfBinaryTreeV2(Node root) {
//      System.out.println(diameterOfBinaryTreeV2(root).dia);
      if (root == null) {
         DiaPair d = new DiaPair();
         d.ht = -1;
         d.dia = 0;
         return d;
      }

      DiaPair diaPairLeft = diameterOfBinaryTreeV2(root.left);
      DiaPair diaPairRight = diameterOfBinaryTreeV2(root.right);

      DiaPair dia = new DiaPair();
      dia.ht = Integer.max(diaPairLeft.ht, diaPairRight.ht) + 1;
      dia.dia = Integer.max(Integer.max(diaPairLeft.dia, diaPairRight.dia), diaPairLeft.ht + diaPairRight.ht + 2);

      return dia;
   }


   // we can do this in better time complexity
   private static int diameterOfBinaryTree(Node root) {

      if (root == null) {
         return 0;
      }

      int left = diameterOfBinaryTree(root.left);
      int right = diameterOfBinaryTree(root.right);

      int height = heightV2(root.left) + heightV2(root.right) + 2;

      return Integer.max(right, Integer.max(left, height));
   }


   private static int heightV2(Node node) {
      if (node == null) {
         return -1;
      }

      int left = heightV2(node.left);
      int right = heightV2(node.right);

      return Integer.max(left, right) + 1;
   }

   // better approach than below v1
   private static Node removeChildrenV2(Node root) {
      if (root == null) {
         return null;
      }
      if (root.left == null && root.right == null) {
         return null;
      }
      root.left = removeChildrenV2(root.left);
      root.right = removeChildrenV2(root.right);

      return root;
   }

   // better approach is above
   private static void removeChildren(Node root, Node parent) {
      if (root == null) {
         return;
      }
      if (root.left == null && root.right == null) {
         if (parent.left == null) {
            parent.right = null;
         } else if (parent.right == null) {
            parent.left = null;
         } else {
            if (parent.left.equals(root)) {
               parent.left = null;
            } else {
               parent.right = null;
            }
         }
      }


      removeChildren(root.left, root);
      removeChildren(root.right, root);
   }


   //   working fine
   private static void parentHaveOneChild(Node node) {
      if (node == null) {
         return;
      }
      if (node.left == null || node.right == null) {
         System.out.print(node.data + " ");
      }

      parentHaveOneChild(node.left);
      parentHaveOneChild(node.right);
   }

   // giving null pointer exception don't know why
   private static Node normalFromLeftClone(Node root) {
      if (root == null) {
         return null;
      }

      root.left = normalFromLeftClone(root.left.left);
      root.right = normalFromLeftClone(root.right);

      return root;
   }

   // working fine
   private static void leftCloneTree(Node root) {
      if (root == null) {
         return;
      }

      leftCloneTree(root.left);
      leftCloneTree(root.right);

      if (root.left != null) {
         Node node = new Node(root.data);
         Node temp = root.left;
         root.left = node;
         node.left = temp;
      }
   }

   // printing all paths with given sum range
   private static void pathWithGivenSumRange(Node root, int from, int to, int sum, String builder) {
//      pathWithGivenSumRange(root, 75, 263, 0, "");
      if (root == null) {
         return;
      }
      if (root.left == null || root.right == null) {
         if (sum >= from && sum < to) {
            System.out.println(builder + root.data + " ");
         }
         return;
      }

      pathWithGivenSumRange(root.left, from, to, sum + root.data, builder + root.data + " ");
      pathWithGivenSumRange(root.right, from, to, sum + root.data, builder + root.data + " ");
   }

   // find all the paths from current node at k distance
   private static void printKNodeFar(Node root, int data, int k) {
//      printKNodeFar(root, 75, 2);
      List<Node> nodes = nodeToRootPathV2(root, data);
      for (int i = 0; i < nodes.size(); i++) {
         kLevelDownV2(nodes.get(i), k - i, i == 0 ? null : nodes.get(i - 1));
      }
   }


   // helper for printKNodeFar
   private static List<Node> nodeToRootPathV2(Node root, int nodeData) {
//      System.out.println(Arrays.toString(nodeToRootPath(root, 70).toArray()));
      if (root == null) {
         return List.of();
      }
      if (root.data == nodeData) {
         List<Node> ret = new ArrayList<>();
         ret.add(root);
         return ret;
      }
      List<Node> left = nodeToRootPathV2(root.left, nodeData);
      List<Node> right = nodeToRootPathV2(root.right, nodeData);

      if (left.size() > 0) {
         left.add(root);
      }
      if (right.size() > 0) {
         right.add(root);
      }
      return left.size() > 0 ? left : right;
   }

   // helper for printKNodeFar
   private static void kLevelDownV2(Node root, int k, Node blocker) {
      if (root == null || k < 0 || root == blocker) {
         return;
      }
      if (k == 0) {
         System.out.print(root.data + " ");
      }
      kLevelDownV2(root.left, k - 1, blocker);
      kLevelDownV2(root.right, k - 1, blocker);
   }


   private static void kLevelDown(Node root, int k) {
      if (root == null || k < 0) {
         return;
      }
      if (k == 0) {
         System.out.print(root.data + " ");
      }
      kLevelDown(root.left, k - 1);
      kLevelDown(root.right, k - 1);
   }


   // finding the path same as GT question
   private static List<Integer> nodeToRootPath(Node root, int nodeData) {
//      System.out.println(Arrays.toString(nodeToRootPath(root, 70).toArray()));
      if (root == null) {
         return List.of();
      }
      if (root.data == nodeData) {
         List<Integer> ret = new ArrayList<>();
         ret.add(root.data);
         return ret;
      }
      List<Integer> left = nodeToRootPath(root.left, nodeData);
      List<Integer> right = nodeToRootPath(root.right, nodeData);

      if (left.size() > 0) {
         left.add(root.data);
      }
      if (right.size() > 0) {
         right.add(root.data);
      }
      return left.size() > 0 ? left : right;
   }


   // using iterative working fine
   private static void preInPostOrderIterative(Node node) {
      Stack<Pair> stack = new Stack<>();
      stack.add(new Pair(node, -1));
      StringBuilder pre = new StringBuilder();
      StringBuilder in = new StringBuilder();
      StringBuilder post = new StringBuilder();

      while (!stack.isEmpty()) {
         Pair pair = stack.peek();
         if (pair.state == -1) {
            Node temp = pair.node;
            pre.append(temp.data).append(" ");
            if (temp.left != null) {
               stack.push(new Pair(temp.left, -1));
            }
            pair.state += 1;
         } else if (pair.state == 0) {
            Node temp = pair.node;
            in.append(temp.data).append(" ");
            if (temp.right != null) {
               stack.push(new Pair(temp.right, -1));
            }
            pair.state += 1;
         } else {
            post.append(pair.node.data).append(" ");
            stack.pop();
         }
      }
      System.out.println(pre);
      System.out.println(in);
      System.out.println(post);
   }

   // level order using for loop
   private static void levelOrderTraversalForLoop(Node root) {
      Queue<Node> queue = new ArrayDeque<>();
      queue.add(root);

      while (!queue.isEmpty()) {
         int size = queue.size();
         for (int i = 0; i < size; i++) {
            Node node = queue.remove();
            System.out.print(node.data + " ");
            if (node.left != null) {
               queue.add(node.left);
            }
            if (node.right != null) {
               queue.add(node.right);
            }
         }
         System.out.println();
      }
   }

   // working fine but we can also use for loop to do this type as well check above
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

   // any sum path available
   private static boolean pathAvail(Node node, int sum, int cSum) {
//      System.out.println(pathAvail(root, 50 + 25 + 37 + 30, 0)); // it's node itself actually
      if (node == null) {
         return false;
      }
      if (node.left == null && node.right == null) {
         if (cSum + node.data == sum) {
            return true;
         }
      }
      cSum += node.data;
      boolean left = pathAvail(node.left, sum, cSum);
      boolean right = pathAvail(node.right, sum, cSum);
      return left || right;
   }
}
