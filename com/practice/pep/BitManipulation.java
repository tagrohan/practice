package com.practice.pep;

public class BitManipulation {
   public static void main(String[] args) {

//      System.out.println(Integer.parseInt("11110001", 2));
//
//      System.out.println(Integer.toBinaryString(10 & ~(1 << 1)));
      toggleBit(15, 2);

   }

   public static void toggleBit(int var, int k) {
      System.out.println(Integer.toBinaryString(var));
      System.out.println(Integer.toBinaryString(var ^ (1 << k)));
   }

   public static void setBitByOne(int var, int k) {
      System.out.println(Integer.toBinaryString(var));
      System.out.println(Integer.toBinaryString(var | (1 << k)));
   }
}