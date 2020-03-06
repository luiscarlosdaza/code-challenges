package com.daza.code;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashCode {

  private int value;

  public HashCode() {}

  public HashCode(int value) {
    this.value = value;
  }

  public static void main(String[] args) {
    HashCode hashCode = new HashCode();
    Map<HashCode, String> prueba = hashCode.create();

    HashCode hashCode1 = new HashCode(10);
    HashCode hashCode2 = new HashCode(15);
    HashCode hashCode3 = new HashCode(20);
    System.out.printf("First value %s%n", prueba.get(hashCode1));
    System.out.printf("Second value %s%n", prueba.get(hashCode2));
    System.out.printf("Third value %s%n", prueba.get(hashCode3));
  }

  public Map<HashCode, String> create() {
    Map<HashCode, String> values = new HashMap<>();
    HashCode hashCode1 = new HashCode(10);
    HashCode hashCode2 = new HashCode(15);
    HashCode hashCode3 = new HashCode(20);
    values.put(hashCode1, "Luis");
    values.put(hashCode2, "Daza");
    values.put(hashCode3, "Acevedo");

    return values;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    HashCode hashCode = (HashCode) o;
    return value == hashCode.value;
  }

  @Override
  public int hashCode() {
    System.out.println("Enter to hashCode method");
    return 1;
  }

  @Override
  public String toString() {
    return "HashCode{value=" + value + '}';
  }
}
