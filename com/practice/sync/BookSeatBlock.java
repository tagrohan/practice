package com.practice.sync;


class OrderSeats {
   private int seatsLeft = 10;

   void bookSeat(int seats) {
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

public class BookSeatBlock extends Thread {
   private int seatsReq;
   static OrderSeats orderSeats;

   @Override
   public void run() {
      orderSeats.bookSeat(seatsReq);
   }

   public static void main(String[] args) {
      orderSeats = new OrderSeats();
      BookSeatBlock seats1 = new BookSeatBlock();
      BookSeatBlock seats2 = new BookSeatBlock();
      seats1.seatsReq = 7;
      seats2.seatsReq = 7;
//      bookSeat(seats1.seatsReq);
//      bookSeat(seats2.seatsReq);
      seats1.start();
      seats2.start();
   }

}
