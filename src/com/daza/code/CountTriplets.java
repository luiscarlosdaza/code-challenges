package com.daza.code;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountTriplets {

  public int process1(List<Long> numbers, int ratio) {
    int result = 0;
    for (int i = 0; i < numbers.size() - 2; i++) {
      for (int j = i + 1; j < numbers.size() - 1; j++) {
        for (int z = j + 1; z < numbers.size(); z++) {
          boolean isJNextMultipleOfI = numbers.get(i) * ratio == numbers.get(j);
          boolean isZNextMultipleOfJ = numbers.get(j) * ratio == numbers.get(z);
          if (isJNextMultipleOfI && isZNextMultipleOfJ) {
            result++;
            System.out.printf("(%d,%d,%d)", i, j, z);
          }
        }
      }
    }
    System.out.println("");

    return result;
  }

  // https://fizzbuzzer.com/count-triplets/
  public long process2(List<Long> numbers, long ratio) {
    long result = 0;
    Map<Long, Long> left = new HashMap<>();
    Map<Long, Long> right = new HashMap<>();
    numbers.forEach(i -> {
      left.put(i, 0l);
      right.put(i, 0l);
    });
    numbers.forEach(i -> {
      right.put(i, right.get(i) + 1);
    });

    for (Long value : numbers) {
      if (value % ratio == 0) {
        Long numberBehind = value / ratio;
        Long numberAbove = value * ratio;
        right.put(value, right.get(value) - 1);
        if (left.containsKey(numberBehind) && right.containsKey(numberAbove)) {
          result += left.get(numberBehind) * right.get(numberAbove);
        }
      }
      left.put(value, left.get(value) + 1);
    }

    return result;
  }
}
