package com.daza.code.hackerrank.string.manipulation;

public class AlternatingCharacter {

  public int process(String text) {
    int amountOfDeletions = 0;
    char previousLetter = '\0';
    for (char letter : text.toCharArray()) {
      if (letter == previousLetter) {
        amountOfDeletions++;
      }
      previousLetter = letter;
    }

    return amountOfDeletions;
  }
}
