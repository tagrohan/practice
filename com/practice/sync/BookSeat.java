package com.practice.sync;

public class BookSeat extends Thread {
   private static int seatsLeft = 10;
   private int seatsReq = 0;

   @Override
   public void run() {
      bookSeat(seatsReq);
   }

   public static void main(String[] args) {
      BookSeat seats1 = new BookSeat();
      BookSeat seats2 = new BookSeat();
      seats1.seatsReq = 7;
      seats2.seatsReq = 7;
//      bookSeat(seats1.seatsReq);
//      bookSeat(seats2.seatsReq);
      seats1.start();
      seats2.start();
   }


   private static void bookSeat(int seats) {
      if (seatsLeft >= seats) {
         System.out.println("seat booked");
         seatsLeft -= seats;
         System.out.println("seat left " + seatsLeft);
      } else {
         System.out.println("no sufficient seats available");
      }
   }
}
