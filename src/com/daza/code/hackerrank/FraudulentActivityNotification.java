package com.daza.code;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FraudulentActivityNotification {

  public int process(int[] expenditure, int d) {
    int amountOfNotifications = 0;
    for (int i=0; i<expenditure.length; i++) {
      if (i + d >= expenditure.length) {
        break;
      }
      double medium = findMedium(expenditure, d, i);
      System.out.println("Medium: " + medium);
      int value = expenditure[i + d];
      if (value >= medium*2) {
        amountOfNotifications++;
      }
    }

    return amountOfNotifications;
  }

  private double findMedium(int[] expenditure, int days, int index) {
    int[] expenditureDays = Arrays.copyOfRange(expenditure, index, index + days);
    Arrays.sort(expenditureDays);
    if (days % 2 == 0) {//If it's even
      int indexMedium = days / 2;
      return (double) (expenditureDays[indexMedium - 1] + expenditureDays[indexMedium]) / 2;
    } else {
      int indexMedium = (int) Math.ceil((double)days/2);
      return expenditureDays[indexMedium-1];
    }
  }

  // --------------------------------------------------------------------------------------------------------------
  //!important: To find out the median value in an unsorted array, we should use Counting sort.
  // 1. Value to find out the median: array.length / 2. array.length = Amount of numbers
  // 2. We create a frequence table
  // 3. Iterate ove the frequence values adding its values. When the sum is >= (value point 1). The INDEX of the frequence table is the median.
  // Note: When the array of number's length is even, we should take two values and divide them by 2.
  private int[] frequencyTable;

  FraudulentActivityNotification() {
    frequencyTable = new int[201];
  }

  public int process2(int[] expenditure, int d) {
    double median = 0;
    int amountOfNotifications = 0;
    for (int i=0; i<expenditure.length; i++) {
      if (i < d) {
        addFrequency(expenditure[i]);
        continue;
      }
      boolean isNumberOfDaysEven = d % 2 == 0;
      if (!isNumberOfDaysEven) {
        int valueToSearch = (d + 1) / 2;
        median = getMediaFromFequencyTable(valueToSearch);
        System.out.println("Media: " + median);
      } else {
        int valueToSearch = d / 2;
        median = getMediaFromFequencyTableEvenLenght(valueToSearch);
        System.out.println("Media: " + median);
      }
      if (expenditure[i] >= median * 2 ) {
        amountOfNotifications++;
      }
      addFrequency(expenditure[i]);
      discountFrequency(expenditure[i-d]);
    }

    return amountOfNotifications;
  }

  private void addFrequency(int value) {
    frequencyTable[value] += 1;
  }

  private void discountFrequency(int value) {
    frequencyTable[value] -= 1;
  }

  private int getMediaFromFequencyTable(int valueToSearch) {
    int summation = 0;
    for (int i=0; i<frequencyTable.length; i++) {
      summation += frequencyTable[i];
      if (summation >= valueToSearch) {
        return i;
      }
    }
    return -1;
  }

  private double getMediaFromFequencyTableEvenLenght(int valueToSearch) {
    int median1 = getMediaFromFequencyTable(valueToSearch);
    int median2 = getMediaFromFequencyTable(valueToSearch + 1);

    return (double) (median1 + median2) / 2;
  }

  // --------------------------------------------------------------------------------------------------------------
  //!important: Other way to find out the median value in an unsorted array is using two queues.
    static PriorityQueue<Integer> highers = new PriorityQueue<>();
    static PriorityQueue<Integer> lowers = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer a, Integer b) {
        return b.compareTo(a);
      }
    });

  public static int process3(int[] expenditure, int d) {
    int amountOfNotifications = 0;
    for (int i = 0; i < expenditure.length; i++) {
      if (i < d) {
        addNumber(expenditure[i], lowers, highers);
        continue;
      }
      double median = getMedian(lowers, highers);
      System.out.println("Median: " + median);
      if (expenditure[i] >= median * 2) {
        amountOfNotifications++;
      }
      addNumber(expenditure[i], lowers, highers);
      removeNumber(expenditure[i - d], lowers, highers);
    }

    return amountOfNotifications;
  }

  private static void addNumber(int value, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
    if (lowers.size() == 0 || value < lowers.peek()) {
      lowers.add(value);
    } else {
      highers.add(value);
    }
    rebalance(lowers, highers);
  }

  private static void removeNumber(int value, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
    if (lowers.contains(value)) {
      lowers.remove(value);
    } else {
      highers.remove(value);
    }
    rebalance(lowers, highers);
  }

  private static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
    PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;
    PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
    if (biggerHeap.size() - smallerHeap.size() >= 2) {
      smallerHeap.add(biggerHeap.poll());
    }
  }

  private static double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
    PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;
    PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
    if (smallerHeap.size() == biggerHeap.size()) {
      return (double)(smallerHeap.peek() + biggerHeap.peek()) / 2;
    } else {
      return biggerHeap.peek();
    }
  }
}
