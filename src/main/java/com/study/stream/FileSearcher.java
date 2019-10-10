package com.study.stream;

import java.io.File;
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

    List<String> list = Arrays.stream(args)
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
  }

  public static File[] searchHiddenFiles(String filePath) {
    File[] hiddenFiles = new File(".").listFiles(File::isHidden);
    return hiddenFiles;
  }

}
