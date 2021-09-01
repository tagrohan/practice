package trello;

public class Recursion {

   public static void main(String[] args) {
      towerOfHanoi(1, 2, 3, 3);
   }

   // working fine bro
   private static void towerOfHanoi(int source, int helper, int destination, int number) {
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
