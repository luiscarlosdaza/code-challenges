package com.daza.code.calculadora.operaciones;

public class Suma {

  int variableUno;
  int variableDos;

  public Suma() {}

  public Suma(int variableUno, int variableDos) {
    this.variableUno = variableUno;
    this.variableDos = variableDos;
  }

  public int sumar() {
    return variableUno + variableDos;
  }

}