package monsters;

import eq.Eq;
import monsters.Monsters;
import game.Player;
import eq.Items;

public class Szczur extends Monsters {
    public static int szczurDeath = 5;

    public Szczur(double health, double healthMax, double attack, double deffence, String monsterName, double coins, double exp, double drop) {
        super(health, healthMax, attack, deffence, monsterName, coins, exp, drop);
    }

   /* public static void dealDamage() {
        physicalDamage();
    }*/

    public static void fight() {
        physicalDamage();
    }

    public static int getSzczurDeath() {
    return szczurDeath;

    }
}