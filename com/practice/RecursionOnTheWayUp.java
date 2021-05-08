package com.practice;

public class RecursionOnTheWayUp {
   public static void main(String[] args) {

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
