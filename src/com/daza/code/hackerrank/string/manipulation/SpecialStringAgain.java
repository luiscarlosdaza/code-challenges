package com.daza.code.hackerrank.string.manipulation;

public class SpecialStringAgain {

  public int process(String s) {
    int counterSpecialString = s.length();
    char[] textCharArray = s.toCharArray();
    for (int i=0; i<textCharArray.length; i++) {
      int repeatedLetterCounter = 0;
      for (int j=i+1; j<textCharArray.length; j++) {
        if (textCharArray[i] == textCharArray[j]) {
          counterSpecialString++;
          repeatedLetterCounter++;
        } else {
          int nextLetter = j+1;
          char letter = textCharArray[i];
          boolean isSameLetter = containSameLetter(textCharArray, letter, nextLetter, nextLetter+repeatedLetterCounter);
          if (isSameLetter) {
            counterSpecialString++;
          }
          break;
        }
      }
    }

    return counterSpecialString;
  }

  private boolean containSameLetter(char[] textCharArray, char letter, int from, int to) {
    if(validateArrayLength(textCharArray, to)) {
      return false;
    }

    for (;from <= to; from++) {
      if (textCharArray[from] != letter) {
        return false;
      }
    }
    return true;
  }

  private boolean validateArrayLength(char[] textCharArray, int to) {
    return to >= textCharArray.length ? true : false;
  }
}
