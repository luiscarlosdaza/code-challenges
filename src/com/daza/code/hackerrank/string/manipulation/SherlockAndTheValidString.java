package com.daza.code.hackerrank.string.manipulation;

import java.util.*;

//https://github.com/RyanFehr/HackerRank/blob/master/Algorithms/Strings/Sherlock%20and%20Valid%20String/Solution.java
public class SherlockAndTheValidString {

  private static final String YES = "YES";
  private static final String NO = "NO";
  private static final int NUMBER_LETTERS_ALPHABET = 28;

  public String process(String text) {
    Map<Character, Integer> amountOfLetters = getAmountOfLetters(text);
    int frequentNumber = getMoreFrequentValue(amountOfLetters);
    List<Character> lettersWithDifferentFrequency = getLettersWithDifferentFrequency(amountOfLetters, frequentNumber);
    if (lettersWithDifferentFrequency.size() > 1) {
      return NO;
    }
    discountOneLetter(amountOfLetters, lettersWithDifferentFrequency);
    return isAmountOfLetterEqual(amountOfLetters) ? YES : NO;
  }

  private Map<Character, Integer> getAmountOfLetters(String text) {
    Map<Character, Integer> result = new HashMap<>();
    for (char letter : text.toCharArray()) {
      if (result.get(letter) == null) {
        result.put(letter, 1);
      } else {
        result.put(letter, result.get(letter) + 1);
      }
    }
    return result;
  }

  private int getMoreFrequentValue(Map<Character, Integer> amountOfLetters) {
    Map<Integer, Integer> frequencyMap = new HashMap<>();
    for (Integer amount : amountOfLetters.values()) {
      if (frequencyMap.get(amount) == null) {
        frequencyMap.put(amount, 1);
      } else {
        frequencyMap.put(amount, frequencyMap.get(amount) + 1);
      }
    }

    return getKeyFromMaxValue(frequencyMap);
  }

  public <K, V extends Comparable<V>> K getKeyFromMaxValue(Map<K, V> map) {
    Map.Entry<K, V> maxEntry = null;
    for (Map.Entry<K, V> entry : map.entrySet()) {
      if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
        maxEntry = entry;
      }
    }
    return maxEntry.getKey();
  }

  private List<Character> getLettersWithDifferentFrequency(Map<Character, Integer> amountOfLetters, int frequentValue) {
    List<Character> characters = new ArrayList<>();
    for (Map.Entry entry : amountOfLetters.entrySet()) {
      if ((int) entry.getValue() != frequentValue) {
        characters.add((Character) entry.getKey());
      }
    }
    return characters;
  }

  private void discountOneLetter(Map<Character, Integer> amountOfLetters, List<Character> characters) {
    if (characters.size() == 0) {
      return;
    }
    char letter = characters.get(0);
    amountOfLetters.put(letter, amountOfLetters.get(letter) - 1);
    if (amountOfLetters.get(letter) == 0) {
      amountOfLetters.remove(letter);
    }
  }

  private boolean isAmountOfLetterEqual(Map<Character, Integer> amountOfLetters) {
    int lastValue = -1;
    for (Integer value : amountOfLetters.values()) {
      if (lastValue != -1 && value != lastValue) {
        return false;
      }
      lastValue = value;
    }

    return true;
  }
}
