package org.example;

// Scrivere la classe Lampadina i cui oggetti rappresentano delle lampadine.
//Lo stato della lampadina può essere accesa o spenta identificata con true o false
//rispettivamente.
//
//La classe mette a disposizione due sole operazioni:
//  1. stato() che indica lo stato corrente della lampadina con true o false nel caso sia accesa o
//  spenta.
//  2. click() che ne cambia lo stato da accesa a spenta o da spenta a accesa.
//
//La classe deve contenere:
//
//  • Un attributo che descriva opportunamente lo stato della lampadina con true o
//  false(Accesa/Spenta)
//  • Un opportuno costruttore che inizializzi lo stato su acceso/spento.
//
//  • I metodi stato() e click() previsti.

public class Lamp {
    public final boolean isOn;

    public Lamp() {
        this(false);
    }

    public Lamp(boolean status){
        this.isOn = status;
    }

    public Lamp click() {
        return new Lamp(!this.isOn);
    }
}
