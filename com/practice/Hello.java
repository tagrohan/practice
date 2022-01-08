package com.practice;

public class Hello {
    public static void main(String[] args) {
        printRev(1 , 5);
    }

    // 5,4,3,2,1
    private static void printRev(int start, int end) {

        if (start > end) return;

        System.out.println(end);
        printRev(start, end - 1);

    }
}
