package game;

import monsters.Monsters;

public class Fight {

    public static void startBattle() {
        System.out.println("zostałeś zaatakowany przez " + Monsters.getMonsterName());
        System.out.println();
        if (Monsters.getMonsterName().equals("Szczur")) {
            szczurFight();
        }
        else continueBattle();

    }
    public static void continueBattle(){
        if(Monsters.getHealth()>0&&Player.getHealth()>0) {
            Player.dealDamage();
            if (Monsters.getHealth() > 0) {
                Monsters.physicalDamage();
            }
            continueBattle();
        }
        else endFight();
        }

    public static void szczurFight(){
        if(Monsters.getHealth()>0&&Player.getHealth()>0) {
            Player.dealDamage();
            if (Monsters.getHealth() > 0) {
                monsters.Szczur.fight();
            }
            szczurFight();
        }
        else {endFight();}

    }

    public static void endFight(){
        System.out.println("pokonaleś "+Monsters.getMonsterName());

    }
}
