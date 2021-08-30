package trello;

public class Recursion {

   public static void main(String[] args) {
      System.out.println(factorial(5));
   }

   private static int factorial(int value) {
      int val = value;
      if (value == 1) {
         return value;
      }
      return val * factorial(value - 1);
   }
}
