package org.example;// Esercizio 12
//Progettare una classe Calcolatrice con questi attributi:
//  ● numero: valore rappresentato dalla calcolatrice, deve essere intero.
//  ● formato: una variabile che può valere soltanto DECIMALE, BINARIO,
//ESADECIMALE, dove DECIMALE, BINARIO ed ESADECIMALE devono essere tre
//costanti opportunamente definite.
//Implementare il seguenti metodo:
//  ● toString: deve restituire una rappresentazione corretta del numero, in base al
//formato scelto. Cercare fra i metodi disponibili in java.lang.Integer una soluzione
//veloce a questa esigenza.
//Inoltre immaginare una implementazione di buon senso per i metodi la cui intestazione è qui
//indicata:
//  ● public void add(Calcolatrice c)
//  ● public void addAll(Calcolatrice[] cs)
//  ● public void mult(Calcolatrice c)
//  ● public void divide(Calcolatrice c)
//  ● public static Calcolatrice max(Calcolatrice[] cs)
//  ● public static Calcolatrice min(Calcolatrice[] cs)

import java.util.Optional;

enum FORMAT {DECIMAL, BINARY, HEX}

class Calculator {
    int number;
    FORMAT format;

    public Calculator(int number, FORMAT format) {
        this.number = number;
        this.format = format;
    }

    public String toString() {
        if (format == FORMAT.BINARY)
            return "0b" + Integer.toBinaryString(number);
        else if (format == FORMAT.HEX)
            return "0x" + Integer.toHexString(number);
        else
            return Integer.toString(number);
    }

    public void add(Calculator c) {
        this.number += c.number;
    }

    public void addAll(Calculator[] cs) {
        for (Calculator i : cs)
            this.add(i);
    }

    public void mult(Calculator c) {
        this.number *= c.number;
    }

    public void divide(Calculator c) {
        this.number /= c.number;
    }

    // ToDo Remake this method using streams
    public static Optional<Calculator> max(Calculator[] cs) {
        if (cs.length == 0)
            return Optional.empty();

        Calculator max = cs[0];
        for(Calculator i: cs){
            if(max.number < i.number)
                max = i;
        }
        return Optional.of(max);
    }

    // ToDo Remake this method using streams
    public static Optional<Calculator> min(Calculator[] cs) {
        if (cs.length == 0)
            return Optional.empty();

        Calculator min = cs[0];
        for(Calculator i: cs){
            if(min.number > i.number)
                min = i;
        }
        return Optional.of(min);
    }

}

public class Calc {
    public static void main(String[] args) {
        Calculator calculator1 = new Calculator(100, FORMAT.HEX);
        Calculator calculator2 = new Calculator(101, FORMAT.BINARY);
        Calculator calculator3 = new Calculator(103, FORMAT.DECIMAL);

        calculator3.addAll(new Calculator[]{calculator1, calculator2});

        Optional<Calculator> max = Calculator.max(new Calculator[]{});

        String formatMessage = max.map(c -> c.format.toString()).orElse("No max found");

        System.out.println(formatMessage);
    }
}


