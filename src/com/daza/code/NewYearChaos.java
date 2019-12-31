package com.daza.code;

//https://www.youtube.com/watch?v=YWYF6bOhPW8
//https://stackabuse.com/sorting-algorithms-in-java/
public class NewYearChaos {
  private static final int MAXIMUM_BRIBES = 2;
  private static final String CHAOTIC = "Too chaotic";

  public void minimumBribes(int[] queue) {
    if (isChaotic(queue)) {
      System.out.println(CHAOTIC);
      return;
    }
    int amountOfBribes = getAmountOfBribes(queue);
    System.out.println(amountOfBribes);
  }

  //Time complexity O(n^2) - Bubble Sort
//  private int getAmountOfBribes(int[] queue) {
//    int amountOfBribes = 0;
//    for (int i=0; i<queue.length-1; i++) {
//      for (int j=i+1; j<queue.length; j++) {
//        if (queue[i] > queue[j]) {
//          amountOfBribes++;
//          int temporal = queue[i];
//          queue[i] = queue[j];
//          queue[j] = temporal;
//        }
//      }
//    }
//    return amountOfBribes;
//  }

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
}
