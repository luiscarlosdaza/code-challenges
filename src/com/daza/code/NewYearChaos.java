package com.daza.code;

//https://stackabuse.com/sorting-algorithms-in-java/
public class NewYearChaos {
  private static final int MAXIMUM_BRIBES = 2;
  private static final String CHAOTIC = "Too chaotic";

  /**
   * ========================== SOLUTION 1 O(n^2) - Bubble Sort ===========================
   */
  public void minimumBribes(int[] queue) {
    if (isChaotic(queue)) {
      System.out.println(CHAOTIC);
      return;
    }
    int amountOfBribes = getAmountOfBribes(queue);
    System.out.println(amountOfBribes);
  }

  private int getAmountOfBribes(int[] queue) {
    int amountOfBribes = 0;
    for (int i=0; i<queue.length-1; i++) {
      for (int j=i+1; j<queue.length; j++) {
        if (queue[i] > queue[j]) {
          amountOfBribes++;
          int temporal = queue[i];
          queue[i] = queue[j];
          queue[j] = temporal;
        }
      }
    }
    return amountOfBribes;
  }

  private boolean isChaotic(int[] queue) {
    for (int index=1; index<=queue.length; index++) {
      int value = queue[index-1];
      if (value > index + MAXIMUM_BRIBES) { //value < index - MAXIMUM_BRIBES || value > index + MAXIMUM_BRIBES
        return true;
      }
    }

    return false;
  }

  /**
   * ========================== SOLUTION 2 O(n) ===========================
   */
  //https://www.youtube.com/watch?v=YWYF6bOhPW8
  public void process2(int[] queue) {
    int bribes = 0;
    for (int i=queue.length-1; i>0; i--) {
      int expectedValue = i+1;
      if(queue[i] != expectedValue) {
        if ((i-1 >= 0) && queue[i-1] == expectedValue) {
          swap(queue, i, i-1);
          bribes++;
        } else if ((i-2 >= 0) && queue[i-2] == expectedValue) {
          swap(queue, i-2, i-1);
          swap(queue, i-1, i);
          bribes += 2;
        } else {
          System.out.println(CHAOTIC);
          return;
        }
      }
    }
    System.out.println(bribes);
  }

  private void swap(int[]array, int index1, int index2) {
    int temporal = array[index1];
    array[index1] = array[index2];
    array[index2] = temporal;
  }
}
