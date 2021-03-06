package eq;

import game.Move;
import game.Player;
import java.util.Scanner;

public class Eq {
    static boolean exit = true;

    public static final String CYAN = "\u001B[36m"; //zdobywanie itemku
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";//otrzymanie obrażeń
    public static final String YELLOW= "\033[0;93m"; //poziom
    public static final String PURPLE = "\033[0;95m"; // systemowe

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
    public static int getHPPots(){
        return HPPots;
    }
    public static int getManaPots(){
        return ManaPots;
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
        Player.setHealth( - Weapons.WeaponsArray[current].health,- Weapons.WeaponsArray[current].health);
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
        if(Player.getCurrentItems()<10){
        for (int a = 0; a < 10; a++) {
            if (ItemEq[a] == -1) {
                ItemEq[a] = Items.ItemsArray[addId].id;
                System.out.println(CYAN+"Nowy przedmiot został dodany do twojego ekwipunku"+RESET);
                break;
            }
        }}
        else System.out.println("Nie masz już miejsca w ekwipunku");
    }

    public static void addWeaponToEq (int addId){
        if(Player.getCurrentWeapons()<5) {
            for (int a = 0; a < 5; a++) {
                if (WeaponEq[a] == -1) {
                    WeaponEq[a] = Weapons.WeaponsArray[addId].id;
                    System.out.println(CYAN + "Nowa broń została dodana do twojego ekwipunku" + RESET);
                    Player.setCurrentWeapons(1);
                    break;

                }
            }
        }
        else System.out.println("Nie masz już miejsca w plecaku na bronie");
        }

        public static void gearOn() {
            System.out.println("Broń: " + currentWeaponName);
            System.out.println(PURPLE + "(1)Zmień broń/(2)Wyświetl statystyki/(x)Wróć" + RESET);
            Scanner scanner = new Scanner(System.in);
            String x = scanner.next();
            //System.out.println("Zbroja: "+currentArmorName);
            if(x.equals("1")) {
                unequipWeapon(Eq.currentWeapon);
                changeWeapon();
            }
                   else if(x.equals("2")) {
                System.out.println("atak +" + Weapons.WeaponsArray[currentWeapon].attack);
                System.out.println("obrona +" + Weapons.WeaponsArray[currentWeapon].deffence);
                System.out.println("życie +" + Weapons.WeaponsArray[currentWeapon].health);
                gearOn();
            }
                   else if(x.equals("x")){
                        return;
                }

            }
            public static void changeWeapon(){
                Scanner scanner = new Scanner(System.in);
                String x = scanner.next();
                if(x.equals("1")){
                        setCurrentWeapon(Weapons.WeaponsArray[WeaponEq[0]].id);
                        System.out.println(Weapons.WeaponsArray[WeaponEq[0]].name + " został założony");
                        WeaponEq[0] = -1;
                        gearOn();
                }
                if(x.equals("2")) {
                    setCurrentWeapon(Weapons.WeaponsArray[WeaponEq[1]].id);
                    System.out.println(Weapons.WeaponsArray[WeaponEq[1]].name + " został założony");
                    WeaponEq[0] = -1;
                    gearOn();
                }
                if(x.equals("3")) {
                    setCurrentWeapon(Weapons.WeaponsArray[WeaponEq[2]].id);
                    System.out.println(Weapons.WeaponsArray[WeaponEq[2]].name + " został założony");
                    WeaponEq[0] = -1;
                    gearOn();
                }
                if(x.equals("4")) {
                    setCurrentWeapon(Weapons.WeaponsArray[WeaponEq[3]].id);
                    System.out.println(Weapons.WeaponsArray[WeaponEq[3]].name + " został założony");
                    WeaponEq[0] = -1;
                    gearOn();
                }

                if(x.equals("5")) {
                    setCurrentWeapon(Weapons.WeaponsArray[WeaponEq[4]].id);
                    System.out.println(Weapons.WeaponsArray[WeaponEq[4]].name + " został założony");
                    WeaponEq[0] = -1;
                    gearOn();
                }






            }
        }






