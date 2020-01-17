package com.daza.code;

import java.util.ArrayList;
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

class FrequencyQueriesTest {
  public static void main(String[] args) {
    List<Integer> value1 = Arrays.asList(1,1);
    List<Integer> value2 = Arrays.asList(1,2);
    List<Integer> value3 = Arrays.asList(1,3);
    List<Integer> value4 = Arrays.asList(1,3);
    List<Integer> value5 = Arrays.asList(3,2);
    List<Integer> value6 = Arrays.asList(3,3);
    List<Integer> value7 = Arrays.asList(3,3);
    List<Integer> value8 = Arrays.asList(3,1);
    List<List<Integer>> values = new ArrayList<>();
    values.add(value1);
    values.add(value2);
    values.add(value3);
    values.add(value4);
    values.add(value5);
    values.add(value6);
    values.add(value7);
    values.add(value8);

    FrequencyQueries frequencyQueries = new FrequencyQueries();
    List<Integer> result = frequencyQueries.process(values);
    result.forEach(System.out::print);
  }
}

class ArrayManipulationTest {

  public static void main(String[] args) {
    int arrayLength = 5;
    int[][] queries = new int[][] {{1, 2, 100}, {2, 5, 100}, {3, 4, 100}};
    ArrayManipulation clazz = new ArrayManipulation();
    long result = clazz.process(arrayLength, queries);
    //long result = clazz.processv2(arrayLength, queries);
    System.out.println(result);
  }
}

class NewYearChaosTest {
  public static void main(String[] args) {
    //int[] queueWithBribes = {2, 1, 5, 3, 4};
    int[] queueWithBribes = {2, 5, 1, 3, 4};
    //int[] queueWithBribes = {1, 2, 5, 3, 7, 8, 6, 4};
    NewYearChaos newYearChaos = new NewYearChaos();
    //newYearChaos.minimumBribes(queueWithBribes);
    newYearChaos.process2(queueWithBribes);
    System.out.println(Arrays.toString(queueWithBribes));

//    int[] queueWithBribes = {1, 2, 7, 3, 5, 8, 6, 4};
//    int[] queueWithBribes = {1, 2, 3, 7, 5, 8, 6, 4};
//    int[] queueWithBribes = {1, 2, 3, 7, 5, 4, 6, 8};
//    int[] queueWithBribes = {1, 2, 3, 7, 5, 6, 4, 8};

  }
}