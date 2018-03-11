package monsters;

import eq.Eq;
import game.Player;
import Misc.Random;
public class Monsters {

    private static double health;
    private static double healthMax;
    private static double attack;
    private static double deffence;
    private static String monsterName;
    private static double exp;
    private static double drop;
    private static double coins;

    public static double getHealth()
    {
        return health;
    }
    public static double getHealthMax()
    {
        return healthMax;
    }
    public static double getAttack(){
        return attack;
    }
    public static double getDeffence(){
        return deffence;
    }
    public static String getMonsterName(){
        return monsterName;
    }
    public static void setHealth(double current,double max){
        current = health;
        max = healthMax;
    }
    public Monsters(double health, double healthMax,double attack, double deffence,String monsterName,double coins,double exp,double drop){
        this.health = health;
        this.healthMax = healthMax;
        this.attack = attack;
        this.deffence = deffence;
        this.monsterName = monsterName;
        this.coins = coins;
        this.exp = exp;
        this.drop = drop;
        }

    public static void physicalDamage(){
        double damage = Random.random(0,10)*attack;
        System.out.println(getMonsterName()+"zadał "+damage+" obrażeń");
        Player.takeDamage(damage);
    }
    public static void takeDamage(double damage){
        health = health - damage;
        System.out.println(getMonsterName()+"ma: "+health+" punktow zycia");
        if (health<=0){
            die();
        }
    }
    public static void die(){
        double coin = Random.random(1,100)*Monsters.coins;
        double exp = Random.random(10,50)*Monsters.exp;
        double drop = Random.random(1,3)*Monsters.drop;

        if(drop==1){
            System.out.println("Z "+getMonsterName()+"a wypadła pochodnia!");
            Eq.setTorch(1);
        }
        if(drop==2||drop==11)
        {
            System.out.println("Z "+getMonsterName()+"a wypadły HP mikstury");
            Eq.setHPPots(Random.Random(1,5));
        }
        if(drop==3||drop==10)
        {
            System.out.println("Z "+ getMonsterName()+"a wypadły MP mikstury");
            Eq.setManaPots(Random.Random(1,2));
        }
        if(drop==4)
        {
            Eq.setCrowbar(1);
        }

        if(getMonsterName().equals("Szczur")){
            Szczur.SzczurDeath();
        }



        System.out.println("Udało Ci sie pokonać przeciwnika, otrzymujesz:"+coin+" monet i:"+exp+"punktów exp");
        Player.setExp(exp);
        Player.setMoney(coin);

    }
}