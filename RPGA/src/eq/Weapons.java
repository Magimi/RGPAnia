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

    public static Weapons WeaponsArray[] = {w0,w1,w2,w3};

}
