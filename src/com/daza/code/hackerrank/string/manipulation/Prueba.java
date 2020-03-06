package com.daza.code.hackerrank.string.manipulation;

class AlternatingCharacterTest {

  public static void main(String[] args) {
    String text = "AAABBB";
    AlternatingCharacter alternatingCharacter = new AlternatingCharacter();
    int result = alternatingCharacter.process(text);
    System.out.println(result);
  }
}

class SherlockAndTheValidStringTest {

  public static void main(String[] args) {
//    String text = "aabbcd";
//    String text = "abcdefghhgfedecba";
//    String text = "aabbc";
    String text = "aaaabbcc";
//    String text = "a";
    SherlockAndTheValidString clazz = new SherlockAndTheValidString();
    String result = clazz.process(text);
    System.out.println(result);
  }
}

class SpecialStringAgainTest {
  public static void main(String[] args) {
//    String text = "asasd";
//    String text = "abcbaba";
    String text = "aaaa";
    SpecialStringAgain specialStringAgain = new SpecialStringAgain();
    int result = specialStringAgain.process(text);
    System.out.println(result);
  }
}