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
//      List<List<Edge>> edges = getEdges(new ArrayList<>());
      List<List<Edge>> edges = getEdgesSplitGraph(new ArrayList<>());
      getConnectedComponent(edges);

   }

   // working fine
   private static void getConnectedComponent(List<List<Edge>> edges) {
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
      for (List<Integer> ints : res) {
         if (ints.size() > 0) {
            System.out.println(Arrays.toString(ints.toArray()));
         }
      }
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

   private static void multiSolver(List<List<Edge>> edges, int source, int destination, boolean[] visited, String path, int cost, int ceilAnchor, int floorAnchor, int kthLargest) {
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
   private static void printAllPath(List<List<Edge>> edges, int source, int destination, boolean[] visited, String path) {
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
}
