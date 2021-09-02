package trello;

import java.util.ArrayList;
import java.util.List;

public class Recursion {

   public static void main(String[] args) {
      combination("abc", "");
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
