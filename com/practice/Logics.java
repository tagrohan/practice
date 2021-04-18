package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Logics {

   public static void main(String[] args) {

      System.out.println(Arrays.toString(sumBy1(new int[]{9,9,9,9})));
   }

   private static int[] sumBy1(int[] arr) {
//      System.out.println(Arrays.toString(sumBy1(new int[]{9,9,9,9})));
//      https://leetcode.com/problems/plus-one/
      int len = arr.length;

      for (int i = len - 1; i >= 0; i--) {
         if (arr[i] < 9) {
            arr[i] += 1;
            return arr;
         }
         arr[i] = 0;
      }
      int[] resultArr = new int[len + 1];
      resultArr[0] =1;

      return resultArr;
   }

   private static void primeNumberSieveOfEratosthenes(int num) {
      boolean[] bool = new boolean[num + 1];
      // todo : working on it tomorrow
//      for (int i = 0; i < ; i++) {
//
//      }
   }

   private static boolean isPrime(int var) {
      for (int i = 2; i * i <= var; i++) {
         if (var % i == 0) {
            return false;
         }
      }
      return true;
   }

   private static void primeNumberDiffMethod(int num) {
      int isPrime = 0;
      for (int i = 2; i < num; i++) {
         for (int j = 2; j < num; j++) {
            if (i % j == 0) {
               isPrime += 1;
               if (isPrime > 1) {
                  break;
               }
            }
         }
         if (isPrime == 1) {
            System.out.print(i + " ");
         }
         isPrime = 0;
      }
   }


   private static int occurrenceNBy2UsingMooreVoting(int[] arr) {
//      System.out.println(occurrenceNBy2UsingMooreVoting(new int[]{3, 3, 4}));

      int result = 0, count = 0;

      for (int var : arr) {
         if (count == 0) result = var;
         count += (var == result) ? 1 : -1;
      }
      return result;


      // moore voting algorithm to understand

//      int result = 0, count = 0;
//
//      for (int var : arr) {
//         if (count == 0) result = var;
//         if (result == var) count += 1;
//         else count -= 1;
//      }
//      return result;


      // using moore voting here
      // https://leetcode.com/problems/majority-element/
      // Given an array nums of size n, return the majority element.

   }

   // https://leetcode.com/problems/majority-element/
   // Given an array nums of size n, return the majority element.
   private static int occurrenceNBy2(int[] arr) {
      Map<Integer, Integer> map = new HashMap<>();

      for (int var : arr) {
         if (map.containsKey(var)) {
            map.put(var, map.get(var) + 1);
         } else {
            map.put(var, 1);
         }
      }
      int len = arr.length / 2;
      for (int key : map.keySet()) {
         if (map.get(key) > len) {
            return key;
         }
      }
      return -1;
   }

   private static int kadaneWithIndex(int[] arr) {
      int sum = arr[0], max = arr[0];
      int start = 0, end = 0;
      if (arr.length == 1) {
         return arr[0];
      }
      for (int i = 1; i < arr.length; i++) {
         sum += arr[i];
         if (sum <= 0) {
            start = i;
         }
         if (sum > max) {
            end = i;
         }
      }

      System.out.println((start + 1) + " " + (end + 1));
      return max;
   }


   private static int dynamicKadane(int[] arr, int toCheck) {
      return -1;
   }


   static int kadane_algo(int[] arr) {
      // kadane's algo for -ve numbers

      if (arr.length == 1) {
         return arr[0];
      }
      int sum = arr[0], ans = arr[0];
      for (int i = 1; i < arr.length; i++) {
         sum = Integer.max(sum + arr[i], arr[i]);
         ans = Integer.max(sum, ans);
      }
      return ans;
   }

   public static int kthSmallest(int[] arr, int k) {
      Arrays.sort(arr);
      return arr[k - 1];
   }


   private static void GFGDiagonal(String var) {
      int newVal = Integer.valueOf(var);
      int sum = 0;
      while (newVal > 0) {
         sum = sum * 10 + newVal % 10;
         newVal = newVal / 10;
      }
      System.out.println(sum);

   }


   private static void GFG(String str) {
      Set<Character> set = new LinkedHashSet<>();

      for (char val : str.toCharArray()) {
         if (set.contains(val)) {
            set.remove(val);
         } else {
            set.add(val);
         }
      }
      System.out.println(set.toArray()[0]);
   }

   private static int[] te(int[] digits) {
      int len = digits.length - 1;
      int sum = digits[len] + 1;
      if (sum < 9) {
         digits[len] += 1;
         return digits;
      }
      digits[len] = 0;
      int[] nums = new int[digits.length + 1];
      nums[0] = 1;
      return nums;
   }


   static String reverse(Object var) {
      String reverse = "";
      if (var instanceof String) {
         reverse = "string";
      } else {
         reverse = " integer";
         var = (int) var + 1;
         System.out.println(var);
      }

      return reverse;
   }


   // kadane's algo working
   public static void maxSumSubArrayKadaneAlgo(int[] arr) {
//      maxSumSubArrayKadaneAlgo(new int[]{1,4,-6,7,4});
      int max = arr[0], sum = 0;
      for (int i = 0; i < arr.length; i++) {
         sum += arr[i];
         if (sum < 0) {
            sum = 0;
         }
         max = Integer.max(sum, max);
      }
      System.out.println(max);
   }

   // goes to O(n^2) // so we use kadane's algo (pardon misspell)
   public static void maxSumSubArray(int[] arr) {
      int max = arr[0], sum = 0;
      for (int i = 0; i < arr.length; i++) {
         for (int j = i; j < arr.length; j++) {
            sum += arr[j];
            max = Integer.max(sum, max);
         }
         sum = 0;
      }
      System.out.println(max);
   }

   public static int removeDuplicates(int[] nums) {
//        removeDuplicates(new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 });
      Set<Integer> set = new LinkedHashSet<>();

      for (int var : nums) {
         set.add(var);
      }

      Object[] obj = set.toArray();
      for (int i = 0; i < obj.length; i++) {
         nums[i] = (int) obj[i];
      }

      return set.size();
   }

   private static int lowestPositiveMissing(int arr[], int size) {

      // not optimized
      // System.out.println(lowestPositiveMissing(new int[] { 1, 2, 3, 4, 5 }, 5));
      Map<Integer, Boolean> map = new LinkedHashMap<>();
      for (int i = 1; i <= 1e6 + 2; i++) {
         map.put(i, true);
      }

      for (int i = 0; i < arr.length; i++) {
         if (map.get(arr[i]) != null) {
            map.remove(arr[i]);
         }
      }
      for (int i : map.keySet()) {
         System.out.println(i);
         break;
      }

      return -1;

      // Map<Integer, Boolean> map = new LinkedHashMap<>();
      // for (int i = 1; i < arr.length; i++) {
      // map.put(i, true);
      // }

      // for (int i = 0; i < arr.length; i++) {
      // if (map.get(arr[i]) != null) {
      // map.remove(arr[i]);
      // }
      // }
      // for (int i : map.keySet()) {
      // System.out.println(i + "->" + map.get(i));
      // break;
      // }
   }

   private static void findSubArraySum() {
      // mcrosoft, fb, google, visa
      // findSubArraySum(new int[] { 1, 2, 3, 7, 5 }, 12);
      // findSubArraySum(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 15);
      Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

      int t = scan.nextInt();
      A:
      for (int z = 0; z < t; z++) {

         int size = scan.nextInt();
         int s = scan.nextInt();
         int[] arr = new int[size];

         for (int i = 0; i < arr.length; i++) {
            arr[i] = scan.nextInt();
         }
         int sum = 0;
         for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
               sum += arr[j];
               if (sum == s) {
                  System.out.println((i + 1) + " " + (j + 1));
                  continue A;
               }
               if (sum > s) {
                  break;
               }
            }
            sum = 0;
         }
         System.out.println("not available");
      }
   }

   private static void shortestMultipleOccur(int[] arr) {

      // occurence of a integer but if 2 found print first one
      // shortestMultipleOccur(new int[] { 1, 5, 3, 4, 3, 5, 6 });
      Map<Integer, Integer> map = new LinkedHashMap<>();

      for (int i : arr) {
         Integer occur = map.get(i);
         if (occur != null) {
            map.put(i, Integer.valueOf(occur + 1));
         } else {
            map.put(i, 1);
         }
      }
      for (int i : map.keySet()) {
         if (map.get(i) > 1) {
            System.out.println(i + " -> " + map.get(i));
            break;
         }
      }

   }

   private static void frequencyCounter() {

      String[] str = {"look", "geeks"};
      Map<Character, Integer> map = new HashMap<>();

      for (String var : str) {
         for (int i = 0; i < var.length(); i++) {
            char ch = var.charAt(i);
            Integer frequency = map.get(ch);
            if (frequency != null) {
               map.put(ch, Integer.valueOf(frequency + 1));
            } else {
               map.put(ch, 1);
            }
         }
      }

      for (Character ch : map.keySet()) {
         System.out.println(ch + " -> " + map.get(ch));
      }

      // Map<String, String> map = new HashMap<>();
      // map.put("name", "value");
      // map.put("ant", "ant");
      // map.put("ant", "new value");

      // for (String str : map.keySet()) {
      // System.out.println(map.get(str));
      // }

   }

   private static int[] sum(int[] arr, int target) {
      int[] res = new int[2];
      Map<Integer, Integer> map = new HashMap<>();
      int first = Integer.MAX_VALUE;
      int last = Integer.MAX_VALUE;
      for (int i = 0; i < arr.length - 1; i++) {
         for (int j = 1; j < arr.length; j++) {
            if (arr[i] + arr[j] == target) {
               last = Integer.min(last, j);
               first = Integer.min(first, i);
               map.put(i + 1, j + 1);
            }
         }
      }
      res[0] = first;
      res[1] = last;
      for (int key : map.keySet()) {
         System.out.println(key + " -> " + map.get(key));
      }
      if (res[0] == Integer.MAX_VALUE) {
         return new int[2];
      }
      return new int[]{first, last};
   }

   private static int duplicate(int[] arr) {
      Map<Integer, Integer> map = new LinkedHashMap<>();

      for (int val : arr) {
         if (map.containsKey(val)) return val;
         else map.put(val, 1);
      }
      return -1;
   }

   public static int solve(int[] arr) {
      Map<Integer, Integer> map = new LinkedHashMap<>();

      int min = Integer.MAX_VALUE;

      for (int val : arr) {
         if (map.containsKey(val)) {
            min = Integer.min(min, map.get(val));
            map.put(val, map.get(val) + 1);
         } else map.put(val, 1);
      }

      System.out.println(min);

      for (int freq : map.keySet()) {
         if (map.get(freq) > 1) {
            return freq;
         }
      }


      return -1;
   }
}
