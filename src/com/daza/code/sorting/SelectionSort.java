package com.daza.code.sorting;

public class SelectionSort {
  public void process(int[] array) {
    for (int i=0; i<array.length; i++) {
      int minimum = array[i];
      int minIndex = i;
      for (int j=i+1; j<array.length; j++) {
        if (array[j] < minimum) {
          minimum = array[j];
          minIndex = j;
        }
        //Swapping
        int temp = array[i];
        array[i] = minimum;
        array[minIndex] = temp;
      }
    }
  }
}
