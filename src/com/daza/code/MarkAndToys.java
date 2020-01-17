package com.daza.code;

import java.util.Arrays;

public class MarkAndToys {

  public static int maximumToys(int[] prices, int k) {
    int amountOfToysCanPurchase = 0;
    Arrays.sort(prices);
    for (int i=0; i<prices.length; i++) {
      if (k >= prices[i]) {
        amountOfToysCanPurchase++;
        k -= prices[i];
      }
    }

    return amountOfToysCanPurchase;
  }
}
