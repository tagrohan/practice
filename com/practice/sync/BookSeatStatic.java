package com.practice.sync;

public class BookSeatStatic extends Thread {
   int seat;
   private static int totalSeats = 10;

   @Override
   public void run() {
      bookSeat(seat);
   }

   public static void main(String[] args) {
      BookSeatStatic seatStatic = new BookSeatStatic();
      BookSeatStatic seatStatic2 = new BookSeatStatic();
      BookSeatStatic seatStatic3 = new BookSeatStatic();
      seatStatic.seat = 7;
      seatStatic2.seat = 7;

      seatStatic.start();
      seatStatic2.start();
      seatStatic3.start();

   }

   private static synchronized void bookSeat(int seats) {
      if (totalSeats >= seats) {
         totalSeats -= seats;
         System.out.println(seats + " seat booked");
         System.out.println(totalSeats + " seats left");
      } else {
         System.out.println("not sufficient seats");
      }

   }
}
