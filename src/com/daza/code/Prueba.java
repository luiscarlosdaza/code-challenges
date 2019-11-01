package com.daza.code;

import java.util.Arrays;
import java.util.List;

public class Prueba {
}

class FizzBuzzTest {

  public static void main(String[] args) {
    FizzBuzz fizzBuzz = new FizzBuzz();
    for (int i = 1; i <= 100; i++) {
      System.out.println(fizzBuzz.process(i));
    }
  }
}

class ReverseStringTest {
  public static void main(String[] args) {
    String input = "Hello World!!!";
    ReverseString reverseString = new ReverseString();
    System.out.println(reverseString.reverseStringWithStringBuilder(input));
    System.out.println(reverseString.reverseStringManually(input));
  }
}

class TwoSumTest {
  public static void main(String[] args) {
    TwoSum twoSum = new TwoSum();
    int[] result1 = twoSum.process1(new int[]{1, 2, 3, 4, 5}, 4);
    System.out.printf("value 1: %d value2: %d%n", result1[0], result1[1]);

    int[] result2 = twoSum.process2(new int[]{1, 2, 3, 4, 5}, 7);
    System.out.printf("value 1: %d value2: %d", result2[0], result2[1]);
  }
}

class StackTest {
  public static void main(String[] args) {
    System.out.println("Hello World!!!");
    Stack stack = new Stack(4);
    stack.push("Hello");
    stack.push("World");
    stack.push("LK");
    stack.push("!!!");
    System.out.println(stack.pop());
    System.out.println(stack.peek());
    System.out.println(stack.pop());
    System.out.println(stack.peek());
    System.out.println(stack.pop());
  }
}

class ReverseIntegerTest {

  public static void main(String[] args) {
    ReverseInteger reverseInteger = new ReverseInteger();
    long reversed = reverseInteger.reverse(1234567899);
    System.out.println(reversed);
  }
}

class CountTripletsTest {
  public static void main(String[] args) {
    int[] numbers = {1, 3, 9, 9, 27, 81};
    CountTriplets countTriplets = new CountTriplets();
    List<Long> values = Arrays.asList(new Long[]{1l, 3l, 9l, 9l, 27l, 81l});
    System.out.printf("My first solution %n");
    System.out.println(countTriplets.process1(values, 3));
    System.out.printf("My second solution %n");
    System.out.println(countTriplets.process2(values, 3));
  }
}