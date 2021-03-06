package com.practice.pep;

// todo : it is generally called as LO (level option style) means on the way up
// todo : 2nd one is faith expectation style means on the way down
// https://www.youtube.com/watch?v=LgFl0hsyWP8&list=TLGGv6_bg6nVfcAwODA1MjAyMQ at 1:59
public class RecursionOnTheWayUp {
   public static void main(String[] args) {
//      printEncoding("123", "");
//      System.out.println(fibonacci(1000));
//      printPermutation("abc","");

      printSubsequence("abc","");
   }

   private static int fibonacci(int n) {
      if (n == 0 || n == 1) {
         return n;
      } else {
         return fibonacci(n - 1) + fibonacci(n - 2);
      }


   }
// todo have to do it later
   private static void printEncoding(String str, String asf) {
      if (str.length() == 0) {
         System.out.println(asf);
         return;
      } else if (str.length() == 1) {
         System.out.println((char) (64 + Integer.parseInt(str)));
         return;
      } else {
         char fChar = str.charAt(0);
         if (fChar == '0') {
            return;
         }
         String ros = str.substring(1);
         printEncoding(ros, asf + (char) (64 + Integer.parseInt(fChar + "")));

      }
   }


   // working fine but it's a O(2^n) abc = 3! = 6 combination
   private static void printPermutation(String str, String res) {
//      printPermutation("abc", "");
      if (str.length() == 0) {
         System.out.println(res);
      }
      for (int i = 0; i < str.length(); i++) {
         char ch = str.charAt(i);
         printPermutation(str.substring(0, i) + str.substring(i + 1), res + ch);
      }

   }

   // will do it later or after some snacks
//   private static void printMazePathWithJump(int r, int c, int eR, int eC, String path) {
//
//      for (int h = 1; h < ; h++) {
//
//      }
//
//   }

   // it's working fine man (done in single hit)
   private static void printMazePath(int r, int c, int eR, int eC, String path) {
      if (r == eR && c == eC) {
         System.out.println(path);
      }
      if (r <= eR) {
         printMazePath(r + 1, c, eR, eC, path + " V");
      }
      if (c <= eC) {
         printMazePath(r, c + 1, eR, eC, path + " H");
      }
   }


   // working perfectly (done this one without any help yay :) )
   private static void printStairPath(int n, String path) {
//      printStairPath(4, "");
      if (n < 0) {
         return;
      }
      if (n == 0) {
         System.out.println(path);
      }

      printStairPath(n - 1, path + " " + 1);
      printStairPath(n - 2, path + " " + 2);
      printStairPath(n - 3, path + " " + 3);
   }


   // using array in this one print Kpc (not storing in list in this one)
   private static void keypad(int[] arr, int idx, String ans) {
//      keypad(new int[]{1, 2}, 0, "");
      if (arr.length == idx) {
         System.out.print("[" + ans + "],");
         return;
      }
      String keys = str[arr[idx]];
      for (int i = 0; i < keys.length(); i++) {
         keypad(arr, idx + 1, ans + keys.charAt(i));
      }
   }

   // print Kpc (not storing in list in this one)
   static String[] str = {".;", "abc", "def", "ghi", "jkl", "mnop", "qrst", "uv", "wxyz"};

   private static void keypad(String number, String ans) {
      //      keypad("12", "");
      if (number.length() == 0) {
         System.out.print("[" + ans + "],");
         return;
      }
      char ch = number.charAt(0);
      String keys = str[Integer.parseInt(ch + "")];

      for (int i = 0; i < keys.length(); i++) {
         keypad(number.substring(1), ans + keys.charAt(i));
      }
   }

   private static void printSubsequence(String str, String ans) {
      //      printSubsequence("abc", "");
      if (str.length() == 0) {
         System.out.print("[" + ans + "],");
         return;
      }

      char ch = str.charAt(0);
      String sub = str.substring(1);

      printSubsequence(sub, ans + ch);
      printSubsequence(sub, ans);
   }

}
