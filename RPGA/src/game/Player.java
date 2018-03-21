package game;

import eq.Eq;
import eq.Items;
import eq.Weapons;
import monsters.Monsters;
import Misc.Random;

import java.util.Scanner;


public class Player {
    public static final String CYAN = "\u001B[36m"; // zdobywanie itemku
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";// otrzymanie obrażeń
    public static final String YELLOW = "\033[0;93m"; // poziom
    public static final String PURPLE = "\033[0;95m"; // systemowe

    static Scanner scanner = new Scanner(System.in);
    static boolean exit = true;

    public static String PlayerName;
    public static double health = 100;
    public static double healthMax = 100;
    public static double mana = 50;
    public static double manaMax = 50;
    public static double attack = 10;
    public static double deffence = 10;
    public static double strenght = 1;
    public static double intelligence = 1;
    public static int lvl = 1;
    public static double money = 0;
    public static double exp = 0;
    public static int currentItems = 0;
    public static int currentWeapons = 0;
    public static int abilityPoints = 0;


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

    public static double getStrenght() {
        return strenght;
    }

    public static double getIntelligence() {
        return intelligence;
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

    public static int getCurrentItems(){return currentItems;}

    public static int getCurrentWeapons(){return currentWeapons;}

    public static int getAbilityPoints() {return abilityPoints;}


    public static void setName(String playerName) {
        playerName = playerName;
    }

    public static void setHealth(double current, double max) {
        health += current;
        healthMax += max;
    }

    public static void setMana(double current, double max) {
        mana += current;
        manaMax += max;
    }

    public static void setStrenght(double addStrenght){
        strenght+=addStrenght;
    }
    public static void setIntelligence(double addIntelligence){
        intelligence+=addIntelligence;
    }
    public static void setAbilityPoints(int addAbilityPoint){
        abilityPoints+=addAbilityPoint;
    }

    public static void setMoney(double addMoney) {
        money += addMoney;
    }

    public static void setLvl(int addLvl) {
        lvl += addLvl;
        System.out.println(YELLOW + "Awansowałeś, Twój aktualny poziom to :" + lvl + ", sprawdź nowe statystyki w (m)menu" + RESET);
        health += 15;
        healthMax += 15;
        mana += 5;
        manaMax += 5;
        attack += 1;
        deffence += 0.5;
        strenght += 0.5;
        intelligence += 0.5;
        setAbilityPoints(5);

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



    public static void setCurrentItems(int addCurrent){currentItems +=addCurrent;}
    public static void setCurrentWeapons(int addCurrent){currentWeapons+=addCurrent;}

    public Player(double health, double healthMax, double mana, double manaMax, double attack, double deffence,double strenght,double intelligence, String PlayerName) {
        this.health = health;
        this.healthMax = healthMax;
        this.mana = mana;
        this.manaMax = manaMax;
        this.attack = attack;
        this.deffence = deffence;
        this.strenght = strenght;
        this.intelligence = intelligence;
        this.PlayerName = PlayerName;

    }

    public static void Stats() {
        System.out.println(getPlayerName() + " Twoje statystyki:");
        System.out.println("HP:" + getHealth() + "/" + getHealthMax());
        System.out.println("Mana:" + getMana() + "/" + getManaMax());
        System.out.println("Punkty ataku:" + getAttack());
        System.out.println("Obrona:" + getDeffence());
        System.out.println("Siła:"+ getStrenght());
        System.out.println("Inteligencja:"+getIntelligence());
        System.out.println("Poziom:" + getLvl());
        System.out.println("Exp:" + getExp());
        System.out.println("Waluta:" + getMoney());
        System.out.println("Punkty umiejętności: "+getAbilityPoints());
        System.out.println("(1)Rozdaj punkty umiejętności/(x)wróć");
        String x = scanner.next();
        if(x.equals("1")){
            setPoints();
        }
        if(x.equals("1")){
            Menu();
        }


    }

    public static void Eq() {
        System.out.println("HP mikstura: " + Eq.HPPots);
        System.out.println("Mana mikstura: " + Eq.ManaPots);
        System.out.println("Pochodnia: " + Eq.torch);
        System.out.println("Lom :" + Eq.crowbar);
        for (int x = 0; x < 10; x++) {
            if (Eq.ItemEq[x] != -1) {
                System.out.println(Items.ItemsArray[Eq.ItemEq[x]].name);
                setCurrentItems(1);
            }
        }
        System.out.println("Plecak 1: "+getCurrentItems()+"/10");
        for (int x = 0; x<5; x++){
            if (Eq.WeaponEq[x] != -1) {
                System.out.println(Weapons.WeaponsArray[Eq.WeaponEq[x]].name);

            }
        }
        System.out.println("Plecak 2: "+getCurrentWeapons()+"/5");

        System.out.println(PURPLE + "(1)Użyj mikstury HP/(2)Użyj mikstury MP/(x)Wróć" + RESET);

        String x = scanner.next();

            if(x.equals("1")) {
            UseHPPots();
            Eq();
        }
            else if(x.equals("2")) {
            UseManaPots();
            Eq();
        }
            else if(x.equals("x")){
                return;
        }

        }



    public static void dealDamage() {
        System.out.println("Jaką podejmujesz decyzję?" + PURPLE + "((1)atakuj,(2)atak magiczny,(3)użyj mikstury hp,(3)użyj mikstury mp)" + RESET);
        String fight = scanner.next();

        if (fight.equals("1")) {
            physialAttack();
        }
        if (fight.equals("2")) {
            basicMagicAttack();
        }
        if (fight.equals("3")) {
            UseHPPots();
        }
        if(fight.equals("4")){
            UseManaPots();
        }
    }

    public static void physialAttack() {
        double damage = Random.random(1, 3) * attack * strenght;
        System.out.println("Zadałeś " + damage + " obrażeń");
        Monsters.takeDamage(damage);
    }
    public static void basicMagicAttack(){
        if(getMana()>4) {
            double damage = Random.random(1, 3) * attack * intelligence;
            System.out.println("Zadałeś " + damage + " magicznych obrażeń");
            setMana(-5, 0);
            Monsters.takeDamage(damage);
        }
        else{
            System.out.println("Niewystarczająca ilość many");
        }
    }

    public static void takeDamage(double damage) {
        health = getHealth() - damage;
        if (getHealth() < 0) {
            System.out.println("Umarłeś");
            System.exit(1);

        }
    }
    public static void addIntelligence(double point){
        setIntelligence(point);
        setAbilityPoints(-1);
        setMana(1,1);
        System.out.println("+1 do inteligencji");
    }
    public static void addStrenght(double point){
        setStrenght(point);
        setAbilityPoints(-1);
        System.out.println("+1 do siły");
    }
    public static void setPoints(){

        System.out.println("(1)Dodaj punkt do inteligencji/(2)Dodaj punkt do siły/(x)wróć");
        String x = scanner.next();
        if(x.equals("1")){
            if(getAbilityPoints()>0) {
                addIntelligence(1);
                setPoints();
            }
            else{
                System.out.println("Nie masz więcej punktów");
                Stats();
            }

        }
        if(x.equals("2")){
            if(getAbilityPoints()>0) {
                addStrenght(1);
                setPoints();
            }
            else{
                System.out.println("Nie masz więcej punktów");
                Stats();
            }
        }
        if(x.equals("x"))
            Stats();
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

        if(x.equals("s")) {
            Player.Stats();
            Menu();
        }
        else if(x.equals("e")){
            Player.Eq();
            Menu();
        }
        else if(x.equals("p")){
            Eq.gearOn();
            Menu();
        }
        else if(x.equals("x")){
            return;
        }
   /* while(exit) {

        switch (x) {
            case "s":
                Player.Stats();
                Menu();
                break;
            case "e":
                Player.Eq();
                Menu();
                break;
            case "p":
                Eq.gearOn();
                Menu();
                break;
            case "x":
                exit = false;
        }
    }*/

    }
}
