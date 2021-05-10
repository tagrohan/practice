package com.practice;

import java.util.Arrays;

public class RecursionBacktracking {
   public static void main(String[] args) {
      nQueensProblem(new int[][]{
              {0, 0, 0, 0},
              {0, 0, 0, 0},
              {0, 0, 0, 0},
              {0, 0, 0, 0},
      }, 0, "");
   }

   // solution is ok but won't work as recursion is very large
   // so we go with some Warnsdorff’s algorithm for Knight’s tour problem in GFG
   private static void knightTour(int[][] arr, int r, int c, int move) {
//      knightTour(new int[8][8], 2, 1, 1);
      if (r < 0 || c < 0 || r >= arr.length || c >= arr.length || arr[r][c] > 0) {
         return;
      } else if (move == arr.length * arr.length) {
         System.out.println("and to aa gye");
         for (int[] val : arr) {
            System.out.println(Arrays.toString(val));
         }
         return;
      }


      arr[r][c] = move;
      knightTour(arr, r - 2, c + 1, move + 1);
      knightTour(arr, r - 1, c + 2, move + 1);
      knightTour(arr, r + 1, c + 2, move + 1);
      knightTour(arr, r + 2, c + 1, move + 1);
      knightTour(arr, r + 2, c - 1, move + 1);
      knightTour(arr, r + 1, c - 2, move + 1);
      knightTour(arr, r - 1, c - 2, move + 1);
      knightTour(arr, r - 2, c - 1, move + 1);
      arr[r][c] = 0;
   }

   // working fine here
   private static void nQueensProblem(int[][] arr, int row, String asf) {
//      nQueensProblem(new int[][]{
//              {0, 0, 0, 0},
//              {0, 0, 0, 0},
//              {0, 0, 0, 0},
//              {0, 0, 0, 0},
//      }, 0, "");
      if (row == arr.length) {
         System.out.println(asf);
         return;
      }
      for (int col = 0; col < arr.length; col++) {
         if (isQueenSafe(arr, row, col)) {
            arr[row][col] = 1;
            nQueensProblem(arr, row + 1, asf + row + "x" + col + " ");
            arr[row][col] = 0;
         }
      }
   }

   // nQueens checking all possibilities
   private static boolean isQueenSafe(int[][] arr, int row, int col) {
      for (int i = row - 1; i >= 0; i--) {
         if (arr[i][col] == 1) {
            return false;
         }
      }
      for (int i = col - 1; i >= 0; i--) {
         if (arr[row][i] == 1) {
            return false;
         }
      }

      for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
         if (arr[i][j] == 1) {
            return false;
         }
      }

      for (int i = row - 1, j = col + 1; i >= 0 && j < arr.length; i--, j++) {
         if (arr[i][j] == 1) {
            return false;
         }
      }
      return true;

   }


   public static void floodFill(int[][] maze, int r, int c, String path, boolean[][] visited) {
//      floodFill(new int[][]{
//              {0, 0, 0},
//              {1, 0, 1},
//              {0, 0, 0}}, 0, 0, "", new boolean[3][3]); path here is (R D D R)e
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
