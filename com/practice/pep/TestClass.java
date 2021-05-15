package com.practice.pep;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class TestClass {
   public static void main(String args[]) throws Exception {

//      2 qwopwasp
//      wdw
//      abco
      //Scanner
      Scanner scan = new Scanner(System.in);

      Map<String, Integer> map = new HashMap<>();

      int team = scan.nextInt();

      String[] regex = scan.nextLine().trim().split("");


      for (int i = 0; i < regex.length; i++) {
         if (map.containsKey(regex[i])) {
            int val = map.get(regex[i]);
            map.put(regex[i], val + 1);
         } else {
            map.put(regex[i], 1);
         }

      }

      int score = 0;
      Map<Integer, Integer> teamScore = new HashMap<>();
      for (int i = 1; i <= team; i++) {
         String[] toCheck = scan.nextLine().split("");
         for (int j = 0; j < toCheck.length; j++) {
            if (map.containsKey(toCheck[j])) {
               score += map.get(toCheck[j]);
            }
         }
         teamScore.put(i, score);
         score = 0;
      }

      int max = -1;
      int keys = -1;
      for (Integer key : teamScore.keySet()) {
         if (teamScore.get(key) > max) {
            max = teamScore.get(key);
            keys = key;
         }
      }
      System.out.println(keys);


      // Write your code here


   }
}
