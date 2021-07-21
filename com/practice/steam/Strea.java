package com.practice.steam;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Strea {

   public static void main(String[] args) {

      String[] names = {"Rohan", "PayTm", "PayTm money", "etc"};

      Stream<String> stream = Stream.of(names);

//      stream.forEach(e -> System.out.println(e));

      List<String> data = stream.filter(e -> e.startsWith("P")).collect(Collectors.toList());

      data.forEach(e -> System.out.println(e));

   }
}
