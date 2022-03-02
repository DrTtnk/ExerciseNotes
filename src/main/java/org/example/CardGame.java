package org.example;

class CharacterUtils{
    static boolean figthResults(int oppenentStrength, int myStrength){
        return oppenentStrength > myStrength;
    }
}

class BaseCharacter implements GameCharacter {
    boolean imDead = false;

    protected void figthResults(GameCharacter oppenent){
        this.imDead = CharacterUtils.figthResults(oppenent.strength, strength);
    }
}

interface GameCharacter {
    int strength = 0;
}

interface Human extends GameCharacter {
    void fightWith(GameCharacter opponent);
}

interface Monster extends GameCharacter {
    void biteTo(GameCharacter opponent);
}

class Hero extends BaseCharacter implements Human {
    int strength = 10;

    public void fightWith(GameCharacter opponent) {
        figthResults(opponent);
        strength = strength - 3;
    }
}

class Vampire extends BaseCharacter implements Monster {
    int strength = 15;

    public void biteTo(GameCharacter opponent) {
        figthResults(opponent);
        strength = strength - 2;
    }
}

class Werewolf extends BaseCharacter implements Monster, Human {
    int strength = 10;

    public void fightWith(GameCharacter opponent) {
        figthResults(opponent);
        strength = strength - 3;
    }

    public void biteTo(GameCharacter opponent) {
        figthResults(opponent);
        strength = strength - 2;
    }
}

public class CardGame {
    public static void main(String[] args) {
        Human mimmo = new Hero();
        Human werewolf = new Werewolf();

        mimmo.fightWith(werewolf);
        werewolf.fightWith(mimmo);
    }

    public static void useInstanceOf(Object character, GameCharacter opponent) {
        if (character instanceof Hero)
            ((Hero) character).fightWith(opponent);
        else if(character instanceof Vampire)
            ((Vampire) character).biteTo(opponent);
        else if (character instanceof Werewolf)
            ((Werewolf) character).fightWith(opponent);
        else
            throw new RuntimeException();
    }

    public static void usePatternMatching(Object character, GameCharacter opponent) {
        switch (character) {
            case Hero hero         -> hero.fightWith(opponent);
            case Vampire vampire   -> vampire.biteTo(opponent);
            case Werewolf werewolf -> werewolf.fightWith(opponent);
            case null, default     -> throw new IllegalStateException("Unexpected value: " + character);
        }
    }
}
