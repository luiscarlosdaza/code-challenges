package com.daza.code;

public class ReverseString {
  //  There are two ways to do it. Reverse method of StringBuilder or manually. It is a good idea to ask the interviewer.
  //Way 1
  public String reverseStringWithStringBuilder(String word) {
    return new StringBuilder(word).reverse().toString();
  }

  //Way 2
  public String reverseStringManually(String word) {
    StringBuilder temporal = new StringBuilder();
    for (int i = word.length() - 1; i >= 0; i--) {
      temporal.append(word.charAt(i));
    }
    return temporal.toString();
  }
}
