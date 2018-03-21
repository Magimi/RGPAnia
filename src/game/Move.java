package game;

import eq.Eq;
import monsters.Szczur;
import Misc.Random;
import java.util.Scanner;

public class Move {
    public static final String CYAN = "\u001B[36m"; //zdobywanie itemku
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";//otrzymanie obrażeń
    public static final String YELLOW= "\033[0;93m"; //poziom
    public static final String PURPLE = "\033[0;95m"; // systemowe
    public static final String BLUE = "\033[1;94m"; //ostrzeżenia




    public static void Sewers() {

        System.out.println("Co chcesz zrobić?"+PURPLE+"((1)idz na polnoc/(2)idz na poludnie/(b)spij(regeneracja hp i many)/(m)menu"+RESET);
        Scanner odczyt = new Scanner(System.in);
        String x = odczyt.nextLine();


        switch (x) {
            case "1":

                if (Eq.torch == 0) {
                    System.out.println("Jest za ciemno, żeby iść dalej");
                    Sewers();
                } else if (Eq.torch == 1) {
                    System.out.println("W głębi kanału jest bardzo ciemno, czy chcesz użyć pochodni?" + PURPLE + "(t/n)" + RESET);
                    String a = odczyt.nextLine();
                    if (a.equals("t")) {
                        System.out.println("Idziesz w głąb kanału, trafiasz na wgłębienie, widzisz kilka szkieletów i worków");
                        Eq.torch--;
                        Move.Corpse();

                    } else {
                        Sewers();
                    }
                }


            case "2":
                if(Szczur.szczurDeath>-1) {
                    Szczur szczur = new Szczur(20, 20, 1, 2, "Szczur", 1, 1, 1);
                    if (monsters.Szczur.getSzczurDeath() > 0) {
                        Fight.startBattle();
                        Szczur.szczurDeath--;
                        Sewers();
                    } else if (monsters.Szczur.getSzczurDeath() == 0) {
                        System.out.println(RED+"Twój masowy mord na szczurach obudził ich króla"+RESET);
                        Szczur szczur1 = new Szczur(50, 50, 3, 6, "Król Szczurów", 5, 5, 5);
                        Fight.startBattle();
                        Szczur.szczurDeath--;
                        Sewers();
                    }
                }
                else{
                    System.out.println("Nic już tutaj nie znajdziesz");
                    Sewers();
                }

            case "b":
                System.out.println("Jest zbyt niebezpiecznie, żeby pójść spać. TIP: poszukaj schronienia");
            case "m":
                Player.Menu();
                Sewers();
            }

        }

    public static void Corpse() {

        System.out.println("Co robisz?"+PURPLE+"((1)idz na poludnie/(2)idz na polnoc/(3)przeszukaj zwłoki/(b)spij(regeneracja hp i many)(m)menu)"+RESET);
        Scanner odczyt = new Scanner(System.in);
        String x = odczyt.nextLine();

        switch (x) {
            case "1":
                System.out.println("Wracasz tam gdzie się obudziłeś");
                Sewers();
            case "2":
                System.out.println("W głębi kanału dostrzegasz drabinę i właz, prowadzące na zewnątrz");
                Outside();
            case "3":

                double coins = Random.random(20, 50);
                Player.setMoney(coins);
                Eq.addWeaponToEq(Random.Random(1,3));
                System.out.println("Przeszukując zwłoki znajdujesz:"+CYAN + coins + " monet"+RESET);
                Corpse();

            case "b":
                System.out.println("Spanie pomiędzy szkieletami nie należy do najprzyjemniejszych ale wygląda na to, że nie masz wyboru");
                Player.Sleep();
                Corpse();
            case "m":
                Player.Menu();
                Corpse();


            }
    }
    public static void Outside() {
        System.out.println("Wyszedłeś z kanałów."+PURPLE+"(1)idz na poludnie/(2)idz na polnoc/(3)/idz na wschod/(4)idz na zachod/(b)spij(regeneracja hp i  many)/(s)statystyki/(e)/ekwipunek/(p)wyposażenie"+RESET);
        Scanner odczyt = new Scanner(System.in);
        String x = odczyt.nextLine();

        switch (x) {

              /*  case "1":
                    System.out.println("Dochodzisz na polane, wygląda na to, że nic tu nie ma.(1)idz na poludnie/(2)idz na polnoc/(3)idz na wschod/(4)idz na zachod");
                    Field();*/
            case "2":
                if (Player.getLvl() <=5){
                System.out.println("Dochodzisz do lasu, nie wygląda on na zbyt przyjazny czy jesteś pewien, że chcesz iśc dalej?"+PURPLE+"(t/n)"+RESET+"NOTE:Sugerowany poziom: 5");
                String a = odczyt.nextLine();
                if (a.equals("t")) {
                    Forest();
                } else Outside();
            } else{
                System.out.println("Dochodzisz do mrocznego lasu ale jesteś napakowanym, hiper koksem z Cubano i wbijasz jak do siebie");
                Forest();
            }
            case "3":
                System.out.println("");
        }
    }
        public static void Forest(){}




}
