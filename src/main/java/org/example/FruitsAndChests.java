// ESERCIZIO FRUTTA
//      Creare una classe astratta Frutta che definisce una variabile incapsulata peso.
//      Per il nostro programma un oggetto Frutta senza peso non ha senso.
//      Creare le sue sottoclassi Mela, Pesca, Arancia. Creare una classe generica Cesto che astrae il concetto di
//      cesto della frutta. Questa definisce un array list di frutti.
//      Inoltre deve esporre un metodo getPeso() che ritorna il peso totale del contenuto della cesta; un metodo
//      aggiungi() per aggiungere un frutto alla volta, che rilancia un’eccezione (creata appositamente) nel caso
//      l’aggiunta del frutto che si vuole aggiungere faccia superare il limite massimo di 5 chili di peso.
//      Ogni Cesta deve avere un solo tipo di frutta per volta. Implementare una soluzione con i generics.
//      Creare una classe di test per verificare l’effettivo funzionamento del programma.

package org.example;

import java.util.ArrayList;

abstract class Fruit { float weigth; }

class Apple extends Fruit { Apple(float w) { weigth = w; } }
class Peach extends Fruit { Peach(float w) { weigth = w; } }
class Orange extends Fruit { Orange(float w) { weigth = w; } }

class Chest<T extends Fruit> {
    public ArrayList<T> friuts = new ArrayList<>();

    public float getWeigth(){
        return (float) friuts.stream().mapToDouble(x -> x.weigth).sum();
    }

    public void add(T fruit){
        friuts.add(fruit);
    }
}

public class FruitsAndChests {

    public static void main(String[] args) {
        var chestApple = new Chest<Apple>();
        var chestOranges = new Chest<Orange>();

        var apple = new Apple(.1f);
        var orange = new Orange(.2f);
        var peach = new Peach(.3f);

        chestApple.add(apple);
        chestApple.add(apple);
        chestApple.add(apple);
        chestOranges.add(orange);
    }
}
