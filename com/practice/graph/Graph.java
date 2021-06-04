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

   public static void main(String[] args) {
      List<List<Edge>> edges = getEdges(new ArrayList<>());

//      System.out.println(hasPath(edges, 0, 6, new boolean[7]));
      printAllPath(edges, 0, 6, new boolean[7], 0 + "");
   }

   // working fine here backtracking is used as well
   private static void printAllPath(List<List<Edge>> edges, int source, int destination, boolean[] visited, String src) {
      if (source == destination) {
         System.out.println(src);
         return;
      }
      visited[source] = true;
      for (Edge edge : edges.get(source)) {
         if (!visited[edge.neighbour]) {
            printAllPath(edges, edge.neighbour, destination, visited, src + " " + edge.neighbour);
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
