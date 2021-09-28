package com.practice.graph;

import java.io.*;
import java.util.*;


public class TestClass {
    // have to rewamp
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter wr = new PrintWriter(System.out);
      int T = Integer.parseInt(br.readLine().trim());
      for(int t_i = 0; t_i < T; t_i++)
      {
         int n = Integer.parseInt(br.readLine().trim());
         String[] arr_w = br.readLine().split(" ");
         int[] w = new int[n];
         for(int i_w = 0; i_w < arr_w.length; i_w++)
         {
            w[i_w] = Integer.parseInt(arr_w[i_w]);
         }
         int x = Integer.parseInt(br.readLine().trim());
         int[][] edges = new int[n-1][2];
         for(int i_edges = 0; i_edges < n-1; i_edges++)
         {
            String[] arr_edges = br.readLine().split(" ");
            for(int j_edges = 0; j_edges < arr_edges.length; j_edges++)
            {
               edges[i_edges][j_edges] = Integer.parseInt(arr_edges[j_edges]);
            }
         }

         long out_ = xor_paths(n, w, x, edges);
         System.out.println(out_);

      }

      wr.close();
      br.close();
   }
   static long xor_paths(int n, int[] w, int x, int[][] edges){
      // Write your code here


      System.out.println(edges[1][1]);


      long result = 0;

      return result;

   }
}
