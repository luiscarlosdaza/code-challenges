package com.daza.code;

import java.util.Comparator;

class Player {
  String name;
  int score;
  Player(String name, int score) {
    this.name = name;
    this.score = score;
  }
}

class Checker implements Comparator<Player> {
  @Override
  public int compare(Player a, Player b) {
    if (b.score != a.score) {
      return b.score - a.score;
    }
    return a.name.compareTo(b.name);
  }
}