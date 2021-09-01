package trello;

public class Recursion {

   public static void main(String[] args) {
      System.out.println(powerOn(2, 3));
   }


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
