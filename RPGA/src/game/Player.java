package game;

import eq.Eq;
import eq.Items;
import eq.Weapons;
import monsters.Monsters;
import Misc.Random;

import java.util.Scanner;


public class Player {
    public static final String CYAN = "\u001B[36m"; //zdobywanie itemku
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";//otrzymanie obrażeń
    public static final String YELLOW = "\033[0;93m"; // poziom
    public static final String PURPLE = "\033[0;95m"; // systemowe

    static Scanner scanner = new Scanner(System.in);

    public static String PlayerName;
    public static double health = 100;
    public static double healthMax = 100;
    public static double mana = 50;
    public static double manaMax = 50;
    public static double attack = 10;
    public static double deffence = 10;
    public static int lvl = 1;
    public static double money = 0;
    public static double exp = 0;


    public static String getPlayerName() {
        return PlayerName;
    }

    public static double getHealth() {
        return health;
    }

    public static double getHealthMax() {
        return healthMax;
    }

    public static double getMana() {
        return mana;
    }

    public static double getManaMax() {
        return manaMax;
    }

    public static double getAttack() {
        return attack;
    }

    public static double getDeffence() {
        return deffence;
    }

    public static int getLvl() {
        return lvl;
    }

    public static double getMoney() {
        return money;
    }

    public static double getExp() {
        return exp;
    }


    public static void setName(String playerName) {
        playerName = playerName;
    }

    public static void setHealth(double current, double max) {
        health += current;
        healthMax += max;
    }

    public static void setMana(double current, double max) {
        current = mana;
        max = manaMax;
    }

    public static void setMoney(double addMoney) {
        money += addMoney;
    }

    public static void setLvl(int addLvl) {
        lvl += addLvl;
        System.out.println(YELLOW + "Awansowałeś, Twój aktualny poziom to :" + lvl + ", wpisz Statystyki, aby zobaczyć zmiany" + RESET);
        health += 15;
        healthMax += 15;
        mana += 5;
        manaMax += 5;
        attack += 1;
        deffence += 0.5;
    }

    public static void setExp(double addExp) {
        exp += addExp;

        if (exp >= 100) {
            if (exp > 100) {
                exp = 0 + (exp - 100);
                setLvl(1);
            } else {
                setLvl(1);
                exp = 0;
            }
        }

    }

    public static void setAttack(double addAttack) {
        attack += addAttack;
    }

    public static void setDeffence(double addDeffence) {
        deffence += addDeffence;
    }

    public Player(double health, double healthMax, double mana, double manaMax, double attack, double deffence, String PlayerName) {
        this.health = health;
        this.healthMax = healthMax;
        this.mana = mana;
        this.manaMax = manaMax;
        this.attack = attack;
        this.deffence = deffence;
        this.PlayerName = PlayerName;

    }

    public static void Stats() {
        System.out.println(getPlayerName() + " Twoje statystyki:");
        System.out.println("HP:" + getHealth() + "/" + getHealthMax());
        System.out.println("Mana:" + getMana() + "/" + getManaMax());
        System.out.println("Punkty ataku:" + getAttack());
        System.out.println("Obrona:" + getDeffence());
        System.out.println("Poziom:" + getLvl());
        System.out.println("Exp:" + getExp());
        System.out.println("Waluta:" + getMoney());

    }

    public static void Eq() {
        System.out.println("HP mikstura: " + Eq.HPPots);
        System.out.println("Mana mikstura: " + Eq.ManaPots);
        System.out.println("Pochodnia: " + Eq.torch);
        System.out.println("łom :" + Eq.crowbar);
        for (int x = 0; x < 10; x++) {
            if (Eq.ItemEq[x] != -1) {
                System.out.println(Items.ItemsArray[Eq.ItemEq[x]].name);
            }
            if (Eq.WeaponEq[x] != -1) {
                System.out.println(Weapons.WeaponsArray[Eq.WeaponEq[x]].name);
            }
        }
        System.out.println(PURPLE + "(1)Użyj mikstury HP/(2)Użyj mikstury MP/(x)Wróć" + RESET);

        String x = scanner.next();

        switch (x) {
            case "1":
                UseHPPots();
                Eq();

            case "2":
                UseManaPots();
                Eq();

            case "x":
                break;
                //return;

        }

    }

    public static void dealDamage() {
        System.out.println("Jaką podejmujesz decyzję?" + PURPLE + "((1)atakuj,(2)użyj mikstury hp,(3)użyj mikstury mp)" + RESET);
        String fight = scanner.next();

        if (fight.equals("1")) {
            physialAttack();
        }
        if (fight.equals("2")) {
            UseHPPots();
        }
        if (fight.equals("3")) {
            UseManaPots();
        }
    }

    public static void physialAttack() {
        double damage = Random.random(1, 3) * attack;
        System.out.println("Zadałeś " + damage + " obrażęń");
        Monsters.takeDamage(damage);
    }

    public static void takeDamage(double damage) {
        health = getHealth() - damage;
        if (getHealth() < 0) {
            System.out.println("Umarłeś");
            System.exit(1);

        }
    }

    public static void Sleep() {

        System.out.println("Kontynuujesz gre za 5s");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Regenerujesz część MP i HP");
        Player.setHealth(0.1 * Player.getHealthMax(), 0);
        if (Player.getHealth() > Player.getHealthMax()) {
            Player.setHealth(Player.getHealthMax() - Player.getHealth(), 0);
        }
        Player.setMana(0.1 * Player.getManaMax(), 0);
        if (Player.getMana() > Player.getManaMax()) {
            Player.setHealth(Player.getMana() - Player.getManaMax(), 0);
        }
    }

    public static void UseHPPots() {
        if (Player.getHealth() < Player.getHealthMax()) {
            if (Eq.getHPPots() > 0) {
                System.out.println("Wypijasz miksturę i regenerujesz część hp");

                Player.setHealth(0.05 * Player.getHealthMax(), 0);
                Eq.HPPots--;
                if (Player.getHealth() > Player.getHealthMax()) {
                    Player.setHealth(Player.getHealthMax() - Player.getHealth(), 0);

                }
            } else if (Eq.getHPPots() <= 0) {
                System.out.println("Nie masz żadnej mikstury");
            }
        } else if (Player.getHealth() == Player.getHealthMax()) {
            System.out.println("Twoje życie jest pełne");
        }
    }

    public static void UseManaPots() {
        if (Player.getMana() < Player.getManaMax()) {
            if (Eq.getManaPots() > 0) {
                System.out.println("Wypijasz miksturę i regenerujesz część MP");
                Eq.ManaPots--;
                Player.setMana(0.05 * Player.getHealth(), 0);
                if (Player.getMana() > Player.getManaMax()) {
                    Player.setMana(Player.getManaMax() - Player.getMana(), 0);
                }
            } else if (Eq.getManaPots() <= 0) {
                System.out.println("Nie masz żadnej mikstury");
            }
        } else if (Player.getMana() == Player.getManaMax()) {
            System.out.println("Twoja mana jest pełna");
        }
    }

    public static void Menu(){
        System.out.println(PURPLE+"(e)ekwipunek/(p)wyposażenie/(s)statystyki/(x)wróć"+RESET);
        String x = scanner.next();

        switch(x){

           case "s":
                Player.Stats();
                Menu();

            case "e":
                Player.Eq();
                Menu();
            case "p":
                Eq.gearOn();
                Menu();
            case "x":
                break;
        }

    }
}
