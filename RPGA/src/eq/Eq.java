package eq;

import game.Player;
import java.util.Scanner;

public class Eq {

    //itemki "stałe" o zmieniającej się ilości
    public static int torch = 0;
    public static int HPPots = 0;
    public static int ManaPots = 0;
    public static int crowbar = 0;
    public static int currentWeapon;
    public static String currentWeaponName = Weapons.WeaponsArray[currentWeapon].name;
    public static String name;
    public static int D_X;
    public static int D_Y;
    public static int id;
    public static int ItemEq[] = new int[10];
    public static int WeaponEq[] = new int[10];

    //ekwipunek na pojedyncze itemki
    public Eq(){

    }
    public Eq(String name, int D_X, int D_Y, int id){
        this.name = name;
        this.D_X = D_X;
        this.D_Y = D_Y;
        this.id = id;

    }


    public static void setTorch(int current) {
        torch += current;
    }
    public static void setHPPots(int current){
        HPPots+=current;
    }
    public static void setManaPots(int current){
        ManaPots+=current;
    }
    public static void setCrowbar(int current){
        crowbar+=current;
    }

    public static void setCurrentWeapon(int current){

        currentWeapon = current;
        currentWeaponName = Weapons.WeaponsArray[currentWeapon].name;
        Player.setAttack(Weapons.WeaponsArray[current].attack);
        Player.setHealth(Weapons.WeaponsArray[current].health,Weapons.WeaponsArray[current].health);
        Player.setDeffence(Weapons.WeaponsArray[current].deffence);

    }
    public static void unequipWeapon(int current)
    {
        Player.setAttack( - Weapons.WeaponsArray[current].attack);
        Player.setHealth(-  Weapons.WeaponsArray[current].health,- Weapons.WeaponsArray[current].health);
        Player.setDeffence(- Weapons.WeaponsArray[current].deffence);
        addWeaponToEq(current);
    }
    public static void InitItemEq(){
        for(int x = 0; x<10;x++){
            ItemEq[x] = -1;
        }
    }
    public static void InitWeaponEq(){
        for(int x = 0;x<10;x++){
            WeaponEq[x] = -1;
        }
    }
    public static void addItemToEq (int addId) {
        for (int a = 0; a < 10; a++) {
            if (ItemEq[a] == -1) {
                ItemEq[a] = Items.ItemsArray[addId].id;
                System.out.println("Nowy przedmiot został dodany do twojego ekwipunku");
                break;
            }
        }
    }
    public static void addWeaponToEq (int addId){
            for(int a=0;a<10;a++){
                if(WeaponEq[a] == -1) {
                    WeaponEq[a] = Weapons.WeaponsArray[addId].id;
                    System.out.println("Nowa broń została dodana do twojego ekwipunku");
                    break;
                }
            }
        }
        public static void gearOn(){
            System.out.println("Broń: "+currentWeaponName);
            System.out.println("(1)Zmień broń/(2)Wyświetl statystyki/(x)Wróć");
            Scanner scanner = new Scanner(System.in);
            String x = scanner.next();
            //System.out.println("Zbroja: "+currentArmorName);

            switch(x){
                case "1":
                    unequipWeapon(Eq.currentWeapon);
                    setCurrentWeapon(Weapons.WeaponsArray[WeaponEq[0]].id);
                    WeaponEq[0] = -1;
                    gearOn();
                case "2":
                    System.out.println("atak +"+Weapons.WeaponsArray[currentWeapon].attack);
                    System.out.println("obrona +"+Weapons.WeaponsArray[currentWeapon].deffence);
                    System.out.println("życie +" +Weapons.WeaponsArray[currentWeapon].health);
                    gearOn();
                case "x":
                    //coś żeby wrócić

            }
        }

    }




