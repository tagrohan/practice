package trello;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recursion {

   public static void main(String[] args) {

      nQueens(0, "", new int[4][4]);
   }

   private static void nQueens(int row, String psf, int[][] visited) {
      if (row == visited.length) {
         System.out.println(psf);
         return;
      }

      for (int col = 0; col < visited.length; col++) {
         if (isQueenSafe(visited, row, col)) {
            visited[row][col] = 1;
            nQueens(row + 1, psf + row + "x" + col + " ", visited);
            visited[row][col] = 0;
         }
      }
   }

   private static boolean isQueenSafe(int[][] visited, int row, int col) {

      for (int i = row - 1; i >= 0; i--) { // for row
         if (visited[i][col] == 1) return false;
      }
      for (int i = col - 1; i >= 0; i--) { // for column
         if (visited[row][i] == 1) return false;
      }
      for (int i = row - 1, j = col + 1; i >= 0 && j < visited[0].length; i--, j++) { // right reverse diagonal
         if (visited[i][j] == 1) return false;
      }
      for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) { // left reverse diagonal
         if (visited[i][j] == 1) return false;
      }
      return true;
   }

   private static void floodFill(int[][] flood, String psf, int row, int col, int[][] dp) {

//      floodFill(new int[][]{
//              {0, 1, 0, 0},
//              {0, 0, 0, 0},
//              {1, 0, 1, 0},
//              {1, 0, 0, 0}}, "", 0, 0, new int[4][4]);
      if (row < 0 || col < 0 || row > flood.length - 1 || col > flood[0].length - 1 || flood[row][col] == 1) return;
      if (dp[row][col] == 1) return;
      if (row == flood.length - 1 && col == flood[0].length - 1) {
         System.out.println(psf);
      }

      dp[row][col] = 1;
      floodFill(flood, psf + "u", row - 1, col, dp);
      floodFill(flood, psf + "r", row, col + 1, dp);
      floodFill(flood, psf + "d", row + 1, col, dp);
      floodFill(flood, psf + "l", row, col - 1, dp);
      dp[row][col] = 0;
   }

   // todo will do it in DP
   private static boolean targetSumDp(int[] arr, int sum) {
      int len = arr.length;
      boolean[][] dp = new boolean[len + 1][sum + 1];
      for (int i = 0; i <= len; i++) {
         for (int j = 0; j <= sum; j++) {
            if (j == 0 && i == 0) dp[i][j] = true;
            else if (j == 0) dp[i][j] = false;
            else if (i == 0) dp[i][j] = true;
            else if (arr[i - 1] <= j) {
               dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
            } else {
               dp[i][j] = dp[i - 1][j];
            }
         }
      }
      return dp[len][sum];
   }

   private static void subsetSum(int[] arr, int sum, String vsf, int ssf, int idx) {
//      subsetSum(new int[]{1, 2, 3, 4, 5}, 5, "", 0, 0);
      if (sum == ssf) {
         System.out.print(vsf + ", ");
         return;
      } else if (arr.length == idx) return;

      subsetSum(arr, sum, arr[idx] + " " + vsf, arr[idx] + ssf, idx + 1);
      subsetSum(arr, sum, vsf, ssf, idx + 1);
   }


   private static void printPermutation(String str, String ssf) {
//      printPermutation("abc", "");
      if (str.length() == 0) {
         System.out.print(ssf + " ");
      }

      for (int i = 0; i < str.length(); i++) {
         char ch = str.charAt(i);
         printPermutation(str.substring(0, i) + str.substring(i + 1), ssf + ch);
      }
   }


   private static void printMazePath(int startRow, int startCol, int endRow, int endCol, String path) {
//      printMazePath(1, 1, 3, 3, "");
      if (startRow == endRow && startCol == endCol) {
         System.out.print(path + " ");
         return;
      } else if (startRow > endRow || startCol > endCol) return;

      printMazePath(startRow, startCol + 1, endRow, endCol, path + "H");
      printMazePath(startRow + 1, startCol, endRow, endCol, path + "V");
   }

   private static void stairPath(int stairs, String path) {
//      stairPath(5, "");
      if (stairs == 1) {
         System.out.print(path + " ");
         return;
      } else if (stairs < 0) {
         return;
      }

      stairPath(stairs - 1, path + "1");
      stairPath(stairs - 2, path + "2");
      stairPath(stairs - 3, path + "3");

   }

   private static final String[] str = {".;", "abc", "def", "ghi", "jkl", "mnop", "qrst", "uv", "wxyz"};

   private static void printKpc(String num, String psf) {
//      printKpc("127", "");
      if (num.length() == 0) {
         System.out.print(psf + " ");
         return;
      }
      int startNumber = num.charAt(0) - '0';
      String startString = str[startNumber];
      for (int i = 0; i < startString.length(); i++) {
         printKpc(num.substring(1), psf + startString.charAt(i));
      }
   }

   private static void printSubsequence(String str, String psf) {

//      printSubsequence("abc", "");
//      System.out.println(Arrays.toString(getSubsequence("abc").toArray()));
      if (str.length() == 0) {
         System.out.print(psf + ", ");
         return;
      }

      char ch = str.charAt(0);
      printSubsequence(str.substring(1), psf);
      printSubsequence(str.substring(1), psf + ch);

   }

   // using dp we solved maze path that gives number
   private static int getMazePathNo(int row, int col) {
//      System.out.println(getMazePathNo(3, 3));
      int[][] dp = new int[row + 1][col + 1];
      for (int i = 1; i <= row; i++) {
         for (int j = 1; j <= col; j++) {
            if (i == 1 || j == 1) {
               dp[i][j] = 1;
            } else {
               dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
         }
      }
      return dp[row][col];
   }

   private static List<String> getMazePath(int startRow, int startCol, int row, int col) {

      if (startRow == row && startCol == col)
         return List.of("");
      else if (startRow > row || startCol > col) return List.of();

      List<String> horizontal = getMazePath(startRow, startCol + 1, row, col);
      List<String> vertical = getMazePath(startRow + 1, startCol, row, col);
      List<String> paths = new ArrayList<>();

      for (String path : horizontal) {
         paths.add("H" + path);
      }
      for (String path : vertical) {
         paths.add("V" + path);
      }
      return paths;
   }

   private static int getStairWays(int numOfStairs) {
      int[] dp = new int[numOfStairs + 1];
      dp[0] = 1;
      dp[1] = 1;
      dp[2] = 2;
      for (int i = 3; i <= numOfStairs; i++) {
         dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
      }
      System.out.println(Arrays.toString(dp));
      return dp[numOfStairs];
   }

   private static List<String> getPaths(int numOfStairs) {
//      System.out.println(Arrays.toString(getPaths(5).toArray()));
      if (numOfStairs == 0) {
         return List.of("");
      } else if (numOfStairs < 0) {
         return new ArrayList<>();
      }

      List<String> one = getPaths(numOfStairs - 1);
      List<String> two = getPaths(numOfStairs - 2);
      List<String> three = getPaths(numOfStairs - 3);
      List<String> res = new ArrayList<>();

      for (String oneS : one) {
         res.add(1 + oneS);
      }
      for (String twoS : two) {
         res.add(2 + twoS);
      }
      for (String threeS : three) {
         res.add(3 + threeS);
      }
      return res;
   }

//   private static final String[] str = {"abc", "def", "ghi", "jkl", "mnop", "qrst", "uv", "wxyz", ".;", "?!"};

   private static List<String> kyp(String num) {// 123
//      System.out.println(Arrays.toString(kyp("16").toArray()));
      if (num.length() == 0) {
         return List.of("");
      }
      char ch = num.charAt(0);//1
      List<String> rest = kyp(num.substring(1)); // 23
      List<String> result = new ArrayList<>();
      String currentString = str[ch - '0'];
      for (int i = 0; i < currentString.length(); i++) {
         for (String str : rest) {
            result.add(currentString.charAt(i) + str);
         }
      }
      return result;
   }


   private static void combination(String str, String csf) {
      if (str.length() == 0) {
         System.out.print(csf + " - ");
      }

      for (int i = 0; i < str.length(); i++) {
         char ch = str.charAt(i);
         combination(str.substring(0, i) + str.substring(i + 1), csf + ch);
      }

   }


   private static List<String> getSubsequence(String str) {
//      System.out.println(getSubsequence("abc").toString());
      if (str.length() == 0) {
         return List.of("");
      }

      char ch = str.charAt(0);
      List<String> shortString = getSubsequence(str.substring(1));
      List<String> soFar = new ArrayList<>();
      for (String ss : shortString) {
         soFar.add(ss);
         soFar.add(ch + ss);
      }
      return soFar;
   }

   private static int[] allIndexesV2(int[] arr, int idx, int key, int no) {
//      System.out.println(Arrays.toString(allIndexesV2(new int[]{1, 3, 4, 3, 3, 5}, 0, 3, 0)));
      if (arr.length == idx) {
         return new int[no]; // no = 3
      }

      if (arr[idx] == key) {
         no++;
      }
      int[] indexes = allIndexesV2(arr, idx + 1, key, no);
      if (arr[idx] == key) {
         indexes[--no] = idx;
      }
      return indexes;
   }


   private static List<Integer> list = new ArrayList<>();

   private static void allIndexes(int[] arr, int idx, int key) {

//      allIndexes(new int[]{1, 3, 4, 3, 3, 5}, 0, 3);
//      System.out.println(Arrays.toString(list.toArray()));
      if (arr.length == idx) {
         return;
      }
      if (arr[idx] == key) list.add(idx);

      allIndexes(arr, idx + 1, key);
   }

   private static int findFromLast(int[] arr, int idx, int key) {
//      System.out.println(findFromLast(new int[]{1, 3, 4, 4, 3, 5}, 0, 3));
      if (arr.length - 1 == idx) {
         if (arr[idx] == key) {
            return idx;
         } else return -1;
      }

      int index = findFromLast(arr, idx + 1, key);
      if (index == -1) {
         if (arr[idx] == key) return idx;
      }
      return index;
   }

   // working fine bro
   private static void towerOfHanoi(int source, int helper, int destination, int number) {
//      towerOfHanoi(1, 2, 3, 3);
      if (number == 1) {
         System.out.println(source + " -> " + destination);
         return;
      }

      towerOfHanoi(source, destination, helper, number - 1);
      System.out.println(source + " -> " + destination);
      towerOfHanoi(helper, source, destination, number - 1);
   }

   private static int maxAndMin(int[] arr, int idx) {
//      System.out.println(maxAndMin(new int[]{1, 2, 4, 3, 200, 13, 64}, 0));
      if (arr.length == idx) {
         return arr[idx - 1];
      }
      int cMax = maxAndMin(arr, idx + 1);
      return Math.min(arr[idx], cMax); // Math.max() for max
   }


   // working with O(Log n)
   private static int powerOn2(int value, int power) {
      if (power <= 0) return 1;

      int cVal = powerOn2(value, power / 2);
      cVal *= cVal;
      if (power % 2 == 1) {
         cVal *= value;
      }
      return cVal;
   }


   // it's a O(n) we have O(log n as well) check up
   private static int powerOn(int value, int power) {
      if (power <= 0) return 1;

      return value * powerOn(value, power - 1);
   }

   private static int factorial(int value) {
      if (value == 1) {
         return value;
      }
      return value * factorial(value - 1);
   }
}
