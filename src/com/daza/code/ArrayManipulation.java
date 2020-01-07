package com.daza.code;

import java.util.Arrays;

//https://www.hackerrank.com/challenges/crush/problem
public class ArrayManipulation {

  /**
   * Time complexity: O(nm) + O(n) = 0(nm).
   */
  public long process(int arrayLength, int[][] queries) {
    long maxNumber = Long.MIN_VALUE;
    long[] array = new long[arrayLength + 1];
    for (int i = 0; i < queries.length; i++) {
      int initialIndex = queries[i][0];
      int endingIndex = queries[i][1];
      long value = queries[i][2];
      for (int j = initialIndex; j <= endingIndex; j++) {
        array[j] += value;
        if (maxNumber < array[j]) {
          maxNumber = array[j];
        }
        System.out.printf("Column %d: %s%n", j, Arrays.toString(array));
      }
    }

    return maxNumber;
  }

  /**
   * Time complexity: O(n+m).
   * https://www.youtube.com/watch?v=hDhf04AJIRs
   */
  public long processv2(int arrayLength, int[][] queries) {
    long[] outputArray = new long[arrayLength + 2];
    for (int i = 0; i < queries.length; i++) {
      int initialIndex = queries[i][0];
      int finalIndex = queries[i][1];
      int value = queries[i][2];
      outputArray[initialIndex] += value;
      outputArray[finalIndex + 1] -= value;
    }
    System.out.printf("First array modification: %s%n", Arrays.toString(outputArray));
    long max = getMax(outputArray);
    System.out.printf("Sum prefix : %s%n", Arrays.toString(outputArray));

    return max;
  }

  private long getMax(long[] outputArray) {
    long prefixSum = 0;
    long max = Long.MIN_VALUE;
    for (int i = 0; i < outputArray.length; i++) {
      prefixSum += outputArray[i];
      max = Math.max(max, prefixSum);
      outputArray[i] = prefixSum; //This line is because I want to modify the array to see the Prefix Sum changes.
    }

    return max;
  }
}
