package com.practice.sync;

public class BookSeatBlock extends Thread {
   private static int seatsLeft = 10;
   private int seatsReq = 0;

   @Override
   public void run() {
      bookSeat(seatsReq);
   }

   public static void main(String[] args) {
      BookSeatBlock seats1 = new BookSeatBlock();
      BookSeatBlock seats2 = new BookSeatBlock();
      seats1.seatsReq = 7;
      seats2.seatsReq = 7;
//      bookSeat(seats1.seatsReq);
//      bookSeat(seats2.seatsReq);
      seats1.start();
      seats2.start();
   }


   private static void bookSeat(int seats) {
      System.out.println("called via thread");
      synchronized (BookSeatBlock.class) {
         if (seatsLeft >= seats) {
            System.out.println("seat booked");
            seatsLeft -= seats;
            System.out.println("seat left " + seatsLeft);
         } else {
            System.out.println("no sufficient seats available");
         }
      }
   }
}
