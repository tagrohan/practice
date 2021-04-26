package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecursionInArrayList {
   public static void main(String[] args) {


   }

   // arraylist subsequence (don't forget to do it in bit manipulation as well)
   private static List<String> subsequence(String str) {
//      System.out.println(Arrays.toString(subsequence("abc").toArray()));
         if (str.length() == 0) {
            return List.of("");
         }
         char ch = str.charAt(0);

         List<String> subsequence = subsequence(str.substring(1));

         List<String> list = new ArrayList<>();

         for (String st : subsequence) {
            list.add(ch + st);
            list.add("" + st);   // order is not maintained here
         }
         return list;
   }

}