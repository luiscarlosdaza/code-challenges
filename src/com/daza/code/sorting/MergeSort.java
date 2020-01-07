package com.daza.code.sorting;

//Explanation: https://www.geeksforgeeks.org/merge-sort/
public class MergeSort {

  public void process(int[] array) {
    mergeSort(array, 0,array.length-1);
  }

  public void mergeSort(int[] array, int left, int right) {
    if (right <= left) return;
    int middle = (left + right) / 2;
    mergeSort(array, left, middle);
    mergeSort(array, middle+1, right);
    merge(array, left, middle, right);
  }

  public void merge(int[] array, int left, int middle, int right) {
    int lengthLeft = middle - left + 1;
    int lengthRight = right - middle;

    // creating temporary subarrays
    int leftArray[] = new int [lengthLeft];
    int rightArray[] = new int [lengthRight];

    // copying our sorted subarrays into temporaries
    for (int i = 0; i < lengthLeft; i++) {
      leftArray[i] = array[left + i];
    }
    for (int i = 0; i < lengthRight; i++) {
      rightArray[i] = array[middle + i + 1];
    }
    // iterators containing current index of temp subarrays
    int leftIndex = 0;
    int rightIndex = 0;

    // copying from leftArray and rightArray back into array
    for (int i = left; i < right + 1; i++) {
      // if there are still uncopied elements in R and L, copy minimum of the two
      if (leftIndex < lengthLeft && rightIndex < lengthRight) {
        if (leftArray[leftIndex] < rightArray[rightIndex]) {
          array[i] = leftArray[leftIndex];
          leftIndex++;
        } else {
          array[i] = rightArray[rightIndex];
          rightIndex++;
        }
      } else if (leftIndex < lengthLeft) { // if all the elements have been copied from rightArray, copy the rest of leftArray
        array[i] = leftArray[leftIndex];
        leftIndex++;
      } else if (rightIndex < lengthRight) { // if all the elements have been copied from leftArray, copy the rest of rightArray
        array[i] = rightArray[rightIndex];
        rightIndex++;
      }
    }
  }
}
