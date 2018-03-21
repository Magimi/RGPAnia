package monsters;

import monsters.Monsters;
import game.Player;

public class Dzik extends Monsters {

    public Dzik(double health,double healthMax,double attack,double deffence,String monsterName,double coins, double exp,double drop) {
        super(health, healthMax, attack, deffence, monsterName,coins,exp,drop);
    }
    public static void dealDamage(){
        physicalDamage();
    }
    public static void fight(){
        physicalDamage();
    }
}
