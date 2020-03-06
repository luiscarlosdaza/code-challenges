package com.daza.code.calculadora;

import com.daza.code.calculadora.operaciones.*;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner =  new Scanner(System.in);
    System.out.println("Digita el primer número");
    int numeroUno = scanner.nextInt();
    System.out.println("Digita el segundo número");
    int numeroDos = scanner.nextInt();

    Suma suma = new Suma(numeroUno, numeroDos);
    System.out.println(suma.sumar());

    Resta resta = new Resta();
    System.out.println(resta.procesar(numeroUno,numeroDos));

    Multiplicacion multiplicar = new Multiplicacion();
    System.out.println(multiplicar.procesar(numeroUno,numeroDos));

    Division division = new Division();
    System.out.println(division.procesar(numeroUno,numeroDos));
  }
}