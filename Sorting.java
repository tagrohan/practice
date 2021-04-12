
import java.util.*;

public class Sorting {
   public static void main(String[] args) {

//      insertionSort(new int[]{3, 46, 6, 6, 5, 45, 13, 42, 23, 2, 1});

      System.out.println(Arrays.toString(sum(new int[]{4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8}, -3)));
      // 4,8
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
               map.put(i+1, j+1);
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
            map.put(val, Integer.valueOf(map.get(val) + 1));
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


   // insertion working fine
   private static void insertionSort(int[] arr) {
      for (int i = 1; i < arr.length; i++) {
         int key = arr[i];
         int j;
         for (j = i - 1; j > -1 && arr[j] > key; j--) {
            arr[j + 1] = arr[j];
         }
         arr[j + 1] = key;
      }
      System.out.println(Arrays.toString(arr));
   }


   private static void bubbleSort(int[] arr) {

      for (int i = 1; i <= arr.length; i++) {
         for (int j = 0; j < arr.length - i; j++) {
            if (arr[j] > arr[j + 1]) {
               int temp = arr[j];
               arr[j] = arr[j + 1];
               arr[j + 1] = temp;
            }
         }
      }
      System.out.println(Arrays.toString(arr));
   }

   private static void selectionSort(int[] arr) {

      for (int i = 0; i < arr.length; i++) {
         for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] < arr[i]) {
               // swapping here
               int temp = arr[i];
               arr[i] = arr[j];
               arr[j] = temp;
            }
         }

      }
      System.out.println(Arrays.toString(arr));
   }

}
