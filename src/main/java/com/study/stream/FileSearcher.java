package com.study.stream;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/* - Пустой стрим: Stream.empty() // Stream<String>
   - Стрим из List: list.stream() // Stream<String>
   - Стрим из Map: map.entrySet().stream() // Stream<Map.Entry<String, String>>
   - Стрим из массива: Arrays.stream(array) // Stream<String>
   - Стрим из указанных элементов: Stream.of("a", "b", "c") // Stream<String>*/

public class FileSearcher {

  public static void main(String[] args) {

    final List<Integer> ints = new ArrayList<>();
    /*IntStream.range(0, 200)
      .parallel()
      .forEach(j -> ints.add(j));*/

    IntStream.range(0, 100)
      .parallel()
      .forEach(j -> ints.add(j));
    System.out.println("Size " + ints.size());

    int counter = 0;
    for (int i: ints) {
      System.out.println(counter + " - " +i);
      counter++;
    }

    /*IntStream.range(0, 10)
      .parallel()
      .forEach(System.out::println);*/

    /*final List<Integer> ints = new ArrayList<>();
    IntStream.range(0, 1000000)
      .parallel()
      .forEach(j -> ints.add(j));
    System.out.println("Size " + ints.size());*/

    /*List<String> list = Arrays.stream(args)
      .filter(s -> s.length() <= 2)
      .collect(Collectors.toList());

    for (String listElement:list) {
      System.out.println("args - " + listElement);
    }

    IntStream.of(120, 410, 85, 32, 314, 12)
      .filter(x -> x < 300)
      .map(x -> x + 11)
      .limit(3)
      .forEach(System.out::println);

    for (File file: searchHiddenFiles("C:\\Windows")) {
      System.out.println("Hidden file - " + file.getName());
    }

    // parallel streams
    *//*list.parallelStream()
      .filter(x -> x > 10)
      .map(x -> x * 2)
      .collect(Collectors.toList());*//*

    int i = IntStream.range(0, 10)
      .parallel()
      .map(x -> x * 10)
      .sum();

    System.out.println("i " + i);*/

  }

  public static File[] searchHiddenFiles(String filePath) {
    File[] hiddenFiles = new File(".").listFiles(File::isHidden);
    return hiddenFiles;
  }

}
