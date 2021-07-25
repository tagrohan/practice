package com.practice.sync;

public class Single {

   private Single() {
      // for reflection api's, throwing error
      throw new RuntimeException("Can't be initialize");
   }

   private static volatile Single single;

   public static Single getInstance() {
      if (single == null) {
         synchronized (Single.class) {
            if (single == null) {
               single = new Single();
            }
         }
      }
      return single;
   }
}
