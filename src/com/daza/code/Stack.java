package com.daza.code;

public class Stack {

  private String[] array;
  private int top;
  private int capacity;

  public Stack(int capacity) {
    this.capacity = capacity;
    array = new String[capacity];
    top = -1;
  }

  public void push(String value) {
    if (isFull()) {
      throw new RuntimeException("Stack is full");
    }
    array[++top] = value;
  }

  public String pop() {
    if (isEmpty()) {
      throw new RuntimeException("Stack is empty!!!");
    }
    return array[top--];
  }

  public String peek() {
    if (isEmpty()) {
      throw new RuntimeException("Stack is empty!!!");
    }
    return array[top];
  }

  private boolean isFull() {
    return top == capacity - 1;
  }

  private boolean isEmpty() {
    return top == -1;
  }
}
