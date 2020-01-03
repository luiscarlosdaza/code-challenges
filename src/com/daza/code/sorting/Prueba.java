package com.daza.code.sorting;

import java.util.Arrays;

public class Prueba {
}

class BubbleSortTest {
  public static void main(String[] args) {
    int[] array = {3, 5, 7, 8, 4, 2, 1, 9, 6};
    BubbleSort bubbleSort = new BubbleSort();
    bubbleSort.process(array);
    System.out.println(Arrays.toString(array));
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