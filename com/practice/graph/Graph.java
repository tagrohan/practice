package com.practice.graph;

import java.util.ArrayList;
import java.util.List;

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
      int smallest;
      String smallestPath;
      int largest;
      String largestPath;
      int ceil;
      String ceilPath;
      int floor;
      String floorPath;
      int kth;
      String kthPath;

      @Override
      public int compareTo(Properties o) {
         return this.kth - o.kth;
      }
   }

   public static void main(String[] args) {
      List<List<Edge>> edges = getEdges(new ArrayList<>());

//      System.out.println(hasPath(edges, 0, 6, new boolean[7]));
      multiSolver(edges, 0, 6, new boolean[7], 0 + "", 0);
   }
   // todo: will do it later
   private static void multiSolver(List<List<Edge>> edges, int source, int destination, boolean[] visited, String path, int cost) {
      if (source == destination) {
         System.out.println(path + " @ " + cost);
         return;
      }
      visited[source] = true;
      for (Edge edge : edges.get(source)) {
         if (!visited[edge.neighbour]) {
            multiSolver(edges, edge.neighbour, destination, visited, path + " " + edge.neighbour, cost + edge.weight);
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
}
