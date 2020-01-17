package com.daza.code.sorting;

public class Quicksort {

  public void process(int[] array) {
    //quickSortFirstVersion(array, 0, array.length-1);
    quickSortSecondVersion(array, 0, array.length-1);
  }

  public void quickSortFirstVersion(int[] array, int begin, int end) {
    if (end <= begin) return;
    int pivot = partition(array, begin, end);
    quickSortFirstVersion(array, begin, pivot-1);
    quickSortFirstVersion(array, pivot+1, end);
  }

  public int partition(int[] array, int begin, int end) {
    int pivot = end;
    int counter = begin;
    for (int i=begin; i<end; i++) {
      if (array[i] < array[pivot]) {
        int temp = array[counter];
        array[counter] = array[i];
        array[i] = temp;
        counter++;
      }
    }
    int temp = array[pivot];
    array[pivot] = array[counter];
    array[counter] = temp;

    return counter;
  }

  public void quickSortSecondVersion(int[] array, int left, int right) {
    if (left >= right) {
      return;
    }
    int pivot = array[(left + right) / 2];
    int index = partition(array, left, right, pivot);
    quickSortSecondVersion(array, left, index - 1);
    quickSortSecondVersion(array, index, right);
  }

  private int partition(int[] array, int left, int right, int pivot) {
    while (left <= right) {
      while (array[left] < pivot) {
        left++; //Keep moving left
      }
      while (array[right] > pivot) {
        right--; //Keep moving right
      }
      if (left <= right) {
        swap(array, left, right);
        left++;
        right--;
      }
    }
    return left;
  }

  private void swap(int[] array, int left, int right) {
    int temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }
}
