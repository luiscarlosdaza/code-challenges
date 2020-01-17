package com.daza.code.sorting;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.TemporalQueries;
import java.util.Arrays;

public class Prueba {
}

class BubbleSortTest {
  public static void main(String[] args) {
    Instant start = Instant.now();
    //int[] array = {3, 5, 7, 8, 4, 2, 1, 9, 6};
    int[] array = {2, 3, 1, 6, 5, 8, 7, 9, 15};
    BubbleSort bubbleSort = new BubbleSort();
    bubbleSort.process(array);
    System.out.println(Arrays.toString(array));
    Instant finish = Instant.now();
    System.out.println(Duration.between(start, finish).toMillis());
  }
}

class InsertSortTest {
  public static void main(String[] args) {
    int[] array = {5, 4, 3, 2};
    InsertionSort insertionSort = new InsertionSort();
    insertionSort.process(array);
  }
}

class SelectionSortTest {
  public static void main(String[] args) {
    int[] array = {5, 4, 3, 2};
    SelectionSort selectionSort = new SelectionSort();
    selectionSort.process(array);
    System.out.println(Arrays.toString(array));
  }
}

class MergeSortTest {
  public static void main(String[] args) {
    int[] array = {3, 5, 4, 2, 1};
    MergeSort mergeSort = new MergeSort();
    mergeSort.process(array);
    System.out.println(Arrays.toString(array));
  }
}

class QuicksortTest {
  public static void main(String[] args) {
    Instant start = Instant.now();
    int[] array = {15, 3, 2, 1, 9, 5, 7, 8, 6};
    Quicksort quicksort = new Quicksort();
    quicksort.process(array);
    System.out.println(Arrays.toString(array));
    Instant finish = Instant.now();
    System.out.println(Duration.between(start, finish));
  }
}