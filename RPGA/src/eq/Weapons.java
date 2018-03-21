package eq;

import game.Player;
import java.util.Scanner;
public class Weapons {

    public int id;
    public double attack;
    public double deffence;
    public double health;
    public String name;
    Scanner odczyt = new Scanner(System.in);

    public Weapons(int id,double attack,double deffence,double health,String name){
        this.id = id;
        this.attack = attack;
       // Player.setAttack(attack);
        this.deffence = deffence;
      //  Player.setDeffence(deffence);
        this.health = health;
      //  Player.setHealth(health,health);
        this.name = name;
    }

    public static Weapons w0 = new Weapons(0,2,1,5,"Złamany miecz");
    public static Weapons w1 = new Weapons(1,2,2,7,"Zardzewiały miecz");
    public static Weapons w2 = new Weapons(2,7,4,10,"Brązowy miecz");
    public static Weapons w3 = new Weapons(3,10,5,10,"Stara siekierka");
    public static Weapons w4 = new Weapons(4,8,7,12,"Metalowa siekierka");
    public static Weapons w5 = new Weapons(5,12,3,15,"Stalowy miecz");
    public static Weapons w6 = new Weapons(6,15,10,15,"Stalowy miecz oburęczny");
    public static Weapons w7 = new Weapons(7,13,8,20,"Perfekcyjny miecz stalowy");
    public static Weapons w8 = new Weapons(8,20,8,10,"Stalowa maczuga");
    public static Weapons w9 = new Weapons(9,22,12,20,"Tytanowy miecz");
    public static Weapons w10 = new Weapons(10,30,20,30,"Miecz wpierdolu 3000");


    public static Weapons WeaponsArray[] = {w0,w1,w2,w3,w4,w5,w6,w7,w8,w9,w10};

}
