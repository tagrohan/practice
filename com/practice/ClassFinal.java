package com.practice;

class Official extends Thread {
   @Override
   public void run() {
      try {
         System.out.println("officer sign");
         Thread.sleep(3000);
         System.out.println("officer sign done");
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }
}

class TestDrive extends Thread {
   @Override
   public void run() {
      try {
         System.out.println("TestDrive started");
         Thread.sleep(3000);
         System.out.println("TestDrive completed");
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }
}


public class ClassFinal extends Thread {

   public static void main(String[] args) throws InterruptedException {
      ClassFinal cl = new ClassFinal();
      TestDrive td = new TestDrive();
      Official of = new Official();
      cl.start();
      cl.join();
      td.start();
      td.join();
      of.start();

   }

   @Override
   public void run() {
      try {
         System.out.println("Medical started");
         Thread.sleep(3000);
         System.out.println("Medical completed");
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }
}
