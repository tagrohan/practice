package com.practice.graph;

import java.util.*;

public class Graph {
   private static class Edge {
      int source;
      int neighbour;
      int weight;

      public Edge(int source, int neighbour, int weight) {
         this.source = source;
         this.neighbour = neighbour;
         this.weight = weight;
      }

      public Edge(int source, int neighbour) {
         this.source = source;
         this.neighbour = neighbour;
      }
   }

   // specially designed for multiSolver
   private static class Properties implements Comparable<Properties> {
      int smallest = Integer.MAX_VALUE;
      String smallestPath = "";
      int largest = Integer.MIN_VALUE;
      String largestPath = "";
      int ceil = Integer.MAX_VALUE;
      String ceilPath = "";
      int floor = Integer.MIN_VALUE;
      String floorPath = "";
      int cost;
      String kthPath;

      @Override
      public int compareTo(Properties o) {
         return this.cost - o.cost;
      }
   }

   public static void main(String[] args) {
      List<List<Edge>> edges = getEdges(new ArrayList<>());


//      List<List<Edge>> edges = getEdgesSplitGraph(new ArrayList<>());
//      List<List<Edge>> edgeForHamilton = getEdgesFromMatrix(new int[][]
//              {{0, 1, 10},
//                      {1, 2, 10},
//                      {2, 3, 10},
//                      {0, 3, 10},
//                      {3, 4, 10},
//                      {4, 5, 10},
//                      {5, 6, 10},
//                      {4, 6, 10},
//                      {2, 5, 10}}, 7);
////      printAllPath(edgeForHamilton, 0, 6, new boolean[7], 0 + "");
////      printHamiltonianPathAndCycle(edgeForHamilton, 0, new HashSet<>(), 0 + " ", 0);
//      hamiltonianPathAndCycle(edgeForHamilton, 0, 0, new HashSet<>(), 0 + "");
   }

   // todo : have some problem maybe in graph or something i'll do it later
   // hamiltonian path -> from source to destination visit all path that called HamPath,
   //  Ham cycle -> after HP if there is a direct edge b/w source to last node then called as HC
   private static void printHamiltonianPathAndCycle(List<List<Edge>> edges, int source, Set<Integer> visited, String path, int toCheckFromSource) {

      visited.add(source);
      if (visited.size() == edges.size()) {
         System.out.println(path);
         return;
      }
      for (Edge edge : edges.get(source)) {
         if (!visited.contains(edge.neighbour)) {
            printHamiltonianPathAndCycle(edges, edge.neighbour, visited, path + edge.neighbour + " ", toCheckFromSource);
         }
      }
      visited.remove(source);
   }

   // ways to choose a pair from different component , in this it's 16
   private static int perfectFriends(int[][] arr) {
//      System.out.println(perfectFriends(new int[][]{{0, 1}, {2, 3}, {4, 5}, {5, 6}, {4, 6}}));
      List<List<Edge>> edges = getEdgesFromMatrix(arr, 7);
      List<List<Integer>> component = getConnectedComponent(edges);

      int combination = 0;
      for (int i = 0; i < component.size() - 1; i++) {
         for (int j = i + 1; j < component.size(); j++) {
            combination += component.get(i).size() * component.get(j).size();
         }
      }

      return combination;
   }


   //   here 0's are island and 1's are water in leetcode it's reversed
   private static void noOfIslands(int[][] matrix) {
//      noOfIslands(new int[][]{{0, 0, 1, 1, 1, 1, 1, 1},
//              {0, 0, 1, 1, 1, 1, 1, 1},
//              {1, 1, 1, 1, 1, 1, 1, 0},
//              {1, 1, 0, 0, 0, 1, 1, 0},
//              {1, 1, 1, 1, 0, 1, 1, 0},
//              {1, 1, 1, 1, 0, 1, 1, 0},
//              {1, 1, 1, 1, 1, 1, 1, 0},
//              {1, 1, 1, 1, 1, 1, 1, 0}});
      boolean[][] vis = new boolean[matrix.length][matrix[0].length];
      int count = 0;
      for (int i = 0; i < matrix.length; i++) {
         for (int j = 0; j < matrix[i].length; j++) {
            if (matrix[i][j] == 0 && !vis[i][j]) {
               travel(matrix, i, j, vis);
               count += 1;
            }
         }
      }
      System.out.println(count);
   }

   private static void travel(int[][] matrix, int source, int destination, boolean[][] vis) {

      if (source < 0 || destination < 0 || matrix.length <= source ||
              matrix[source].length <= destination || matrix[source][destination] == 1 || vis[source][destination]) {
         return;
      }

      vis[source][destination] = true;

      travel(matrix, source - 1, destination, vis);
      travel(matrix, source, destination + 1, vis);
      travel(matrix, source + 1, destination, vis);
      travel(matrix, source, destination - 1, vis);
   }

   // highly based on getConnectedComponent problem
   private static boolean isGraphConnected(List<List<Edge>> edges) {
//      System.out.println(isGraphConnected(edges));
      return getConnectedComponent(edges).size() == 1;
   }

   // working fine
   private static List<List<Integer>> getConnectedComponent(List<List<Edge>> edges) {
//      List<List<Edge>> edges = getEdgesSplitGraph(new ArrayList<>());
//      getConnectedComponent(edges);
      List<List<Integer>> res = new ArrayList<>();
      boolean[] visited = new boolean[edges.size()];
      for (int i = 0; i < edges.size(); i++) {
         if (edges.get(i).size() > 0) {
            List<Integer> li = new ArrayList<>();
            getConnectedComponentHelper(edges, i, visited, li);
            res.add(li);
         }
      }
      for (int i = res.size() - 1; i >= 0; i--) {
         if (res.get(i).size() > 0) {
            System.out.println(Arrays.toString(res.get(i).toArray()));
         } else {
            res.remove(i);
         }
      }
      return res;
   }

   private static void getConnectedComponentHelper(List<List<Edge>> edges, int source, boolean[] visited, List<Integer> path) {

      if (!visited[source]) {
         path.add(source);
      }
      visited[source] = true;
      for (Edge edge : edges.get(source)) {
         if (!visited[edge.neighbour]) {
            getConnectedComponentHelper(edges, edge.neighbour, visited, path);
         }
      }
   }

   private static Properties prop = new Properties();
   private static Queue<Properties> queue = new PriorityQueue<>();

   private static void multiSolver(List<List<Edge>> edges, int source, int destination,
                                   boolean[] visited, String path, int cost, int ceilAnchor, int floorAnchor, int kthLargest) {
//      multiSolver(edges, 0, 6, new boolean[7], 0 + "", 0, 40, 50,3);
//      System.out.println("-----------------------------------------------");
//      System.out.println(prop.ceil + " " + prop.floor);
//      System.out.println(prop.cost);
      if (source == destination) {
         if (prop.smallest > cost) {
            prop.smallest = cost;
            prop.smallestPath = path;
         }
         if (prop.largest < cost) {
            prop.largest = cost;
            prop.largestPath = path;
         }
         if (prop.ceil > ceilAnchor && cost > ceilAnchor) {
            prop.ceil = Integer.min(prop.ceil, cost);
            // we can also print path if wanted, same for floor
         }

         if (prop.floor < floorAnchor && cost < floorAnchor) {
            prop.floor = Integer.max(prop.floor, cost);
         }
         prop.cost = cost;
         queue.add(prop);
         if (queue.size() > kthLargest) {
            queue.remove();
         }
         prop.cost = queue.peek().cost;

         System.out.println(path + " @ " + cost);

         return;
      }
      visited[source] = true;
      for (Edge edge : edges.get(source)) {
         if (!visited[edge.neighbour]) {
            multiSolver(edges, edge.neighbour, destination, visited, path + " " + edge.neighbour, cost + edge.weight, ceilAnchor, floorAnchor, kthLargest);
         }
      }
      visited[source] = false;
   }

   // working fine here backtracking is used as well
   private static void printAllPath(List<List<Edge>> edges, int source, int destination,
                                    boolean[] visited, String path) {
//      printAllPath(edges, 0, 6, new boolean[7], 0 + "");
      if (source == destination) {
         System.out.println(path);
         return;
      }
      visited[source] = true;
      for (Edge edge : edges.get(source)) {
         if (!visited[edge.neighbour]) {
            printAllPath(edges, edge.neighbour, destination, visited, path + " " + edge.neighbour);
         }
      }
      visited[source] = false;
   }

   // checking if path from source 0 to destination 6 exist in graph or not
   private static boolean hasPath(List<List<Edge>> edges, int source, int destination, boolean[] visited) {
//      System.out.println(hasPath(edges, 0, 6, new boolean[7]));
      if (source == destination) {
         return true;
      }

      visited[source] = true;
      for (Edge edge : edges.get(source)) {
         if (!visited[edge.neighbour]) {
            boolean found = hasPath(edges, edge.neighbour, destination, visited);
            if (found) {
               return true;
            }
         }
      }
      return false;
   }

   private static List<List<Edge>> getEdges(List<List<Edge>> edges) {

      for (int i = 0; i < 7; i++) {
         edges.add(new ArrayList<>());
      }
      edges.get(0).add(new Edge(0, 3, 40));
      edges.get(0).add(new Edge(0, 1, 10));

      edges.get(1).add(new Edge(1, 0, 10));
      edges.get(1).add(new Edge(1, 2, 10));

      edges.get(2).add(new Edge(2, 3, 10));
      edges.get(2).add(new Edge(2, 1, 10));

      edges.get(3).add(new Edge(3, 0, 40));
      edges.get(3).add(new Edge(3, 2, 10));
      edges.get(3).add(new Edge(3, 4, 2));

      edges.get(4).add(new Edge(4, 3, 2));
      edges.get(4).add(new Edge(4, 5, 3));
      edges.get(4).add(new Edge(4, 6, 8));

      edges.get(5).add(new Edge(5, 4, 2));
      edges.get(5).add(new Edge(5, 6, 3));

      edges.get(6).add(new Edge(6, 5, 3));
      edges.get(6).add(new Edge(6, 4, 8));

//      for (List<Edge> edge : edges) {
//         for (Edge ed : edge) {
//            System.out.println(ed.source + " " + ed.neighbour + " " + ed.weight);
//         }
//      }
      return edges;
   }

   private static List<List<Edge>> getEdgesSplitGraph(List<List<Edge>> edges) {

      for (int i = 0; i < 7; i++) {
         edges.add(new ArrayList<>());
      }
      edges.get(0).add(new Edge(0, 1, 10));
      edges.get(2).add(new Edge(2, 3, 10));
      edges.get(4).add(new Edge(4, 5, 10));
      edges.get(5).add(new Edge(5, 6, 10));
      edges.get(4).add(new Edge(4, 6, 10));
      return edges;
   }

   private static List<List<Edge>> getEdgesFromMatrix(int[][] arr, int no) {
      List<List<Edge>> res = new ArrayList<>();
      for (int i = 0; i < no; i++) {
         res.add(new ArrayList<>());
      }
      for (int i = 0; i < arr.length; i++) {
         res.get(arr[i][0]).add(new Edge(arr[i][0], arr[i][1]));
      }
      return res;
   }
}
