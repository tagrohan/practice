package com.practice.sync;


class OrderSeat {
   private int seatsLeft = 10;

   synchronized void bookSeat(int seats) {
      if (seatsLeft >= seats) {
         System.out.println("seat booked");
         seatsLeft -= seats;
         System.out.println("seat left " + seatsLeft);
      } else {
         System.out.println("no sufficient seats available");
      }
   }

}

public class BookSeat extends Thread {
   private int seatsReq;
   private static OrderSeat orderSeat;

   @Override
   public void run() {
      orderSeat.bookSeat(seatsReq);
   }

   public static void main(String[] args) {
      orderSeat = new OrderSeat();
      BookSeat seats1 = new BookSeat();
      BookSeat seats2 = new BookSeat();
      seats1.seatsReq = 7;
      seats2.seatsReq = 7;
//      bookSeat(seats1.seatsReq);
//      bookSeat(seats2.seatsReq);
      seats1.start();
      seats2.start();
   }

}
