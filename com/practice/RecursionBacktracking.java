package com.practice;

public class RecursionBacktracking {
   public static void main(String[] args) {
      floodFill(new int[][]{
              {0, 0, 0},
              {1, 0, 1},
              {0, 0, 0}}, 0, 0, "", new boolean[3][3]);
   }


   public static void floodFill(int[][] maze, int r, int c, String path, boolean[][] visited) {
//      floodFill(new int[][]{
//              {0, 0, 0},
//              {1, 0, 1},
//              {0, 0, 0}}, 0, 0, "", new boolean[3][3]); path here is (R D D R)
      if (r < 0 || r > maze.length - 1 || c < 0 || c > maze[0].length - 1 || maze[r][c] == 1
              || visited[r][c]) {
         return;

      }
      if (r == maze.length - 1 && c == maze[0].length - 1) {
         System.out.println(path);
         return;
      }
      visited[r][c] = true;
      floodFill(maze, r - 1, c, path + "T ", visited);
      floodFill(maze, r, c - 1, path + "L ", visited);
      floodFill(maze, r + 1, c, path + "D ", visited);
      floodFill(maze, r, c + 1, path + "R ", visited);
      visited[r][c] = false;
   }

   // print target sum in subset simple question in recursion
   public static void printTargetSumSubsets(int[] arr, int idx, String set, int sos, int tar) {
//      printTargetSumSubsets(new int[]{1, 2, 3, 4, 5}, 0, "", 0, 9);
      if (arr.length == idx) {
         if (sos == tar) {
            System.out.println(set);
         }
         return;
      }

      printTargetSumSubsets(arr, idx + 1, set + " " + arr[idx], sos + arr[idx], tar);
      printTargetSumSubsets(arr, idx + 1, set, sos, tar);
   }
}
